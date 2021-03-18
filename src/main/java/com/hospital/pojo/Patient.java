package com.hospital.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Patient {

	private Integer patientId;

	private String firstName;

	private String lastName;

	private String dob;

	private Integer hospitalId;

}
