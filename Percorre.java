public class Percorre {

    public static int Percorre(LerAquivoTexto ler ) {
        char[] linha;
        char ch;
        int total = 0;
        for (int i = ler.arv.size() - 1; i > 0; i--) {
            linha = ler.arv.get(i);
            for (int j = 0; j < linha.length; j++) {
                ch = linha[j];

                if(Character.isDigit(ch)) total += Character.getNumericValue(ch);
                if (ch == 'V' || ch == 'W') {
                    total = Bifurcacao.Percorre(j, i, ler, total,0);
                    return total;
                }
                if (ch != ' ') System.out.println(ch);
            }
        }
        return 0;
    }


}
