package controller;

import java.util.concurrent.Semaphore;

public class Corredor extends Thread {

	private int idPessoa;
	private Semaphore semaforo;

	public Corredor(int idPessoa, Semaphore semaforo) {
		this.idPessoa = idPessoa;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		andar();
		try {
			semaforo.acquire();
			porta();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}

	private void andar() {
		int tamanhoCorredor = 200;
		int distanciaPercorrida = 0;
		int deslocamento = (int) ((Math.random() * 3) + 4);
		int tempo = 1000;
		while (distanciaPercorrida < tamanhoCorredor) {
			distanciaPercorrida += deslocamento;
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("#" + idPessoa + " chegou a porta!");
	}

	// CRITICO!!!
	private void porta() {
		System.err.println("#" + idPessoa + " começou a abrir a porta.");
		int tempo = (int) ((Math.random() * 1001) + 1000);
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("#" + idPessoa + " saiu!");
	}

}