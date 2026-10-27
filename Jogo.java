// Nome: Marco Antonio Teodoro da Silva
// RA: a2888068

public abstract class Jogo implements Calculavel {

    private int codigo;
    private String titulo;
    private String genero;
    private String plataforma;
    private double valorDiaria;

    // Default
    public Jogo() {
        this.codigo = 0;
        this.titulo = "";
        this.genero = "";
        this.plataforma = "";
        this.valorDiaria = 0.0;
    }

    // Sobrecarga
    public Jogo(int codigo, String titulo, String genero, String plataforma, double valorDiaria) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.genero = genero;
        this.plataforma = plataforma;
        this.valorDiaria = valorDiaria;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return this.genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPlataforma() {
        return this.plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public double getValorDiaria() {
        return this.valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    @Override
    public double calcularValorBase(int dias) {
        if (dias <= 0) {
            return 0.0;
        }
        return this.valorDiaria * dias;
    }

    @Override
    public abstract double calcularMultaPorDia();
    public abstract String obterTipoMidia();
    public String exibirResumo() {
        return "[Jogo #" + this.codigo + " - " + obterTipoMidia() + "] Titulo: " + this.titulo
                + " | Genero: " + this.genero
                + " | Plataforma: " + this.plataforma
                + " | Diaria: R$ " + String.format("%.2f", this.valorDiaria)
                + " | Multa/Dia Atraso: R$ " + String.format("%.2f", calcularMultaPorDia());
    }
}
