package com.adelsonbarros.math;

public class SimpleMath {
	public Double Math(String operation, Double numberOne, Double numberTwo) {
		switch (operation) {
		case "sum": 
			return numberOne+numberTwo;
		case "subtraction": 
			return numberOne-numberTwo; 
		case "multiplication": 
			return numberOne*numberTwo; 
		case "division": 
			return numberOne/numberTwo; 
		case "mean": 
			return (numberOne+numberTwo)/2; 
		case "squareRoot": 
			return Math.sqrt(numberOne);
		}
		
		return 0D;
	}
}
