import java.util.HashMap;
import java.util.Scanner;

abstract public class Menuzao {

    private final int len = 55;
    protected Scanner scanner = new Scanner(System.in);

    abstract public void run(HashMap<String, Usuario> usuarios);  // Implementar

    // Favor usar esta funcao pra mostrar o menu formatado (colocar a opcao "sair" no final)
    public void show(String title, String[] options) {
        String str;

        System.out.println("\n" + repeat("-", len));
        System.out.println("| " + title + repeat(" ", len - title.length() - 3) + "|");
        System.out.println(repeat("-", len));

        for (int i = 0; i < options.length; i++) {
            str = "| " + (i + 1) + " | ";
            System.out.println(str + options[i] + repeat(" ", len - str.length() - options[i].length() - 1) + "|");
            System.out.println(repeat("-", len));
        }
    }

    public String repeat(String text, int n) {
        String str = "";
        for (int i = 0; i < n; i++) {
            str += text;
        }

        return str;
    }
    
    public void imprime(String s){
        System.out.println("> "+s);
    }
    
    public void erro(String s){
        System.err.println("> ERRO: "+s);
        scanner.nextLine();
    }   

    public Integer getOpcaoMenu(Integer qtdOpcoes) {
        Integer escolha;

        do {
            System.out.print("> ");
            escolha = scanner.nextInt();
            if (escolha > qtdOpcoes || escolha < 1) {
                System.out.println("- Opcao invalida!");
            }
        } while (escolha > qtdOpcoes || escolha < 1);

        scanner.nextLine(); // Limpa o buffer
        return escolha;
    }

    public String getString(String pergunta) {
        return this.getString(pergunta, 3); 
    }

    public String getString(String pergunta, Integer minCaracters) {
        System.out.println("-> " + pergunta);

        String entrada = "";
        do {
            System.out.print("> ");
            entrada = scanner.nextLine();

            if (entrada.length() < minCaracters) {
                System.out.println("- Entrada invalida! (Minimo " + minCaracters + " caracteres)");
            }
        } while (entrada.length() < minCaracters);

        return entrada;
    }

    public Integer getInteiro(String pergunta, Integer min, Integer max) {
        System.out.println("-> " + pergunta + ":");

        Integer entrada = 0;

        do {
            System.out.print("> ");
            entrada = scanner.nextInt();

            if (entrada < min || entrada > max) {
                System.out.println("- Entrada invalida!");
            }
        } while (entrada < min || entrada > max);

        scanner.nextLine(); // Limpa o buffer
        return entrada;
    }
}
