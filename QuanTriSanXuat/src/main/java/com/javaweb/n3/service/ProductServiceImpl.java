/**
 * 
 */
package com.javaweb.n3.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.n3.entity.Material;
import com.javaweb.n3.entity.Product;
import com.javaweb.n3.repository.ProductRepository;

/**
 * @author HungDinh
 *
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	EntityManagerFactory entityManagerFactory;

	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public Product save(Product product) {
		Product p = productRepository.save(product);
		return p;
	}

	@Override
	public Product getOne(int id) {
		return productRepository.findById(id).orElse(null);
	}

	@Override
	public Product findByProductName(String productName) {
		return productRepository.findByProductName(productName);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Material> getMaterialOfProduct(int productId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		List<Material> material = entityManager.createQuery(
				"SELECT m FROM Material m LEFT JOIN m.materialProduct mp ON m.id = mp.material.id WHERE mp.product.id = :param",
				Material.class).setParameter("param", productId).getResultList();

		return material;
	}

}
