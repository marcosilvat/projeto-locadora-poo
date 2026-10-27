// Nome: Marco Antonio Teodoro da Silva
// RA: a2888068

public class Cliente extends Pessoa {

    private String email;
    private String categoriaFidelidade;
    private int limiteJogosSimultaneos;

    // Default
    public Cliente() {
        super();
        this.email = "";
        this.categoriaFidelidade = "Padrao";
        this.limiteJogosSimultaneos = 3;
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
}
