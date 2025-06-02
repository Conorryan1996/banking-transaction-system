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
import { DateTimePicker } from '@mui/x-date-pickers/DateTimePicker';
import { LocalizationProvider } from '@mui/x-date-pickers/LocalizationProvider';
import { AdapterDateFns } from '@mui/x-date-pickers/AdapterDateFns';
import PaymentIcon from '@mui/icons-material/Payment';
import CalendarMonthIcon from '@mui/icons-material/CalendarMonth';
import PersonSearchIcon from '@mui/icons-material/PersonSearch';
import { format, addDays, startOfDay } from 'date-fns';
import transactionService from '../../services/transactionService';
import accountService from '../../services/accountService';
import api from '../../services/api';

const BillPayDialog = ({ open, onClose, accountId, currentBalance, onSuccess }) => {
  const [activeStep, setActiveStep] = useState(0);
  const [payeeAccountNumber, setPayeeAccountNumber] = useState('');
  const [payeeInfo, setPayeeInfo] = useState(null);
  const [amount, setAmount] = useState('');
  const [description, setDescription] = useState('');
  const [scheduledDate, setScheduledDate] = useState(addDays(new Date(), 1));
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState('');

  const steps = ['Enter Payee Account', 'Payment Details', 'Schedule Payment', 'Confirm Payment'];

  const formatCurrency = (amount) => {
    return new Intl.NumberFormat('en-US', {
      style: 'currency',
      currency: 'USD',
    }).format(amount);
  };

  const validatePayee = async () => {
    setError('');
    setLoading(true);

    try {
      // Check if account exists
      const response = await api.get(`/accounts/number/${payeeAccountNumber}/exists`);
      
      if (response.data) {
        // Get payee account info
        const accountResponse = await api.get(`/accounts/number/${payeeAccountNumber}`);
        const payeeAccount = accountResponse.data;
        
        // Check if account is active
        if (payeeAccount.status !== 'ACTIVE') {
          setError('Payee account is not active');
          return;
        }
        
        // Check if account can receive payments
        if (payeeAccount.accountType !== 'CHECKING' && payeeAccount.accountType !== 'SAVINGS') {
          setError('This account type cannot receive payments');
          return;
        }
        
        // Get customer info for the account
        const customerResponse = await api.get(`/customers/${payeeAccount.customerId}`);
        const customer = customerResponse.data;
        
        setPayeeInfo({
          customer: customer,
          account: payeeAccount
        });
        setActiveStep(1);
      } else {
        setError('Account number not found. Please check and try again.');
      }
    } catch (error) {
      setError('Failed to validate payee. Please try again.');
    } finally {
      setLoading(false);
    }
  };

  const handleAmountNext = () => {
    const paymentAmount = parseFloat(amount);
    
    if (isNaN(paymentAmount) || paymentAmount <= 0) {
      setError('Please enter a valid amount greater than 0');
      return;
    }

    if (paymentAmount > currentBalance) {
      setError('Insufficient funds. Your current balance is ' + formatCurrency(currentBalance));
      return;
    }

    setError('');
    setActiveStep(2);
  };

  const handleScheduleNext = () => {
    // Validate scheduled date is in the future
    const now = new Date();
    if (scheduledDate <= now) {
      setError('Scheduled date must be in the future');
      return;
    }

    setError('');
    setActiveStep(3);
  };

  const handleSchedulePayment = async () => {
    setError('');
    setLoading(true);

    try {
      const paymentAmount = parseFloat(amount);
      
      // Schedule the bill payment
      await transactionService.scheduleTransfer(
        accountId,
        payeeInfo.account.id,
        paymentAmount,
        description || `Bill payment to ${payeeInfo.customer.firstName} ${payeeInfo.customer.lastName}`,
        scheduledDate.toISOString()
      );
      
      onSuccess();
      handleClose();
    } catch (error) {
      if (error.response?.status === 403) {
        setError('Payment blocked due to fraud detection. Please contact customer service.');
      } else {
        setError(error.response?.data?.message || 'Failed to schedule payment');
      }
    } finally {
      setLoading(false);
    }
  };

  const handleClose = () => {
    setActiveStep(0);
    setPayeeAccountNumber('');
    setPayeeInfo(null);
    setAmount('');
    setDescription('');
    setScheduledDate(addDays(new Date(), 1));
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
              Enter the account number of the payee you want to send the payment to.
            </Typography>
            <TextField
              fullWidth
              label="Payee Account Number"
              value={payeeAccountNumber}
              onChange={(e) => setPayeeAccountNumber(e.target.value)}
              margin="normal"
              placeholder="Enter account number"
              InputProps={{
                startAdornment: (
                  <InputAdornment position="start">
                    <PersonSearchIcon />
                  </InputAdornment>
                ),
              }}
              autoFocus
            />
          </Box>
        );

      case 1:
        return (
          <Box sx={{ pt: 2 }}>
            {payeeInfo && (
              <Paper elevation={1} sx={{ p: 2, mb: 3, bgcolor: 'grey.50' }}>
                <Typography variant="subtitle2" color="text.secondary">
                  Paying to:
                </Typography>
                <Typography variant="h6">
                  {payeeInfo.customer.firstName} {payeeInfo.customer.lastName}
                </Typography>
                <Typography variant="body2" color="text.secondary">
                  Account: {payeeInfo.account.accountNumber} ({payeeInfo.account.accountType})
                </Typography>
              </Paper>
            )}

            <Typography variant="body2" color="text.secondary" gutterBottom>
              Enter the payment amount and description.
            </Typography>

            <TextField
              fullWidth
              label="Amount"
              value={amount}
              onChange={(e) => setAmount(e.target.value)}
              margin="normal"
              type="number"
              InputProps={{
                startAdornment: <InputAdornment position="start">$</InputAdornment>,
              }}
              inputProps={{
                min: 0.01,
                step: 0.01,
              }}
              autoFocus
            />

            <TextField
              fullWidth
              label="Description (Optional)"
              value={description}
              onChange={(e) => setDescription(e.target.value)}
              margin="normal"
              multiline
              rows={2}
              placeholder="e.g., Monthly utilities bill"
            />

            <Typography variant="caption" color="text.secondary" sx={{ mt: 1 }}>
              Available balance: {formatCurrency(currentBalance)}
            </Typography>
          </Box>
        );

      case 2:
        return (
          <Box sx={{ pt: 2 }}>
            <Typography variant="body2" color="text.secondary" gutterBottom>
              Select when you want this payment to be processed.
            </Typography>

            <LocalizationProvider dateAdapter={AdapterDateFns}>
              <DateTimePicker
                label="Payment Date & Time"
                value={scheduledDate}
                onChange={setScheduledDate}
                renderInput={(params) => <TextField {...params} fullWidth margin="normal" />}
                minDateTime={new Date()}
                slotProps={{
                  textField: {
                    fullWidth: true,
                    margin: 'normal',
                    InputProps: {
                      startAdornment: (
                        <InputAdornment position="start">
                          <CalendarMonthIcon />
                        </InputAdornment>
                      ),
                    },
                  },
                }}
              />
            </LocalizationProvider>

            <Paper elevation={1} sx={{ p: 2, mt: 3, bgcolor: 'info.50' }}>
              <Typography variant="subtitle2" color="info.main" gutterBottom>
                Scheduled Payment Info
              </Typography>
              <Typography variant="body2">
                • Payment will be processed on {format(scheduledDate, 'PPP')} at {format(scheduledDate, 'p')}
              </Typography>
              <Typography variant="body2">
                • Funds will be deducted from your account at the scheduled time
              </Typography>
              <Typography variant="body2">
                • You can view scheduled payments in your transaction history
              </Typography>
            </Paper>
          </Box>
        );

      case 3:
        return (
          <Box sx={{ pt: 2 }}>
            <Paper elevation={2} sx={{ p: 3 }}>
              <Typography variant="h6" gutterBottom>
                Payment Summary
              </Typography>
              
              <Divider sx={{ my: 2 }} />
              
              <Box sx={{ mb: 2 }}>
                <Typography variant="body2" color="text.secondary">
                  Paying to
                </Typography>
                <Typography variant="body1" fontWeight="bold">
                  {payeeInfo?.customer.firstName} {payeeInfo?.customer.lastName}
                </Typography>
                <Typography variant="body2" color="text.secondary">
                  Account: {payeeInfo?.account.accountNumber}
                </Typography>
              </Box>

              <Box sx={{ mb: 2 }}>
                <Typography variant="body2" color="text.secondary">
                  Payment Amount
                </Typography>
                <Typography variant="h5" color="primary" fontWeight="bold">
                  {formatCurrency(parseFloat(amount))}
                </Typography>
              </Box>

              <Box sx={{ mb: 2 }}>
                <Typography variant="body2" color="text.secondary">
                  Scheduled For
                </Typography>
                <Typography variant="body1" fontWeight="bold">
                  {format(scheduledDate, 'PPP')} at {format(scheduledDate, 'p')}
                </Typography>
              </Box>

              {description && (
                <Box sx={{ mb: 2 }}>
                  <Typography variant="body2" color="text.secondary">
                    Description
                  </Typography>
                  <Typography variant="body1">
                    {description}
                  </Typography>
                </Box>
              )}

              <Divider sx={{ my: 2 }} />

              <Box sx={{ bgcolor: 'warning.50', p: 2, borderRadius: 1 }}>
                <Typography variant="body2" color="warning.main">
                  <strong>Important:</strong> This payment will be automatically processed on the scheduled date. 
                  Ensure sufficient funds are available in your account.
                </Typography>
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
          <PaymentIcon color="primary" />
          Schedule Bill Payment
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

        {error && (
          <Alert severity="error" sx={{ mb: 2 }}>
            {error}
          </Alert>
        )}

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
            onClick={validatePayee}
            variant="contained"
            disabled={!payeeAccountNumber || loading}
            startIcon={loading && <CircularProgress size={20} />}
          >
            Next
          </Button>
        )}
        {activeStep === 1 && (
          <Button
            onClick={handleAmountNext}
            variant="contained"
            disabled={!amount || loading}
          >
            Next
          </Button>
        )}
        {activeStep === 2 && (
          <Button
            onClick={handleScheduleNext}
            variant="contained"
            disabled={loading}
          >
            Next
          </Button>
        )}
        {activeStep === 3 && (
          <Button
            onClick={handleSchedulePayment}
            variant="contained"
            color="primary"
            disabled={loading}
            startIcon={loading ? <CircularProgress size={20} /> : <PaymentIcon />}
          >
            {loading ? 'Scheduling...' : 'Confirm & Schedule'}
          </Button>
        )}
      </DialogActions>
    </Dialog>
  );
};

export default BillPayDialog;