package com.nibor.rajo;

public class Mina {
	
	private Ley ley;
	
	private int recuperacionOro;
	private Double capacidad;
	private Double razonRemocion;
	
	private Double densidadMineral;
	private Double densidadEsteril;
	private Double costo;
	
	private Double precioOro;
	private Double precioCobre;
	private Double capacidadMena;
	private Double costoRemocion;
	
	private Double tonelajeMineralTotal;
	private Double tonelajeEsterilTotal;
	private Double tonelajeEsteril;
	
	private Double costoAsociadoMina;
	
	public Double getTonelajeEsteril() {
		return tonelajeEsteril;
	}
	public void setTonelajeEsteril(Double tonelajeEsteril) {
		this.tonelajeEsteril = tonelajeEsteril;
	}
	public Double getCostoAsociadoMina() {
		return costoAsociadoMina;
	}
	public void setCostoAsociadoMina(Double costoAsociadoMina) {
		this.costoAsociadoMina = costoAsociadoMina;
	}
	public Double getTonelajeMineralTotal() {
		return tonelajeMineralTotal;
	}
	public void setTonelajeMineralTotal(Double tonelajeMineralTotal) {
		this.tonelajeMineralTotal = tonelajeMineralTotal;
	}
	public Double getTonelajeEsterilTotal() {
		return tonelajeEsterilTotal;
	}
	public void setTonelajeEsterilTotal(Double tonelajeEsterilTotal) {
		this.tonelajeEsterilTotal = tonelajeEsterilTotal;
	}
	public int getRecuperacionOro() {
		return recuperacionOro;
	}
	public void setRecuperacionOro(int recuperacionOro) {
		this.recuperacionOro = recuperacionOro;
	}
	public Double getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(Double capacidad) {
		this.capacidad = capacidad;
	}
	public Double getRazonRemocion() {
		return razonRemocion;
	}
	public void setRazonRemocion(Double razonRemocion) {
		this.razonRemocion = razonRemocion;
	}
	public Ley getLey() {
		return ley;
	}
	public void setLey(Ley ley) {		
		this.ley = ley;
	}
	public void setCosto() {
		;
	}
	public Double getCosto() {
		return costo;
	}
	public void setCosto(Double costo) {
		this.costo = costo;
	}
	public Double getCostoRemocion() {
		return costoRemocion;
	}
	public void setCostoRemocion(Double costoRemocion) {
		this.costoRemocion = costoRemocion;
	}
	public void setDensidadMineral(Double densidadMineral) {
		this.densidadMineral = densidadMineral;
	}
	public void setDensidadEsteril(Double densidadEsteril) {
		this.densidadEsteril = densidadEsteril;
	}
	public void setPrecioOroOnza(int precio) {
		this.precioOro = (precio*1000000)/31.1;
	}
	public void setPrecioCobreCentesimo(int precio) {
		this.precioCobre = (double) ((precio*2205)/100);
	}
	public void setCostoComercializacion(Double costoComercializacion) {
		;
	}
	public void setCostoGeneralesyAdministracion(Double costoGeneralyAdmninistracion) {
		;
	}
	public Double getPrecioOro() {
		return precioOro;
	}
	public void setPrecioOro(Double precioOro) {
		this.precioOro = precioOro;
	}
	public Double getPrecioCobre() {
		return precioCobre;
	}
	public void setPrecioCobre(Double precioCobre) {
		this.precioCobre = precioCobre;
	}
	public Double getDensidadMineral() {
		return densidadMineral;
	}
	public Double getDensidadEsteril() {
		return densidadEsteril;
	}
	public Double getCapacidadMena() {
		return capacidadMena;
	}
	public void setCapacidadMena(Double capacidadMena) {
		this.capacidadMena = capacidadMena;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Mina [ley=");
		builder.append(ley);
		builder.append(", recuperacionOro=");
		builder.append(recuperacionOro);
		builder.append(", capacidad=");
		builder.append(capacidad);
		builder.append(", razonRemocion=");
		builder.append(razonRemocion);
		builder.append(", densidadMineral=");
		builder.append(densidadMineral);
		builder.append(", densidadEsteril=");
		builder.append(densidadEsteril);
		builder.append(", costo=");
		builder.append(costo);
		builder.append(", precioOro=");
		builder.append(precioOro);
		builder.append(", precioCobre=");
		builder.append(precioCobre);
		builder.append(", capacidadMena=");
		builder.append(capacidadMena);
		builder.append(", costoRemocion=");
		builder.append(costoRemocion);
		builder.append(", tonelajeMineralTotal=");
		builder.append(tonelajeMineralTotal);
		builder.append(", tonelajeEsterilTotal=");
		builder.append(tonelajeEsterilTotal);
		builder.append(", tonelajeEsteril=");
		builder.append(tonelajeEsteril);
		builder.append(", costoAsociadoMina=");
		builder.append(costoAsociadoMina);
		builder.append("]");
		return builder.toString();
	}
}