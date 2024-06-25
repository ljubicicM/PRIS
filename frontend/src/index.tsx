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

root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);
