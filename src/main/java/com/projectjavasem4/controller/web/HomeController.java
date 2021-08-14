package com.projectjavasem4.controller.web;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.projectjavasem4.entities.UserEntity;
import com.projectjavasem4.util.SecurityUtils;
@Controller(value = "homeControllerOfWeb")
public class HomeController {
  
   @RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
   public ModelAndView homePage() {
      ModelAndView mav = new ModelAndView("web/home");
      return mav;
   }
   @RequestMapping(value = "/dang-nhap", method = RequestMethod.GET)
	public ModelAndView loginPage() {
	   ModelAndView mav = new ModelAndView("login");
	   
	   
	   // để ngăn người dùng quay lại trang đăng nhập nếu họ đã đăng nhập
	   Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	   return mav;
		/*
		 * if ( authentication == null || authentication instanceof
		 * AnonymousAuthenticationToken ) { return mav; }
		 * 
		 * return new ModelAndView("redirect:/trang-chu");
		 */
	}
   @RequestMapping(value = "/thoat", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return new ModelAndView("redirect:/trang-chu");
	}
	
	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public ModelAndView accessDenied() {
		return new ModelAndView("redirect:/dang-nhap?accessDenied");
	}
	
	@RequestMapping(value = "/thanh-toan", method = RequestMethod.GET)
	public ModelAndView payment(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth.isAuthenticated()) {
			
			ModelAndView m= new ModelAndView("redirect:/dang-nhap?returnUrl=thanh-toan");
			//m.addObject("returnUrl", "thanh-toan");
			return m;
		}
		else {
			return new ModelAndView("redirect:/thanh-toan");
		}
		
	}
	
	
	
	@RequestMapping(value = "/dang-ky", method = RequestMethod.GET)
	   public ModelAndView Register() {
	      ModelAndView mav = new ModelAndView("register");
	      return mav;
	   }
	
	
	@RequestMapping(value = "/xu-ly-dang-ky", method = RequestMethod.POST)
    public String doRegister(  @ModelAttribute("userForm") UserEntity user, BindingResult bindingResult) {
 
        if (bindingResult.hasErrors()) {
            // form validation error
 
        } else {
            // form input is OK
        }
 
        // process registration...
 
        return "Success";
    }
	
}