import './App.css';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import { Button } from './components/buttonComponent/Button';
import { Textfield } from './components/textFieldComponent/textfield';
import { RegisterPage } from './routes/RegisterPage';

function App() {
  return (
    <div className="App">
      <Router>
        <Routes>
          <Route path="/" element={<Textfield headerText='email' size='medium' placeholder='mail@adress.com' />} />
          <Route path="/register" element={<RegisterPage />} />
          <Route path="/b" element={<Button label='Klikni' size='small' onClick={() => { }} />} />
          <Route path="/t" element={<Textfield headerText='email' size='medium' placeholder='mail@adress.com' />} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
