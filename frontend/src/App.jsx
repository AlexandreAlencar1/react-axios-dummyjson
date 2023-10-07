import React from "react";
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";

import { Route, BrowserRouter as Router, Routes } from "react-router-dom"; // Importe Routes aqui

import Home from "./components/pages/Home";
import ProductDetails from "./components/products/ProductDetails";
import ProductList from "./components/products/ProductList";
import AddUser from "./components/users/AddUser";
import EditUser from "./components/users/EditUser";
import ViewUser from "./components/users/ViewUser";
import Navbar from "./components/layout/Navbar";
function App() {
  return (
    <Router>
      <Navbar />
      <Routes>
        <Route exact path="/" element={<Home />} />
        <Route exact path="/adduser" element={<AddUser />} />
        <Route exact path="/edituser/:idUser" element={<EditUser />} />
        <Route exact path="/viewuser/:idUser" element={<ViewUser />} />
        <Route path="/products" element={<ProductList />} />
        <Route path="/product/:id" element={<ProductDetails />} />
      </Routes>
    </Router>
  );
}

export default App;
