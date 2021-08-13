package sistconcdist;
/**
 * @author Julia Gratz
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Início do Programa!\n");
		
	Servico n = new Servico("");
	Cliente c = new Cliente("Pode me prestar um serviço?");
	
	c.start();
	c.join();
		
	System.out.println("\nFim do Programa!");
    }    
}
