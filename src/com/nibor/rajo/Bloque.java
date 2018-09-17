package com.nibor.rajo;

public class Bloque {
	private int dimensionx;
	private int dimensiony;
	private int dimensionz;
	
	private int cobre;
	private int oro;
	private int esteril;
	
	public static ValorEconomico valorEconomico;
	
	public int getDimensionx() {
		return dimensionx;
	}
	public void setDimensionx(int dimensionx) {
		this.dimensionx = dimensionx;
	}
	public int getDimensiony() {
		return dimensiony;
	}
	public void setDimensiony(int dimensiony) {
		this.dimensiony = dimensiony;
	}
	public int getDimensionz() {
		return dimensionz;
	}
	public void setDimensionz(int dimensionz) {
		this.dimensionz = dimensionz;
	}
	public int getCobre() {
		return cobre;
	}
	public void setCobre(int cobre) {
		this.cobre = cobre;
	}
	public int getOro() {
		return oro;
	}
	public void setOro(int oro) {
		this.oro = oro;
	}
	public int getEsteril() {
		return esteril;
	}
	public void setEsteril(int esteril) {
		this.esteril = esteril;
	}
	public static ValorEconomico getValorEconomico() {
		return valorEconomico;
	}
	public static void setValorEconomico(ValorEconomico valorEconomico) {
		Bloque.valorEconomico = valorEconomico;
	}
}