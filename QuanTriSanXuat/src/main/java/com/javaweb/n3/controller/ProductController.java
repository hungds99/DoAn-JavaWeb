/**
 * 
 */
package com.javaweb.n3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.javaweb.n3.entity.Material;
import com.javaweb.n3.entity.Product;
import com.javaweb.n3.service.MaterialProductService;
import com.javaweb.n3.service.ProductService;

/**
 * @author HungDinh
 *
 */

@RestController
@CrossOrigin
@RequestMapping("/api/n3/product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	MaterialProductService materialProductService;

	@GetMapping
	public List<Product> getProducts() {
		return productService.findAll();
	}
	
	@PostMapping
	public Product saveProduct(@RequestBody Product product) {
		Product p = productService.save(product);
		return p;
	}
	
	@GetMapping("/{id}")
	public Product getProduct(@PathVariable(name = "id") int id) {
		return productService.getOne(id);
	}
	
	@CrossOrigin
	@GetMapping("/insertMaterial")
	public Material insertMaterialToProduct(@RequestParam("productId") int productId, @RequestParam("materialId") int materialId, @RequestParam("materialAmount") int materialAmount) throws JsonProcessingException {
		
		Material material = materialProductService.saveMaterialProduct(1, 1, 10);
		
		return material;
	}
	
	@PostMapping("/search")
	public Product search(@RequestParam("productName") String productName) {
		return productService.findByProductName(productName);
	}
	
	@CrossOrigin
	@GetMapping("/getMaterial")
	public List<Material> getMaterialOfProduct(@RequestParam("productId") int productId) {
		return productService.getMaterialOfProduct(productId);
	}
	
}
