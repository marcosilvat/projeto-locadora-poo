// Nome: Marco Antonio Teodoro da Silva
// RA: a2888068


public class Principal {

    private static final int CAPACIDADE = 50;

    private static Cliente[] clientes = new Cliente[CAPACIDADE];
    private static int qtdClientes = 0;

    private static Atendente[] atendentes = new Atendente[CAPACIDADE];
    private static int qtdAtendentes = 0;

    private static Jogo[] jogos = new Jogo[CAPACIDADE];
    private static int qtdJogos = 0;

    private static Locacao[] locacoes = new Locacao[CAPACIDADE];
    private static int qtdLocacoes = 0;

    // Controla se a carga de dados de exemplo ja foi inserida nos vetores
    private static boolean dadosExemploPopulados = false;

    private static Leitura leitura = new Leitura();

    public static void main(String[] args) {
        int opcao = -1;
        do {
            System.out.println("\n=======================================================");
            System.out.println("   SISTEMA DE LOCADORA DE JOGOS ELETRONICOS (POO)      ");
            System.out.println("=======================================================");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Cadastrar Atendente");
            System.out.println("3 - Cadastrar Jogo Fisico (Midia Optica, Cartucho ou Colecionador)");
            System.out.println("4 - Registrar Locacao (Calcula Valor Total e Multa por Atraso)");
            System.out.println("5 - Listar Clientes Cadastrados");
            System.out.println("6 - Listar Atendentes Cadastrados");
            System.out.println("7 - Listar Jogos Cadastrados");
            System.out.println("8 - Listar Locacoes e Relatorio Financeiro");
            System.out.println("9 - Popular Dados de Exemplo e Testar Todas as Classes");
            System.out.println("0 - Sair");
            opcao = lerInteiro("Escolha uma opcao: ", 0);

            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    cadastrarAtendente();
                    break;
                case 3:
                    cadastrarJogo();
                    break;
                case 4:
                    registrarLocacao();
                    break;
                case 5:
                    listarClientes();
                    break;
                case 6:
                    listarAtendentes();
                    break;
                case 7:
                    listarJogos();
                    break;
                case 8:
                    listarLocacoes();
                    break;
                case 9:
                    popularDadosDeTeste();
                    break;
                case 0:
                    System.out.println("\nEncerrando o sistema da Locadora. Ate logo!");
                    break;
                default:
                    System.out.println("\nOpcao invalida! Escolha um numero de 0 a 9.");
                    break;
            }
        } while (opcao != 0);
    }

    private static String lerTextoObrigatorio(String rotulo) {
        while (true) {
            String entrada = leitura.entDados(rotulo).trim();
            if (!entrada.isEmpty()) {
                return entrada;
            }
            System.out.println("  [!] Atencao: este campo nao pode ficar em branco. Digite novamente.");
        }
    }

    private static int lerInteiro(String rotulo, int minimo) {
        while (true) {
            String entrada = leitura.entDados(rotulo).trim();
            if (entrada.isEmpty()) {
                System.out.println("  [!] Atencao: campo vazio! Digite um numero inteiro (minimo " + minimo + ").");
                continue;
            }
            try {
                int valor = Integer.parseInt(entrada);
                if (valor < minimo) {
                    System.out.println("  [!] O valor deve ser maior ou igual a " + minimo + ".");
                    continue;
                }
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("  [!] Valor invalido! Digite apenas numeros inteiros.");
            }
        }
    }

    private static double lerDouble(String rotulo, double minimo) {
        while (true) {
            String entrada = leitura.entDados(rotulo).trim().replace(',', '.');
            if (entrada.isEmpty()) {
                System.out.println("  [!] Atencao: campo vazio! Digite um valor numerico (minimo " + minimo + ").");
                continue;
            }
            try {
                double valor = Double.parseDouble(entrada);
                if (valor < minimo) {
                    System.out.println("  [!] O valor deve ser maior ou igual a " + minimo + ".");
                    continue;
                }
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("  [!] Valor invalido! Digite um numero valido (ex.: 15.50).");
            }
        }
    }

    private static boolean lerBooleano(String rotulo) {
        while (true) {
            String resp = leitura.entDados(rotulo).trim().toLowerCase();
            if (resp.equals("s") || resp.equals("sim") || resp.equals("1")) {
                return true;
            }
            if (resp.equals("n") || resp.equals("nao") || resp.equals("não") || resp.equals("0")) {
                return false;
            }
            System.out.println("  [!] Resposta invalida! Digite 's' para Sim ou 'n' para Nao.");
        }
    }

    private static Endereco lerEndereco() {
        Endereco end = new Endereco();
        end.setRua(lerTextoObrigatorio("  Rua: "));
        end.setNumero(lerInteiro("  Numero: ", 1));
        end.setCidade(lerTextoObrigatorio("  Cidade: "));
        return end;
    }

    private static void cadastrarCliente() {
        if (qtdClientes >= CAPACIDADE) {
            System.out.println("\nLimite do vetor de clientes atingido!");
            return;
        }
        System.out.println("\n--- CADASTRO DE CLIENTE ---");
        Cliente cli = new Cliente();
        cli.setCodigo(qtdClientes + 1);
        cli.setNome(lerTextoObrigatorio("Nome do cliente: "));
        cli.setCpf(lerTextoObrigatorio("CPF (sem validacao): "));
        cli.setTelefone(lerTextoObrigatorio("Telefone: "));
        cli.setEndereco(lerEndereco());
        cli.setEmail(lerTextoObrigatorio("E-mail: "));
        cli.setCategoriaFidelidade(lerTextoObrigatorio("Categoria Fidelidade (Bronze/Prata/Ouro): "));
        cli.setLimiteJogosSimultaneos(lerInteiro("Limite de jogos simultaneos: ", 1));

        clientes[qtdClientes] = cli;
        qtdClientes++;
        System.out.println("\nCliente cadastrado com sucesso:\n" + cli.exibirResumo());
    }

    private static void cadastrarAtendente() {
        if (qtdAtendentes >= CAPACIDADE) {
            System.out.println("\nLimite do vetor de atendentes atingido!");
            return;
        }
        System.out.println("\n--- CADASTRO DE ATENDENTE ---");
        Atendente atend = new Atendente();
        atend.setCodigo(qtdAtendentes + 1);
        atend.setNome(lerTextoObrigatorio("Nome do atendente: "));
        atend.setCpf(lerTextoObrigatorio("CPF (sem validacao): "));
        atend.setTelefone(lerTextoObrigatorio("Telefone: "));
        atend.setEndereco(lerEndereco());
        atend.setMatricula(lerTextoObrigatorio("Matricula funcional: "));
        atend.setTurno(lerTextoObrigatorio("Turno (Manha/Tarde/Noite): "));
        atend.setPercentualComissao(lerDouble("Percentual de comissao (%): ", 0.0));

        atendentes[qtdAtendentes] = atend;
        qtdAtendentes++;
        System.out.println("\nAtendente cadastrado com sucesso:\n" + atend.exibirResumo());
    }

    private static void cadastrarJogo() {
        if (qtdJogos >= CAPACIDADE) {
            System.out.println("\nLimite do vetor de jogos atingido!");
            return;
        }
        System.out.println("\n--- CADASTRO DE JOGO FISICO ---");
        System.out.println("Tipos de midia fisica disponiveis:");
        System.out.println("  1 - Jogo em Midia Optica (Blu-Ray / DVD)");
        System.out.println("  2 - Jogo em Cartucho Fisico (Switch / Retro)");
        System.out.println("  3 - Jogo Edicao de Colecionador (Box Fisico Especial)");

        int tipo = 0;
        while (tipo < 1 || tipo > 3) {
            tipo = lerInteiro("Escolha o tipo de jogo (1, 2 ou 3): ", 1);
            if (tipo < 1 || tipo > 3) {
                System.out.println("  [!] Escolha apenas 1, 2 ou 3.");
            }
        }

        int codigo = qtdJogos + 1;
        String titulo = lerTextoObrigatorio("Titulo do jogo: ");
        String genero = lerTextoObrigatorio("Genero (Acao/RPG/Esporte/Aventura): ");
        String plataforma = lerTextoObrigatorio("Plataforma (PS5/Xbox/Switch/SNES): ");
        double valorDiaria = lerDouble("Valor da diaria (R$): ", 0.01);

        Jogo novoJogo;
        if (tipo == 2) {
            String carcaca = lerTextoObrigatorio("Codigo da carcaca do cartucho: ");
            int capMb = lerInteiro("Capacidade do cartucho (MB): ", 1);
            boolean caixa = lerBooleano("Possui caixa protetora original? (s/n): ");
            novoJogo = new JogoCartucho(codigo, titulo, genero, plataforma, valorDiaria, carcaca, capMb, caixa);
        } else if (tipo == 3) {
            String serie = lerTextoObrigatorio("Numero de serie da Edicao de Colecionador: ");
            String brinde = lerTextoObrigatorio("Item/Brinde fisico incluso no box: ");
            double seguro = lerDouble("Valor do seguro da caixa fisica (R$): ", 0.0);
            novoJogo = new JogoEdicaoColecionador(codigo, titulo, genero, plataforma, valorDiaria, serie, brinde, seguro);
        } else {
            String tipoDisco = lerTextoObrigatorio("Tipo de disco optico (Blu-Ray/DVD): ");
            int qtdDiscos = lerInteiro("Quantidade de discos na embalagem: ", 1);
            boolean encarte = lerBooleano("Possui encarte fisico original? (s/n): ");
            novoJogo = new JogoMidiaOptica(codigo, titulo, genero, plataforma, valorDiaria, tipoDisco, qtdDiscos, encarte);
        }

        jogos[qtdJogos] = novoJogo;
        qtdJogos++;
        System.out.println("\nJogo cadastrado com sucesso:\n" + novoJogo.exibirResumo());
    }

    private static void registrarLocacao() {
        if (qtdLocacoes >= CAPACIDADE) {
            System.out.println("\nLimite do vetor de locacoes atingido!");
            return;
        }
        if (qtdClientes == 0 || qtdAtendentes == 0 || qtdJogos == 0) {
            System.out.println("\nAtencao: cadastre ao menos 1 Cliente, 1 Atendente e 1 Jogo antes de locar (ou use a opcao 9)!");
            return;
        }

        System.out.println("\n--- REGISTRAR NOVA LOCACAO ---");
        listarClientes();
        int idxCli = -1;
        while (idxCli < 0 || idxCli >= qtdClientes) {
            idxCli = lerInteiro("Informe o codigo do Cliente (1 a " + qtdClientes + "): ", 1) - 1;
            if (idxCli < 0 || idxCli >= qtdClientes) {
                System.out.println("  [!] Codigo de cliente inexistente! Escolha entre 1 e " + qtdClientes + ".");
            }
        }

        listarAtendentes();
        int idxAtend = -1;
        while (idxAtend < 0 || idxAtend >= qtdAtendentes) {
            idxAtend = lerInteiro("Informe o codigo do Atendente responsavel (1 a " + qtdAtendentes + "): ", 1) - 1;
            if (idxAtend < 0 || idxAtend >= qtdAtendentes) {
                System.out.println("  [!] Codigo de atendente inexistente! Escolha entre 1 e " + qtdAtendentes + ".");
            }
        }

        listarJogos();
        int idxJogo = -1;
        while (idxJogo < 0 || idxJogo >= qtdJogos) {
            idxJogo = lerInteiro("Informe o codigo do Jogo (1 a " + qtdJogos + "): ", 1) - 1;
            if (idxJogo < 0 || idxJogo >= qtdJogos) {
                System.out.println("  [!] Codigo de jogo inexistente! Escolha entre 1 e " + qtdJogos + ".");
            }
        }

        int diasLocados = lerInteiro("Quantidade de dias locados: ", 1);
        int diasAtraso = lerInteiro("Quantidade de dias de atraso na devolucao (0 se sem atraso): ", 0);

        Locacao loc = new Locacao(
                qtdLocacoes + 1,
                clientes[idxCli],
                atendentes[idxAtend],
                jogos[idxJogo],
                diasLocados,
                diasAtraso
        );

        locacoes[qtdLocacoes] = loc;
        qtdLocacoes++;

        System.out.println("\nLocacao registrada com sucesso!");
        System.out.println(loc.exibirResumo());
    }

    private static void listarClientes() {
        System.out.println("\n--- LISTA DE CLIENTES (" + qtdClientes + ") ---");
        if (qtdClientes == 0) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }
        for (int i = 0; i < qtdClientes; i++) {
            System.out.println(clientes[i].exibirResumo());
        }
    }

    private static void listarAtendentes() {
        System.out.println("\n--- LISTA DE ATENDENTES (" + qtdAtendentes + ") ---");
        if (qtdAtendentes == 0) {
            System.out.println("Nenhum atendente cadastrado.");
            return;
        }
        for (int i = 0; i < qtdAtendentes; i++) {
            System.out.println(atendentes[i].exibirResumo());
        }
    }

    private static void listarJogos() {
        System.out.println("\n--- LISTA DE JOGOS FISICOS (" + qtdJogos + ") ---");
        if (qtdJogos == 0) {
            System.out.println("Nenhum jogo cadastrado.");
            return;
        }
        for (int i = 0; i < qtdJogos; i++) {
            System.out.println(jogos[i].exibirResumo());
        }
    }

    private static void listarLocacoes() {
        System.out.println("\n--- LISTA DE LOCACOES (" + qtdLocacoes + ") ---");
        if (qtdLocacoes == 0) {
            System.out.println("Nenhuma locacao registrada.");
            return;
        }
        double faturamentoTotal = 0.0;
        double totalMultas = 0.0;
        for (int i = 0; i < qtdLocacoes; i++) {
            System.out.println(locacoes[i].exibirResumo());
            faturamentoTotal += locacoes[i].calcularValorTotal();
            totalMultas += locacoes[i].calcularValorMulta();
        }
        System.out.println("-------------------------------------------------------");
        System.out.println("Total arrecadado em multas: R$ " + String.format("%.2f", totalMultas));
        System.out.println("Faturamento bruto total das locacoes: R$ " + String.format("%.2f", faturamentoTotal));
    }


    private static void popularDadosDeTeste() {
        if (!dadosExemploPopulados) {
            if (qtdClientes + 2 <= CAPACIDADE && qtdAtendentes + 2 <= CAPACIDADE
                    && qtdJogos + 3 <= CAPACIDADE && qtdLocacoes + 3 <= CAPACIDADE) {

                Endereco end1 = new Endereco("Av. Brasil", 1500, "Cornelio Procopio");
                Endereco end2 = new Endereco("Rua Parana", 420, "Londrina");
                Endereco end3 = new Endereco("Av. Sete de Setembro", 3165, "Curitiba");

                Cliente c1 = new Cliente(qtdClientes + 1, "Carlos Eduardo Souza", "11122233344", "(43) 99911-1001", end1,
                        "carlos@email.com", "Ouro", 5);
                clientes[qtdClientes++] = c1;

                Cliente c2 = new Cliente(qtdClientes + 1, "Mariana Alves", "55566677788", "(43) 99922-2002", end2,
                        "mariana@email.com", "Prata", 3);
                clientes[qtdClientes++] = c2;

                Atendente a1 = new Atendente(qtdAtendentes + 1, "Roberto Ferreira", "99988877766", "(43) 98800-3003", end3,
                        "AT-101", "Manha", 6.0);
                atendentes[qtdAtendentes++] = a1;

                Atendente a2 = new Atendente(qtdAtendentes + 1, "Fernanda Lima", "44433322211", "(43) 98811-4004", end1,
                        "AT-102", "Noite", 7.5);
                atendentes[qtdAtendentes++] = a2;

                Jogo j1 = new JogoMidiaOptica(qtdJogos + 1, "God of War Ragnarok", "Acao", "PS5", 14.00,
                        "Blu-Ray Ultra HD", 1, true);
                jogos[qtdJogos++] = j1;

                Jogo j2 = new JogoCartucho(qtdJogos + 1, "Zelda: Breath of the Wild", "Aventura", "Nintendo Switch", 16.00,
                        "HAC-008-BR", 16384, true);
                jogos[qtdJogos++] = j2;

                Jogo j3 = new JogoEdicaoColecionador(qtdJogos + 1, "Elden Ring Collector Box", "RPG", "PS5", 22.00,
                        "ER-COL-0089", "Estatua Malenia 23cm + Artbook Fisico", 180.00);
                jogos[qtdJogos++] = j3;

                Locacao l1 = new Locacao(qtdLocacoes + 1, c1, a1, j1, 3, 2);
                locacoes[qtdLocacoes++] = l1;

                Locacao l2 = new Locacao(qtdLocacoes + 1, c2, a2, j2, 4, 1);
                locacoes[qtdLocacoes++] = l2;

                Locacao l3 = new Locacao(qtdLocacoes + 1, c1, a2, j3, 2, 3);
                locacoes[qtdLocacoes++] = l3;

                dadosExemploPopulados = true;
                System.out.println("\nDados de exemplo adicionados e todas as classes testadas com sucesso!");
            } else {
                System.out.println("\nCapacidade maxima dos vetores atingida para inserir novos exemplos.");
            }
        } else {
            System.out.println("\nOs dados de exemplo ja foram adicionados! Exibindo relatorio completo de todas as classes:");
        }

        listarClientes();
        listarAtendentes();
        listarJogos();
        listarLocacoes();
    }
}
