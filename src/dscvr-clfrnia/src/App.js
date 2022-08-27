import React from 'react';
import Navbar from './components/Navbar';
import './App.css';
import Home from './components/pages/Home';
import Services from './components/pages/Services';
import Contact from './components/pages/Contact';
import SignUp from './components/pages/SignUp';
import Trailer from './components/pages/Trailer';
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';

function App() {
    return (
        <>
            <Router>
                <Navbar/>
                <Routes>
                    <Route path='/' element={<Home />} />
                    <Route path='/services' element={<Services />} />
                    <Route path='/products' element={<Contact />} />
                    <Route path='/sign-up' element={<SignUp />} />
                    <Route path='/trailer' element={<Trailer />} />
                </Routes>
            </Router>
        </>
    );
}

export default App;