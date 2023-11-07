import React from 'react';
import CustomerList from './components/customer/customerList';
import './App.css';

const App = () => {
    return (
        <div className='App'>
            <h1> Customers Component</h1>
            <CustomerList/>
        </div>
    );
}

export default App;
