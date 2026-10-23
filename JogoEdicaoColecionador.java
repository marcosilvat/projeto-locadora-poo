// Nome: Marco Antonio Teodoro da Silva
// RA: a2888068

public class JogoEdicaoColecionador extends Jogo {

    private String numeroSerieEdicao;
    private String brindeFisicoIncluso;
    private double valorSeguroCaixa;

    public JogoEdicaoColecionador() {
        super();
        this.numeroSerieEdicao = "";
        this.brindeFisicoIncluso = "";
        this.valorSeguroCaixa = 0.0;
    }

    public JogoEdicaoColecionador(int codigo, String titulo, String genero, String plataforma, double valorDiaria,
            String numeroSerieEdicao, String brindeFisicoIncluso, double valorSeguroCaixa) {
        super(codigo, titulo, genero, plataforma, valorDiaria);
        this.numeroSerieEdicao = numeroSerieEdicao;
        this.brindeFisicoIncluso = brindeFisicoIncluso;
        this.valorSeguroCaixa = valorSeguroCaixa;
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

    @Override
    public double calcularMultaPorDia() {
        return (this.getValorDiaria() * 1.20) + (this.valorSeguroCaixa * 0.05);
    }

    @Override
    public String obterTipoMidia() {
        return "Edicao de Colecionador";
    }

    @Override
    public String exibirResumo() {
        return super.exibirResumo()
                + " | Serie: " + this.numeroSerieEdicao
                + " | Brinde Fisico: " + this.brindeFisicoIncluso
                + " | Seguro: R$ " + String.format("%.2f", this.valorSeguroCaixa);
    }
}
