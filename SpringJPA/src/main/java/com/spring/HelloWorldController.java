package com.spring;

//import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.byteslounge.spring.tx.model.User;
import com.spring2.services.ProvaService;

@Controller
public class HelloWorldController {
	
	@Autowired
	ProvaService userManager;
	 
	@RequestMapping("/hello10")
	public String hello(@RequestParam(value = "msg", required = false, defaultValue = "Hello World") String msg, Model model) {

		User user = new User();
		user.setName("John Doe222");
		userManager.insertUser(user);
		System.out.println("User inserted!");
	
		model.addAttribute("msg", msg);

		return "helloworld10";

	}

}
