package view;

import java.util.concurrent.Semaphore;

import controller.Pista;

public class Main {

	public static void main(String[] args) {

		Semaphore semaphN = new Semaphore(1);
		Semaphore semaphS = new Semaphore(1);
		
		for (int i = 0; i < 12; i++) {
			
			Pista aviao = new Pista(semaphN, semaphS, i);
			aviao.start();
		}
	}
}
