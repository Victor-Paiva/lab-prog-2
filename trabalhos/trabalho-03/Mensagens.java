import java.util.HashMap;

public class Mensagens extends Menuzao
{
    private String[] options = new String[]{"Registrar mensagem", "Comentar mensagem", "Ver mensagens", "Voltar"};
    private String title = "Menu mensagens";
    private HashMap<String, Usuario> users;

    public Mensagens()
    {
        
    }

    @Override
    public void run(HashMap<String, Usuario> users)
    {
        int option;
        boolean exit = false;

        this.users = users;

        do
        {
            show(title, options);
            System.out.print("> ");
            option = scanner.nextInt();

            switch(option)
            {
                case 1:
                    post();
                    break;

                case 2:
                    comment();
                    break;

                case 3:
                    stalk();
                    break;

                default:
                    exit = true;
                    break;
            }
        } while(!exit);
    }

    public void post()
    {
        scanner.nextLine();
        String login = getString("Insira o login do usuario: ");

        if(!users.keySet().contains(login))
        {
            System.out.println("> Usuario nao encontrado.");
            return;
        }

        String message = getString("Insira a mensagem: ");

        if(message.length() > 140)
        {
            System.out.println("> Mensagem muito longa.");
        }
        else
        {
            users.get(login).addMensagem(message);
        }
    }

    public void comment()
    {
        scanner.nextLine();
        String login = getString("Insira o login do usuario: ");

        if(!users.keySet().contains(login) || users.get(login).getMensagens().size() == 0)
        {
            System.out.println("> Nenhuma mensagem encontrada.");
            return;
        }

        users.get(login).mostrarMensagens();
        System.out.print("> Insira o numero da mensagem que deseja comentar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        String commentaryText = getString("Insira o comentario: ");
        if(commentaryText.length() > 140)
        {
            System.out.println("> Comentario muito longo.");
            return;
        }
        String loginB = getString("Insira seu login: ");

        if(!users.keySet().contains(loginB))
        {
            System.out.println("> Login invalido.");
            return;
        }

        if(!users.get(login).getSeguidores().contains(users.get(loginB)))
        {
            System.out.println("> Voce precisa seguir o usuario primeiro.");
            return;
        }

        users.get(login).getMensagens().get(id).addComment(commentaryText);
    }

    public void stalk()
    {
        scanner.nextLine();
        String login = getString("Insira o login do usuario: ");

        if(!users.keySet().contains(login) || users.get(login).getMensagens().size() == 0)
        {
            System.out.println("> Nenhuma mensagem encontrada.");
            return;
        }

        for(Mensagem message : users.get(login).getMensagens())
        {
            System.out.println(message);
        }
    }
}