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
  Stepper,
  Step,
  StepLabel,
  Paper,
  Divider,
} from '@mui/material';
import SendIcon from '@mui/icons-material/Send';
import PersonSearchIcon from '@mui/icons-material/PersonSearch';
import transactionService from '../../services/transactionService';
import accountService from '../../services/accountService';
import api from '../../services/api';

const TransferDialog = ({ open, onClose, accountId, currentBalance, onSuccess }) => {
  const [activeStep, setActiveStep] = useState(0);
  const [recipientAccountNumber, setRecipientAccountNumber] = useState('');
  const [recipientInfo, setRecipientInfo] = useState(null);
  const [amount, setAmount] = useState('');
  const [description, setDescription] = useState('');
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState('');

  const steps = ['Enter Recipient Account', 'Enter Amount', 'Confirm Transfer'];

  const formatCurrency = (amount) => {
    return new Intl.NumberFormat('en-US', {
      style: 'currency',
      currency: 'USD',
    }).format(amount);
  };

  const validateRecipient = async () => {
    setError('');
    setLoading(true);

    try {
      // Check if account exists
      const response = await api.get(`/accounts/number/${recipientAccountNumber}/exists`);
      
      if (response.data) {
        // Get recipient account info
        const accountResponse = await api.get(`/accounts/number/${recipientAccountNumber}`);
        const recipientAccount = accountResponse.data;
        
        // Check if account is active
        if (recipientAccount.status !== 'ACTIVE') {
          setError('Recipient account is not active');
          return;
        }
        
        // Check if account can receive transfers
        if (recipientAccount.accountType !== 'CHECKING' && recipientAccount.accountType !== 'SAVINGS') {
          setError('This account type cannot receive transfers');
          return;
        }
        
        // Get customer info for the account
        const customerResponse = await api.get(`/customers/${recipientAccount.customerId}`);
        const customer = customerResponse.data;
        
        setRecipientInfo({
          customer: customer,
          account: recipientAccount
        });
        setActiveStep(1);
      } else {
        setError('Account number not found. Please check and try again.');
      }
    } catch (error) {
      setError('Failed to validate recipient. Please try again.');
    } finally {
      setLoading(false);
    }
  };

  const handleAmountNext = () => {
    const transferAmount = parseFloat(amount);
    
    if (isNaN(transferAmount) || transferAmount <= 0) {
      setError('Please enter a valid amount greater than 0');
      return;
    }

    if (transferAmount > currentBalance) {
      setError('Insufficient funds. Your current balance is ' + formatCurrency(currentBalance));
      return;
    }

    setError('');
    setActiveStep(2);
  };

  const handleTransfer = async () => {
    setError('');
    setLoading(true);

    try {
      const transferAmount = parseFloat(amount);
      
      // For now, we'll process this as a withdrawal from the sender's account
      // and a deposit to the recipient's account
      // In a real implementation, this would be a single atomic transaction
      
      // First, validate the recipient account still exists
      const recipientAccountId = recipientInfo.account.id;
      
      // Process the transfer
      await transactionService.transfer(
        accountId,
        recipientAccountId,
        transferAmount,
        description || `Transfer to ${recipientInfo.customer.firstName} ${recipientInfo.customer.lastName}`
      );
      
      onSuccess();
      handleClose();
    } catch (error) {
      if (error.response?.status === 403) {
        setError('Transaction blocked due to fraud detection. Please contact customer service.');
      } else {
        setError(error.response?.data?.message || 'Failed to process transfer');
      }
    } finally {
      setLoading(false);
    }
  };

  const handleClose = () => {
    setActiveStep(0);
    setRecipientAccountNumber('');
    setRecipientInfo(null);
    setAmount('');
    setDescription('');
    setError('');
    onClose();
  };

  const handleBack = () => {
    setError('');
    setActiveStep(activeStep - 1);
  };

  const renderStepContent = () => {
    switch (activeStep) {
      case 0:
        return (
          <Box sx={{ pt: 2 }}>
            <Typography variant="body2" color="text.secondary" gutterBottom>
              Enter the account number of the recipient.
            </Typography>
            {error && (
              <Alert severity="error" sx={{ mb: 2 }}>
                {error}
              </Alert>
            )}
            <TextField
              autoFocus
              margin="dense"
              label="Recipient Account Number"
              fullWidth
              variant="outlined"
              value={recipientAccountNumber}
              onChange={(e) => setRecipientAccountNumber(e.target.value)}
              placeholder="e.g., ACC1234567890"
              helperText="Enter the account number where you want to send money"
            />
          </Box>
        );

      case 1:
        return (
          <Box sx={{ pt: 2 }}>
            {recipientInfo && (
              <Paper elevation={1} sx={{ p: 2, mb: 2, bgcolor: 'grey.50' }}>
                <Typography variant="subtitle2" color="text.secondary">
                  Sending to:
                </Typography>
                <Typography variant="body1" fontWeight="medium">
                  {recipientInfo.customer.firstName} {recipientInfo.customer.lastName}
                </Typography>
                <Typography variant="caption" color="text.secondary">
                  Account: {recipientInfo.account.accountNumber} ({recipientInfo.account.accountType})
                </Typography>
              </Paper>
            )}
            
            <Alert severity="info" sx={{ mb: 2 }}>
              <Typography variant="body2">
                Available Balance: <strong>{formatCurrency(currentBalance)}</strong>
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
              label="Amount to Transfer"
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
              placeholder="e.g., Rent payment, Gift, etc."
            />
          </Box>
        );

      case 2:
        return (
          <Box sx={{ pt: 2 }}>
            <Alert severity="warning" sx={{ mb: 2 }}>
              Please review the transfer details before confirming.
            </Alert>
            
            {error && (
              <Alert severity="error" sx={{ mb: 2 }}>
                {error}
              </Alert>
            )}
            
            <Paper elevation={1} sx={{ p: 2 }}>
              <Typography variant="subtitle2" color="text.secondary" gutterBottom>
                Transfer Summary
              </Typography>
              
              <Box sx={{ mt: 1 }}>
                <Box sx={{ display: 'flex', justifyContent: 'space-between', mb: 1 }}>
                  <Typography variant="body2" color="text.secondary">To:</Typography>
                  <Typography variant="body2" fontWeight="medium">
                    {recipientInfo?.customer.firstName} {recipientInfo?.customer.lastName}
                  </Typography>
                </Box>
                
                <Box sx={{ display: 'flex', justifyContent: 'space-between', mb: 1 }}>
                  <Typography variant="body2" color="text.secondary">Account:</Typography>
                  <Typography variant="body2">
                    {recipientInfo?.account.accountNumber}
                  </Typography>
                </Box>
                
                <Box sx={{ display: 'flex', justifyContent: 'space-between', mb: 1 }}>
                  <Typography variant="body2" color="text.secondary">Amount:</Typography>
                  <Typography variant="body1" fontWeight="bold" color="primary">
                    {formatCurrency(parseFloat(amount || 0))}
                  </Typography>
                </Box>
                
                {description && (
                  <Box sx={{ display: 'flex', justifyContent: 'space-between', mb: 1 }}>
                    <Typography variant="body2" color="text.secondary">Description:</Typography>
                    <Typography variant="body2">{description}</Typography>
                  </Box>
                )}
                
                <Divider sx={{ my: 1 }} />
                
                <Box sx={{ display: 'flex', justifyContent: 'space-between' }}>
                  <Typography variant="body2" color="text.secondary">New Balance:</Typography>
                  <Typography variant="body2" fontWeight="medium">
                    {formatCurrency(currentBalance - parseFloat(amount || 0))}
                  </Typography>
                </Box>
              </Box>
            </Paper>
          </Box>
        );

      default:
        return null;
    }
  };

  return (
    <Dialog open={open} onClose={handleClose} maxWidth="sm" fullWidth>
      <DialogTitle>
        <Box sx={{ display: 'flex', alignItems: 'center', gap: 1 }}>
          <SendIcon color="primary" />
          Transfer Money
        </Box>
      </DialogTitle>
      
      <DialogContent>
        <Stepper activeStep={activeStep} sx={{ mb: 3 }}>
          {steps.map((label) => (
            <Step key={label}>
              <StepLabel>{label}</StepLabel>
            </Step>
          ))}
        </Stepper>
        
        {renderStepContent()}
      </DialogContent>
      
      <DialogActions>
        <Button onClick={handleClose} disabled={loading}>
          Cancel
        </Button>
        
        {activeStep > 0 && (
          <Button onClick={handleBack} disabled={loading}>
            Back
          </Button>
        )}
        
        {activeStep === 0 && (
          <Button
            onClick={validateRecipient}
            variant="contained"
            disabled={loading || !recipientAccountNumber}
            startIcon={loading ? <CircularProgress size={20} /> : <PersonSearchIcon />}
          >
            Validate Account
          </Button>
        )}
        
        {activeStep === 1 && (
          <Button
            onClick={handleAmountNext}
            variant="contained"
            disabled={loading || !amount}
          >
            Next
          </Button>
        )}
        
        {activeStep === 2 && (
          <Button
            onClick={handleTransfer}
            variant="contained"
            color="primary"
            disabled={loading}
            startIcon={loading ? <CircularProgress size={20} /> : <SendIcon />}
          >
            Confirm Transfer
          </Button>
        )}
      </DialogActions>
    </Dialog>
  );
};

export default TransferDialog;