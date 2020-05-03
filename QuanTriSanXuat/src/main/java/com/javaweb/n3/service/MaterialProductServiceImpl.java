/**
 * 
 */
package com.javaweb.n3.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.n3.entity.Material;
import com.javaweb.n3.entity.MaterialProduct;
import com.javaweb.n3.entity.Product;
import com.javaweb.n3.repository.MaterialProductRepository;
import com.javaweb.n3.repository.MaterialRepository;

/**
 * @author HungDinh
 *
 */
@Service
@Transactional
public class MaterialProductServiceImpl implements MaterialProductService {

	@Autowired
	MaterialProductRepository materialProductRepository;
	
	@Autowired
	MaterialRepository materialRepository;
	
	@Override
	public Material saveMaterialProduct(int productId, int materialId, int amount) {
		Product product = new Product();
		product.setId(productId);
		
		Material material = new Material();
		material.setId(materialId);
		
		MaterialProduct materialProduct = new MaterialProduct();
		materialProduct.setProduct(product);
		materialProduct.setMaterial(material);
		materialProduct.setAmount(amount);
		
		materialProductRepository.save(materialProduct);
		
		Material materialProductSaved = materialRepository.findById(material.getId()).orElse(null);
		
		return materialProductSaved;
		
	}
	
}
