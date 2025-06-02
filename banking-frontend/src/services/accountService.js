import api from './api';

const accountService = {
  getCustomerAccounts: async (customerId) => {
    const response = await api.get(`/accounts/customer/${customerId}`);
    return response.data;
  },

  getAccount: async (accountId) => {
    const response = await api.get(`/accounts/${accountId}`);
    return response.data;
  },

  getAccountBalance: async (accountId) => {
    const response = await api.get(`/transactions/account/${accountId}/balance`);
    return response.data;
  },
};

export default accountService;