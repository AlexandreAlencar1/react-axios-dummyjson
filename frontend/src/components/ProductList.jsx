import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';
import RegistrationPrompt from './RegistrationPrompt';

function ProductList() {
  const [products, setProducts] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:8080/productsjson/listFromDB')
      .then((response) => {
        setProducts(response.data.products);
      })
      .catch((error) => {
        console.error(error);
      });
  }, []);

  return (
    <div>
      <div>
        <RegistrationPrompt /> {/* Renderize o novo componente aqui */}
      </div>
      <h1>Lista de Produtos</h1>
      <ul>
        {products.map((product) => (
          <div key={product.id}>
            <h3>{product.title}</h3>
            <img src={product.thumbnail} alt={product.title} />
            <p>
              Preço: R$ {product.price} <Link to={`/product/${product.id}`}>Detalhes</Link>
            </p>
          </div>
        ))}

      </ul>
    </div>
  );
}

export default ProductList;
