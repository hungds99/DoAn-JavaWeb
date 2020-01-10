/**
 * 
 */
package com.javaweb.n3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.javaweb.common.utils.ViewNameUtils;


/**
 * @author HungDinh
 *
 */

@Controller
public class N3Controller {

	@GetMapping("/production")
	public String getProductionPage() {
		return ViewNameUtils.VIEW_PRODUCTION_PAGE;
	}
	
}
