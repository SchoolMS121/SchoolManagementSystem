package com.app.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter

@Setter
@ToString
public class AuthRespDTO {

	private Long parent_id;
	private String p_first_name;
	private String p_last_name;
}
