package com.busms.Busmanagement_system.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;

import com.busms.Busmanagement_system.dao.AgencyDao;
import com.busms.Busmanagement_system.dao.CustomerDao;
import com.busms.Busmanagement_system.dto.Customer;
import com.busms.Busmanagement_system.helper.AES;
import com.busms.Busmanagement_system.helper.MailSendingHelper;

import jakarta.servlet.http.HttpSession;

public class CustomerService {

	@Autowired
	static
	AgencyDao agencyDao;
	
	@Autowired
	static
	CustomerDao customerDao;
	
	@Autowired
	static
	MailSendingHelper mailSendingHelper;
	
	public static String signup(Customer customer, BindingResult result,HttpSession session) {
		if (!customer.getPassword().equals(customer.getCpassword()))
			result.rejectValue("cpassword", "error.cpassword", "* Password and Confirm Password Should be Matching");
		if (agencyDao.checkEmail(customer.getEmail()) || customerDao.checkEmail(customer.getEmail()))
			result.rejectValue("email", "error.email", "* Email Should be Unique");
		if (agencyDao.checkMobile(customer.getPhone()) || customerDao.checkMobile(customer.getPhone()))
			result.rejectValue("phone", "error.phone", "* Mobile Number Should be Unique");

		if (result.hasErrors())
			return "customer-signup.html";
		else {
			customerDao.deleteIfExists(customer);
			customer.setPassword(AES.encrypt(customer.getPassword(), "123"));
			customer.setOtp(new Random().nextInt(100000,1000000));
			System.out.println("OTP-"+customer.getOtp());
			if(mailSendingHelper.sendEmail(customer)) {
				customerDao.save(customer);
				session.setAttribute("successMessage","Otp sent success");
				return "redirect:/customer/send-otp/"+customer.getId()+"";
			}else {
				session.setAttribute("failMessage","Sry not able to send Message");
				return "redirect:/customer/signup";
			}
		}
	}
	
	public static String verifyOtp(int id, int otp, HttpSession session) {
		Customer customer=customerDao.findbyid(id);
		if(customer.getOtp()==otp) {
			customer.setStatus(true);
			customerDao.save(customer);
			session.setAttribute("successMessage","Otp Verified Success,You can Login Now");
			return "redirect:/login";
		}else {
			session.setAttribute("failMessage","Invalid Otp,Try Again");
			return "redirect:/customer/send-otp/"+customer.getId()+"";
		}
	}

	public static String resendOtp(int id, HttpSession session) {
		Customer customer=customerDao.findbyid(id);
		customer.setOtp(new Random().nextInt(100000,1000000));
		System.out.println("OTP-"+customer.getOtp());
		if(mailSendingHelper.sendEmail(customer)) {
			customerDao.save(customer);
			session.setAttribute("successMessage","Otp Re-sent Success");
			return "redirect:/customer/send-otp/"+customer.getId()+"";
		}else {
			session.setAttribute("failMessage","Sry not able to send Message");
			return "redirect:/customer/send-otp/"+customer.getId()+"";
		}
	}

}
