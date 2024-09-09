package com.adelsonbarros.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adelsonbarros.converts.NumberConverter;
import com.adelsonbarros.exceptions.DescriptionValuesOperationException;
import com.adelsonbarros.exceptions.UnsupportedMathOperationException;
import com.adelsonbarros.math.SimpleMath;

@RestController
public class MathController {
	
	private static final AtomicLong counter = new AtomicLong();
	private SimpleMath math = new SimpleMath();
	private final String[] operations = { "sum", "subtraction", "multiplication", "division", "average", "squareRoot" };
	
	@GetMapping("/api/calc/{operation}/{numberOne}/{numberTwo}")
	public Double calc(
			@PathVariable(value = "operation") String operation,
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			) throws Exception {
		
		if(!isValid(operation)) {
			throw new UnsupportedMathOperationException("Values suported sum, subtraction, multiplication, division, mean, squareRoot");
		}
		
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		
		return math.Math(operation, NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
		
	}
	
	private boolean isValid(String strString) {
		if (strString == null) return false;
		for (String op: operations) {
			if(op.equals(strString)) {
				return true;
			}
		}
		return false;
	}
}