package com.busms.Busmanagement_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.busms.Busmanagement_system.dto.Station;

public interface StationRepository extends JpaRepository<Station, Integer>{

	List<Station> findByName(String from);

}
