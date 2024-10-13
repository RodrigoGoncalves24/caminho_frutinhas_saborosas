
// VERSÃO FINAL
public class Bifurcacao {

    private static int caminho1, fixo = 0, count = 1;
    private static final int adicional = 0;
    private static int cLeft, cRight, cTop;
    private static char[] linha;
    private static char caracter;

    public static int Percorre(int pos, int linhaCaracter, LerAquivoTexto arquivo, int total, int adicional) {
        if (fixo == 0) fixo = total;

        linha = arquivo.arv.get(linhaCaracter);
        caracter = linha[pos];
        System.out.println(caracter);


        switch (caracter) {
            case 'W': {
                caminhoDireita(pos + 1, linhaCaracter - 1, arquivo, adicional);
                caminhoCentral(pos, linhaCaracter - 1, arquivo, adicional);
                caminhoEsquerda(pos - 1, linhaCaracter - 1, arquivo, adicional);

                break;
            }
            case 'V': {
                caminhoDireita(pos + 1, linhaCaracter - 1, arquivo, adicional);
                caminhoEsquerda(pos - 1, linhaCaracter - 1, arquivo, adicional);
                break;
            }

        }

        return caminho1;
    }


    // Percorre pela direita
    public static void caminhoDireita(int pos, int linhaCaracter, LerAquivoTexto arquivo, int adicional) {
        anda(pos, linhaCaracter, arquivo);

        if (caracter == 'W' || caracter == 'V') {
            adicional += cRight;
            cRight = 0;
            Percorre(pos, linhaCaracter, arquivo, 0, adicional);

        }
        cRight += isNumber(caracter, cRight);

        if (caracter != '#') caminhoDireita(pos + 1, linhaCaracter - 1, arquivo, adicional);

        maior(cRight + fixo + adicional);
        cRight = 0;

    }

    //Percorre central
    public static void caminhoCentral(int pos, int linhaCaracter, LerAquivoTexto arquivo, int adicional) {
        anda(pos, linhaCaracter, arquivo);

        if (caracter == 'W' || caracter == 'V') {
            adicional += cTop;
            cTop = 0;
            Percorre(pos, linhaCaracter, arquivo, 0, adicional);

        }
        cTop += isNumber(caracter, cTop);

        if (caracter != '#') caminhoCentral(pos, linhaCaracter - 1, arquivo, adicional);

        maior(cTop + fixo + adicional);
        cTop = 0;
    }

    // Percorre pela esquerda
    public static void caminhoEsquerda(int pos, int linhaCaracter, LerAquivoTexto arquivo, int adicional) {

        anda(pos, linhaCaracter, arquivo);

        if (caracter == 'W' || caracter == 'V') {
            adicional += cLeft;
            cLeft = 0;
            Percorre(pos, linhaCaracter, arquivo, 0, adicional);

        }
        cLeft += isNumber(caracter, cLeft);

        if (caracter != '#') caminhoEsquerda(pos - 1, linhaCaracter - 1, arquivo, adicional);

        maior(cLeft + fixo + adicional);
        cLeft = 0;

    }

    //Identifica sem caracter é número
    public static int isNumber(char c, int valor) {
        System.out.println(c);

        if (Character.isDigit(c)) {
            valor = Character.getNumericValue(c);
            return valor;
        }
        return 0;
    }

    //Identifica o maior deles
    public static void maior(int c1) {
        if (c1 > caminho1) caminho1 = c1;
        System.out.println("Soma até o momento: " + c1);

    }

    public static void anda(int pos, int linhaCaracter, LerAquivoTexto arquivo) {
        linha = arquivo.arv.get(linhaCaracter);
        caracter = linha[pos];
    }

}
