public class Cliente 
{
    private String CPF;
    private String nome;
    private String endereco;
    private boolean possuiNumero = false;

    public Cliente() {

    }

    public Cliente(String CPF, String nome, String endereco) {
        this.CPF = CPF;
        this.nome = nome;
        this.endereco = endereco;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public boolean getPossuiNumero() {
        return possuiNumero;
    }

    public void setPossuiNumero(boolean possuiNumero)
    {
        this.possuiNumero = possuiNumero;
    }

    @Override
    public String toString() {
        return String.format(
            "\nCliente %s\n|\n|_ Nome: %s\n|\n|_ Endereco: %s",
            CPF, nome, endereco
        );
    }
}
