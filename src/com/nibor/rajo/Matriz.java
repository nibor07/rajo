package com.nibor.rajo;

public class Matriz {

	private double[][] matrizInicial = { { -2, -1, 0.8, -2, -2, 0.9, 0.5, -2, -2, 0.3, 0.1, -2 },
		{ -1, 0.7, 0.3, 1.2, -2, 0.7, 1.2, 1, 0.4, 0.8, 0.2, -2 },
		{ -1, 0.3, -1, 0.7, 0.1, 1.2, 0.8, 0.7, 0.2, 0.5, 0.2, -2 },
		{ -1, -1, 0.6, 0.2, 0.2, 0.4, 0.6, 0.4, 0.3, 0.7, 0.2, -1 },
		{ -1, -1, 0.2, 0.2, 0.8, 0.2, -1, -1, 0.2, -1, -1, -1 } };
	
	private double[][] matrizEquivalente; 
	private double[][] matrizValorizada;
	private double[][] matrizLerchyCrossman;
	
	public double[][] getMatrizInicial() {
		return matrizInicial;
	}
	public void setMatrizInicial(double[][] matrizInicial) {
		this.matrizInicial = matrizInicial;
	}
	public double[][] getMatrizEquivalente() {
		return matrizEquivalente;
	}
	public void setMatrizEquivalente(double[][] matrizEquivalente) {
		this.matrizEquivalente = matrizEquivalente;
	}
	public double[][] getMatrizValorizada() {
		return matrizValorizada;
	}
	public void setMatrizValorizada(double[][] matrizValorizada) {
		this.matrizValorizada = matrizValorizada;
	}
	public double[][] getMatrizLerchyCrossman() {
		return matrizLerchyCrossman;
	}
	public void setMatrizLerchyCrossman(double[][] matrizLerchyCrossman) {
		this.matrizLerchyCrossman = matrizLerchyCrossman;
	}
}