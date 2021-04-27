package progconcorrente;

public class Produtor extends Thread {
	Compartilhado n;
	
	Produtor(Compartilhado numero) {
		n = numero;
	}
	
	@Override
	public void run() {
		
		for(int i=0; i<10; i++) {
			n.produzir(this.getName(), i);
			
			try {
				sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
