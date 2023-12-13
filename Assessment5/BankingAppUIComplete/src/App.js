import React from "react";
import "./App.css";

import "bootstrap/dist/css/bootstrap.min.css";
import { BrowserRouter as Routes, Route } from "react-router-dom";
import HomePage from "./pages/homePage";
import CustomersList from "./components/customers/customersList";
import CustomerDetails from "./components/customers/customerDetails";
import CustomerForm from "./components/customers/customerForm";
import AppNavBar from "./pages/appNavbar";

function App() {
  return (
    <div className="container">
      <AppNavBar />
      <br />
      <hr />
      <Routes>
        <Route exact path="/" element={HomePage} />
        <Route exact path="/customers" element={CustomersList} />
        <Route exact path="/customers/:id" element={CustomerDetails} />
        <Route exact path="/new/customers/" element={CustomerForm} />
        <Route exact path="/customers/:id/edit" element={CustomerForm} />
      </Routes>
    </div>
  );
}

export default App;
