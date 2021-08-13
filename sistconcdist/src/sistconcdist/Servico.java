package sistconcdist;

import java.util.logging.Level;
import java.util.logging.Logger;

class Servico {

    private String produto;
    private boolean disponivel; // VARIAVEL DE CONTROLE

    Servico(String valor) {
        this.produto = valor;
        disponivel = false;
    }

    public synchronized void produzir(String threadId, Servico s) {
        while (disponivel == false) {
            /* aguandando disponibilidade! */
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }

        s.produto = "Produtinho";
        produto = s.produto.concat(threadId);
        System.out.println("  Servidor " + threadId + " produziu: " + produto);

        disponivel = false;
        notifyAll();
    }

    public synchronized void solicitar(String threadId, String mensagem) {
        
        while (disponivel == true) {
            /* aguandando disponibilidade! */
                try {
                    this.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Servico.class.getName()).log(Level.SEVERE, null, ex);
                }
        }

        System.out.println("  Cliente " + threadId + " solicitou: " + mensagem);
        
        disponivel = true;
        notifyAll();
    }
}
