package com.mainapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mainapp.util.CaptchaGenerated;
import com.mainapp.util.CaptchaSetting;

import cn.apiclub.captcha.Captcha;

@Controller
@RequestMapping("/app")
public class CaptchaController {
	
	private CaptchaSetting generateCaptcha() {
		CaptchaSetting captchaSetting = new CaptchaSetting();
		Captcha captcha = CaptchaGenerated.generatedCaptcha(260, 80);
		captchaSetting.setHiddenCaptcha(captcha.getAnswer());
		captchaSetting.setCaptcha("");
		captchaSetting.setRealCaptcha(CaptchaGenerated.encodeCaptchaToBinary(captcha));
		return captchaSetting;
	}
	
	@GetMapping("/verify")
	public String register(Model model) {
		model.addAttribute("captcha",generateCaptcha());
		return "VerifyCaptcha";
	}
	
	@PostMapping("/verify")
	public String verify(@ModelAttribute CaptchaSetting captchaSetting, Model model) {
		if(captchaSetting.getCaptcha().equals(captchaSetting.getHiddenCaptcha())) {
			model.addAttribute("message","Captcha Verify Successfully");
			return "Success";
		}else {
			model.addAttribute("message","Invalid Captcha");
			model.addAttribute("captcha",generateCaptcha());
		}
		return "VerifyCaptcha";
	}
	
	
	
	
	
	
	
	
	

}
