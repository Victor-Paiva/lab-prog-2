import java.util.Scanner;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String[] opcoes = new String[]{"Plano", "Cliente", "Telefone", "Chamada", "Relatorio", "Sair"};
        Menu menu = new Menu("Menu Principal", opcoes);
        Planos ps = new Planos();
        Clientes cs = new Clientes();
        ArrayList<Telefone> ts = new ArrayList<>();
        ArrayList<Chamada> chs = new ArrayList<>();
        int opcao;

        do
        {
            menu.show();
            System.out.print("> Escolha uma opcao: ");
            opcao = in.nextInt();

            switch (opcao) 
            {
                case 1:
                    menuPlano(ps);
                    break;

                case 2:
                    menuCliente(cs);
                    break;

                case 3:
                    menuTelefone(ps, cs, ts);
                    break;

                case 4:
                    menuChamada(ts, chs);
                    break;

                case 5:
                    gerarRelatorio(chs);
                    break;
            
                default:
                    break;
            }     
        } while (opcao != 6);

        in.close();
    }

    public static void gerarRelatorio(ArrayList<Chamada> chs)
    {
        Scanner in = new Scanner(System.in);
        String numero;
        int mes, ano, franquia = 0, alem = 0, nova = 0;
        double custo = 0, plano = 0;

        System.out.print("Numero de telefone: ");
        numero = in.nextLine();
        System.out.print("Mes e ano: ");
        mes = in.nextInt();
        ano = in.nextInt();

        for(Chamada ch : chs)
        {
            if(ch.getNumeroOrigem().getNumero().equals(numero))
            {
                if(ch.getDataInicio().getMonth() == mes && ch.getDataInicio().getYear() == ano)
                {
                    System.out.println(ch.toString());
                    nova = ch.getNumeroOrigem().getPlano().getFranquia();
                    if(nova > franquia)
                        franquia = nova;
                    alem += ch.getAlem();
                    custo += ch.getCusto();
                    plano = ch.getNumeroOrigem().getPlano().getMensalidade();
                }
            }
        }

        System.out.printf("\n- Franquia: %d\n- Minutos alem da franquia: %d\n- Valor do plano: %.2f\n- Valor total: %.2f\n", franquia, alem, plano, (custo+plano));

        for(Chamada ch : chs)
            ch.reset();
    }

    public static void menuPlano(Planos ps)
    {
        Scanner in = new Scanner(System.in);
        String[] opcoes = new String[]{"Cadastrar", "Alterar", "Excluir", "Listar", "Pesquisar", "Voltar"};
        Menu menu = new Menu("Menu Planos", opcoes);
        int opcao;

        do
        {
            menu.show();
            System.out.print("> Escolha uma opcao: ");
            opcao = in.nextInt();

            switch (opcao) 
            {
                case 1:
                    ps.adicionarPlano();
                    break;

                case 2:
                    ps.alterarPlano();
                    break;

                case 3:
                    ps.removerPlano();
                    break;

                case 4:
                    ps.listarPlanos();
                    break;

                case 5:
                    ps.getPlanoByCodigo();
                    break;
            
                default:
                    break;
            }     
        } while (opcao != 6);
    }

    public static void menuCliente(Clientes cs)
    {
        Scanner in = new Scanner(System.in);
        String[] opcoes = new String[]{"Cadastrar", "Alterar", "Excluir", "Listar", "Pesquisar", "Voltar"};
        Menu menu = new Menu("Menu Clientes", opcoes);
        int opcao;

        do
        {
            menu.show();
            System.out.print("> Escolha uma opcao: ");
            opcao = in.nextInt();

            switch (opcao) 
            {
                case 1:
                    cs.adicionarCliente();
                    break;

                case 2:
                    cs.alterarCliente();
                    break;

                case 3:
                    cs.removerCliente();
                    break;

                case 4:
                    cs.listarClientes();
                    break;

                case 5:
                    cs.getClienteByCPF();
                    break;
            
                default:
                    break;
            }     
        } while (opcao != 6);
    }

    public static void menuTelefone(Planos ps, Clientes cs, ArrayList<Telefone> ts)
    {
        Scanner in = new Scanner(System.in);
        String[] opcoes = new String[]{"Cadastrar", "Alterar", "Excluir", "Cancelar", "Listar", "Pesquisar", "Voltar"};
        Menu menu = new Menu("Menu Telefones", opcoes);
        int opcao;

        do
        {
            menu.show();
            System.out.print("> Escolha uma opcao: ");
            opcao = in.nextInt();

            switch (opcao) 
            {
                case 1:
                    cadastrarTelefone(ps, cs, ts);
                    break;

                case 2:
                    alterarTelefone(ps, cs, ts);
                    break;

                case 3:
                    excluirTelefone(ts);
                    break;

                case 4:
                    alterarTelefone_Cancelamento(ts);
                    break;

                case 5:
                    listarTelefone(ts);
                    break;

                case 6:
                    pesquisarTelefone(ts);
                    break;
            
                default:
                    break;
            }     
        } while (opcao != 7);
    }

    public static void menuChamada(ArrayList<Telefone> ts, ArrayList<Chamada> chs)
    {
        Scanner in = new Scanner(System.in);
        String[] opcoes = new String[]{"Registrar", "Alterar", "Excluir", "Listar", "Pesquisar", "Voltar"};
        Menu menu = new Menu("Menu Chamadas", opcoes);
        int opcao;

        do
        {
            menu.show();
            System.out.print("> Escolha uma opcao: ");
            opcao = in.nextInt();

            switch (opcao) 
            {
                case 1:
                    registrarChamada(ts, chs);
                    break;

                case 2:
                    alterarChamada(ts, chs);
                    break;

                case 3:
                    excluirChamada(chs);
                    break;

                case 4:
                    listarChamadas(chs);
                    break;

                case 5:
                    pesquisarChamada(chs);
                    break;
            
                default:
                    break;
            }     
        } while (opcao != 6);
    }

    public static void listarChamadas(ArrayList<Chamada> chs)
    {
        for(Chamada ch : chs)
            System.out.println(ch.toString());

        for(Chamada ch : chs)
            ch.reset();
    }

    public static void pesquisarChamada(ArrayList<Chamada> chs)
    {
        Scanner in = new Scanner(System.in);
        int index;

        System.out.print("> Indice da chamada: ");
        index = in.nextInt();

        if(index >= chs.size())
        {
            System.out.println("> Essa chamada nao existe.");
            return;
        }

        System.out.println(chs.get(index).toString());
    }

    public static void registrarChamada(ArrayList<Telefone> ts, ArrayList<Chamada> chs)
    {
        Scanner in = new Scanner(System.in);
        Chamada ch = new Chamada();
        String numero;
        boolean achado = false;
        
        System.out.print("> Origem: ");
        numero = in.nextLine();
        
        for(Telefone tel : ts)
        {
            if(tel.getNumero().equals(numero) && tel.getDataCancelamento() == null)
            {
                ch.setNumeroOrigem(tel);
                achado = true;
                break;
            }
        }

        if(!achado)
        {
            System.out.println("> Numero indisponivel.");
            return;
        }

        System.out.print("> Destino: ");
        ch.setNumeroDestino(in.nextLine());

        System.out.print("> Data de inicio: ");
        ch.setDataInicio(new Date(in.nextInt(), in.nextInt(), in.nextInt()));
        System.out.print("> Hora de inicio: ");
        ch.setHoraInicio(new Time(in.nextInt(), in.nextInt(), in.nextInt()));

        System.out.print("> Data de termino: ");
        ch.setDataFim(new Date(in.nextInt(), in.nextInt(), in.nextInt()));
        System.out.print("> Hora de termino: ");
        ch.setHoraFim(new Time(in.nextInt(), in.nextInt(), in.nextInt()));

        chs.add(ch);
    }

    public static void alterarChamada(ArrayList<Telefone> ts, ArrayList<Chamada> chs)
    {
        Scanner in = new Scanner(System.in);
        String[] opcoes = new String[]{"Numero de origem", "Numero de destino", "Data/Hora inicio", "Data/hora fim", "Voltar"};
        Menu menu = new Menu("Alterar Chamada", opcoes);
        int opcao;

        do
        {
            menu.show();
            System.out.print("> Escolha uma opcao: ");
            opcao = in.nextInt();

            switch (opcao) 
            {
                case 1:
                    alterarChamada_Origem(ts, chs);
                    break;

                case 2:
                    alterarChamada_Destino(chs);
                    break;

                case 3:
                    alterarChamada_Inicio(chs);
                    break;

                case 4:
                    alterarChamada_Fim(chs);
                    break;
            
                default:
                    break;
            }     
        } while (opcao != 5);
    }

    public static void alterarChamada_Origem(ArrayList<Telefone> ts, ArrayList<Chamada> chs)
    {
        Scanner in = new Scanner(System.in);
        int index;
        String numero;

        System.out.print("> Indice da chamada: ");
        index = in.nextInt();

        if(index >= chs.size())
        {
            System.out.println("> Essa chamada nao existe.");
            return;
        }

        System.out.print("> Novo numero de origem: ");
        numero = in.nextLine();
        for(Telefone tel : ts)
        {
            if(tel.getNumero().equals(numero))
            {
                chs.get(index).setNumeroOrigem(tel);
                System.out.println("Numero alterado.");
                return;
            }
        }

        System.out.println("Numero nao encontrado.");
    }

    public static void excluirChamada(ArrayList<Chamada> chs)
    {
        Scanner in = new Scanner(System.in);
        int index;

        System.out.print("> Indice da chamada: ");
        index = in.nextInt();

        if(index >= chs.size())
        {
            System.out.println("> Essa chamada nao existe.");
            return;
        }

        chs.remove(index);

        System.out.println("> Chamada removida.");
    }

    public static void alterarChamada_Destino(ArrayList<Chamada> chs)
    {
        Scanner in = new Scanner(System.in);
        int index;

        System.out.print("> Indice da chamada: ");
        index = in.nextInt();

        if(index >= chs.size())
        {
            System.out.println("> Essa chamada nao existe.");
            return;
        }

        System.out.print("> Novo numero de destino: ");
        chs.get(index).setNumeroDestino(in.nextLine());

        System.out.println("> Numero alterado.");
    }

    public static void alterarChamada_Inicio(ArrayList<Chamada> chs)
    {
        Scanner in = new Scanner(System.in);
        int index;

        System.out.print("> Indice da chamada: ");
        index = in.nextInt();

        if(index >= chs.size())
        {
            System.out.println("> Essa chamada nao existe.");
            return;
        }

        System.out.print("> Data de inicio: ");
        chs.get(index).setDataInicio(new Date(in.nextInt(), in.nextInt(), in.nextInt()));
        System.out.print("> Hora de inicio: ");
        chs.get(index).setHoraInicio(new Time(in.nextInt(), in.nextInt(), in.nextInt()));

        System.out.println("> Data alterada.");
    }

    public static void alterarChamada_Fim(ArrayList<Chamada> chs)
    {
        Scanner in = new Scanner(System.in);
        int index;

        System.out.print("> Indice da chamada: ");
        index = in.nextInt();

        if(index >= chs.size())
        {
            System.out.println("> Essa chamada nao existe.");
            return;
        }

        System.out.print("> Data de termino: ");
        chs.get(index).setDataFim(new Date(in.nextInt(), in.nextInt(), in.nextInt()));
        System.out.print("> Hora de termino: ");
        chs.get(index).setHoraFim(new Time(in.nextInt(), in.nextInt(), in.nextInt()));

        System.out.println("> Data alterada.");
    }

    public static void cadastrarTelefone(Planos ps, Clientes cs, ArrayList<Telefone> ts)
    {
        Scanner in = new Scanner(System.in);
        Telefone t = new Telefone();
        String cpf, codigo;

        System.out.print("> Numero do telefone: ");
        t.setNumero(in.nextLine());
        for(Telefone tel : ts)
        {
            if(tel.getNumero().equals(t.getNumero()) && tel.getDataCancelamento() == null)
            {
                System.out.println("> Este telefone ja esta em uso.");
                return;
            }
        }

        System.out.print("> CPF do cliente: ");
        cpf = in.nextLine();
        if(!cs.getClientes().containsKey(cpf))
        {
            System.out.println("> Nao existe um cliente com este CPF.");
            return;
        }
        t.setCliente(cs.getClientes().get(cpf));

        System.out.print("> Codigo do plano: ");
        codigo = in.nextLine();
        if(!ps.getPlanos().containsKey(codigo))
        {
            System.out.println("> O codigo nao existe.");
            return;
        }
        t.setPlano(ps.getPlanos().get(codigo));

        System.out.print("> Data de ativacao: ");
        t.setDataAtivacao(new Date(in.nextInt(), in.nextInt(), in.nextInt()));

        System.out.print("> Hora de ativacao: ");
        t.setHoraAtivacao(new Time(in.nextInt(), in.nextInt(), in.nextInt()));

        System.out.print("> Possui data de cancelamento ? (NAO: 0 / SIM: 1) ");
        if(in.nextInt() == 1)
        {
            System.out.print("> Data de cancelamento: ");
            t.setDataCancelamento(new Date(in.nextInt(), in.nextInt(), in.nextInt()));
            System.out.print("> Hora de cancelamento: ");
            t.setHoraCancelamento(new Time(in.nextInt(), in.nextInt(), in.nextInt()));
        }

        System.out.print("> Dia de pagamento: ");
        t.setDiaPagamento(in.nextInt());

        t.getCliente().setPossuiNumero(true);

        ts.add(t);
        System.out.println("> Telefone cadastrado.");
    }

    public static void alterarTelefone(Planos ps, Clientes cs, ArrayList<Telefone> ts)
    {
        Scanner in = new Scanner(System.in);
        String[] opcoes = new String[]{"Cliente", "Plano", "Data/Hora de cancelamento", "Dia do pagamento", "Voltar"};
        Menu menu = new Menu("Alterar Telefone", opcoes);
        int opcao;

        do
        {
            menu.show();
            System.out.print("> Escolha uma opcao: ");
            opcao = in.nextInt();

            switch (opcao) 
            {
                case 1:
                    alterarTelefone_Cliente(cs, ts);
                    break;

                case 2:
                    alterarTelefone_Plano(ps, ts);
                    break;

                case 3:
                    alterarTelefone_Cancelamento(ts);
                    break;

                case 4:
                    alterarTelefone_Pagamento(ts);
                    break;

                default:
                    break;
            }     
        } while (opcao != 5);
    }

    public static void alterarTelefone_Cliente(Clientes cs, ArrayList<Telefone> ts)
    {
        Scanner in = new Scanner(System.in);
        String numero, cpf;
        Telefone t = null;

        System.out.print("> Numero do telefone: ");
        numero = in.nextLine();

        for(Telefone tel : ts)
        {
            if(tel.getNumero().equals(numero))
            {
                t = tel;
                break;
            }
        }

        if(t == null)
        {
            System.out.println("> O numero de telefone nao existe.");
            return;
        }

        System.out.print("> CPF do cliente: ");
        cpf = in.nextLine();
        if(!cs.getClientes().containsKey(cpf))
        {
            System.out.println("> Nao existe um cliente com este CPF.");
            return;
        }

        t.getCliente().setPossuiNumero(false);
        t.setCliente(cs.getClientes().get(cpf));
        System.out.println("> Cliente alterado.");
    }

    public static void alterarTelefone_Plano(Planos ps, ArrayList<Telefone> ts)
    {
        Scanner in = new Scanner(System.in);
        String numero, codigo;
        Telefone t = null;

        System.out.print("> Numero do telefone: ");
        numero = in.nextLine();

        for(Telefone tel : ts)
        {
            if(tel.getNumero().equals(numero))
            {
                t = tel;
                break;
            }
        }

        if(t == null)
        {
            System.out.println("> O numero de telefone nao existe.");
            return;
        }

        System.out.print("> Codigo do plano: ");
        codigo = in.nextLine();
        if(!ps.getPlanos().containsKey(codigo))
        {
            System.out.println("> O codigo nao existe.");
            return;
        }

        t.setPlano(ps.getPlanos().get(codigo));
        System.out.println("> Plano alterado.");
    }

    public static void alterarTelefone_Cancelamento(ArrayList<Telefone> ts)
    {
        Scanner in = new Scanner(System.in);
        String numero;
        Telefone t = null;

        System.out.print("> Numero do telefone: ");
        numero = in.nextLine();

        for(Telefone tel : ts)
        {
            if(tel.getNumero().equals(numero))
            {
                t = tel;
                break;
            }
        }

        if(t == null)
        {
            System.out.println("> O numero de telefone nao existe.");
            return;
        }

        System.out.print("> Data de cancelamento: ");
        t.setDataCancelamento(new Date(in.nextInt(), in.nextInt(), in.nextInt()));
        System.out.print("> Hora de cancelamento: ");
        t.setHoraCancelamento(new Time(in.nextInt(), in.nextInt(), in.nextInt()));

        System.out.println("> Data de cancelamento atualizada.");
    }

    public static void alterarTelefone_Pagamento(ArrayList<Telefone> ts)
    {
        Scanner in = new Scanner(System.in);
        String numero;
        Telefone t = null;

        System.out.print("> Numero do telefone: ");
        numero = in.nextLine();

        for(Telefone tel : ts)
        {
            if(tel.getNumero().equals(numero))
            {
                t = tel;
                break;
            }
        }

        if(t == null)
        {
            System.out.println("> O numero de telefone nao existe.");
            return;
        }

        System.out.print("> Novo dia do pagamento: ");
        t.setDiaPagamento(in.nextInt());

        System.out.println("Dia do pagamento alterado.");
    }

    public static void excluirTelefone(ArrayList<Telefone> ts)
    {
        Scanner in = new Scanner(System.in);
        String numero;

        System.out.print("> Numero do telefone: ");
        numero = in.nextLine();

        for(Telefone tel : ts)
        {
            if(tel.getNumero().equals(numero))
            {
                tel.getCliente().setPossuiNumero(false);
                ts.remove(tel);
                System.out.println("> Telefone removido.");
                return;
            }
        }

        System.out.println("> O numero de telefone nao existe.");
    }

    public static void listarTelefone(ArrayList<Telefone> ts)
    {
        for(Telefone tel : ts)
            System.out.println(tel.toString());
    }

    public static void pesquisarTelefone(ArrayList<Telefone> ts)
    {
        Scanner in = new Scanner(System.in);
        String numero;

        System.out.print("> Numero do telefone: ");
        numero = in.nextLine();

        for(Telefone tel : ts)
        {
            if(tel.getNumero().equals(numero))
            {
                System.out.println(tel.toString());
                return;
            }
        }

        System.out.println("> O numero de telefone nao existe.");
    }
}