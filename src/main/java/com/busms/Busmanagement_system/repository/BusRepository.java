package com.busms.Busmanagement_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.busms.Busmanagement_system.dto.Bus;

public interface BusRepository extends JpaRepository<Bus, Integer>{

}
