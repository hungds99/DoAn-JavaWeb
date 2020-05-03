/**
 * 
 */
package com.javaweb.n3.service;

import com.javaweb.n3.entity.Material;

/**
 * @author HungDinh
 *
 */
public interface MaterialProductService {

	public Material saveMaterialProduct(int productId, int materialId, int amount);
	
}
