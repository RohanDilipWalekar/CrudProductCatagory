package com.prodcat.service;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.prodcat.dto.ProductDTO;
import com.prodcat.entity.Category;
import com.prodcat.entity.Product;

public interface ProdCatServ {
	 //List<Category> getAllCategories(int page, int size);
    Category createCategory(Category category);
    Optional<Category> getCategoryById(Long id);
    Category updateCategory(Long id, Category categoryDetails);
    void deleteCategory(Long id);
    Page<ProductDTO> getAllProducts(Pageable pageable);
    ProductDTO getProductById(Long id);
    Page<Product> getAllProducts(int page);
    Product createProduct(Product product);
    Product updateProduct(Long id, Product productDetails);
    void deleteProduct(Long id);
	Page<Category> getAllCategories(Pageable pageable);
}
