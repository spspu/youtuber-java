package in.sp.main.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {
	@GetMapping("/openProfile")
	public String openProfilePage(Model model) 
	{
		String name= "Deepak Panwar";
		model.addAttribute("modelName",name);
		return "profile";
	}
	@GetMapping("/openConditional")
	public String openConditionalPage(Model model) {
		int no1 =10;
		int no2= 20;
		
		model.addAttribute("no1",no1);
		model.addAttribute("no2",no2);
		return "conditional";
	}
	
	@GetMapping("/openLooping")
	public String openLoopingPage(Model model) {
		List<Integer> numbers = List.of(1,2,3,4,5);
		model.addAttribute("modelNumbers",numbers);
		
		return "looping";
	}
}
