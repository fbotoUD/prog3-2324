package es.deusto.prog3.cap01.ejercicios;

public class OperacionesConArray {
	
	public static void sumarAPosicion(int[] array, int posicion, int numero) {
		System.out.println(array[posicion]);
		array[posicion] = array[posicion] + numero;
		System.out.println(array[posicion]);
	}
	
	public static int sumarPosiciones(int[] array) {
		int total = 0;
		for(int i=0; i< array.length; i++) {
			total += array[i];
		}
		return total;
	}
}
