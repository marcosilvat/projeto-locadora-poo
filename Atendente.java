// Nome: Marco Antonio Teodoro da Silva
// RA: a2888068

public class Atendente extends Pessoa {

    private String matricula;
    private String turno;
    private double percentualComissao;

    // Default
    public Atendente() {
        super();
        this.matricula = "";
        this.turno = "Comercial";
        this.percentualComissao = 5.0;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getTurno() {
        return this.turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public double getPercentualComissao() {
        return this.percentualComissao;
    }

    public void setPercentualComissao(double percentualComissao) {
        this.percentualComissao = percentualComissao;
    }

    // Sobrescrita
    @Override
    public String obterTipoPessoa() {
        return "Atendente";
    }
}
