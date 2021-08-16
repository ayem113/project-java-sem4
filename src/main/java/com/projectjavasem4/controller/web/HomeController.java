package com.projectjavasem4.controller.web;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.projectjavasem4.dto.ProductDTO;
import com.projectjavasem4.entities.UserEntity;
import com.projectjavasem4.service.IRoleService;
import com.projectjavasem4.service.IUserService2;
import com.projectjavasem4.service.IProductService;
import com.projectjavasem4.util.SecurityUtils;
@Controller(value = "homeControllerOfWeb")


public class HomeController {

	
	@Autowired IRoleService rr;
	@Autowired IUserService2 IUserService2;
	@Autowired IProductService iPro;
	
	public boolean isLogin() {
		  
		   return SecurityUtils.getPermission().size()>1;
		
	   }
	   public boolean isLogin2() {
			  
		   return SecurityUtils.getPermission().get(0).toString()!="ROLE_ANONYMOUS";
		
	   }
	   
	   
	   
	public ModelAndView showList(@RequestParam("page") int page, @RequestParam("limit") int limit,HttpServletRequest request) {
		ProductDTO model = new ProductDTO();
		model.setPage(page);
		model.setLimit(limit);
		ModelAndView mav = new ModelAndView("admin/new/list");
		Pageable pageable = new PageRequest(page - 1, limit);
		model.setListResult(iPro.findAll(pageable));
		model.setTotalItem(iPro.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));

			//if (request.getParameter("message") != null) {
			//Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			//mav.addObject("message", message.get("message"));
			//mav.addObject("alert", message.get("alert"));
			//}
		
		return mav.addObject("model", model);
	}
	
	
	
   @RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
   public ModelAndView homePage(HttpServletRequest request,@RequestParam(name = "isLogin",required = false)String isLogin) {
      ModelAndView mav = new ModelAndView("web/home");
     if (isLogin!=null) {
    	 mav.addObject("isLogin", isLogin);
	} 
     else { mav.addObject("isLogin", "false");}
      return mav;
   }
   
   
   
   @RequestMapping(value = "/dang-nhap", method = RequestMethod.GET)
   public ModelAndView loginPage(HttpServletRequest request,@RequestParam(name = "returnUrl",required = false)String returnUrl) {
	   ModelAndView mav = new ModelAndView("login");
	   mav.addObject("returnUrl", request.getParameter("returnUrl"));
	   // c2 mav.addObject("returnUrl", returnUrl);
	   
	   
	// để tb ban da dang nhap roi  nếu họ  đăng nhập tiep
	   
	   
	   //String role=SecurityUtils.getPrincipal().getFullName();
	   //String role2=SecurityUtils.getPrincipal().getRole();
	   
	   
	   
	   
	   
	   
	   if (isLogin2()) {
		   return new ModelAndView("redirect:/trang-chu?isLogin=true");
	   	}
	   
	   
	   
	   
	   
	   
		/*
		 * Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		 * if ( authentication.getPrincipal()!="anonymousUser" ||
		 * authentication.getAuthorities().size()<1 || authentication instanceof
		 * AnonymousAuthenticationToken ) {
		 * 
		 * return new ModelAndView("redirect:/trang-chu?isLogin=true"); }
		 */
	   
	   return mav;
	   
	   
	   
	   
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
	
	@RequestMapping(value = "/xu-ly-thanh-toan", method = RequestMethod.GET)
	public ModelAndView payment(HttpServletRequest request, HttpServletResponse response) {
		//Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		
		if (isLogin()==false) {
			
			return  new ModelAndView("redirect:/dang-nhap?returnUrl=thanh-toan");
			
		}
		else {
			//xử lý code thanh toán ở đây
			return new ModelAndView( "redirect:/trang-chu?isCheckout=true");
		}
		
	}
	
	@RequestMapping(value = "/thanh-toan", method = RequestMethod.GET)
	public ModelAndView payment2(HttpServletRequest request, HttpServletResponse response) {
		
			return new ModelAndView("web/checkout");
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