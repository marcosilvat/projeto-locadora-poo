// Nome: Marco Antonio Teodoro da Silva
// RA: a2888068

// Classe filha Atendente que herda de Pessoa ("Atendente e um tipo de Pessoa").
// Representa o funcionario responsavel por registrar cada locacao na loja.
public class Atendente extends Pessoa {

    // Atributos especificos do atendente
    private String matricula;
    private String turno;
    private double percentualComissao;

    // Construtor padrao
    public Atendente() {
        super();
        this.matricula = "";
        this.turno = "Comercial";
        this.percentualComissao = 5.0;
    }

    // Construtor sobrecarregado usando super(...)
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
