import React from "react";
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import { Route, BrowserRouter as Router, Routes } from "react-router-dom";
import "./App.css";
import Home from "./components/pages/Home";
import ProductDetails from "./components/products/ProductDetails";
import ProductList from "./components/products/ProductList";
import AddUser from "./components/users/AddUser";
import EditUser from "./components/users/EditUser";
import ViewUser from "./components/users/ViewUser";
import Navbar from "./components/layout/Navbar";
import Header from "./components/layout/Header";

function App() {
  return (
    <Router>
      <Navbar />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/adduser" element={<AddUser />} />
        <Route path="/edituser/:idUser" element={<EditUser />} />
        <Route path="/viewuser/:idUser" element={<ViewUser />} />

        <Route path="/products/*" element={
            <div>
              <Header />
              <Routes>
                <Route path="/" element={<ProductList />} />
              </Routes>
            </div>
          }
        />
        <Route
          path="/product/:id/*" element={
            <div>
              <Header />
              <Routes>
                <Route path="/" element={<ProductDetails />} />
              </Routes>
            </div>
          }
        />
      </Routes>
    </Router>
  );
}

export default App;