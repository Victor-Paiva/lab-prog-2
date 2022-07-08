import java.util.HashSet;

public class Mensagem
{
    private String text;
    private HashSet<String> comments = new HashSet<>();

    public Mensagem(String text)
    {
        this.text = text;
    }

    public void addComment(String comment)
    {
        comments.add(comment);
    }

    public String getText()
    {
        return text;
    }

    public HashSet<String> getComments()
    {
        return comments;
    }

    @Override
    public String toString()
    {
        String str = "\n" + text;

        if(!comments.isEmpty())
        {
            for(String comment : comments)
            {
                str += "\n\t" + comment;
            }
        }

        return str;
    }
}
