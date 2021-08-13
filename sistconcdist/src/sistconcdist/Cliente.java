package sistconcdist;

import java.util.logging.Level;
import java.util.logging.Logger;

class Cliente extends Thread {

    private Servico s;
    private String mensagem = "";
    
    Cliente(String mensagem) {
        this.mensagem = mensagem;
        s = new Servico(mensagem);
    }

    @Override
    public void run() {
        System.out.println("Início Thread do Cliente --");
        
        Servidor p = new Servidor(mensagem, s);
        p.start();
        s.solicitar(this.getName(), mensagem);
        try {
            p.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
