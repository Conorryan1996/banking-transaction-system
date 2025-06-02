#!/bin/bash

echo "=== Memory Tuning Recommendations ==="
echo ""
echo "Current Memory Usage:"
docker stats --no-stream --format "table {{.Container}}\t{{.Name}}\t{{.MemUsage}}\t{{.MemPerc}}"

echo ""
echo "=== Immediate Actions ==="
echo ""

# 1. Force garbage collection on high-memory services
echo "1. Triggering garbage collection on Java services..."
for service in fraud-service account-service transaction-service customer-service; do
    container_id=$(docker ps -qf "name=$service")
    if [ ! -z "$container_id" ]; then
        echo "   - Forcing GC on $service"
        docker exec $container_id jcmd 1 GC.run 2>/dev/null || echo "     (GC command not available)"
    fi
done

echo ""
echo "2. Checking for memory leaks..."
docker stats --no-stream --format "{{.Name}}\t{{.MemUsage}}" | while read line; do
    name=$(echo $line | awk '{print $1}')
    mem=$(echo $line | awk '{print $2}' | sed 's/MiB//')
    limit=$(docker inspect $name --format '{{.HostConfig.Memory}}' 2>/dev/null | awk '{print $1/1048576}')
    if [ ! -z "$limit" ] && [ "$limit" != "0" ]; then
        percent=$(echo "scale=2; $mem / $limit * 100" | bc 2>/dev/null || echo "0")
        if (( $(echo "$percent > 75" | bc -l) )); then
            echo "   ⚠️  $name using ${percent}% of memory limit"
        fi
    fi
done

echo ""
echo "=== Long-term Recommendations ==="
echo ""
echo "1. Increase memory limits for services > 75% usage:"
echo "   - fraud-service: 384MB → 512MB"
echo "   - transaction-service: 384MB → 448MB"
echo "   - account-service: 384MB → 448MB"
echo ""
echo "2. Add JVM flags for better memory management:"
echo "   -XX:+UseStringDeduplication"
echo "   -XX:+AlwaysPreTouch"
echo "   -XX:InitiatingHeapOccupancyPercent=45"
echo ""
echo "3. Configure Kafka cleanup:"
echo "   - Set KAFKA_LOG_RETENTION_HOURS=1"
echo "   - Set KAFKA_LOG_SEGMENT_BYTES=52428800"
echo ""
echo "4. Monitor with:"
echo "   ./monitor-memory.sh"
echo ""

# Save current snapshot
echo "Saving memory snapshot to memory-snapshot-$(date +%Y%m%d-%H%M%S).txt"
docker stats --no-stream > "memory-snapshot-$(date +%Y%m%d-%H%M%S).txt"