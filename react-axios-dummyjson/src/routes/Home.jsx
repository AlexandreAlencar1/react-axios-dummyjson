import productFetch from "../axios/config";

import { useEffect, useState } from "react";

import { Link } from "react-router-dom";

import "./Home.css";

const Home = () => {
//products vira um array vazio e setproducts modifica o valor de products(igual um set normal)
  const [products, setProducts] = useState ([])

  const getProducts = async() => {
    
    try {
      
      const response = await productFetch.get("/products")
      
       const data = response.data;

      setProducts(data.products)

    } catch (error) {
      console.log(error)
    }

  }

  useEffect(() => {

    getProducts()

  }, [])//array vazio pra executar só 1x, no load da pagina

  return (
    <div className="home">
      <h1>Adicionados Recentemente</h1>
      {products.length === 0 ? ( //se nao tiver posts
        <p>Carregando Produtos...</p>
      ) : (
        products.map((product) =>  (
          <div className="product" key={product.id}>
            <h2>{product.title}</h2>
            <p>{product.description}</p>
            <div className="images">
              <img src={product.thumbnail}/>
            </div>
            <Link to={'/products/${product.id}'} className="btn">Ler mais</Link>

          </div>
        ))
      )}
    </div>
  )
}

export default Home