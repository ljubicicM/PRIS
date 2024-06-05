import './App.css';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import { RegisterPage } from './routes/RegisterPage';
import { LoginPage } from './routes/LoginPage';
import { Context } from './context';
import { useState } from 'react';
import { NavBar } from './components/navBarComponent/NavBar';


function App() {
  const [userType, setUserType] = useState("admin");
  const [userId, setUserId] = useState("");
  const [isNavBarVisible, setIsNavBarVisible] = useState(true);
  return (
    <div className="App">
      <Context.Provider value={{
        userType: userType, setUserType: setUserType,
        userId: userId, setUserId: setUserId,
        isNavBarVisible: isNavBarVisible, setIsNavBarVisible: setIsNavBarVisible
      }}>
        <Router>
          <NavBar elements={[]} />
          <Routes>
            <Route path="/register" element={<RegisterPage />} />
            <Route path="/login" element={<LoginPage />} />
          </Routes>
        </Router>
      </Context.Provider>
    </div>
  );
}

export default App;
