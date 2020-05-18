package controller;
import java.util.concurrent.Semaphore;

public class ThreadJokenpo extends Thread {
	private int idDuelo;
	private Semaphore semaforo;
	private int timeA = 0;
	private int timeB = 0;
	
		
	public ThreadJokenpo(int idDuelo, Semaphore semaforo) {
		this.idDuelo = idDuelo;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {		
		try {
			semaforo.acquire();
			jogar();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// --------V (release)----------
			semaforo.release();
			fimJogo();
		}
	}
	

	private void jogar() {
		int tempo = 500;
		for(int i=0; i<5; i++) {
			int pontosA = 0;
			int pontosB = 0;
			
			do 
			{			
				int jogadorA = (int) ((Math.random() * 3));
				int jogadorB = (int) ((Math.random() * 3));
				// 0 = pedra, 1 = papel, 2 = tesoura.

				if(jogadorA == 0) {
					if(jogadorB == 0) {
						//draw
						System.out.println("Jogo #"+idDuelo+" Duelo #"+(idDuelo+i)+", Jogador A empata com Jogador B, com: Pedra X Pedra     = A:"+pontosA+" | B:"+pontosB);
						try {
							sleep(tempo);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					else if(jogadorB == 1) {
						//win
						pontosB += 1;
						System.out.println("Jogo #"+idDuelo+" Duelo #"+(idDuelo+i)+", Jogador B vence Jogador A, com: Papel X Pedra          = A:"+pontosA+" | B:"+pontosB);
						try {
							sleep(tempo);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					else if(jogadorB == 2) {
						//lose
						pontosA += 1;
						System.out.println("Jogo #"+idDuelo+" Duelo #"+(idDuelo+i)+", Jogador A vence Jogador B, com: Pedra X Tesoura        = A:"+pontosA+" | B:"+pontosB);
						try {
							sleep(tempo);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}

				else if(jogadorA == 1) {
					if(jogadorB == 0) {
						pontosA += 1;
						System.out.println("Jogo #"+idDuelo+" Duelo #"+(idDuelo+i)+", Jogador A vence Jogador B, com: Papel X Pedra          = A:"+pontosA+" | B:"+pontosB);
						try {
							sleep(tempo);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					else if(jogadorB == 1) {
						System.out.println("Jogo #"+idDuelo+" Duelo #"+(idDuelo+i)+", Jogador A empata com Jogador B, com: Papel X Papel     = A:"+pontosA+" | B:"+pontosB);
						try {
							sleep(tempo);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					else if(jogadorB == 2) {
						pontosB += 1;
						System.out.println("Jogo #"+idDuelo+" Duelo #"+(idDuelo+i)+", Jogador B vence Jogador A, com: Tesoura X Papel        = A:"+pontosA+" | B:"+pontosB);
						try {
							sleep(tempo);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}

				else if(jogadorA == 2){
					if(jogadorB == 0) {
						pontosB += 1;
						System.out.println("Jogo #"+idDuelo+" Duelo #"+(idDuelo+i)+", Jogador B vence Jogador A, com: Pedra X Tesoura        = A:"+pontosA+" | B:"+pontosB);
						try {
							sleep(tempo);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					else if(jogadorB == 1) {
						pontosA += 1;
						System.out.println("Jogo #"+idDuelo+" Duelo #"+(idDuelo+i)+", Jogador A vence Jogador B, com: Tesoura X Papel        = A:"+pontosA+" | B:"+pontosB);		
						try {
							sleep(tempo);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					else  if(jogadorB == 2) {
						System.out.println("Jogo #"+idDuelo+" Duelo #"+(idDuelo+i)+", Jogador A empata com Jogador B, com: Tesoura X Tesoura = A:"+pontosA+" | B:"+pontosB);
						try {
							sleep(tempo);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}while(pontosA <3 && pontosB <3 );	
			
			if(pontosA > pontosB) {
				timeA+=1;
				System.out.println("\n-----------x O time A venceu o duelo, placar atual = Time A:"+timeA+" | Time B:"+timeB+" x-----------\n");
				try {
					sleep(4000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				timeB+=1;
				System.out.println("\n-----------x O time B venceu o duelo, placar atual = Time A:"+timeA+" | Time B:"+timeB+" x-----------\n");
				try {
					sleep(4000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	private void fimJogo() {
		if(timeA > timeB) {
			System.out.println("\n-----------------------------x O time A venceu o jogo! x-----------------------------\n");
		}
		else {
			System.out.println("\n-----------------------------x O time B venceu o jogo! x-----------------------------\n");
		}		
	}
}
