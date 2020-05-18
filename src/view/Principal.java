package view;
import java.util.concurrent.Semaphore;

import controller.ThreadJokenpo;

public class Principal {
	public static void main(String[] args) {

		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		
		for(int idDuelo = 1; idDuelo <= 1; idDuelo++){
			Thread tDuelo = new ThreadJokenpo(idDuelo, semaforo);
			tDuelo.start();
		}
		
	}

}
