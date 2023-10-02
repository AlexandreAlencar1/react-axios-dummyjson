import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom'; // Importe Routes aqui
import ProductList from './components/ProductList';
import ProductDetails from './components/ProductDetails';

function App() {
  return (
    <Router>
      <Routes> {/* Use Routes em vez de div */}
        <Route path="/" element={<ProductList />} />
        <Route path="/product/:id" element={<ProductDetails />} />
      </Routes> {/* Feche o Routes */}
    </Router>
  );
}

export default App;
