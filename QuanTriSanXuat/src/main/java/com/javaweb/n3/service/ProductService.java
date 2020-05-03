/**
 * 
 */
package com.javaweb.n3.service;

import java.util.List;

import com.javaweb.n3.entity.Material;
import com.javaweb.n3.entity.Product;

/**
 * @author HungDinh
 *
 */
public interface ProductService {

	List<Product> findAll();
	
	Product save(Product product);
	
	Product getOne(int id);
	
	Product findByProductName(String productName);
	
	List<Material> getMaterialOfProduct(int productId);
}
