/**
 * 
 */
package com.javaweb.n3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaweb.n3.entity.Product;

/**
 * @author HungDinh
 *
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	Product findByProductName(String productName);
	
}
