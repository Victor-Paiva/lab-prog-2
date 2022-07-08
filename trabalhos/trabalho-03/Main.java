import java.util.Scanner;
import java.util.HashMap;

public class Main
{
    public static void main(String[] args)
    {
        Menuzao[] menus = new Menuzao[]{
            new Musuario(),
            new Mseguidores(),
            new Mensagens(),
            new Mrede()
        };

        HashMap<String, Usuario> users = new HashMap<>();

        String[] options = new String[]{"Usuario", "Seguidores", "Mensagens", "Rede", "Sair"};
        String title = "Menu Principal";
        Scanner in = new Scanner(System.in);

        int option;

        menus[0].show(title, options);
        System.out.print("> ");
        option = in.nextInt() - 1;

        while(option >= 0 && option < options.length - 1)
        {
            menus[option].run(users);

            menus[0].show(title, options);
            System.out.print("> Insira uma opcao: ");
            option = in.nextInt() - 1;
        }

        in.close();
    }    
}
