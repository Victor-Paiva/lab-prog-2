import java.util.HashMap;

public class Mrede extends Menuzao
{
    private String[] options = new String[]{"Seguidores", "Seguidos", "Mais influente", "Ocorrencia de assunto", "Voltar"};
    private String title = "Menu rede";
    private HashMap<String, Usuario> users;

    public Mrede()
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
                    getFollowers();
                    break;

                case 2:
                    getFollowing();
                    break;

                case 3:
                    getMostInfluent();
                    break;

                case 4:
                    getBySubject();
                    break;

                default:
                    exit = true;
                    break;
            }
        } while(!exit);
    }

    public void getFollowers()
    {
        String login = getString("Insira o login do usuario: ");

        if(!users.keySet().contains(login))
        {
            System.out.println("> Usuario nao encontrado.");
            return;
        }

        for(Usuario user : users.get(login).getSeguidores())
        {
            System.out.println(user);
        }
    }

    public void getFollowing()
    {
        String login = getString("Insira o login do usuario: ");

        if(!users.keySet().contains(login))
        {
            System.out.println("> Usuario nao encontrado.");
            return;
        }

        for(Usuario user : users.values())
        {
            if(user.getSeguidores().contains(users.get(login)))
            {
                System.out.println(user);
            }
        }
    }

    public void getMostInfluent()
    {
        int n = -1;
        Usuario inf = null;
        for(Usuario user : users.values())
        {
            if(user.getSeguidores().size() > n)
            {
               n = user.getSeguidores().size();
               inf = user; 
            }
        }

        System.out.println(inf);
    }

    public void getBySubject()
    {
        String expression = getString("Insira uma expressao: ");

        int counter = 0;
        for(Usuario user : users.values())
        {
            for(Mensagem message : user.getMensagens())
            {
                if(message.getText().contains(expression))
                    counter++;

                for(String comment : message.getComments())
                {
                    if(comment.contains(expression))
                        counter++;
                }
            }
        }

        System.out.println("> Ocorrencias: " + counter);
    }
}
