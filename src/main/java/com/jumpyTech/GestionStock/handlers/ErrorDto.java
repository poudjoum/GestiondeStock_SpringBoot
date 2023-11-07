package com.jumpyTech.GestionStock.handlers;

import java.util.ArrayList;
import java.util.List;

import com.jumpyTech.GestionStock.exception.ErrorCode;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDto {

	private  Integer httpCode;
	private ErrorCode code;
	private String message;
	private List<String>errors= new ArrayList<>();

}
