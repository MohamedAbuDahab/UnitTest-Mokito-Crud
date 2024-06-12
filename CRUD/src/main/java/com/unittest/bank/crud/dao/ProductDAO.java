package com.unittest.bank.crud.dao;

import com.unittest.bank.crud.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private List<Product> products;

    public ProductDAO() {
        products = new ArrayList<>();
        products.add(new Product(1, "Product 1", 10.0));
        products.add(new Product(2, "Product 2", 20.0));
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        product.setId(products.size() + 1);
        products.add(product);
    }
}