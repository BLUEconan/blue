package edu.hziee.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LoginController {
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView get(){
		return new ModelAndView("login/login");
	}
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView post(HttpSession session,HttpServletRequest req,@RequestParam String userName,
			@RequestParam String passWord,@RequestParam(required=false) String returnUrl){	  
		if(userName.equals("blue")&&passWord.equals("aptx-4896")){
			session.setAttribute("userName", userName);
			if(returnUrl !=null)
				return new ModelAndView("redirect:"+returnUrl.replace(req.getContextPath(),""));
			else
				return new ModelAndView("redirect:book");		
		}
		else{
			ModelAndView mav=new ModelAndView("login/login");
			mav.addObject("error", "用户名或密码错误！");
			return new ModelAndView("");
		}
		
	}
}
