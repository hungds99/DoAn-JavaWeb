/**
 * 
 */
package com.javaweb.n3.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.n3.repository.PlanRepository;

/**
 * @author HungDinh
 *
 */
@Service
@Transactional
public class PlanServiceImpl implements PlanService {

	@Autowired
	PlanRepository planRepository;
	
}
