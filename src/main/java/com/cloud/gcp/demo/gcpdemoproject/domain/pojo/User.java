package com.cloud.gcp.demo.gcpdemoproject.domain.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

	private Integer id;
	private String name;
	private Integer age;
	private String location;
}
