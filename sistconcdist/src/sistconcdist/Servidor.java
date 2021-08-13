package sistconcdist;

class Servidor extends Thread {

    Servico s;
    private String mensagem = "";

    Servidor(String pedido, Servico servico) {
        mensagem = pedido;
        s = servico;        
    }

    @Override
    public void run() {
        System.out.println("Início Thread do Servidor --");
        
        s.produzir(this.getName(), s);        
    }
}
