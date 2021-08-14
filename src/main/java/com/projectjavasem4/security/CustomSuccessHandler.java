package com.projectjavasem4.security;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.DefaultSavedRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;

import com.projectjavasem4.util.SecurityUtils;

import lombok.Data;



@Component
@Data
public class CustomSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler     { //xử lý authorization (ủy quyền) SimpleUrlAuthenticationSuccessHandler
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	
	
	/*@Override
    public void onAuthenticationSuccess(HttpServletRequest request,
            HttpServletResponse response, Authentication authentication)
            throws ServletException, IOException {
        DefaultSavedRequest defaultSavedRequest = (DefaultSavedRequest) request.getSession().getAttribute("returnUrl");
        if( defaultSavedRequest != null  ) {
            String requestUrl = defaultSavedRequest.getRequestURL() + "?" + defaultSavedRequest.getQueryString();
            
        }
    }*/
	
	/*@Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session != null) {
            String redirectUrl = (String) session.getAttribute("returnUrl");
            if (redirectUrl != null) {
                // we do not forget to clean this attribute from session
                session.removeAttribute("returnUrl");
                // then we redirect
                getRedirectStrategy().sendRedirect(request, response, redirectUrl);
            } else {
                super.onAuthenticationSuccess(request, response, authentication);
            }
        } else {
            super.onAuthenticationSuccess(request, response, authentication);
        }
    }
	
	
	/*protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
	  SavedRequestAwareAuthenticationSuccessHandler handler = new SavedRequestAwareAuthenticationSuccessHandler();
	  String targetUrl = request.getParameter("returnUrl");
	  if ((targetUrl != null) && !targetUrl.equals("")) {
	    handler.setDefaultTargetUrl(targetUrl);
	  }else{
	    handler.setDefaultTargetUrl("/");
	  }
	  
	}*/

	
	
	
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException {
		
		String targetUrl = determineTargetUrl(authentication);
		
		
		 /* String returnURl0=request.getSession().getAttribute("returnUrl").toString();
		 
		  String returnURl = request.getParameter("returnUrl"); 
		  
		  String returnURl2=(String) request.getAttribute("returnUrl");
		  
		  if(returnURl != null ) { targetUrl = returnURl; }
		  */
		//String referer = request.getHeader("returnUrl");
		  
		  Map<String, String[]> parameters = request.getParameterMap();

		    for(String key : parameters.keySet()) {
		        System.out.println(key);
		        String[] vals = parameters.get(key);
		        for(String val : vals)
		            System.out.println(" -> " + val);
		    }
		  
		    
		 
		 
		
		if (response.isCommitted()) {
			System.out.println("Can't redirect");
			return;
		}
		redirectStrategy.sendRedirect(request, response, targetUrl);
	}

	
	
	private String determineTargetUrl(Authentication authentication) {
		String url = "";
		List<String> lstPer = SecurityUtils.getPermission();
		
		String role = SecurityUtils.getPrincipal().getRole();
		
		if (role.equals("ADMIN")) {
			url = "/quan-tri/trangchu";
			
		} else if (role.equals("USER")) {
			url = "/trang-chu";
		}
		return url;
	}
	
	
	
	
	
	private boolean isAdd(List<String> per) {
		if (per.contains("ADD")) {
			return true;
		}
		return false;
	}
	
	private boolean isEdit(List<String> per) {
		if (per.contains("EDIT")) {
			return true;
		}
		return false;
	}
}
