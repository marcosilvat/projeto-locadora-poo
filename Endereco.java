// Nome: Marco Antonio Teodoro da Silva
// RA: a2888068

// Classe Endereco utilizada na composicao com a classe Pessoa.
public class Endereco {

    private String rua;
    private int numero;
    private String cidade;

    // Construtor padrao (default)
    public Endereco() {
        this.rua = "";
        this.numero = 0;
        this.cidade = "";
    }

    // Construtor sobrecarregado
    public Endereco(String rua, int numero, String cidade) {
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
    }

    // Getters e Setters (encapsulamento dos atributos privados)
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

    // Retorna o endereco formatado para exibicao nos relatorios
    public String exibirEndereco() {
        return this.rua + ", n. " + this.numero + " - " + this.cidade;
    }
}
