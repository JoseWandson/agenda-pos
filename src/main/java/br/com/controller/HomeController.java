package br.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class HomeController {

	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("pages/home");
		return mv;
	}

	@GetMapping("/403")
	public ModelAndView acessoNegado() {
		ModelAndView mv = new ModelAndView("pages/403");
		return mv;
	}
}
