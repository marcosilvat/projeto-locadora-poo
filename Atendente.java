// Nome: Marco Antonio Teodoro da Silva
// RA: a2888068

public class Atendente extends Pessoa {

    private String matricula;
    private String turno;
    private double percentualComissao;

    public Atendente() {
        super();
        this.matricula = "";
        this.turno = "Comercial";
        this.percentualComissao = 5.0;
    }

    public Atendente(int codigo, String nome, String cpf, String telefone, Endereco endereco,
            String matricula, String turno, double percentualComissao) {
        super(codigo, nome, cpf, telefone, endereco);
        this.matricula = matricula;
        this.turno = turno;
        this.percentualComissao = percentualComissao;
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

    @Override
    public String obterTipoPessoa() {
        return "Atendente";
    }

    @Override
    public String exibirResumo() {
        return super.exibirResumo()
                + " | Matricula: " + this.matricula
                + " | Turno: " + this.turno
                + " | Comissao: " + String.format("%.1f%%", this.percentualComissao);
    }
}
