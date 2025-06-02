import api from './api';

const authService = {
  login: async (username, password) => {
    const response = await api.post('/auth/login', { username, password });
    const { accessToken, refreshToken, userId, customerId, email } = response.data;
    
    localStorage.setItem('accessToken', accessToken);
    localStorage.setItem('refreshToken', refreshToken);
    localStorage.setItem('userId', userId);
    localStorage.setItem('customerId', customerId);
    localStorage.setItem('username', username);
    localStorage.setItem('email', email);
    
    return response.data;
  },

  register: async (customerData) => {
    // First create the customer
    const customerResponse = await api.post('/customers', customerData);
    return customerResponse.data;
  },

  logout: () => {
    localStorage.removeItem('accessToken');
    localStorage.removeItem('refreshToken');
    localStorage.removeItem('userId');
    localStorage.removeItem('customerId');
    localStorage.removeItem('username');
    localStorage.removeItem('email');
  },

  isAuthenticated: () => {
    return !!localStorage.getItem('accessToken');
  },

  getUser: () => {
    return {
      userId: localStorage.getItem('userId'),
      customerId: localStorage.getItem('customerId'),
      username: localStorage.getItem('username'),
      email: localStorage.getItem('email'),
    };
  },
};

export default authService;