import React, { useState, useEffect } from 'react';
import {
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
  Chip,
  Typography,
  Box,
  CircularProgress,
} from '@mui/material';
import { format } from 'date-fns';
import transactionService from '../../services/transactionService';
import ArrowUpwardIcon from '@mui/icons-material/ArrowUpward';
import ArrowDownwardIcon from '@mui/icons-material/ArrowDownward';
import SwapHorizIcon from '@mui/icons-material/SwapHoriz';

const TransactionHistory = ({ accountId, refreshTrigger }) => {
  const [transactions, setTransactions] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    if (accountId) {
      loadTransactions();
    }
  }, [accountId, refreshTrigger]);

  const loadTransactions = async () => {
    try {
      setLoading(true);
      const data = await transactionService.getTransactionHistory(accountId);
      console.log('Transaction data:', data);
      // Sort by processedDate since that's what the API returns
      const sortedData = data.sort((a, b) => {
        try {
          const dateStringA = a.processedDate || a.createdDate || '';
          const dateStringB = b.processedDate || b.createdDate || '';
          
          // Handle Java LocalDateTime format
          const dateAStr = dateStringA.includes('Z') || dateStringA.includes('+') || dateStringA.includes('-', 10) 
            ? dateStringA : dateStringA + 'Z';
          const dateBStr = dateStringB.includes('Z') || dateStringB.includes('+') || dateStringB.includes('-', 10)
            ? dateStringB : dateStringB + 'Z';
          
          const dateA = new Date(dateAStr);
          const dateB = new Date(dateBStr);
          
          // Check for invalid dates
          if (isNaN(dateA.getTime())) return 1;
          if (isNaN(dateB.getTime())) return -1;
          
          return dateB - dateA;
        } catch (error) {
          console.error('Error sorting dates:', error);
          return 0;
        }
      });
      setTransactions(sortedData);
    } catch (error) {
      console.error('Error loading transactions:', error);
    } finally {
      setLoading(false);
    }
  };

  const formatCurrency = (amount) => {
    return new Intl.NumberFormat('en-US', {
      style: 'currency',
      currency: 'USD',
    }).format(amount);
  };

  const getTransactionIcon = (type) => {
    switch (type) {
      case 'DEPOSIT':
        return <ArrowUpwardIcon color="success" />;
      case 'WITHDRAWAL':
        return <ArrowDownwardIcon color="error" />;
      case 'TRANSFER':
        return <SwapHorizIcon color="primary" />;
      default:
        return null;
    }
  };

  const getTransactionColor = (type) => {
    switch (type) {
      case 'DEPOSIT':
        return 'success';
      case 'WITHDRAWAL':
        return 'error';
      case 'TRANSFER':
        return 'primary';
      default:
        return 'default';
    }
  };

  const getStatusColor = (status) => {
    switch (status) {
      case 'COMPLETED':
        return 'success';
      case 'PENDING':
        return 'warning';
      case 'SCHEDULED':
        return 'info';
      case 'FAILED':
        return 'error';
      default:
        return 'default';
    }
  };

  if (loading) {
    return (
      <Box display="flex" justifyContent="center" p={3}>
        <CircularProgress />
      </Box>
    );
  }

  if (transactions.length === 0) {
    return (
      <Typography variant="body1" color="text.secondary" align="center" py={3}>
        No transactions found
      </Typography>
    );
  }

  return (
    <TableContainer>
      <Table>
        <TableHead>
          <TableRow>
            <TableCell>Date</TableCell>
            <TableCell>Type</TableCell>
            <TableCell>Description</TableCell>
            <TableCell align="right">Amount</TableCell>
            <TableCell align="right">Balance After</TableCell>
            <TableCell>Status</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {transactions.map((transaction) => (
            <TableRow key={transaction.id}>
              <TableCell>
                {(() => {
                  try {
                    // For scheduled transactions, show scheduled date with a label
                    const dateString = transaction.status === 'SCHEDULED' && transaction.scheduledDate
                      ? transaction.scheduledDate 
                      : (transaction.processedDate || transaction.createdDate);
                    
                    if (!dateString) return 'No date';
                    
                    // Handle Java LocalDateTime format (e.g., "2024-01-01T10:30:00")
                    // If the date string doesn't include timezone info, append it
                    let dateToFormat = dateString;
                    if (!dateString.includes('Z') && !dateString.includes('+') && !dateString.includes('-', 10)) {
                      dateToFormat = dateString + 'Z';
                    }
                    
                    const date = new Date(dateToFormat);
                    if (isNaN(date.getTime())) {
                      console.warn('Invalid date format:', dateString);
                      return 'Invalid Date';
                    }
                    
                    const formattedDate = format(date, 'MMM dd, yyyy HH:mm');
                    return transaction.status === 'SCHEDULED' 
                      ? `Scheduled: ${formattedDate}`
                      : formattedDate;
                  } catch (error) {
                    console.error('Date formatting error:', error, transaction);
                    return 'Invalid Date';
                  }
                })()}
              </TableCell>
              <TableCell>
                <Box display="flex" alignItems="center" gap={1}>
                  {getTransactionIcon(transaction.transactionType)}
                  <Chip
                    label={transaction.transactionType}
                    size="small"
                    color={getTransactionColor(transaction.transactionType)}
                  />
                </Box>
              </TableCell>
              <TableCell>{transaction.description}</TableCell>
              <TableCell align="right">
                <Typography
                  variant="body2"
                  color={transaction.transactionType === 'DEPOSIT' ? 'success.main' : 'error.main'}
                  fontWeight="medium"
                >
                  {transaction.transactionType === 'DEPOSIT' ? '+' : '-'}
                  {formatCurrency(transaction.amount)}
                </Typography>
              </TableCell>
              <TableCell align="right">
                {formatCurrency(transaction.newBalance || transaction.balanceAfter || 0)}
              </TableCell>
              <TableCell>
                <Chip
                  label={transaction.status}
                  size="small"
                  color={getStatusColor(transaction.status)}
                />
              </TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
  );
};

export default TransactionHistory;