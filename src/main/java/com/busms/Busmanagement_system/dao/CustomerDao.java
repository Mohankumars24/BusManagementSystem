package com.busms.Busmanagement_system.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.busms.Busmanagement_system.dto.Customer;
import com.busms.Busmanagement_system.repository.CustomerRepository;

@Repository
public class CustomerDao {

	@Autowired
	CustomerRepository customerRepository;
	
	public boolean checkEmail(String email) {
		return customerRepository.existsByEmail(email);
	}

	public boolean checkMobile(long phone) {
		return customerRepository.existsByPhone(phone);
	}
	
	public void save(Customer customer) {
		customerRepository.save(customer);
	}	

	public Customer findByEmail(String email) {
		return customerRepository.findByEmail(email);
	}
	
	public Customer findByMobile(long phone) {
		return customerRepository.findByPhone(phone);
	}
	
	public void deleteIfExists(Customer customer) {
		if(findByMobile(customer.getPhone())!=null) {
			delete(findByMobile(customer.getPhone()));
		}
		if(findByEmail(customer.getEmail())!=null) {
			delete(findByEmail(customer.getEmail()));
		}
	}

	private void delete(Customer customer) {
		customerRepository.delete(customer);
	}

	public Customer findbyid(int id) {
		return customerRepository.findById(id).orElseThrow();
	}	
}