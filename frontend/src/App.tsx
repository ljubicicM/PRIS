import './App.css';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';

function App() {
  return (
    <div className="App">
      <Router>
        <Routes>
          <Route path="/" element={<p>Hi</p>} />
          <Route path="/hello" element={<p>Hello</p>} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
