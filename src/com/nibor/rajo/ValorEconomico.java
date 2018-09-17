package com.nibor.rajo;

public class ValorEconomico {

	private Double valorBloqueEsteril;
	private Double valoresIndependientes;
	private Double valoresDependientes;
	
	public Double getValoresIndependientes() {
		return valoresIndependientes;
	}
	public void setValoresIndependientes(Double valoresIndependientes) {
		this.valoresIndependientes = valoresIndependientes;
	}
	public Double getValoresDependientes() {
		return valoresDependientes;
	}
	public void setValoresDependientes(Double valoresDependientes) {
		this.valoresDependientes = valoresDependientes;
	}
	public Double getValorBloqueEsteril() {
		return valorBloqueEsteril;
	}
	public void setValorBloqueEsteril(Double valorBloqueEsteril) {
		this.valorBloqueEsteril = valorBloqueEsteril;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ValorEconomico [valorBloqueEsteril=");
		builder.append(valorBloqueEsteril);
		builder.append(", valoresIndependientes=");
		builder.append(valoresIndependientes);
		builder.append(", valoresDependientes=");
		builder.append(valoresDependientes);
		builder.append("]");
		return builder.toString();
	}
}