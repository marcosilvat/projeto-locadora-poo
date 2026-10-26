// Nome: Marco Antonio Teodoro da Silva
// RA: a2888068

// Classe filha que representa um jogo em disco fisico (Blu-Ray ou DVD).
// Herda de Jogo ("JogoMidiaOptica e um tipo de Jogo").
public class JogoMidiaOptica extends Jogo {

    // Atributos proprios da midia optica
    private String tipoDisco;
    private int quantidadeDiscos;
    private boolean possuiEncarteOriginal;

    public JogoMidiaOptica() {
        super();
        this.tipoDisco = "Blu-Ray";
        this.quantidadeDiscos = 1;
        this.possuiEncarteOriginal = true;
    }

    public JogoMidiaOptica(int codigo, String titulo, String genero, String plataforma, double valorDiaria,
            String tipoDisco, int quantidadeDiscos, boolean possuiEncarteOriginal) {
        super(codigo, titulo, genero, plataforma, valorDiaria);
        this.tipoDisco = tipoDisco;
        this.quantidadeDiscos = quantidadeDiscos;
        this.possuiEncarteOriginal = possuiEncarteOriginal;
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

    // Na midia optica, a multa por dia de atraso equivale a 50% da diaria + R$ 1,50 por disco da caixa
    @Override
    public double calcularMultaPorDia() {
        return (this.getValorDiaria() * 0.50) + (this.quantidadeDiscos * 1.50);
    }

    @Override
    public String obterTipoMidia() {
        return "Midia Optica";
    }

    @Override
    public String exibirResumo() {
        return super.exibirResumo()
                + " | Disco: " + this.tipoDisco
                + " (" + this.quantidadeDiscos + " un.)"
                + " | Encarte Original: " + (this.possuiEncarteOriginal ? "Sim" : "Nao");
    }
}
