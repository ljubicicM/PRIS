import './App.css';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import { RegisterPage } from './routes/RegisterPage';
import { LoginPage } from './routes/LoginPage';
import { CRSearchByPage } from './routes/CRSearchByPage';

function App() {
  return (
    <div className="App">
      <Router>
        <Routes>
          <Route path="/register" element={<RegisterPage />} />
          <Route path="/login" element={<LoginPage />} />
          <Route path="/cr/searchby" element={<CRSearchByPage />} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
