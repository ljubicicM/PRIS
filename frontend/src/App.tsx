import './App.css';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import { RegisterPage } from './routes/RegisterPage';
import { LoginPage } from './routes/LoginPage';
import { CRSearchByPage } from './routes/CRSearchByPage';
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
import { UpdateTextPage } from './routes/UpdateTextPage';
import { ApproveGuidePage } from './routes/ApproveGuidePage';


function App() {

  return (
    <div className="App">
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
          <Route path="save/author" element={<SaveArtistPage />} />
          <Route path="save/artisticmovement" element={<SaveArtisticMovement />} />
          <Route path="save/artpiece" element={<SaveArtPiecePage />} />
          <Route path="/savedroutes" element={<SavedRoutesPage />} />
          <Route path="/update" element={<UpdateTextPage />} />
          <Route path="/approveguide" element={<ApproveGuidePage />} />
          <Route path="/logout" element={<LogoutProcess />} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
