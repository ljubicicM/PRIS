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
import { SaveEpochPage } from './routes/SaveEpochPage';
import { SaveArtistPage } from './routes/SaveArtistPage';
import { SaveArtisticMovement } from './routes/SaveArtisticMovement';
import { SaveArtPiecePage } from './routes/SaveArtPiecePage';
import { SavedRoutesPage } from './routes/SavedRoutesPage';
import { LogoutProcess } from './routes/LogoutProcess';


function App() {

  const [userType, setUserType] = useState("");
  const [userId, setUserId] = useState(0);
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
            <Route path="/save/epoch" element={<SaveEpochPage />} />
            <Route path="save/artist" element={<SaveArtistPage />} />
            <Route path="save/artisticmovement" element={<SaveArtisticMovement />} />
            <Route path="save/artpiece" element={<SaveArtPiecePage />} />
            <Route path="/savedroutes" element={<SavedRoutesPage />} />
            <Route path="/logout" element={<LogoutProcess />} />
          </Routes>
        </Router>
      </Context.Provider>
    </div>
  );
}

export default App;
