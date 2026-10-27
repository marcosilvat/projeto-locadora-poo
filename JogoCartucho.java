// Nome: Marco Antonio Teodoro da Silva
// RA: a2888068

public class JogoCartucho extends Jogo {

    private String codigoCarcaca;
    private int capacidadeMb;
    private boolean possuiCaixaProtetora;

    // Default
    public JogoCartucho() {
        super();
        this.codigoCarcaca = "";
        this.capacidadeMb = 0;
        this.possuiCaixaProtetora = true;
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

    // Sobrescrita
    @Override
    public double calcularMultaPorDia() {
        double adicionalCaixa = this.possuiCaixaProtetora ? 2.50 : 1.00;
        return (this.getValorDiaria() * 0.75) + adicionalCaixa;
    }

    // Sobrescrita
    @Override
    public String obterTipoMidia() {
        return "Cartucho Fisico";
    }
}
