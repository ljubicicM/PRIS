/* eslint-disable eqeqeq */
import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import axios from 'axios';

const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);

const initAdmin = () => {
  axios.post('http://localhost:8082/user/initAdmin')
}
initAdmin();

if (localStorage.getItem('loadedToken') != 'true') {
  localStorage.setItem('userType', '');
  localStorage.setItem('userId', '');
}
localStorage.setItem('loadedToken', 'true');

root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);
