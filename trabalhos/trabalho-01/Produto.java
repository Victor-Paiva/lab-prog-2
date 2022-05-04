public class Produto
{
    private int ID;
    private String nome;
    private int quantidade;
    private double valor;
    private String desc;

    // GETTERS
    public int obterID()
    {
        return ID;
    }

    public String obterNome()
    {
        return nome;
    }

    public int obterQuantidade()
    {
        return quantidade;
    }

    public double obterValor()
    {
        return valor;
    }

    public String obterDesc()
    {
        return desc;
    }

    // SETTERS
    public boolean alterarID(int ID)
    {
        if(ID >= 0)
        {
            this.ID = ID;
            return true;
        }
        
        System.out.println("> ID invalido.");
        return false;
    }

    public boolean alterarNome(String nome)
    {
        if(nome.length() > 0 && nome.length() < 50)
        {
            this.nome = nome;
            return true;
        }
        
        System.out.println("> Nome invalido.");
        return false;
    }

    public boolean alterarQuantidade(int quantidade)
    {
        if(quantidade >= 0)
        {
            this.quantidade = quantidade;
            return true;
        }
        
        System.out.println("> Quantidade invalida.");
        return false;
    }

    public boolean alterarValor(double valor)
    {
        if(valor > 0)
        {
            this.valor = valor;
            return true;
        }
        
        System.out.println("> Valor invalido.");
        return false;
    }

    public boolean alterarDesc(String desc)
    {
        if(desc.length() <= 300)
        {
            this.desc = desc;
            return true;
        }
        
        System.out.println("> Descricao invalida.");
        return false;
    }
}