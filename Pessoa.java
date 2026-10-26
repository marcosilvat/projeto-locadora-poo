// Nome: Marco Antonio Teodoro da Silva
// RA: a2888068

// Classe mãe abstrata: reúne os dados comuns de Cliente e Atendente.
// Nao pode ser instanciada diretamente, servindo de base para a heranca.
public abstract class Pessoa {

    private int codigo;
    private String nome;
    private String cpf;
    private String telefone;
    private Endereco endereco; // Composicao: toda Pessoa possui um Endereco

    // Construtor padrao
    public Pessoa() {
        this.codigo = 0;
        this.nome = "";
        this.cpf = "";
        this.telefone = "";
        this.endereco = new Endereco();
    }

    // Construtor sobrecarregado
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

    // Sem validacao de CPF conforme orientacao das instrucoes do projeto
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

    // Metodo abstrato que obriga as classes filhas (Cliente e Atendente) a informarem seu tipo
    public abstract String obterTipoPessoa();

    // Monta um resumo com os dados basicos da pessoa
    public String exibirResumo() {
        String endTexto = (this.endereco != null) ? this.endereco.exibirEndereco() : "Nao informado";
        return "[" + obterTipoPessoa() + " #" + this.codigo + "] Nome: " + this.nome
                + " | CPF: " + this.cpf
                + " | Tel: " + this.telefone
                + " | Endereco: " + endTexto;
    }
}
