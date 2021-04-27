package progconcorrente;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Início do Programa!\n");
		
		Compartilhado n = new Compartilhado(0);
		
		Produtor p = new Produtor(n);
		Consumidor c = new Consumidor(n);
		
		p.start();
		c.start();
		
		p.join();
		c.join();
		
		System.out.println("\nFim do Programa!");
	}
}
