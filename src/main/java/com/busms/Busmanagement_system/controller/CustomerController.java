package com.busms.Busmanagement_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.busms.Busmanagement_system.dto.Customer;
import com.busms.Busmanagement_system.service.CustomerService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	Customer customer;

	@GetMapping("/signup")
	public String loadSignup(ModelMap map) {
		map.put("customer", customer);
		return "customer-signup";
	}

	@PostMapping("/signup")
	public String signup(@Valid Customer customer, BindingResult result,HttpSession session) {
		try {
			return CustomerService.signup(customer, result,session);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@PostMapping("/verify-otp")
	public String verifyOtp(@RequestParam int id,@RequestParam int otp,HttpSession session) {
		return CustomerService.verifyOtp(id,otp,session);
	}
	
	@GetMapping("/send-otp/{id}")
	public String loadOtpPage(@PathVariable int id,ModelMap map) {
		map.put("id", id);
		return "customer-otp";
	}
	
	@GetMapping("/resend-otp/{id}")
	public String resendOtp(@PathVariable int id,HttpSession session) {
		return CustomerService.resendOtp(id,session);
	}
}
