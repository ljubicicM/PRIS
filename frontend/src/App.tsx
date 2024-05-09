import './App.css';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import { RegisterPage } from './routes/RegisterPage';

function App() {
  return (
    <div className="App">
      <Router>
        <Routes>
          <Route path="/register" element={<RegisterPage />} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
