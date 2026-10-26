// Nome: Marco Antonio Teodoro da Silva
// RA: a2888068

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Classe separada apenas para leitura de dados do teclado,
// mantendo a coesao alta conforme visto em aula.
public class Leitura {

    public String entDados(String rotulo) {
        System.out.print(rotulo);
        InputStreamReader teclado = new InputStreamReader(System.in);
        BufferedReader buff = new BufferedReader(teclado);
        String ret = "";
        try {
            ret = buff.readLine();
        } catch (IOException ioe) {
            System.out.println("\nErro na entrada de dados pelo teclado: " + ioe.getMessage());
        }
        return ret != null ? ret : "";
    }
}
