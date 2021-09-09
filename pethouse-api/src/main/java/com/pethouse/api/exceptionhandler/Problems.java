package com.pethouse.api.exceptionhandler;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Problems {
	private Integer status;
	private LocalDateTime dataHora;
	private String tittle;
	private List<Fields> fields;
	
	
	
	@AllArgsConstructor
	@Getter
	public static class Fields{
		private String name;
		private String message;
	}
}
