package com.projectjavasem4.controller.web;



import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.projectjavasem4.entities.RoleEntity;
import com.projectjavasem4.entities.UserEntity;
import com.projectjavasem4.service.IRoleService;
import com.projectjavasem4.service.IUserService2;
import com.projectjavasem4.service.impl.RoleService;
import com.projectjavasem4.util.SecurityUtils;
@Controller(value = "homeControllerOfWeb")


public class HomeController {

	
	@Autowired IRoleService rr;
	@Autowired IUserService2 IUserService2;
	
   @RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
   public ModelAndView homePage(HttpServletRequest request) {
      ModelAndView mav = new ModelAndView("web/home");
      mav.addObject("alert", request.getParameter("alert"));
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
			
			return  new ModelAndView("redirect:/dang-nhap?returnUrl=thanh-toan");
			
		}
		else {
			return new ModelAndView("web/home");
		}
		
	}
	
	
	
	@RequestMapping(value = "/dang-ky", method = RequestMethod.GET)
	   public ModelAndView Register(HttpServletRequest request) {
		
	      ModelAndView mav = new ModelAndView("register");
	      mav.addObject("alert", request.getParameter("alert"));
	      //mav.addObject("s", new UserEntity());
	      return mav;
	   }
	
	
	@RequestMapping(value = "/xu-ly-dang-ky", method = RequestMethod.POST)
    public String doRegister( HttpServletRequest request, @ModelAttribute("s") UserEntity user /*BindingResult bindingResult*/) throws NoSuchAlgorithmException {
 
		/*
		 * if (bindingResult.hasErrors()) { // form validation error
		 * 
		 * } else { // form input is OK }
		 */
		
        user.setStt(1);
        user.setRole(rr.getByName("User"));
        user.setPassword(new BCryptPasswordEncoder().encode(request.getParameter("password").toString()));
    
        if (IUserService2.save(user)) {
        	
        	return "redirect:/dang-ky?alert=true";
		}
        else {
        	return "redirect:/dang-ky?alert=false";
        }
 
 
       
    }
	
}