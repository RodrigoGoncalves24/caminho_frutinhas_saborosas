import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

public class LerAquivoTexto {
    public List<char[]> arv = new ArrayList<>();

    public void LerAquivo() {

        String currDir = Paths.get("Casos").toAbsolutePath().toString();
        String nameComplete = currDir + "\\" + "casoa30.txt";
        Path path = Paths.get(nameComplete);

        String linha;

        // Usa a classe scanner para fazer a leitura do arquivo
        try (Scanner sc = new Scanner(Files.newBufferedReader(path, StandardCharsets.UTF_8))) {
            while (sc.hasNextLine()) {
                linha = sc.nextLine();
                char[] charLinha = linha.toCharArray();
                arv.add(charLinha);
            }


        } catch (IOException x) {
            System.err.format("Erro de E/S: %s%n", x);
        }


    }
}
