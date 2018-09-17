package com.nibor.rajo;

import com.nibor.util.MatrizOperaciones;
import com.nibor.util.Util;

public class Proceso {

	Mineria mineria = new Mineria();
	static final Double AIRE = -2.0;
	static final Double ESTERIL = -1.0;
	
	public void valorizarBloques() {

		// Convertir todos los precios a US$/Ton
		//System.out.println("Cobre: " + mineria.getMina().getPrecioCobre() + " Oro: " + mineria.getMina().getPrecioOro());
		determinarLeyequivalente();
		obtenerMatrizEquivalente();
		obtenerLimitante();
		obtenerTonelaje();
		obtenerCostos();
		valorizarBloque();
		valorEconomico();
		matrizValorizada();
		matrizAcumulada();

	}
	private void determinarLeyequivalente() {
		System.out.println("[Proceso][determinarLeyequivalente][inicio]");
		// Calculamos el factor equivalente
		Mina mina = mineria.getMina();
		Double factorEquivalente = Util.formatearDecimales((mina.getPrecioOro() * mina.getRecuperacionOro() * 0.01) / mina.getPrecioCobre(), 2);

		Double leyEquivalente = Util.formatearDecimales(((mina.getLey().getOroConRespectoAlCu() * 0.0001 * (factorEquivalente)) + 1), 2);
		mineria.setLeyEquivalente(leyEquivalente);
		System.out.println("[Proceso][determinarLeyequivalente][fin]"+mineria.toString());
	}

	private void obtenerMatrizEquivalente() {
		System.out.println("[Proceso][obtenerMatrizEquivalente][inicio]");
		double[][] matrizEquivalente = MatrizOperaciones.multiplicarMatrizEq(mineria.getLeyEquivalente(), mineria.getMatrizInicial().getMatrizInicial());
		MatrizOperaciones.imprimirOriginal(matrizEquivalente);
		mineria.getMatrizInicial().setMatrizEquivalente(matrizEquivalente);
		System.out.println("[Proceso][obtenerMatrizEquivalente][fin]");
	}

	private void obtenerLimitante() {
		System.out.println("[Proceso][obtenerLimitante][inicio]");
		Double mineral = Util.formatearDecimales((mineria.getMina().getCapacidad() / (1 + mineria.getMina().getRazonRemocion())), 3);
//		System.out.println("mineral: " + mineral);
		mineria.getMina().setCapacidadMena(mineral);
		// Limita Planta
		if (mineria.getMina().getCapacidadMena() < mineria.getPlanta().getCapacidad()) {
			System.out.println("Limita Planta--> ");
		}
		System.out.println("[Proceso][obtenerLimitante][fin]");
	}
	
	private void obtenerTonelaje() {
		System.out.println("[Proceso][obtenerTonelaje][inicio]");
		Bloque bloque = mineria.getBloque();
		int volumen = bloque.getDimensionx() * bloque.getDimensiony() * bloque.getDimensionz();
		System.out.println("volumen: " + volumen + " :" + bloque.getDimensionx() + " y:" + bloque.getDimensiony()+ " z:" + bloque.getDimensionz());

		Double tonelajeMineralTotal = Util.formatearDecimales((volumen * (bloque.getCobre() + bloque.getOro()) / 100 * mineria.getMina().getDensidadMineral()), 2);
		Double tonelajeEsterilTotal = Util.formatearDecimales((volumen * (bloque.getEsteril()) / 100 * mineria.getMina().getDensidadEsteril()), 2);
		//Double tonelajeEsteril = Util.formatearDecimales((volumen * 1 / mineria.getMina().getDensidadEsteril()), 2);
		Double tonelajeEsteril = Util.formatearDecimales((volumen * (1) / 1 * mineria.getMina().getDensidadEsteril()), 2);
		mineria.getMina().setTonelajeEsterilTotal(tonelajeEsterilTotal);
		mineria.getMina().setTonelajeMineralTotal(tonelajeMineralTotal);
		mineria.getMina().setTonelajeEsteril(tonelajeEsteril);

		System.out.println("tonelajeMineral Total: " + tonelajeMineralTotal + " tonelajeEsteril Total: " + tonelajeEsterilTotal+" Tonelaje Esteril: " + tonelajeEsteril);
		System.out.println("[Proceso][obtenerTonelaje][fin]"+mineria.getMina().toString());
	}
	
	private void obtenerCostos() {
		System.out.println("[Proceso][obtenerCostos][inicio]");
		// Calculo costo mina Cm = Cm + GGyAdm
		// Convirtiendo GGyAdm de us/aÃ±o a us/ton
		Double gastoGGyAdm = Util.formatearDecimales((mineria.getCostoGeneralyAdmninistracion() / mineria.getMina().getCapacidad()),2);
		Double costoAsociadoMina = Util.formatearDecimales((mineria.getMina().getCosto() + gastoGGyAdm),2);
		mineria.getMina().setCostoAsociadoMina(costoAsociadoMina);
		System.out.println("Gasto GGyAdm: " + gastoGGyAdm + " CostoAsociado: " + costoAsociadoMina);

		// Costo comercializacion
		Double costoProcesamientoMena = mineria.getMina().getCapacidadMena() * mineria.getMina().getCostoRemocion() * mineria.getPlanta().getRecuperacion() * mineria.getMina().getLey().getLeyCabeza();
		costoProcesamientoMena = (costoProcesamientoMena / (100 * 100));
		Double costoComercializacionMena = Util.formatearDecimales((mineria.getCostoComercializacion() / costoProcesamientoMena),2);
		mineria.setCostoComercializacionMena(costoComercializacionMena);
		System.out.println("costoComercializacion Mena:" + costoComercializacionMena);

		Double costoFundicionRefineria = mineria.getRefinadora().getCosto() + costoComercializacionMena;
		mineria.setCostoFundicionYRefineria(costoFundicionRefineria);
		System.out.println("costoFundicionRefineria: " + costoFundicionRefineria);
		System.out.println("[Proceso][obtenerCostos][fin]");
	}
	
	private void valorizarBloque() {
		System.out.println("[Proceso][valorizarBloque][inicio]");
		valorizarBloqueSegunUp();
		System.out.println("[Proceso][valorizarBloque][fin]");
	}

	private void valorizarBloqueSegunUp() {
		//UP = Tm*Lm*R*P - Tm*Ln*Rt*Cfr -Tm*Cm-Tm*Cp
		// datos que influyen en la ley
		//Tm*Lm*R*P - Tm*Ln*Rt*Cfr 
		Double datoDepLey = Util.formatearDecimales((mineria.getMina().getTonelajeMineralTotal() * mineria.getPlanta().getRecuperacion() / 100 * mineria.getMina().getCostoRemocion() * (mineria.getMina().getPrecioCobre() - mineria.getCostoFundicionYRefineria())), 2);
		
		
		mineria.setVariablesDependienteLey(datoDepLey);
		//System.out.println("datoDepLey: " + datoDepLey);
		// variables independientes
		//-Tm*Cm-Tm*Cp
		Double datoIndLey = Util.formatearDecimales((-mineria.getMina().getTonelajeMineralTotal() * (mineria.getMina().getCostoAsociadoMina() + mineria.getPlanta().getCosto())),2);
		//System.out.println("datoIndLey: " + datoIndLey);
		mineria.setVariablesIndependienteLey(datoIndLey);

		Double leyCriticaDiseño = Util.formatearDecimales((-datoIndLey / datoDepLey), 4);
		mineria.setLeyCriticaDiseño(leyCriticaDiseño);
		System.out.println("leyM: " + leyCriticaDiseño);

//		obtenerValorBloqueMineral(datoIndLey, datoDepLey, 0.8);
	}
	
	private void valorEconomico() {
		System.out.println("[Proceso][valorEconomico][inicio]");
		ValorEconomico valorEconomico = new ValorEconomico();
		
		Double	valorBloqueEsteril = Util.fijarDecimales((-mineria.getMina().getTonelajeEsteril() * mineria.getMina().getCostoRemocion()), 2);
		valorEconomico.setValorBloqueEsteril(valorBloqueEsteril);
		
		Double valoresIndependientes =  mineria.getVariablesIndependienteLey() - mineria.getMina().getTonelajeEsteril() * mineria.getMina().getCostoRemocion();
		valorEconomico.setValoresIndependientes(valoresIndependientes);
		
		Double valoresDependientes = mineria.getVariablesDependienteLey();
		valorEconomico.setValoresDependientes(valoresDependientes);
		
		Bloque.valorEconomico = valorEconomico;
		System.out.println("[Proceso][valorEconomico][fin]"+valorEconomico.toString());
	}

	private void matrizValorizada() {
		System.out.println("[Proceso][matrizValorizada][inicio]");
		double[][] matrizEquivalente = mineria.getMatrizInicial().getMatrizEquivalente();
		double[][] matrizValorizada = new double[MatrizOperaciones.fila][MatrizOperaciones.colum];

		for (int i = 0; i < MatrizOperaciones.fila; i++)
			for (int j = 0; j < MatrizOperaciones.colum; j++) {
				if (matrizEquivalente[i][j] >= mineria.getLeyCriticaDiseño()) {
					//System.out.println("matrizEquivalente[i][j]: " + matrizEquivalente[i][j]);
					matrizValorizada[i][j] = funcionValorizacionMx(matrizEquivalente[i][j]);
				} else {
					matrizValorizada[i][j] = funcionValorizacionAireEsteril(matrizEquivalente[i][j]);
				}
			}

		MatrizOperaciones.imprimirNormal(matrizValorizada);
		mineria.getMatrizInicial().setMatrizValorizada(matrizValorizada);
		System.out.println("[Proceso][matrizValorizada][fin]");
	}
	
	private void matrizAcumulada() {
		System.out.println("[Proceso][matrizAcumulada][inicio]");
		//agregamos una fila y una columna.
		addColumnAndRow();
		
		double[][] matrizValorizada = mineria.getMatrizInicial().getMatrizEquivalente();
		double[][] matrizAcumulada = new double[MatrizOperaciones.fila][MatrizOperaciones.colum];
		int acumulado = 0;
		for (int j = 0; j < MatrizOperaciones.colum; j++)
		{
			acumulado = 0;
			for (int i = 0; i < MatrizOperaciones.fila; i++) {
				acumulado += matrizValorizada[i][j];
				matrizAcumulada[i][j]= acumulado;
				//System.out.println("matrizAcumulada["+i+"]["+j+"]: " + matrizAcumulada[i][j]);
				
			}
		}
		MatrizOperaciones.imprimirNormal(matrizAcumulada);
		mineria.getMatrizInicial().setMatrizValorizada(matrizValorizada);
		System.out.println("[Proceso][matrizAcumulada][fin]");
	}


	private void addColumnAndRow() {
		// TODO Auto-generated method stub
		
	}
	public Double funcionValorizacionMx(Double leyBloque) {
		Mina mina = mineria.getMina();
		ValorEconomico valor = Bloque.valorEconomico;
		Double valorBloqueMx1 = Util.formatearDecimales((mineria.getVariablesDependienteLey() * leyBloque + mineria.getVariablesIndependienteLey() - mineria.getMina().getTonelajeEsteril() * mineria.getMina().getCostoRemocion()), 2);
		Double valorBloqueMx = valor.getValoresDependientes() * leyBloque + valor.getValoresIndependientes() - mina.getTonelajeEsteril() * mina.getCostoRemocion();
		//System.out.println("valorBloqueMx: " + valorBloqueMx);
		//6.622845901E7
		return valorBloqueMx;
	}

	public Double funcionValorizacionAireEsteril(Double leyBloque) {
		
		
		Double valorBloqueEsteril = 0.0;
//		System.out.println("leyBloque: "+leyBloque);
		//AIRE
		
		if(Double.compare(leyBloque, AIRE) == 0)
		{
			valorBloqueEsteril = 0.0;
		}
		//Esteril
		else
		{
			valorBloqueEsteril = Util.fijarDecimales((-mineria.getMina().getTonelajeEsteril() * mineria.getMina().getCostoRemocion()), 2);
		}
		//System.out.println("============valorBloqueEsteril: " + valorBloqueEsteril);
		return valorBloqueEsteril;
	}







	public void valoresIniciales() {
		System.out.println("[Proceso][valoresIniciales][inicio]");
		Bloque bloque = new Bloque();
		// DIMENSIONES
		bloque.setDimensionx(20);
		bloque.setDimensiony(20);
		bloque.setDimensionz(20);
		bloque.setEsteril(20);
		bloque.setCobre(70);
		bloque.setOro(10);
		mineria.setBloque(bloque);

		Mina mina = new Mina();
		Planta planta = new Planta();
		Refinadora refinadora = new Refinadora();

		// LEYES
		Ley ley = new Ley();
		ley.setOroConRespectoAlCu(1.2);
		ley.setLeyCabeza(2.0);
		mina.setLey(ley);
		// mina.getLey().setOroConRespectoAlCu(1.2);
		// mina.setLeyCobre(leyCobre);
		// mina.getLey().setLeyCabeza(2.0);

		// COSTOS
		mina.setCosto(1.3);
		mina.setCostoRemocion(0.9);
		planta.setCosto(3.4);
		refinadora.setCosto(120.0);
		mineria.setCostoComercializacion(4.0);
		mineria.setCostoGeneralyAdmninistracion(3.0);

		// RECUPERACION
		mina.setRecuperacionOro(70);
		planta.setRecuperacion(80);
		refinadora.setRecuperacion(90);

		// DENSIDAD
		mina.setDensidadMineral(2.5);
		mina.setDensidadEsteril(2.0);

		// OTROS
		mina.setCapacidad(3.5);
		planta.setCapacidad(2.0);
		mina.setRazonRemocion(1.25);

		// PRECIOS
		mina.setPrecioOroOnza(500);
		mina.setPrecioCobreCentesimo(280);

		mineria.setMina(mina);
		mineria.setPlanta(planta);
		mineria.setRefinadora(refinadora);

		// Matriz Inicial
		Matriz matriz = new Matriz();
		double[][] matrizInicial = { { -2, -1, 0.80, -2, -2, 0.90, 0.50, -2, -2, 0.30, 0.10, -2 },
				{ -1, 0.70, 0.30, 1.20, -2, 0.70, 1.20, 1, 0.40, 0.80, 0.20, -2 },
				{ -1, 0.30, -1, 0.70, 0.10, 1.20, 0.80, 0.70, 0.20, 0.50, 0.20, -2 },
				{ -1, -1, 0.60, 0.20, 0.20, 0.40, 0.60, 0.40, 0.30, 0.70, 0.20, -1 },
				{ -1, -1, 0.20, 0.20, 0.80, 0.20, -1, -1, 0.20, -1, -1, -1 } };
		matriz.setMatrizInicial(matrizInicial);
		MatrizOperaciones.imprimirOriginal(matrizInicial);
		mineria.setMatrizInicial(matriz);
		System.out.println("[Proceso][valoresIniciales][fin]");
	}
}