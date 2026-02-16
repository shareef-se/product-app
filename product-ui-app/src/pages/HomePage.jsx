import React, { useState, useEffect } from 'react';
import ProductList from '../components/ProductList';
import AddProduct from '../components/AddProduct';
import { getAllProducts, createProduct} from '../services/api'; 
import '../styles/HomePage.css';

function HomePage() {
  const [products, setProducts] = useState([]);

  useEffect(() => {
    fetchProducts();
  }, []);

  const fetchProducts = async () => {
    try {
      const productsData = await getAllProducts();
      setProducts(productsData);
    } catch (error) {
      console.error('Error fetching products:', error);
    }
  };

  const handleSave = async (productData) => {
    try {
      
      await createProduct(productData);
      fetchProducts();
      
    } catch (error) {
      console.error('Error saving product:', error);
    }
  };

  return (
    <div className="home-page">
      
      <ProductList products={products}/>
      <AddProduct onSave={handleSave} />
      
    </div>
  );
}

export default HomePage;
