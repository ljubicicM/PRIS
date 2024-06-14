import './App.css';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import { RegisterPage } from './routes/RegisterPage';
import { LoginPage } from './routes/LoginPage';
import { CRSearchByPage } from './routes/CRSearchByPage';
import { Context } from './context';
import { useState } from 'react';
import { NavBar } from './components/navBarComponent/NavBar';
import { HomePage } from './routes/HomePage';
import { CRSortByPage } from './routes/CRSortByPage';
import { CRChooseContextPage } from './routes/CRChooseContextPage';


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
          <NavBar />
          <Routes>
            <Route path="/" element={<HomePage />} />
            <Route path="/register" element={<RegisterPage />} />
            <Route path="/login" element={<LoginPage />} />
            <Route path="/cr/searchby" element={<CRSearchByPage />} />
            <Route path="/cr/sortby" element={<CRSortByPage />} />
            <Route path="/cr/choosecontext" element={<CRChooseContextPage />} />
          </Routes>
        </Router>
      </Context.Provider>
    </div>
  );
}

export default App;
