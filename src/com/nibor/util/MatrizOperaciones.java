package com.nibor.util;

import java.io.IOException;

public class MatrizOperaciones {

	public static int opc;
	public static int fila = 5;
	public static int colum = 12;
	public static int fila2 = 5;
	public static int colum2 = 12;

	public static double[][] m1 = { { -2, -1, 0.8, -2, -2, 0.9, 0.5, -2, -2, 0.3, 0.1, -2 },
			{ -1, 0.7, 0.3, 1.2, -2, 0.7, 1.2, 1, 0.4, 0.8, 0.2, -2 },
			{ -1, 0.3, -1, 0.7, 0.1, 1.2, 0.8, 0.7, 0.2, 0.5, 0.2, -2 },
			{ -1, -1, 0.6, 0.2, 0.2, 0.4, 0.6, 0.4, 0.3, 0.7, 0.2, -1 },
			{ -1, -1, 0.2, 0.2, 0.8, 0.2, -1, -1, 0.2, -1, -1, -1 } };

	public static double[][] m2 = {};

	public static void sumar() throws IOException {

		if (fila == fila2 && colum == colum2) {
			for (int x = 0; x < fila; x++) {
				for (int y = 0; y < colum; y++) {
					System.out.print((m1[x][y]) + (m2[x][y]) + " , ");
				}
				System.out.println(" ");
			}

		} else {
			System.out.print("no se pude sumar las matrices ");
		}
	}

	public static void imprimirOriginal(double[][] m1) {
		for (int x = 0; x < fila; x++) {
			for (int y = 0; y < colum; y++) {
				if (Double.compare(m1[x][y], Util.AIRE) == 0) {
					System.out.print("A       ");
				} else if (Double.compare(m1[x][y], Util.ESTERIL) == 0) {
					System.out.print("E       ");
				} else {
					//System.out.print(Util.formatear(Util.fijarDecimales(m1[x][y], 2), "0.00") + "    ");
					System.out.print(Util.formatear(Util.formatearDecimales(m1[x][y], 2), "0.00")+"    ");
				}
			}
			System.out.println(" ");
		}
	}

	public static void imprimirNormal(double[][] m1) {
		for (int x = 0; x < fila; x++) {
			for (int y = 0; y < colum; y++) {
				//System.out.print((Util.fijarDecimales(m1[x][y], 2)) + "   ");
				System.out.print(Util.formatear(Util.formatearDecimales(m1[x][y], 2), "0.00")+"    ");
			}
			System.out.println(" ");
		}
	}

	public static void matriz1() throws IOException {
		// System.out.print("tamaño de filas " );
		// fila=Integer.parseInt( entrada.readLine());
		// System.out.print("tamaño de columnoas " );
		// colum=Integer.parseInt( entrada.readLine());
		// m1= new double [fila][colum];
		// m1[0] = {1,1};
		/*
		 * for(int i=0;i<fila;i++){ for(int j=0;j<colum;j++){
		 * System.out.print("valor de matriz en ["+(i+1)+" , "+(j+1)+" ]" );
		 * m1[i][j]=Double.parseDouble( entrada.readLine()); } }
		 */
	}

	public static void matriz2() throws IOException {
		/*
		 * System.out.print("tamaño de filas " ); fila2=Integer.parseInt(
		 * entrada.readLine()); System.out.print("tamaño de columnoas " );
		 * colum2=Integer.parseInt( entrada.readLine()); m2= new double [fila2][colum2];
		 * for(int i=0;i<fila2;i++){ for(int j=0;j<colum2;j++){
		 * System.out.print("valor de matriz en ["+i+1+" , "+(j+1)+" ]" );
		 * m2[i][j]=Double.parseDouble( entrada.readLine()); } }
		 */
	}

	public static void sumar2() {
		if (fila == fila2 && colum == colum2) {
			for (int x = 0; x < fila; x++) {
				for (int y = 0; y < colum; y++) {
					System.out.print((m1[x][y]) + (m2[x][y]) + " , ");
				}
				System.out.print("n");
			}

		} else {
			System.out.print("no se pude sumar las matrices ");
		}
	}

	public static void restar() {
		if (fila == fila2 && colum == colum2) {
			for (int x = 0; x < fila; x++) {
				for (int y = 0; y < colum; y++) {
					System.out.print((m1[x][y]) - (m2[x][y]) + " , ");
				}
				System.out.print("n");
			}
		} else {
			System.out.print("no se pude restar las matrices ");
		}
	}

	public static void restar2() {
		if (fila == fila2 && colum == colum2) {
			for (int x = 0; x < fila; x++) {
				for (int y = 0; y < colum; y++) {
					System.out.print((m2[x][y]) - (m1[x][y]) + " , ");
				}
				System.out.print("n");
			}
		} else {
			System.out.print("no se pude sumar las matrices ");
		}
	}

	public static void multi() throws IOException {
		if (colum == fila2) {
			double[][] r1 = new double[fila][colum2];
			for (int x = 0; x < fila; x++) {
				for (int y = 0; y < colum2; y++) {
					for (int m = 0; m < colum; m++) {
						r1[x][y] += m1[x][m] * m2[m][y];
					}
					System.out.print(r1[x][y] + " , ");
				}
				System.out.print("n");
			}
		} else {
			System.out.print("No se puede multiplicar matrices");
		}
	}

	public static void multi2() throws IOException {
		if (colum2 == fila) {
			double[][] r1 = new double[fila2][colum];
			for (int x = 0; x < fila2; x++) {
				for (int y = 0; y < colum; y++) {
					for (int m = 0; m < colum2; m++) {
						r1[x][y] += m2[x][m] * m1[m][y];
					}
					System.out.print(r1[x][y] + " , ");
				}
				System.out.print("n");
			}
		} else {
			System.out.print("No se puede multiplicar matrices");
		}
	}

	public static void deta() throws IOException {
		if (fila == colum) {
			System.out.print("La determinante es : " + determinante(m1));
		} else {
			System.out.print("La Matriz no tiene determinante");
		}
	}

	public static double determinante(double[][] matriz) {
		double det;
		if (matriz.length == 2) {
			det = (matriz[0][0] * matriz[1][1]) - (matriz[1][0] * matriz[0][1]);
			return det;
		}
		double suma = 0;
		for (int i = 0; i < matriz.length; i++) {
			double[][] nm = new double[matriz.length - 1][matriz.length - 1];
			for (int j = 0; j < matriz.length; j++) {
				if (j != i) {
					for (int k = 1; k < matriz.length; k++) {
						int indice = -1;
						if (j < i)
							indice = j;
						else if (j > i)
							indice = j - 1;
						nm[indice][k - 1] = matriz[j][k];
					}
				}
			}
			if (i % 2 == 0)
				suma += matriz[i][0] * determinante(nm);
			else
				suma -= matriz[i][0] * determinante(nm);
		}
		return suma;
	}

	public static void detb() throws IOException {
		if (fila2 == colum2) {
			System.out.print("La determinante es : " + determinante(m2));
		} else {
			System.out.print("La Matriz no tiene determinante");
		}
	}

	public static void traa() throws IOException {
		System.out.print("La matriz original");
		System.out.print("n");
		for (int x = 0; x < fila; x++) {
			for (int y = 0; y < colum; y++) {
				System.out.print(m1[x][y] + " , ");
			}
			System.out.print("n");
		}
		System.out.print("nn");
		System.out.print("La matriz transpuesta");
		System.out.print("n");
		for (int x = 0; x < colum; x++) {
			for (int y = 0; y < fila; y++) {
				System.out.print(m1[y][x] + " , ");
			}
			System.out.print("n");
		}
	}

	public static void trab() throws IOException {
		System.out.print("La matriz original");
		System.out.print("n");
		for (int x = 0; x < fila2; x++) {
			for (int y = 0; y < colum2; y++) {
				System.out.print(m2[x][y] + " , ");
			}
			System.out.print("n");
		}
		System.out.print("nn");
		System.out.print("La matriz transpuesta");
		System.out.print("n");
		for (int x = 0; x < colum2; x++) {
			for (int y = 0; y < fila2; y++) {
				System.out.print(m2[y][x] + " , ");
			}
			System.out.print("n");
		}
	}

	public static void inva() throws IOException {
		if (fila == colum && determinante(m1) != 0) {
			double[][] res = matrizInversa(m1);
			for (int i = 0; i < res.length; i++) {
				for (int j = 0; j < res.length; j++) {
					System.out.print(((res[i][j] * 100) / 100) + " , ");
				}
				System.out.print("n");
			}
		} else {
			System.out.println("no tiene inversa");
		}
	}

	public static void invb() throws IOException {
		if (fila2 == colum2 && determinante(m1) != 0) {
			double[][] res = matrizInversa(m2);
			for (int i = 0; i < res.length; i++) {
				for (int j = 0; j < res.length; j++) {
					System.out.print(((res[i][j] * 100) / 100) + " , ");
				}
				System.out.print("n");
			}
		} else {
			System.out.println("La matriz no tiene inversa");
		}
	}

	public static double[][] matrizInversa(double[][] matriz) {
		double det = 1 / determinante(matriz);
		double[][] nmatriz = matrizAdjunta(matriz);
		multiplicarMatriz(det, nmatriz);
		return nmatriz;
	}

	public static void multiplicarMatriz(double n, double[][] matriz) {
		for (int i = 0; i < fila; i++) {
			for (int j = 0; j < colum; j++) {
				matriz[i][j] *= n;
				System.out.print(" " + matriz[i][j]);
			}
			System.out.println(" ");
		}
	}

	public static double[][] multiplicarMatrizEq(double n, double[][] matriz) {
		double[][] matrizEq = new double[fila][colum];
		for (int i = 0; i < fila; i++) {
			for (int j = 0; j < colum; j++) {
				if (matriz[i][j] > 0) {
					matrizEq[i][j] = Util.formatearDecimales(matriz[i][j] * n, 2);
				} else {
					matrizEq[i][j] = Util.formatearDecimales(matriz[i][j], 2);
				}
				//System.out.print(" " + matrizEq[i][j]);
			}
			//System.out.println(" ");
		}
		return matrizEq;
	}

	public static double[][] matrizAdjunta(double[][] matriz) {
		return matrizTranspuesta(matrizCofactores(matriz));
	}

	public static double[][] matrizCofactores(double[][] matriz) {
		double[][] nm = new double[matriz.length][matriz.length];
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				double[][] det = new double[matriz.length - 1][matriz.length - 1];
				double detValor;
				for (int k = 0; k < matriz.length; k++) {
					if (k != i) {
						for (int l = 0; l < matriz.length; l++) {
							if (l != j) {
								int indice1 = k < i ? k : k - 1;
								int indice2 = l < j ? l : l - 1;
								det[indice1][indice2] = matriz[k][l];
							}
						}
					}
				}
				detValor = determinante(det);
				nm[i][j] = detValor * (double) Math.pow(-1, i + j + 2);
			}
		}
		return nm;
	}

	public static double[][] matrizTranspuesta(double[][] matriz) {
		double[][] nuevam = new double[matriz[0].length][matriz.length];
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++)
				nuevam[i][j] = matriz[j][i];
		}
		return nuevam;
	}
}
