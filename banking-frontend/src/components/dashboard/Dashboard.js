import React, { useState, useEffect } from 'react';
import {
  Container,
  Grid,
  Paper,
  Typography,
  Box,
  Card,
  CardContent,
  Button,
  Divider,
} from '@mui/material';
import { useAuth } from '../../contexts/AuthContext';
import accountService from '../../services/accountService';
import TransactionHistory from './TransactionHistory';
import DepositDialog from '../transactions/DepositDialog';
import TransferDialog from '../transactions/TransferDialog';
import BillPayDialog from '../transactions/BillPayDialog';
import AccountBalanceIcon from '@mui/icons-material/AccountBalance';
import TrendingUpIcon from '@mui/icons-material/TrendingUp';
import TrendingDownIcon from '@mui/icons-material/TrendingDown';
import PaymentIcon from '@mui/icons-material/Payment';

const Dashboard = () => {
  const { user } = useAuth();
  const [accounts, setAccounts] = useState([]);
  const [selectedAccount, setSelectedAccount] = useState(null);
  const [balance, setBalance] = useState(null);
  const [loading, setLoading] = useState(true);
  const [depositOpen, setDepositOpen] = useState(false);
  const [transferOpen, setTransferOpen] = useState(false);
  const [billPayOpen, setBillPayOpen] = useState(false);
  const [refreshTrigger, setRefreshTrigger] = useState(0);

  useEffect(() => {
    if (user?.customerId) {
      loadAccounts();
    }
  }, [user, refreshTrigger]);

  useEffect(() => {
    if (selectedAccount) {
      loadBalance();
    }
  }, [selectedAccount, refreshTrigger]);

  const loadAccounts = async () => {
    try {
      console.log('Loading accounts for customer:', user.customerId);
      const accountsData = await accountService.getCustomerAccounts(user.customerId);
      console.log('Accounts loaded:', accountsData);
      setAccounts(accountsData);
      if (accountsData.length > 0 && !selectedAccount) {
        setSelectedAccount(accountsData[0]);
      }
    } catch (error) {
      console.error('Error loading accounts:', error);
      // Don't break the app on account loading error
    } finally {
      setLoading(false);
    }
  };

  const loadBalance = async () => {
    try {
      console.log('Loading balance for account:', selectedAccount.id);
      const balanceData = await accountService.getAccountBalance(selectedAccount.id);
      console.log('Balance loaded:', balanceData);
      setBalance(balanceData);
    } catch (error) {
      console.error('Error loading balance:', error);
      // Don't break the app on balance loading error
    }
  };

  const handleTransactionComplete = () => {
    try {
      console.log('Transaction completed, refreshing data...');
      setRefreshTrigger(prev => prev + 1);
      setDepositOpen(false);
      setTransferOpen(false);
    } catch (error) {
      console.error('Error in handleTransactionComplete:', error);
    }
  };

  const formatCurrency = (amount) => {
    return new Intl.NumberFormat('en-US', {
      style: 'currency',
      currency: 'USD',
    }).format(amount);
  };

  if (loading) {
    return <Typography>Loading...</Typography>;
  }

  return (
    <Container maxWidth="lg" sx={{ mt: 4, mb: 4 }}>
      <Grid container spacing={3}>
        {/* Welcome Section */}
        <Grid item xs={12}>
          <Paper sx={{ p: 3, display: 'flex', alignItems: 'center', justifyContent: 'space-between' }}>
            <Box>
              <Typography variant="h4" gutterBottom>
                Welcome back, {user.username}!
              </Typography>
              <Typography variant="body1" color="text.secondary">
                Manage your accounts and transactions
              </Typography>
            </Box>
            <AccountBalanceIcon sx={{ fontSize: 60, color: 'primary.main' }} />
          </Paper>
        </Grid>

        {/* Account Overview */}
        <Grid item xs={12} md={4}>
          <Card>
            <CardContent>
              <Typography variant="h6" gutterBottom>
                Account Overview
              </Typography>
              <Divider sx={{ mb: 2 }} />
              {selectedAccount && (
                <>
                  <Typography variant="body2" color="text.secondary">
                    Account Number
                  </Typography>
                  <Typography variant="h6" gutterBottom>
                    {selectedAccount.accountNumber}
                  </Typography>
                  <Typography variant="body2" color="text.secondary">
                    Account Type
                  </Typography>
                  <Typography variant="h6" gutterBottom>
                    {selectedAccount.accountType}
                  </Typography>
                  <Typography variant="body2" color="text.secondary">
                    Status
                  </Typography>
                  <Typography variant="h6" color="success.main">
                    {selectedAccount.status}
                  </Typography>
                </>
              )}
            </CardContent>
          </Card>
        </Grid>

        {/* Balance Card */}
        <Grid item xs={12} md={4}>
          <Card>
            <CardContent>
              <Typography variant="h6" gutterBottom>
                Current Balance
              </Typography>
              <Divider sx={{ mb: 2 }} />
              <Typography variant="h3" color="primary.main" gutterBottom>
                {balance ? formatCurrency(balance.balance) : '$0.00'}
              </Typography>
              <Typography variant="body2" color="text.secondary">
                Available for transactions
              </Typography>
            </CardContent>
          </Card>
        </Grid>

        {/* Quick Actions */}
        <Grid item xs={12} md={4}>
          <Card>
            <CardContent>
              <Typography variant="h6" gutterBottom>
                Quick Actions
              </Typography>
              <Divider sx={{ mb: 2 }} />
              <Box sx={{ display: 'flex', flexDirection: 'column', gap: 2 }}>
                <Button
                  variant="contained"
                  color="success"
                  startIcon={<TrendingUpIcon />}
                  fullWidth
                  onClick={() => setDepositOpen(true)}
                >
                  Deposit Money
                </Button>
                <Button
                  variant="contained"
                  color="warning"
                  startIcon={<TrendingDownIcon />}
                  fullWidth
                  onClick={() => setTransferOpen(true)}
                >
                  Transfer Money
                </Button>
                <Button
                  variant="contained"
                  color="primary"
                  startIcon={<PaymentIcon />}
                  fullWidth
                  onClick={() => setBillPayOpen(true)}
                >
                  Schedule Bill Pay
                </Button>
              </Box>
            </CardContent>
          </Card>
        </Grid>

        {/* Transaction History */}
        <Grid item xs={12}>
          <Paper sx={{ p: 3 }}>
            <Typography variant="h6" gutterBottom>
              Recent Transactions
            </Typography>
            <Divider sx={{ mb: 2 }} />
            {selectedAccount && (
              <TransactionHistory 
                accountId={selectedAccount.id} 
                refreshTrigger={refreshTrigger}
              />
            )}
          </Paper>
        </Grid>
      </Grid>

      {/* Dialogs */}
      {selectedAccount && (
        <>
          <DepositDialog
            open={depositOpen}
            onClose={() => setDepositOpen(false)}
            accountId={selectedAccount.id}
            onSuccess={handleTransactionComplete}
          />
          <TransferDialog
            open={transferOpen}
            onClose={() => setTransferOpen(false)}
            accountId={selectedAccount.id}
            currentBalance={balance?.balance || 0}
            onSuccess={handleTransactionComplete}
          />
          <BillPayDialog
            open={billPayOpen}
            onClose={() => setBillPayOpen(false)}
            accountId={selectedAccount.id}
            currentBalance={balance?.balance || 0}
            onSuccess={handleTransactionComplete}
          />
        </>
      )}
    </Container>
  );
};

export default Dashboard;