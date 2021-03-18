package com.hospital.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.pojo.Hospital;

@Repository
public interface HospitalService extends JpaRepository<Hospital, Integer>{

}
