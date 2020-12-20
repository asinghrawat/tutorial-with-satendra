package com.anilsatendra.mvctutorial.tutorialspringmvc;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.anilsatendra.mvctutorial.tutorialspringmvc.model.Login;
import com.anilsatendra.mvctutorial.tutorialspringmvc.model.LoginRepo;
@Controller
public class WelcomeController {
	
	@Autowired
	LoginRepo loginRepo;
	
	@GetMapping("/")
	public String welcomeMethod()
	{
		return "login";
	}
	
	@RequestMapping(value="/login/username/{username}/password/{password}",method=RequestMethod.POST)
	public String login2(@PathVariable("username") String username,
			            @PathVariable("password") String password, Model m)
	{
		//m.addAttribute("Username", username);
		return "Username-"+username;
	}
	
	
	@RequestMapping(value="/find/password/{password}",method=RequestMethod.GET)
	public String searchUser(@PathVariable("password") String password,Model m)
	{
		Login login= loginRepo.findByPassword(password);
		
		m.addAttribute("username", login.getUsername());
		return "homepage";
	}
	
	
	@RequestMapping(value="/find/username/{username}/password/{password}",method=RequestMethod.GET)
	public String searchUserByUsernameandPassword(@PathVariable("username") String username,
			@PathVariable("password") String password,Model m)
	{
		Login login= loginRepo.findByUsernameAndPassword(username, password);
		m.addAttribute("username", login.getUsername());
		return "homepage";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@RequestParam("username") String username,
			            @RequestParam("password") String password, Model m)
	{
		
		Login login = new Login(username,password);
		loginRepo.save(login);
		m.addAttribute("username", username);
		return "homepage";
	}
	
	
	
	/*@PostMapping("/login")
	public String login2()
	{
		return "homepage";
	}*/
	
	
	
	

}
