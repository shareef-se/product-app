import React, { useState, useEffect } from 'react';
import '../styles/AddProduct.css';

function AddProduct({ product, onSave }) {
  const [formData, setFormData] = useState({
    name: ''
  });

  useEffect(() => {
    if (product) {
      setFormData({
        name: product.name
      });
    }
  }, [product]);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevData) => ({
      ...prevData,
      [name]: value
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    await onSave(formData);
    setFormData({
      name: ''
    });
  };

  return (
    <div className="add-edit-product">
      <h2>{'Add Product'}</h2>
      <form onSubmit={handleSubmit}>
        <label>
          Name:
          <input
            type="text"
            name="name"
            value={formData.name}
            onChange={handleChange}
          />
        </label>
        <div className="buttons">
          <button type="submit">{'Add Product'}</button>
        </div>
      </form>
    </div>
  );
}

export default AddProduct;
