package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCarros;



public class Principal {

	public static void main(String[] args) {
		
		int permissao = 1;
		Semaphore semaforo = new Semaphore(permissao);

		for(int idCarro =0; idCarro < 4; idCarro++) {
			Thread tCarros = new ThreadCarros(idCarro,semaforo);
			tCarros.start();
		}
	}

}
