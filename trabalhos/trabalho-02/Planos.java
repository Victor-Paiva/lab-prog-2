import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Planos {

    private Map<String, Plano> planos = new HashMap<String, Plano>();

    public Planos() {

    }

    public void adicionarPlano() {
        Scanner in = new Scanner(System.in);
        Plano p = new Plano();

        System.out.print("> Codigo: ");
        p.setCodigo(in.nextLine());
        System.out.print("> Descricao: ");
        p.setDescricao(in.nextLine());
        System.out.print("> Mensalidade: ");
        p.setMensalidade(in.nextDouble());
        System.out.print("> Franquia: ");
        p.setFranquia(in.nextInt());
        System.out.print("> Custo chamada: ");
        p.setCustoChamada(in.nextDouble());

        if(planos.containsKey(p.getCodigo())) {
            System.out.println("> O codigo ja existe.");
        } else {
            planos.put(p.getCodigo(), p);
            System.out.println("> Plano adicionado.");
        }
    }

    public void removerPlano() {
        Scanner in = new Scanner(System.in);
        String codigo;

        System.out.print("> Codigo: ");
        codigo = in.nextLine();

        if (planos.containsKey(codigo)) {
            planos.remove(codigo);
            System.out.println("> Plano removido.");
        } else {
            System.out.println("> O codigo nao existe.");
        }
    }

    public void alterarPlano()
    {
        Scanner in = new Scanner(System.in);
        String[] opcoes = new String[]{"Descricao", "Mensalidade", "Franquia", "Custo da chamada", "Voltar"};
        Menu menu = new Menu("Alterar Plano", opcoes);
        int opcao;

        do
        {
            menu.show();
            System.out.print("> Insira uma opcao: ");
            opcao = in.nextInt();

            switch (opcao) 
            {
                case 1:
                    alterarPlano_descricao();
                    break;

                case 2:
                    alterarPlano_mensalidade();
                    break;

                case 3:
                    alterarPlano_franquia();
                    break;

                case 4:
                    alterarPlano_custoChamada();
                    break;
            
                default:
                    break;
            }
        }while(opcao != 5);
    }

    public void alterarPlano_descricao() {
        Scanner in = new Scanner(System.in);
        String codigo;

        System.out.print("> Codigo: ");
        codigo = in.nextLine();
        if (planos.containsKey(codigo)) {
            System.out.print("> Nova descricao: ");
            planos.get(codigo).setDescricao(in.nextLine());
            System.out.print("> Descricao atualizada.");
        } else {
            System.out.println("> O codigo nao existe.");
        }
    }

    public void alterarPlano_mensalidade() {
        Scanner in = new Scanner(System.in);
        String codigo;

        System.out.print("> Codigo: ");
        codigo = in.nextLine();
        if (planos.containsKey(codigo)) {
            System.out.print("> Nova mensalidade: ");
            planos.get(codigo).setMensalidade(in.nextDouble());
            System.out.print("> Mensalidade atualizada.");
        } else {
            System.out.println("> O codigo nao existe.");
        }
    }

    public void alterarPlano_franquia() {
        Scanner in = new Scanner(System.in);
        String codigo;

        System.out.print("> Codigo: ");
        codigo = in.nextLine();
        if (planos.containsKey(codigo)) {
            System.out.print("> Nova franquia: ");
            planos.get(codigo).setFranquia(in.nextInt());
            System.out.print("> Franquia atualizada.");
        } else {
            System.out.println("> O codigo nao existe.");
        }
    }

    public void alterarPlano_custoChamada() {
        Scanner in = new Scanner(System.in);
        String codigo;

        System.out.print("> Codigo: ");
        codigo = in.nextLine();
        if (planos.containsKey(codigo)) {
            System.out.print("> Novo custo da chamada: ");
            planos.get(codigo).setCustoChamada(in.nextDouble());
            System.out.print("> Custo da chamada atualizado.");
        } else {
            System.out.println("> O codigo nao existe.");
        }
    }

    public void getPlanoByCodigo() {
        Scanner in = new Scanner(System.in);
        String codigo;

        System.out.print("> Codigo: ");
        codigo = in.nextLine();
        if (planos.containsKey(codigo)) {
            System.out.println(planos.get(codigo).toString());    
        } else {
            System.out.println("> O codigo nao existe.");
        }
    }
    
    public void listarPlanos() {
        for(String key : planos.keySet())
            System.out.println(planos.get(key).toString());
    }

    public Map<String, Plano> getPlanos()
    {
        return planos;
    }

}
