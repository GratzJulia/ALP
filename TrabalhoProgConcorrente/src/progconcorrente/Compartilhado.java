package progconcorrente;

public class Compartilhado {
	private int produto;
	private boolean disponivel; // VARIAVEL DE CONTROLE
	
	Compartilhado(int numero) {
		this.produto = numero;
		disponivel = false;
	}
	
	public synchronized void produzir(String threadId, int valor) {
		while(disponivel == true) {
		/* aguandando disponibilidade! */
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		produto = valor;
		System.out.println("Produtor:   " + threadId + " produziu " + valor);
		disponivel = true;
		notifyAll();
	}

	public synchronized void consumir(String threadId) {
		while(disponivel == false) {
		/* aguandando disponibilidade! */
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("  Consumidor: " + threadId + " consumiu " + produto);
		System.out.println();
		disponivel = false;
		notifyAll();
	}
}
