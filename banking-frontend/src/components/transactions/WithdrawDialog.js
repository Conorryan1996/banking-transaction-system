import React, { useState } from 'react';
import {
  Dialog,
  DialogTitle,
  DialogContent,
  DialogActions,
  TextField,
  Button,
  Box,
  Alert,
  CircularProgress,
  InputAdornment,
  Typography,
} from '@mui/material';
import transactionService from '../../services/transactionService';

const WithdrawDialog = ({ open, onClose, accountId, currentBalance, onSuccess }) => {
  const [amount, setAmount] = useState('');
  const [description, setDescription] = useState('');
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState('');

  const formatCurrency = (amount) => {
    return new Intl.NumberFormat('en-US', {
      style: 'currency',
      currency: 'USD',
    }).format(amount);
  };

  const handleSubmit = async () => {
    setError('');
    
    const withdrawAmount = parseFloat(amount);
    if (isNaN(withdrawAmount) || withdrawAmount <= 0) {
      setError('Please enter a valid amount greater than 0');
      return;
    }

    if (withdrawAmount > currentBalance) {
      setError('Insufficient funds. Your current balance is ' + formatCurrency(currentBalance));
      return;
    }

    setLoading(true);
    try {
      await transactionService.withdraw(
        accountId,
        withdrawAmount,
        description || 'ATM Withdrawal'
      );
      onSuccess();
      handleClose();
    } catch (error) {
      if (error.response?.status === 403) {
        setError('Transaction blocked due to fraud detection. Please contact customer service.');
      } else {
        setError(error.response?.data?.message || 'Failed to process withdrawal');
      }
    } finally {
      setLoading(false);
    }
  };

  const handleClose = () => {
    setAmount('');
    setDescription('');
    setError('');
    onClose();
  };

  return (
    <Dialog open={open} onClose={handleClose} maxWidth="sm" fullWidth>
      <DialogTitle>Make a Withdrawal</DialogTitle>
      <DialogContent>
        <Box sx={{ pt: 2 }}>
          <Alert severity="info" sx={{ mb: 2 }}>
            <Typography variant="body2">
              Available Balance: <strong>{formatCurrency(currentBalance)}</strong>
            </Typography>
            <Typography variant="caption" display="block" sx={{ mt: 1 }}>
              Daily withdrawal limit: $1,000 | Maximum 5 withdrawals per day
            </Typography>
          </Alert>
          
          {error && (
            <Alert severity="error" sx={{ mb: 2 }}>
              {error}
            </Alert>
          )}
          
          <TextField
            autoFocus
            margin="dense"
            label="Amount"
            type="number"
            fullWidth
            variant="outlined"
            value={amount}
            onChange={(e) => setAmount(e.target.value)}
            InputProps={{
              startAdornment: <InputAdornment position="start">$</InputAdornment>,
              inputProps: { min: 0, step: 0.01, max: currentBalance }
            }}
            sx={{ mb: 2 }}
          />
          
          <TextField
            margin="dense"
            label="Description (Optional)"
            fullWidth
            variant="outlined"
            value={description}
            onChange={(e) => setDescription(e.target.value)}
            placeholder="e.g., ATM withdrawal, Cash withdrawal"
          />
        </Box>
      </DialogContent>
      <DialogActions>
        <Button onClick={handleClose} disabled={loading}>
          Cancel
        </Button>
        <Button
          onClick={handleSubmit}
          variant="contained"
          color="warning"
          disabled={loading || !amount}
        >
          {loading ? <CircularProgress size={24} /> : 'Withdraw'}
        </Button>
      </DialogActions>
    </Dialog>
  );
};

export default WithdrawDialog;