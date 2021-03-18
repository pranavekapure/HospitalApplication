package com.hospital.pojo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter @NoArgsConstructor
@AllArgsConstructor @Setter
public class Hospital {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer hospitalId;
	
	private String hospitalName;
	
	@Transient
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<Patient> patientList;
	
}
