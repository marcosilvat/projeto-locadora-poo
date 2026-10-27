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
            opcao = lerInteiro("Escolha uma opcao (0 a 9): ");

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

    private static String lerTexto(String rotulo) {
        while (true) {
            String entrada = leitura.entDados(rotulo).trim();
            if (!entrada.isEmpty()) {
                return entrada;
            }
            System.out.println("  [!] Campo vazio! Informe um valor para continuar.");
        }
    }

    private static int lerInteiro(String rotulo) {
        while (true) {
            String entrada = leitura.entDados(rotulo).trim();
            if (entrada.isEmpty()) {
                System.out.println("  [!] Campo vazio! Digite um numero inteiro.");
                continue;
            }
            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("  [!] Formato invalido! Digite apenas numeros inteiros.");
            }
        }
    }

    private static double lerDouble(String rotulo) {
        while (true) {
            String entrada = leitura.entDados(rotulo).trim().replace(',', '.');
            if (entrada.isEmpty()) {
                System.out.println("  [!] Campo vazio! Digite um valor numerico.");
                continue;
            }
            try {
                return Double.parseDouble(entrada);
            } catch (NumberFormatException e) {
                System.out.println("  [!] Formato invalido! Digite um numero valido (ex.: 15.50).");
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

    private static void cadastrarCliente() {
        if (qtdClientes >= CAPACIDADE) {
            System.out.println("\nLimite do vetor de clientes atingido!");
            return;
        }
        System.out.println("\n--- CADASTRO DE CLIENTE ---");
        Cliente cli = new Cliente();
        cli.setCodigo(qtdClientes + 1);
        cli.setNome(lerTexto("Nome do cliente: "));
        cli.setCpf(lerTexto("CPF: "));
        cli.setTelefone(lerTexto("Telefone (ex.: 43 99999-0000): "));
        cli.getEndereco().setRua(lerTexto("  Rua: ")); //Reflexividade
        cli.getEndereco().setNumero(lerInteiro("  Numero da residencia (inteiro, ex.: 150): ")); //Reflexividade
        cli.getEndereco().setCidade(lerTexto("  Cidade: ")); //Reflexividade
        cli.setEmail(lerTexto("E-mail (ex.: nome@email.com): "));
        cli.setCategoriaFidelidade(lerTexto("Categoria Fidelidade (Bronze/Prata/Ouro): "));
        cli.setLimiteJogosSimultaneos(lerInteiro("Limite de jogos simultaneos (inteiro, ex.: 3): "));

        clientes[qtdClientes] = cli;
        qtdClientes++;
        System.out.println("\nCliente cadastrado com sucesso!");
        imprimirCliente(cli);
    }

    private static void cadastrarAtendente() {
        if (qtdAtendentes >= CAPACIDADE) {
            System.out.println("\nLimite do vetor de atendentes atingido!");
            return;
        }
        System.out.println("\n--- CADASTRO DE ATENDENTE ---");
        Atendente atend = new Atendente();
        atend.setCodigo(qtdAtendentes + 1);
        atend.setNome(lerTexto("Nome do atendente: "));
        atend.setCpf(lerTexto("CPF: "));
        atend.setTelefone(lerTexto("Telefone (ex.: 43 98888-0000): "));
        atend.getEndereco().setRua(lerTexto("  Rua: ")); //Reflexividade
        atend.getEndereco().setNumero(lerInteiro("  Numero da residencia (inteiro, ex.: 200): ")); //Reflexividade
        atend.getEndereco().setCidade(lerTexto("  Cidade: ")); //Reflexividade
        atend.setMatricula(lerTexto("Matricula funcional (ex.: AT-101): "));
        atend.setTurno(lerTexto("Turno (Manha/Tarde/Noite): "));
        atend.setPercentualComissao(lerDouble("Percentual de comissao em % (ex.: 5.0): "));

        atendentes[qtdAtendentes] = atend;
        qtdAtendentes++;
        System.out.println("\nAtendente cadastrado com sucesso!");
        imprimirAtendente(atend);
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
            tipo = lerInteiro("Escolha o tipo de jogo (1, 2 ou 3): ");
            if (tipo < 1 || tipo > 3) {
                System.out.println("  [!] Escolha apenas 1, 2 ou 3.");
            }
        }

        int codigo = qtdJogos + 1;
        String titulo = lerTexto("Titulo do jogo: ");
        String genero = lerTexto("Genero (Acao/RPG/Esporte/Aventura): ");
        String plataforma = lerTexto("Plataforma (PS5/Xbox/Switch/SNES): ");
        double valorDiaria = lerDouble("Valor da diaria em R$ (ex.: 15.00): ");

        Jogo novoJogo;
        if (tipo == 2) {
            JogoCartucho cart = new JogoCartucho();
            cart.setCodigo(codigo);
            cart.setTitulo(titulo);
            cart.setGenero(genero);
            cart.setPlataforma(plataforma);
            cart.setValorDiaria(valorDiaria);
            cart.setCodigoCarcaca(lerTexto("Codigo da carcaca do cartucho (ex.: HAC-008): "));
            cart.setCapacidadeMb(lerInteiro("Capacidade do cartucho em MB (inteiro, ex.: 16384): "));
            cart.setPossuiCaixaProtetora(lerBooleano("Possui caixa protetora original? (s/n): "));
            novoJogo = cart;
        } else if (tipo == 3) {
            JogoEdicaoColecionador col = new JogoEdicaoColecionador();
            col.setCodigo(codigo);
            col.setTitulo(titulo);
            col.setGenero(genero);
            col.setPlataforma(plataforma);
            col.setValorDiaria(valorDiaria);
            col.setNumeroSerieEdicao(lerTexto("Numero de serie da Edicao de Colecionador (ex.: COL-001): "));
            col.setBrindeFisicoIncluso(lerTexto("Item/Brinde fisico incluso no box: "));
            col.setValorSeguroCaixa(lerDouble("Valor do seguro da caixa fisica em R$ (ex.: 150.00): "));
            novoJogo = col;
        } else {
            JogoMidiaOptica opt = new JogoMidiaOptica();
            opt.setCodigo(codigo);
            opt.setTitulo(titulo);
            opt.setGenero(genero);
            opt.setPlataforma(plataforma);
            opt.setValorDiaria(valorDiaria);
            opt.setTipoDisco(lerTexto("Tipo de disco optico (Blu-Ray/DVD): "));
            opt.setQuantidadeDiscos(lerInteiro("Quantidade de discos na embalagem (inteiro, ex.: 1): "));
            opt.setPossuiEncarteOriginal(lerBooleano("Possui encarte fisico original? (s/n): "));
            novoJogo = opt;
        }

        jogos[qtdJogos] = novoJogo;
        qtdJogos++;
        System.out.println("\nJogo cadastrado com sucesso!");
        imprimirJogo(novoJogo);
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
            idxCli = lerInteiro("Informe o codigo do Cliente (1 a " + qtdClientes + "): ") - 1;
            if (idxCli < 0 || idxCli >= qtdClientes) {
                System.out.println("  [!] Codigo de cliente inexistente! Escolha entre 1 e " + qtdClientes + ".");
            }
        }

        listarAtendentes();
        int idxAtend = -1;
        while (idxAtend < 0 || idxAtend >= qtdAtendentes) {
            idxAtend = lerInteiro("Informe o codigo do Atendente responsavel (1 a " + qtdAtendentes + "): ") - 1;
            if (idxAtend < 0 || idxAtend >= qtdAtendentes) {
                System.out.println("  [!] Codigo de atendente inexistente! Escolha entre 1 e " + qtdAtendentes + ".");
            }
        }

        listarJogos();
        int idxJogo = -1;
        while (idxJogo < 0 || idxJogo >= qtdJogos) {
            idxJogo = lerInteiro("Informe o codigo do Jogo (1 a " + qtdJogos + "): ") - 1;
            if (idxJogo < 0 || idxJogo >= qtdJogos) {
                System.out.println("  [!] Codigo de jogo inexistente! Escolha entre 1 e " + qtdJogos + ".");
            }
        }

        int diasLocados = lerInteiro("Quantidade de dias locados (inteiro, ex.: 3): ");
        int diasAtraso = lerInteiro("Quantidade de dias de atraso na devolucao (0 se sem atraso): ");

        Locacao loc = new Locacao();
        loc.setCodigoLocacao(qtdLocacoes + 1);
        loc.setCliente(clientes[idxCli]);
        loc.setAtendente(atendentes[idxAtend]);
        loc.setJogo(jogos[idxJogo]);
        loc.setDiasLocados(diasLocados);
        loc.setDiasAtraso(diasAtraso);

        locacoes[qtdLocacoes] = loc;
        qtdLocacoes++;

        System.out.println("\nLocacao registrada com sucesso!");
        imprimirLocacao(loc);
    }

    // Impressao feita na classe de controle via getters
    private static void imprimirCliente(Cliente c) {
        System.out.println("[" + c.obterTipoPessoa() + " #" + c.getCodigo() + "] Nome: " + c.getNome()
                + " | CPF: " + c.getCpf() + " | Telefone: " + c.getTelefone());
        System.out.println("  Rua: " + c.getEndereco().getRua()); //Reflexividade
        System.out.println("  Numero: " + c.getEndereco().getNumero()); //Reflexividade
        System.out.println("  Cidade: " + c.getEndereco().getCidade()); //Reflexividade
        System.out.println("  E-mail: " + c.getEmail()
                + " | Fidelidade: " + c.getCategoriaFidelidade()
                + " | Limite de Jogos: " + c.getLimiteJogosSimultaneos());
    }

    private static void imprimirAtendente(Atendente a) {
        System.out.println("[" + a.obterTipoPessoa() + " #" + a.getCodigo() + "] Nome: " + a.getNome()
                + " | CPF: " + a.getCpf() + " | Telefone: " + a.getTelefone());
        System.out.println("  Rua: " + a.getEndereco().getRua()); //Reflexividade
        System.out.println("  Numero: " + a.getEndereco().getNumero()); //Reflexividade
        System.out.println("  Cidade: " + a.getEndereco().getCidade()); //Reflexividade
        System.out.println("  Matricula: " + a.getMatricula()
                + " | Turno: " + a.getTurno()
                + " | Comissao: " + String.format("%.1f%%", a.getPercentualComissao()));
    }

    private static void imprimirJogo(Jogo j) {
        System.out.println("[Jogo #" + j.getCodigo() + " - " + j.obterTipoMidia() + "] Titulo: " + j.getTitulo()
                + " | Genero: " + j.getGenero()
                + " | Plataforma: " + j.getPlataforma()
                + " | Diaria: R$ " + String.format("%.2f", j.getValorDiaria())
                + " | Multa/Dia Atraso: R$ " + String.format("%.2f", j.calcularMultaPorDia()));

        if (j instanceof JogoMidiaOptica) {
            JogoMidiaOptica opt = (JogoMidiaOptica) j;
            System.out.println("  Tipo de Disco: " + opt.getTipoDisco()
                    + " | Quantidade de Discos: " + opt.getQuantidadeDiscos()
                    + " | Encarte Original: " + (opt.isPossuiEncarteOriginal() ? "Sim" : "Nao"));
        } else if (j instanceof JogoCartucho) {
            JogoCartucho cart = (JogoCartucho) j;
            System.out.println("  Codigo Carcaca: " + cart.getCodigoCarcaca()
                    + " | Capacidade: " + cart.getCapacidadeMb() + " MB"
                    + " | Caixa Protetora: " + (cart.isPossuiCaixaProtetora() ? "Sim" : "Nao"));
        } else if (j instanceof JogoEdicaoColecionador) {
            JogoEdicaoColecionador col = (JogoEdicaoColecionador) j;
            System.out.println("  Serie Edicao: " + col.getNumeroSerieEdicao()
                    + " | Brinde Fisico: " + col.getBrindeFisicoIncluso()
                    + " | Seguro Caixa: R$ " + String.format("%.2f", col.getValorSeguroCaixa()));
        }
    }

    private static void imprimirLocacao(Locacao loc) {
        System.out.println("[Locacao #" + loc.getCodigoLocacao() + "]");
        System.out.println("  Cliente: " + loc.getCliente().getNome() + " (CPF: " + loc.getCliente().getCpf() + ")"); //Reflexividade
        System.out.println("  Cidade do Cliente: " + loc.getCliente().getEndereco().getCidade()); //Reflexividade
        System.out.println("  Atendente Responsavel: " + loc.getAtendente().getNome() + " (Mat.: " + loc.getAtendente().getMatricula() + ")"); //Reflexividade
        System.out.println("  Jogo Alugado: " + loc.getJogo().getTitulo() + " [" + loc.getJogo().obterTipoMidia() + "]"); //Reflexividade
        double valorDiarias = loc.getJogo().calcularValorBase(loc.getDiasLocados()); //Reflexividade
        System.out.println("  Dias Locados: " + loc.getDiasLocados()
                + " | Dias de Atraso: " + loc.getDiasAtraso());
        System.out.println("  Valor Diarias: R$ " + String.format("%.2f", valorDiarias)
                + " | Multa por Atraso: R$ " + String.format("%.2f", loc.calcularValorMulta())
                + " | VALOR TOTAL: R$ " + String.format("%.2f", loc.calcularValorTotal())
                + " | Comissao Atendente: R$ " + String.format("%.2f", loc.calcularComissaoAtendente()));
    }

    private static void listarClientes() {
        System.out.println("\n--- LISTA DE CLIENTES (" + qtdClientes + ") ---");
        if (qtdClientes == 0) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }
        for (int i = 0; i < qtdClientes; i++) {
            imprimirCliente(clientes[i]);
        }
    }

    private static void listarAtendentes() {
        System.out.println("\n--- LISTA DE ATENDENTES (" + qtdAtendentes + ") ---");
        if (qtdAtendentes == 0) {
            System.out.println("Nenhum atendente cadastrado.");
            return;
        }
        for (int i = 0; i < qtdAtendentes; i++) {
            imprimirAtendente(atendentes[i]);
        }
    }

    private static void listarJogos() {
        System.out.println("\n--- LISTA DE JOGOS FISICOS (" + qtdJogos + ") ---");
        if (qtdJogos == 0) {
            System.out.println("Nenhum jogo cadastrado.");
            return;
        }
        for (int i = 0; i < qtdJogos; i++) {
            imprimirJogo(jogos[i]);
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
            imprimirLocacao(locacoes[i]);
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

                Cliente c1 = new Cliente();
                c1.setCodigo(qtdClientes + 1);
                c1.setNome("Carlos Eduardo Souza");
                c1.setCpf("11122233344");
                c1.setTelefone("(43) 99911-1001");
                c1.getEndereco().setRua("Av. Brasil"); //Reflexividade
                c1.getEndereco().setNumero(1500); //Reflexividade
                c1.getEndereco().setCidade("Cornelio Procopio"); //Reflexividade
                c1.setEmail("carlos@email.com");
                c1.setCategoriaFidelidade("Ouro");
                c1.setLimiteJogosSimultaneos(5);
                clientes[qtdClientes++] = c1;

                Cliente c2 = new Cliente();
                c2.setCodigo(qtdClientes + 1);
                c2.setNome("Mariana Alves");
                c2.setCpf("55566677788");
                c2.setTelefone("(43) 99922-2002");
                c2.getEndereco().setRua("Rua Parana"); //Reflexividade
                c2.getEndereco().setNumero(420); //Reflexividade
                c2.getEndereco().setCidade("Londrina"); //Reflexividade
                c2.setEmail("mariana@email.com");
                c2.setCategoriaFidelidade("Prata");
                c2.setLimiteJogosSimultaneos(3);
                clientes[qtdClientes++] = c2;

                Atendente a1 = new Atendente();
                a1.setCodigo(qtdAtendentes + 1);
                a1.setNome("Roberto Ferreira");
                a1.setCpf("99988877766");
                a1.setTelefone("(43) 98800-3003");
                a1.getEndereco().setRua("Av. Sete de Setembro"); //Reflexividade
                a1.getEndereco().setNumero(3165); //Reflexividade
                a1.getEndereco().setCidade("Curitiba"); //Reflexividade
                a1.setMatricula("AT-101");
                a1.setTurno("Manha");
                a1.setPercentualComissao(6.0);
                atendentes[qtdAtendentes++] = a1;

                Atendente a2 = new Atendente();
                a2.setCodigo(qtdAtendentes + 1);
                a2.setNome("Fernanda Lima");
                a2.setCpf("44433322211");
                a2.setTelefone("(43) 98811-4004");
                a2.getEndereco().setRua("Av. Brasil"); //Reflexividade
                a2.getEndereco().setNumero(1500); //Reflexividade
                a2.getEndereco().setCidade("Cornelio Procopio"); //Reflexividade
                a2.setMatricula("AT-102");
                a2.setTurno("Noite");
                a2.setPercentualComissao(7.5);
                atendentes[qtdAtendentes++] = a2;

                JogoMidiaOptica j1 = new JogoMidiaOptica();
                j1.setCodigo(qtdJogos + 1);
                j1.setTitulo("God of War Ragnarok");
                j1.setGenero("Acao");
                j1.setPlataforma("PS5");
                j1.setValorDiaria(14.00);
                j1.setTipoDisco("Blu-Ray Ultra HD");
                j1.setQuantidadeDiscos(1);
                j1.setPossuiEncarteOriginal(true);
                jogos[qtdJogos++] = j1;

                JogoCartucho j2 = new JogoCartucho();
                j2.setCodigo(qtdJogos + 1);
                j2.setTitulo("Zelda: Breath of the Wild");
                j2.setGenero("Aventura");
                j2.setPlataforma("Nintendo Switch");
                j2.setValorDiaria(16.00);
                j2.setCodigoCarcaca("HAC-008-BR");
                j2.setCapacidadeMb(16384);
                j2.setPossuiCaixaProtetora(true);
                jogos[qtdJogos++] = j2;

                JogoEdicaoColecionador j3 = new JogoEdicaoColecionador();
                j3.setCodigo(qtdJogos + 1);
                j3.setTitulo("Elden Ring Collector Box");
                j3.setGenero("RPG");
                j3.setPlataforma("PS5");
                j3.setValorDiaria(22.00);
                j3.setNumeroSerieEdicao("ER-COL-0089");
                j3.setBrindeFisicoIncluso("Estatua Malenia 23cm + Artbook Fisico");
                j3.setValorSeguroCaixa(180.00);
                jogos[qtdJogos++] = j3;

                Locacao l1 = new Locacao();
                l1.setCodigoLocacao(qtdLocacoes + 1);
                l1.setCliente(c1);
                l1.setAtendente(a1);
                l1.setJogo(j1);
                l1.setDiasLocados(3);
                l1.setDiasAtraso(2);
                locacoes[qtdLocacoes++] = l1;

                Locacao l2 = new Locacao();
                l2.setCodigoLocacao(qtdLocacoes + 1);
                l2.setCliente(c2);
                l2.setAtendente(a2);
                l2.setJogo(j2);
                l2.setDiasLocados(4);
                l2.setDiasAtraso(1);
                locacoes[qtdLocacoes++] = l2;

                Locacao l3 = new Locacao();
                l3.setCodigoLocacao(qtdLocacoes + 1);
                l3.setCliente(c1);
                l3.setAtendente(a2);
                l3.setJogo(j3);
                l3.setDiasLocados(2);
                l3.setDiasAtraso(3);
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
