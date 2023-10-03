import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { useParams } from 'react-router-dom';

function ProductDetail() {
  const { id } = useParams();
  const [product, setProduct] = useState(null);

  useEffect(() => {
    console.log(`Solicitando detalhes do produto com ID: ${id}`);
    axios.get(`http://localhost:8080/productsjson/${id}`)
      .then((response) => {
        setProduct(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  }, [id]);

  if (!product) {
    return <div>Carregando...</div>;
  }

  return (
    <div>
      <h3>Imagens do Produto</h3>
      <div className="product-images">
        {product.images.map((image, index) => (
          <img key={index} src={image} alt={`Imagem ${index + 1}`} />
        ))}
      </div>
      
      <h1>Detalhes do Produto</h1>
      <h2>{product.title}</h2>
      <p>{product.description}</p>
      <p>Preço: R$ {product.price}</p>
      <p>Classificação: {product.rating}</p>
      <p>Estoque: {product.stock} unidades</p>


    </div>


  );
}

export default ProductDetail;
