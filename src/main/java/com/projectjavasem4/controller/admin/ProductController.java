package com.projectjavasem4.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.projectjavasem4.service.IProductService;

@Controller(value = "ProControllerOfAdmin")
public class ProductController {
	@Autowired
	private IProductService proService;
	
	@RequestMapping(value = "/quan-tri/san-pham/danh-sach", method = RequestMethod.GET)
	public ModelAndView list() {
		return new ModelAndView("admin/listPro").addObject("List", proService.getAll());
	}
	
	
}
