package com.hospital.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hospital.pojo.Hospital;
import com.hospital.pojo.Patient;
import com.hospital.service.HospitalService;

@Service
public class HospitalServiceImpl {

	@Autowired
	private HospitalService hospitalService;
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	public static final String TOPIC = "HospitalInfo";

	public List<Hospital> getHospitalList() {
		List<Hospital> hospitalList = hospitalService.findAll();
		return hospitalList;
	}

	public Hospital saveOrUpdateHospitalInfo(Hospital hospital) {
		Hospital savedHospital = hospitalService.save(hospital);
		return savedHospital;
	}

	public Optional<Hospital> getHospital(Integer id) {
		Optional<Hospital> hospital = hospitalService.findById(id);
		return hospital;

	}

	public String deleteHospital(Integer id) {
		hospitalService.deleteById(id);
		kafkaTemplate.send(TOPIC, id.toString());
		return "deleted successfully";
	}

	public List<Patient> getPatientInfoWithHospitalId(Integer id) {
		String url="http://localhost:8763/patient/getPatients/"+id;
		String JSONList=restTemplate.getForObject(url,String.class);
		List<Patient> patientList=null;
		try {
			patientList = objectMapper.readValue(JSONList, new TypeReference<List<Patient>>() {
			});

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return patientList;
	}

}
