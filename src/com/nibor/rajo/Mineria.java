package com.nibor.rajo;

public class Mineria {
	private Mina mina;
	private Planta planta;
	private Refinadora refinadora;
	private Bloque bloque;
	private Double leyEquivalente;
	private Matriz matrizInicial;
	private Matriz matrizEquivalente;

	private Double variablesIndependienteLey;
	private Double variablesDependienteLey;
	private Double leyCriticaDiseño;
	
	private Double costoComercializacion;
	private Double costoGeneralyAdmninistracion;
	private Double costoComercializacionMena;
	private Double costoFundicionYRefineria;
	
	public Double getLeyCriticaDiseño() {
		return leyCriticaDiseño;
	}
	public void setLeyCriticaDiseño(Double leyCriticaDiseño) {
		this.leyCriticaDiseño = leyCriticaDiseño;
	}
	public Double getVariablesIndependienteLey() {
		return variablesIndependienteLey;
	}
	public void setVariablesIndependienteLey(Double variablesIndependienteLey) {
		this.variablesIndependienteLey = variablesIndependienteLey;
	}
	public Double getVariablesDependienteLey() {
		return variablesDependienteLey;
	}
	public void setVariablesDependienteLey(Double variablesDependienteLey) {
		this.variablesDependienteLey = variablesDependienteLey;
	}
	public Double getCostoFundicionYRefineria() {
		return costoFundicionYRefineria;
	}
	public void setCostoFundicionYRefineria(Double costoFundicionYRefineria) {
		this.costoFundicionYRefineria = costoFundicionYRefineria;
	}
	public Mina getMina() {
		return mina;
	}
	public void setMina(Mina mina) {
		this.mina = mina;
	}
	public Planta getPlanta() {
		return planta;
	}
	public void setPlanta(Planta planta) {
		this.planta = planta;
	}
	public Refinadora getRefinadora() {
		return refinadora;
	}
	public void setRefinadora(Refinadora refinadora) {
		this.refinadora = refinadora;
	}
	public Bloque getBloque() {
		return bloque;
	}
	public void setBloque(Bloque bloque) {
		this.bloque = bloque;
	}
	public Matriz getMatrizInicial() {
		return matrizInicial;
	}
	public void setMatrizInicial(Matriz matrizInicial) {
		this.matrizInicial = matrizInicial;
	}
	public Matriz getMatrizEquivalente() {
		return matrizEquivalente;
	}
	public void setMatrizEquivalente(Matriz matrizEquivalente) {
		this.matrizEquivalente = matrizEquivalente;
	}
	public Double getLeyEquivalente() {
		return leyEquivalente;
	}
	public void setLeyEquivalente(Double leyEquivalente) {
		this.leyEquivalente = leyEquivalente;
	}
	public Double getCostoComercializacion() {
		return costoComercializacion;
	}
	public void setCostoComercializacion(Double costoComercializacion) {
		this.costoComercializacion = costoComercializacion;
	}
	public Double getCostoGeneralyAdmninistracion() {
		return costoGeneralyAdmninistracion;
	}
	public void setCostoGeneralyAdmninistracion(Double costoGeneralyAdmninistracion) {
		this.costoGeneralyAdmninistracion = costoGeneralyAdmninistracion;
	}
	public Double getCostoComercializacionMena() {
		return costoComercializacionMena;
	}
	public void setCostoComercializacionMena(Double costoComercializacionMena) {
		this.costoComercializacionMena = costoComercializacionMena;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Mineria [mina=");
		builder.append(mina);
		builder.append(", planta=");
		builder.append(planta);
		builder.append(", refinadora=");
		builder.append(refinadora);
		builder.append(", bloque=");
		builder.append(bloque);
		builder.append(", leyEquivalente=");
		builder.append(leyEquivalente);
		builder.append(", matrizInicial=");
		builder.append(matrizInicial);
		builder.append(", matrizEquivalente=");
		builder.append(matrizEquivalente);
		builder.append(", variablesIndependienteLey=");
		builder.append(variablesIndependienteLey);
		builder.append(", variablesDependienteLey=");
		builder.append(variablesDependienteLey);
		builder.append(", leyCriticaDiseño=");
		builder.append(leyCriticaDiseño);
		builder.append(", costoComercializacion=");
		builder.append(costoComercializacion);
		builder.append(", costoGeneralyAdmninistracion=");
		builder.append(costoGeneralyAdmninistracion);
		builder.append(", costoComercializacionMena=");
		builder.append(costoComercializacionMena);
		builder.append(", costoFundicionYRefineria=");
		builder.append(costoFundicionYRefineria);
		builder.append("]");
		return builder.toString();
	}
}