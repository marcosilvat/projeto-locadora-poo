// Nome: Marco Antonio Teodoro da Silva
// RA: a2888068

public class JogoCartucho extends Jogo {

    private String codigoCarcaca;
    private int capacidadeMb;
    private boolean possuiCaixaProtetora;

    public JogoCartucho() {
        super();
        this.codigoCarcaca = "";
        this.capacidadeMb = 0;
        this.possuiCaixaProtetora = true;
    }

    public JogoCartucho(int codigo, String titulo, String genero, String plataforma, double valorDiaria,
            String codigoCarcaca, int capacidadeMb, boolean possuiCaixaProtetora) {
        super(codigo, titulo, genero, plataforma, valorDiaria);
        this.codigoCarcaca = codigoCarcaca;
        this.capacidadeMb = capacidadeMb;
        this.possuiCaixaProtetora = possuiCaixaProtetora;
    }

    public String getCodigoCarcaca() {
        return this.codigoCarcaca;
    }

    public void setCodigoCarcaca(String codigoCarcaca) {
        this.codigoCarcaca = codigoCarcaca;
    }

    public int getCapacidadeMb() {
        return this.capacidadeMb;
    }

    public void setCapacidadeMb(int capacidadeMb) {
        this.capacidadeMb = capacidadeMb;
    }

    public boolean isPossuiCaixaProtetora() {
        return this.possuiCaixaProtetora;
    }

    public void setPossuiCaixaProtetora(boolean possuiCaixaProtetora) {
        this.possuiCaixaProtetora = possuiCaixaProtetora;
    }

    @Override
    public double calcularMultaPorDia() {
        double adicionalCaixa = this.possuiCaixaProtetora ? 2.50 : 1.00;
        return (this.getValorDiaria() * 0.75) + adicionalCaixa;
    }

    @Override
    public String obterTipoMidia() {
        return "Cartucho Fisico";
    }

    @Override
    public String exibirResumo() {
        return super.exibirResumo()
                + " | Carcaca: " + this.codigoCarcaca
                + " | Capacidade: " + this.capacidadeMb + " MB"
                + " | Caixa Protetora: " + (this.possuiCaixaProtetora ? "Sim" : "Nao");
    }
}
