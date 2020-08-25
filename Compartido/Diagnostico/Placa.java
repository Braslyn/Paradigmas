//package com.eif400.diagnostic;
import java.util.*;
import java.util.regex.*;

public class Placa{
	static public boolean PlacaCR(String placa){
		return Pattern.matches("[\\d]{3,25}|[A-Z]{3}-[\\d]{3}",placa);
	}
	public static void main(String... args){
		List<String> placas = Arrays.asList(
		"109456",
		"ABC-666",
		"600-ABC",
		"666",
		"abC-123",
		"55",
		"600/ABC"
		);
		for(var placa: placas){
			System.out.format("is %s valid?: %b%n",placa,PlacaCR(placa));
		}
	};

}