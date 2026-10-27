// Nome: Marco Antonio Teodoro da Silva
// RA: a2888068

public class JogoMidiaOptica extends Jogo {

    private String tipoDisco;
    private int quantidadeDiscos;
    private boolean possuiEncarteOriginal;

    // Default
    public JogoMidiaOptica() {
        super();
        this.tipoDisco = "Blu-Ray";
        this.quantidadeDiscos = 1;
        this.possuiEncarteOriginal = true;
    }

    public String getTipoDisco() {
        return this.tipoDisco;
    }

    public void setTipoDisco(String tipoDisco) {
        this.tipoDisco = tipoDisco;
    }

    public int getQuantidadeDiscos() {
        return this.quantidadeDiscos;
    }

    public void setQuantidadeDiscos(int quantidadeDiscos) {
        this.quantidadeDiscos = quantidadeDiscos;
    }

    public boolean isPossuiEncarteOriginal() {
        return this.possuiEncarteOriginal;
    }

    public void setPossuiEncarteOriginal(boolean possuiEncarteOriginal) {
        this.possuiEncarteOriginal = possuiEncarteOriginal;
    }

    // Sobrescrita
    @Override
    public double calcularMultaPorDia() {
        return (this.getValorDiaria() * 0.50) + (this.quantidadeDiscos * 1.50);
    }

    // Sobrescrita
    @Override
    public String obterTipoMidia() {
        return "Midia Optica";
    }
}
