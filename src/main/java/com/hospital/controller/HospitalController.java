package com.hospital.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.pojo.Hospital;
import com.hospital.pojo.Patient;
import com.hospital.service.Impl.HospitalServiceImpl;

@RestController
@RequestMapping("/hospital")
public class HospitalController {

	@Autowired
	private HospitalServiceImpl hospitalServiceImpl;

	@GetMapping(path = "/getHospitalList")
	public ResponseEntity<List<Hospital>> getHospitalInfo() {

		return new ResponseEntity<List<Hospital>>(hospitalServiceImpl.getHospitalList(), HttpStatus.OK);
	}

	@GetMapping(path = "/getPatients/{hospitalId}")
	public ResponseEntity<List<Patient>> getPatientInfoWithHospitalId(@PathVariable Integer hospitalId) {

		return new ResponseEntity<List<Patient>>(hospitalServiceImpl.getPatientInfoWithHospitalId(hospitalId), HttpStatus.OK);
	}

	@PostMapping(path = "/saveHospital")
	public ResponseEntity<Hospital> saveOrUpdateHospitalInfo(@RequestBody Hospital hospital) {

		return new ResponseEntity<Hospital>(hospitalServiceImpl.saveOrUpdateHospitalInfo(hospital), HttpStatus.OK);
	}

	@GetMapping(path = "/getHospital/{id}")
	public ResponseEntity<Optional<Hospital>> getHospital(@PathVariable Integer id) {

		return new ResponseEntity<>(hospitalServiceImpl.getHospital(id), HttpStatus.OK);
	}

	@DeleteMapping(path = "/deleteHospital/{id}")
	public ResponseEntity<String> deleteHospitalInfo(@PathVariable Integer id) {

		return new ResponseEntity<>(hospitalServiceImpl.deleteHospital(id), HttpStatus.OK);
	}

}
