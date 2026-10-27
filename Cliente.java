// Nome: Marco Antonio Teodoro da Silva
// RA: a2888068

public class Cliente extends Pessoa {

    private String email;
    private String categoriaFidelidade;
    private int limiteJogosSimultaneos;

    // Construtor usando reflexividade
    public Cliente() {
        super();
        this.email = "";
        this.categoriaFidelidade = "Padrao";
        this.limiteJogosSimultaneos = 3;
    }

    // Sobrecarga
    public Cliente(int codigo, String nome, String cpf, String telefone, Endereco endereco,
            String email, String categoriaFidelidade, int limiteJogosSimultaneos) {
        super();
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

    // Sobrescrita
    @Override
    public String obterTipoPessoa() {
        return "Cliente";
    }

    @Override
    public String exibirResumo() {
        return super.exibirResumo()
                + " | E-mail: " + this.email
                + " | Fidelidade: " + this.categoriaFidelidade
                + " | Limite de Jogos: " + this.limiteJogosSimultaneos;
    }
}
