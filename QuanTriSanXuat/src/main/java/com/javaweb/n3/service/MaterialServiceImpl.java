/**
 * 
 */
package com.javaweb.n3.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.n3.entity.Material;
import com.javaweb.n3.repository.MaterialRepository;

/**
 * @author HungDinh
 *
 */
@Service
@Transactional
public class MaterialServiceImpl implements MaterialService {

	@Autowired
	MaterialRepository materialRepository;

	@Override
	public boolean saveOrEdit(Material material) {
		Material materialExisted = null;
		try {
			materialExisted = this.findById(material.getId());
			if (materialExisted == null) {
				materialRepository.save(material);
				return true;
			} else {
				materialExisted.setMaterialName(material.getMaterialName());
				materialExisted.setAmount(material.getAmount());
				materialExisted.setUnit(material.getUnit());
				materialExisted.setPrice(material.getPrice());
				materialRepository.save(materialExisted);
				return true;
			}
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Material> findAll() {
		return materialRepository.findAll();
	}

	@Override
	public Material findById(int id) {
		return materialRepository.findById(id).orElse(null);
	}

	@Override
	public boolean deleteById(int id) {
		try {
			materialRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Material> findByMaterialName(String term) {
		return materialRepository.findByMaterialName(term);
	}
	
}
