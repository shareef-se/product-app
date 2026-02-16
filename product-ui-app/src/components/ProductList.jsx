import React from 'react';
import ProductCard from './ProductCard';
import '../styles/ProductList.css';

function ProductList({ products }) {
    console.log(products)
    return (
        <div className="product-list">
         <h3>Products List</h3>   
        <ul> 
        {products.map((product) => (
            <ProductCard
                key={product.id}
                product={product}  
            />
            ))}
           </ul>    
      </div>
    );
}

export default ProductList;