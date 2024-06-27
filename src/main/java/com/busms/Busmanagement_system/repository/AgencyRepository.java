package com.busms.Busmanagement_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.busms.Busmanagement_system.dto.Agency;

public interface AgencyRepository extends JpaRepository<Agency, Integer> {

	boolean existsByEmailAndStatusTrue(String email);

	boolean existsByMobileAndStatusTrue(long mobile);

	Agency findByEmail(String email);

	Agency findByMobile(long mobile);

}
