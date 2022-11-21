package br.atos.zoologico.controller;

//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	
	
	@RequestMapping("/")
	public ModelAndView index() {

//		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username=null;
//		if (principal instanceof UserDetails) {
//			 username = ((UserDetails)principal).getUsername();
//		} else {
//			 username = principal.toString();
//		}
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("userName", username);//
		return modelAndView;
	}
	
}
