// Nome: Marco Antonio Teodoro da Silva
// RA: a2888068

public class Endereco {

    private String rua;
    private int numero;
    private String cidade;

    // Default
    public Endereco() {
        this.rua = "";
        this.numero = 0;
        this.cidade = "";
    }

    public String getRua() {
        return this.rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return this.cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
