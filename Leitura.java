// Nome: Marco Antonio Teodoro da Silva
// RA: a2888068

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Leitura {

    public String entDados(String rotulo) {
        System.out.print(rotulo);
        InputStreamReader teclado = new InputStreamReader(System.in);
        BufferedReader buff = new BufferedReader(teclado);
        String ret = "";
        try {
            ret = buff.readLine();
        } catch (IOException ioe) {
            System.out.println("\nErro de entrada de dados: " + ioe.getMessage());
        }
        return ret != null ? ret : "";
    }
}
