package controller;

import java.util.concurrent.Semaphore;

public class ThreadCarros extends Thread{
	
	private String sentido;
	private int idCarro;
	private Semaphore semaforo;

	public ThreadCarros(int idCarro, Semaphore semaforo) {
		this.idCarro=idCarro;
		this.semaforo=semaforo;
	}
	
	@Override
	public void run() {
		movimentaCarro();
		try {
			semaforo.acquire();
			cruzar();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
		
	}



	private void movimentaCarro() {
		int anda = 0;
		
		while (anda <= 500) {
			anda += 100;
		}
		try {
			sleep(100);//parada
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Carro "+idCarro+ " parou no cruzamento" );
	}
	
	private void cruzar() {
		if(idCarro==0) {
			sentido="Leste";
		}else if(idCarro == 1){
			sentido="Oeste";
		}else if(idCarro == 2){
			sentido="Norte";
		}else {
			sentido="Sul";
		}
		System.out.println("#Carro "+idCarro+" cruzou para o " + sentido);
	}
}
