// Nome: Marco Antonio Teodoro da Silva
// RA: a2888068

public class JogoEdicaoColecionador extends Jogo {

    private String numeroSerieEdicao;
    private String brindeFisicoIncluso;
    private double valorSeguroCaixa;

    // Default
    public JogoEdicaoColecionador() {
        super();
        this.numeroSerieEdicao = "";
        this.brindeFisicoIncluso = "";
        this.valorSeguroCaixa = 0.0;
    }

    public String getNumeroSerieEdicao() {
        return this.numeroSerieEdicao;
    }

    public void setNumeroSerieEdicao(String numeroSerieEdicao) {
        this.numeroSerieEdicao = numeroSerieEdicao;
    }

    public String getBrindeFisicoIncluso() {
        return this.brindeFisicoIncluso;
    }

    public void setBrindeFisicoIncluso(String brindeFisicoIncluso) {
        this.brindeFisicoIncluso = brindeFisicoIncluso;
    }

    public double getValorSeguroCaixa() {
        return this.valorSeguroCaixa;
    }

    public void setValorSeguroCaixa(double valorSeguroCaixa) {
        this.valorSeguroCaixa = valorSeguroCaixa;
    }

    // Sobrescrita
    @Override
    public double calcularMultaPorDia() {
        return (this.getValorDiaria() * 1.20) + (this.valorSeguroCaixa * 0.05);
    }

    // Sobrescrita
    @Override
    public String obterTipoMidia() {
        return "Edicao de Colecionador";
    }
}
