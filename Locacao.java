// Nome: Marco Antonio Teodoro da Silva
// RA: a2888068

public class Locacao {

    private int codigoLocacao;
    private Cliente cliente;
    private Atendente atendente;
    private Jogo jogo;
    private int diasLocados;
    private int diasAtraso;

    // Default
    public Locacao() {
        this.codigoLocacao = 0;
        this.cliente = new Cliente();
        this.atendente = new Atendente();
        this.jogo = null;
        this.diasLocados = 1;
        this.diasAtraso = 0;
    }

    public int getCodigoLocacao() {
        return this.codigoLocacao;
    }

    public void setCodigoLocacao(int codigoLocacao) {
        this.codigoLocacao = codigoLocacao;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Atendente getAtendente() {
        return this.atendente;
    }

    public void setAtendente(Atendente atendente) {
        this.atendente = atendente;
    }

    public Jogo getJogo() {
        return this.jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    public int getDiasLocados() {
        return this.diasLocados;
    }

    public void setDiasLocados(int diasLocados) {
        this.diasLocados = diasLocados;
    }

    public int getDiasAtraso() {
        return this.diasAtraso;
    }

    public void setDiasAtraso(int diasAtraso) {
        this.diasAtraso = diasAtraso;
    }

    public double calcularValorMulta() {
        if (this.jogo == null || this.diasAtraso <= 0) {
            return 0.0;
        }
        return this.diasAtraso * this.getJogo().calcularMultaPorDia(); //Reflexividade
    }

    //Sobrecarga
    public double calcularValorTotal() {
        if (this.jogo == null) {
            return 0.0;
        }
        return this.getJogo().calcularValorBase(this.diasLocados) + this.calcularValorMulta(); //Reflexividade
    }

    //Sobrecarga
    public double calcularValorTotal(double percentualDesconto) {
        double totalBruto = this.calcularValorTotal();
        if (percentualDesconto <= 0.0) {
            return totalBruto;
        }
        return totalBruto - (totalBruto * (percentualDesconto / 100.0));
    }

    public double calcularComissaoAtendente() {
        if (this.atendente == null) {
            return 0.0;
        }
        return this.calcularValorTotal() * (this.getAtendente().getPercentualComissao() / 100.0); //Reflexividade
    }
}
