package com.prodcat.service;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.prodcat.dto.ProductDTO;
import com.prodcat.entity.Category;
import com.prodcat.entity.Product;
import com.prodcat.repository.CategoryRepository;
import com.prodcat.repository.ProductRepository;

@Service
public class ProdCatServImpl implements ProdCatServ {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;
    
    @Override
    public Page<Category> getAllCategories(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category updateCategory(Long id, Category categoryDetails) {
        Category category = categoryRepository.findById(id).orElseThrow();
        category.setName(categoryDetails.getName());
        category.setDescription(categoryDetails.getDescription());
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
    @Override
    public Page<Product> getAllProducts(int page) {
        return productRepository.findAll(PageRequest.of(page, 2));
    }

   

    @Override
    public ProductDTO getProductById(Long id) {
        return productRepository.findById(id)
            .map(product -> new ProductDTO(
                product.getProd_id(),
                product.getName(),
                product.getPrice(),
                product.getDescription(),
                product.getCategory().getName(),
                product.getCategory().getDescription() // Add category description
            ))
            .orElse(null);
    }


    @Override
    public Product updateProduct(Long id, Product productDetails) {
        Product product = productRepository.findById(id).orElseThrow();
        product.setName(productDetails.getName());
        product.setDescription(productDetails.getDescription());
        product.setPrice(productDetails.getPrice());
        product.setCategory(productDetails.getCategory());
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
    @Override
    public Page<ProductDTO> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable)
                .map(product -> new ProductDTO(
                    product.getProd_id(),
                    product.getName(),
                    product.getPrice(),
                    product.getDescription(),
                    product.getCategory().getName(),        
                    product.getCategory().getDescription() 
                ));
    }

    @Override
    public Product createProduct(Product product) {
        Long catId = product.getCategory().getCat_id();
        Category category = null;

        try {
            category = categoryRepository.findById(catId).get(); 
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Category not found with ID: " + catId);
        }
        product.setCategory(category);
        return productRepository.save(product);
    }

}
