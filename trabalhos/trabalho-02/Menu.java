import java.util.Arrays;

public class Menu 
{
    private String title;
    private String[] options;
    private int len = 55;

    public Menu(String title, String[] options)
    {
        this.title = title;
        this.options = Arrays.copyOf(options, options.length);
    }

    public Menu(String title, String[] options, int len)
    {
        this.title = title;
        this.options = Arrays.copyOf(options, options.length);
        this.len = len;
    }

    public void show()
    {
        String str;

        System.out.println("\n" + repeat("-", len));
        System.out.println("| " + title + repeat(" ", len - title.length() - 3) + "|");
        System.out.println(repeat("-", len));

        for(int i = 0; i < options.length; i++)
        {
            str = "| " + (i+1) + " | ";
            System.out.println(str + options[i] + repeat(" ", len - str.length() - options[i].length() - 1) + "|");
            System.out.println(repeat("-", len));
        }
    }

    public String repeat(String text, int n)
    {
        String str = "";
        for(int i = 0; i < n; i++)
            str += text;

        return str;
    }
}
