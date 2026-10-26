// Nome: Marco Antonio Teodoro da Silva
// RA: a2888068

// Interface que define os metodos obrigatorios para calculo de valores dos jogos.
public interface Calculavel {

    // Calcula o valor da multa por cada dia de atraso (varia conforme o tipo de jogo)
    public double calcularMultaPorDia();

    // Calcula o valor das diarias normais da locacao
    public double calcularValorBase(int dias);
}
