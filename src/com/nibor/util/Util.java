package com.nibor.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Util {

	public static final Double AIRE = -2.0;
	public static final Double ESTERIL = -1.0;
	
	public static Double fijarDecimales(Double data, int numDecimales) {
		BigDecimal bigDecimal = new BigDecimal(data).setScale(numDecimales, RoundingMode.UP);
		//System.out.println(bigDecimal.doubleValue());
		return bigDecimal.doubleValue();
	}

	public static String formatear(Double numero, String formato) {
		DecimalFormat formato1 = new DecimalFormat(formato);
		return formato1.format(numero);
	}
	
	public static Double formatearDecimales(Double numero, Integer numeroDecimales) {
	    return Math.round(numero * Math.pow(10, numeroDecimales)) / Math.pow(10, numeroDecimales);
	}
}
