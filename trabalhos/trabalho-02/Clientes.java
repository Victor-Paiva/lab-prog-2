import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Clientes {

    private Map<String, Cliente> clientes = new HashMap<String, Cliente>();

    public Clientes() {

    }

    public void adicionarCliente() {
        Scanner in = new Scanner(System.in);
        Cliente c = new Cliente();

        System.out.print("> CPF: ");
        c.setCPF(in.nextLine());
        System.out.print("> Nome: ");
        c.setNome(in.nextLine());
        System.out.print("> Endereco: ");
        c.setEndereco(in.nextLine());


        if (clientes.containsKey(c.getCPF())) {
            System.out.println("> Este CPF ja existe.");
        } else {
            clientes.put(c.getCPF(), c);
            System.out.println("> Cliente cadastrado.");
        }
    }

    public void removerCliente() {
        Scanner in = new Scanner(System.in);
        String cpf;

        System.out.print("> CPF: ");
        cpf = in.nextLine();
        if (clientes.containsKey(cpf) && !clientes.get(cpf).getPossuiNumero()) {
            clientes.remove(cpf);
            System.out.println("> Cliente excluido.");
        } else if (!clientes.containsKey(cpf)) {
            System.out.println("> Nao existe um cliente com este CPF.");
        } else {
            System.out.println("> Este cliente esta associado a um numero de telefone.");
        }
    }

    public void alterarCliente()
    {
        Scanner in = new Scanner(System.in);
        String[] opcoes = new String[]{"Nome", "Endereco", "Voltar"};
        Menu menu = new Menu("Alterar Cliente", opcoes);
        int opcao;

        do
        {
            menu.show();
            System.out.print("> Insira uma opcao: ");
            opcao = in.nextInt();

            switch (opcao) 
            {
                case 1:
                    alterarCliente_nome();
                    break;

                case 2:
                    alterarCliente_endereco();
                    break;
            
                default:
                    break;
            }
        }while(opcao != 3);
    }

    public void alterarCliente_nome() {
        Scanner in = new Scanner(System.in);
        String cpf;

        System.out.print("> CPF: ");
        cpf = in.nextLine();
        if (clientes.containsKey(cpf)) {
            System.out.print("> Novo nome: ");
            clientes.get(cpf).setNome(in.nextLine());
            System.out.print("> Nome alterado.");
        } else {
            System.out.println("> Nao existe um cliente com este CPF.");
        }
    }
    
    public void alterarCliente_endereco() {
        Scanner in = new Scanner(System.in);
        String cpf;

        System.out.print("> CPF: ");
        cpf = in.nextLine();
        if (clientes.containsKey(cpf)) {
            System.out.print("> Novo endereco: ");
            clientes.get(cpf).setEndereco(in.nextLine());
            System.out.print("> Endereco alterado.");
        } else {
            System.out.println("> Nao existe um cliente com este CPF.");
        }
    }

    public void getClienteByCPF(){
        Scanner in = new Scanner(System.in);
        String cpf;

        System.out.print("> CPF: ");
        cpf = in.nextLine();
        if(clientes.containsKey(cpf)){
            System.out.println(clientes.get(cpf).toString());
        } else {
            System.out.println("> Nao existe um cliente com este CPF.");
        }
    }
    
    public void listarClientes() {
        for(String key : clientes.keySet())
            System.out.println(clientes.get(key).toString());
    }

    public Map<String, Cliente> getClientes()
    {
        return clientes;
    }
}
