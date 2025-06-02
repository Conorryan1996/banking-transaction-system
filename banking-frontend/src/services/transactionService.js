import api from './api';

const transactionService = {
  getTransactionHistory: async (accountId) => {
    const response = await api.get(`/transactions/account/${accountId}`);
    return response.data;
  },

  deposit: async (accountId, amount, description = 'Deposit') => {
    const response = await api.post('/transactions', {
      accountId,
      amount,
      transactionType: 'DEPOSIT',
      description,
    });
    return response.data;
  },

  withdraw: async (accountId, amount, description = 'Withdrawal') => {
    const response = await api.post('/transactions', {
      accountId,
      amount,
      transactionType: 'WITHDRAWAL',
      description,
    });
    return response.data;
  },

  transfer: async (fromAccountId, toAccountId, amount, description = 'Transfer') => {
    const response = await api.post('/transactions', {
      accountId: fromAccountId,
      targetAccountId: toAccountId,
      amount,
      transactionType: 'TRANSFER',
      description,
    });
    return response.data;
  },

  scheduleTransfer: async (fromAccountId, toAccountId, amount, description = 'Scheduled Transfer', scheduledDate) => {
    const response = await api.post('/transactions/schedule', {
      accountId: fromAccountId,
      targetAccountId: toAccountId,
      amount,
      transactionType: 'TRANSFER',
      description,
      scheduledDate,
    });
    return response.data;
  },
};

export default transactionService;