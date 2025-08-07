package com.prodcat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prodcat.entity.Category;

public interface ProdCatRepository extends JpaRepository<Category, Long>{

}
