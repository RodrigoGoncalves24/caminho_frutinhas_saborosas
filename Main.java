
public class Main {
    public static void main(String[] args) {
        //Lendo o arquivo
        LerAquivoTexto ler = new LerAquivoTexto();
        ler.LerAquivo();

        System.out.println("O caminho com maior ponto é: "+Percorre.Percorre(ler));

    }
}
