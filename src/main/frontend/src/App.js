import React from 'react';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import StudentList from './components/StudentList';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap-icons/font/bootstrap-icons.css';

function App() {
    return (
        <Router>
            <h1 className="text-center mb-4">Student Management System</h1>
            <div className="container mt-4">
                <StudentList />
            </div>
        </Router>
    );
}

export default App;
