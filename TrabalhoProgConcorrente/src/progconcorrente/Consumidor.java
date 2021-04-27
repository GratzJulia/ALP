package progconcorrente;

public class Consumidor extends Thread {
	private Compartilhado n;
	
	Consumidor(Compartilhado numero) {
		n = numero;
	}
	
	@Override
	public void run() {
		
		for(int i=0; i<10; i++) {
			n.consumir(this.getName());
		}
	}
}
