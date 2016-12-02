package edu.hziee.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class LoginFilter implements Filter {

    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)res;
		HttpSession session=request.getSession();
		
		boolean loggedIn=session.getAttribute("userName")!=null;
		boolean isResourceRequest =request.getRequestURI().startsWith(request.getContextPath()+"/resources"+"/");
		String loginUrl=request.getContextPath()+"/login";
		boolean isLoginRequest=request.getRequestURI().equals(loginUrl);
		if(loggedIn||isResourceRequest||isLoginRequest){
			if(!isResourceRequest){
				response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
				response.setHeader("PPragma", "no-cache");
				response.setDateHeader("Expires",0);
			}
		}
		else{
			String returnUrl=request.getRequestURI();
			response.sendRedirect(loginUrl+"?returnUrl="+returnUrl);
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
