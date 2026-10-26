// Nome: Marco Antonio Teodoro da Silva
// RA: a2888068

// Classe filha Cliente que herda de Pessoa ("Cliente e um tipo de Pessoa").
public class Cliente extends Pessoa {

    // Atributos especificos do cliente na locadora
    private String email;
    private String categoriaFidelidade;
    private int limiteJogosSimultaneos;

    // Construtor padrao usando super() para inicializar a classe mae (reflexividade)
    public Cliente() {
        super();
        this.email = "";
        this.categoriaFidelidade = "Padrao";
        this.limiteJogosSimultaneos = 3;
    }

    // Construtor sobrecarregado repassando os dados gerais para a superclasse Pessoa
    public Cliente(int codigo, String nome, String cpf, String telefone, Endereco endereco,
            String email, String categoriaFidelidade, int limiteJogosSimultaneos) {
        super(codigo, nome, cpf, telefone, endereco);
        this.email = email;
        this.categoriaFidelidade = categoriaFidelidade;
        this.limiteJogosSimultaneos = limiteJogosSimultaneos;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCategoriaFidelidade() {
        return this.categoriaFidelidade;
    }

    public void setCategoriaFidelidade(String categoriaFidelidade) {
        this.categoriaFidelidade = categoriaFidelidade;
    }

    public int getLimiteJogosSimultaneos() {
        return this.limiteJogosSimultaneos;
    }

    public void setLimiteJogosSimultaneos(int limiteJogosSimultaneos) {
        this.limiteJogosSimultaneos = limiteJogosSimultaneos;
    }

    // Sobrescrita (polimorfismo) do metodo abstrato da classe mae
    @Override
    public String obterTipoPessoa() {
        return "Cliente";
    }

    // Reaproveita o exibirResumo() da classe mae via super e adiciona os dados do cliente
    @Override
    public String exibirResumo() {
        return super.exibirResumo()
                + " | E-mail: " + this.email
                + " | Fidelidade: " + this.categoriaFidelidade
                + " | Limite de Jogos: " + this.limiteJogosSimultaneos;
    }
}
