import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom'; // Importe Routes aqui
import ProductList from './components/ProductList';
import ProductDetails from './components/ProductDetails';
import UserPosts from './components/UserPost';
function App() {
  return (
    <Router>
      <Routes> {}
        <Route path="/" element={<ProductList />} />
        <Route path="/product/:id" element={<ProductDetails />} />
        <Route path="/user/cadastro" element={<UserPosts />} />
      </Routes> {}
    </Router>
  );
}

export default App;
