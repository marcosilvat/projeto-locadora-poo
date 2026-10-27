// Nome: Marco Antonio Teodoro da Silva
// RA: a2888068

public abstract class Pessoa {

    private int codigo;
    private String nome;
    private String cpf;
    private String telefone;
    private Endereco endereco;

    // Default
    public Pessoa() {
        this.codigo = 0;
        this.nome = "";
        this.cpf = "";
        this.telefone = "";
        this.endereco = new Endereco();
    }

    // Sobrecarega
    public Pessoa(int codigo, String nome, String cpf, String telefone, Endereco endereco) {
        this.codigo = codigo;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public abstract String obterTipoPessoa();
    public String exibirResumo() {
        String endTexto = (this.endereco != null) ? this.endereco.exibirEndereco() : "Nao informado";
        return "[" + obterTipoPessoa() + " #" + this.codigo + "] Nome: " + this.nome
                + " | CPF: " + this.cpf
                + " | Tel: " + this.telefone
                + " | Endereco: " + endTexto;
    }
}
