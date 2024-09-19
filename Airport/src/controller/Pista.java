package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Pista extends Thread {
	
	private int numero;
	private int aviao;
	private Random rand = new Random();
	private Semaphore norte;
	private Semaphore sul;
	private String pista;
	
	public Pista(Semaphore n, Semaphore s, int i) {
		this.numero = rand.nextInt(1,1001);
		this.norte = n;
		this.sul = s;
		this.aviao = (1+i);
		this.pista = norteOuSul(numero);
	}
	
	private String norteOuSul(int numero) {
		
		if (numero % 2 == 0) {
			
			return "norte";
		} else {return "sul";}
	}

	private void manobrar() {
		
		int manobrouEm = rand.nextInt(300,701);
		
		try {
			sleep(manobrouEm);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println( "\n------------------------------ \n" + "O avião " + aviao + " manobrou em " + manobrouEm + ".s \n" + "------------------------------\n");
		
	}
	
	private void taxiar() {
		int taxiouEm = rand.nextInt(500,1001);
		
		try {
			sleep(taxiouEm);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println( "\n-------------------------- \n" + "O avião " + aviao + " taxiou em " + taxiouEm+ ".s \n" + "--------------------------\n");
	}
	
	private void decolar() {
		int decolouEm = rand.nextInt(600,801);
		
		try {
			sleep(decolouEm);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println( "\n---------------------------------------- \n" + "O avião " + aviao + " decolou em " + decolouEm+ ".s pela pista " +pista+ "\n" + "----------------------------------------\n");
	}
	
	private void afastar() {
		int afastou = rand.nextInt(300,801);
		
		String viao = """
				                   
⠀⠀⠀⣖⠲⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠉⡇⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠸⡆⠹⡀⣠⢤⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡏⠀⡧⢤⡄⠀⠀⠀⠀⠀
⠀⠀⠀⠀⡧⢄⣹⣅⣜⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠁⠀⢹⠚⠃⠀⠀⠀⠀⠀
⠀⣀⠴⢒⣉⡹⣶⣤⣀⡉⠉⠒⠒⠒⠤⠤⣀⣀⣀⠇⠀⠀⢸⠠⣄⠀⠀⠀⠀⠀
⠀⠈⠉⠁⠀⠀⠀⠉⠒⠯⣟⣲⠦⣤⣀⡀⠀⠀⠈⠉⠉⠉⠛⠒⠻⢥⣀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⣲⡬⠭⠿⢷⣦⣤⢄⣀⠀⠀⠚⠛⠛⠓⢦⡀
⠀⠀⠀⠀⠀⠀⠀⢀⣀⠤⠴⠚⠉⠁⠀⠀⠀⠀⣀⣉⡽⣕⣯⡉⠉⠉⠑⢒⣒⡾
⠀⠀⣀⡠⠴⠒⠉⠉⠀⢀⣀⣀⠤⡤⢶⣶⣋⠉⠉⠀⠀⠀⠈⠉⠉⠉⠉⠉⠁⠀
⣖⣉⣁⣠⠤⠶⡶⡶⢍⡉⠀⠀⠀⠙⠒⠯⠜⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠁⠀⠀⠀⠀⠑⢦⣯⠇
				
				""";
		
		try {
			sleep(afastou);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println( "\n* * * * * * * * * * * * * * * * * *\n" + "O avião " + aviao + " se afastou do aeroporto! \n* * * * * * * * * * * * * * * * * * " + " \n" + viao);
	}

	@Override
	public void run() {
		
		if(pista.equals("norte")) {
			try {
				norte.acquire();
				manobrar();
				taxiar();
				decolar();
				afastar();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {norte.release(); }
			
		} else {
			try {
				sul.acquire();
				manobrar();
				taxiar();
				decolar();
				afastar();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {sul.release(); }
		}
	}
		
}
