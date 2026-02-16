import React from 'react';
import '../styles/ProductCard.css';

function ProductCard({ product }) {
  return (
    <div className="product-card">
      <div className="product-details">
        {product.name}
        
      </div>
    </div>
  );
}

export default ProductCard;
