package view;

import java.util.concurrent.Semaphore;

import controller.Corredor;

public class CorredorMain {

	public static void main(String[] args) {
		
		Semaphore semaforo = new Semaphore(1);

		for (int idPessoa = 0; idPessoa < 4; idPessoa++) {
			Thread t = new Corredor(idPessoa, semaforo);
			t.start();
		}
	}

}
