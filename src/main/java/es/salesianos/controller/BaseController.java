package es.salesianos.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import es.salesianos.model.Brand;
import es.salesianos.service.BrandService;

@Controller
public class BaseController {

	private static Logger log = LogManager.getLogger(BaseController.class);
	
	private Brand brand;
	
	@Autowired
	private BrandService service;
	
	@GetMapping("/")
	public ModelAndView index() {
		log.debug("ENTERING TO INSERT A NEW CAR BRAND");
		brand = new Brand();
		ModelAndView modelAndView = new ModelAndView("index", "command", new Brand());
		modelAndView.addObject("brands", service.listAll());
		return modelAndView;
	}
	
	@PostMapping("brandInsert")
	public ModelAndView brandInsert(Brand brand) {
		log.debug("INSERTING THE BRAND");
		service.insert(brand);
		ModelAndView modelAndView = new ModelAndView("index", "command", brand);
		addPageData(brand);
		modelAndView.addObject("brand", this.brand);
		return modelAndView;
	}	
	
	private void addPageData(Brand brandForm) {

		if (!StringUtils.isEmpty(brandForm.getName())) {
			this.brand.setName(brandForm.getName());
		}
	}
}
