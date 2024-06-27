package com.busms.Busmanagement_system.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.busms.Busmanagement_system.dto.Agency;
import com.busms.Busmanagement_system.repository.AgencyRepository;

@Repository
public class AgencyDao {

	@Autowired
	AgencyRepository agencyRepository;

	public boolean checkEmail(String email) {
		return agencyRepository.existsByEmailAndStatusTrue(email);
	}

	public boolean checkMobile(long mobile) {
		return agencyRepository.existsByMobileAndStatusTrue(mobile);
	}

	public void save(Agency agency) {
		agencyRepository.save(agency);
	}

	public Agency findById(int id) {
		return agencyRepository.findById(id).orElseThrow();
	}

	public Agency findByEmail(String email) {
		return agencyRepository.findByEmail(email);
	}

	public Agency findByMobile(long mobile) {
		return agencyRepository.findByMobile(mobile);
	}

	public void deleteIfExists(Agency agency) {
		if (findByMobile(agency.getMobile()) != null) {
			delete(findByMobile(agency.getMobile()));
		}
		if (findByEmail(agency.getEmail()) != null) {
			delete(findByEmail(agency.getEmail()));
		}

	}

	public void delete(Agency agency) {
		agencyRepository.delete(agency);
	}
}