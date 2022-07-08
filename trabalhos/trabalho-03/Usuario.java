import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Usuario {
    private String login;
    private String nome;
    private String email;
    private String dataNascimento;
    private Set<Usuario> seguidores;
    private ArrayList<Mensagem> mensagens = new ArrayList<>();

    public Usuario(String login, String nome, String email, String dataNascimento) {
        this.login = login;
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.seguidores = new HashSet<Usuario>();
    }

    public void addMensagem(String m)
    {
        mensagens.add(new Mensagem(m));
    }
    
    public ArrayList<Mensagem> getMensagens()
    {
        return mensagens;
    }

    public void mostrarMensagens()
    {
        for(int i = 0; i < mensagens.size(); i++)
        {
            System.out.println("\n" + i + ") " + mensagens.get(i).getText());
        }
    }
    
    public void addSeguidor(Usuario u){
        seguidores.add(u);
    }
    
    public void delSeguidor(Usuario u){
        seguidores.remove(u);
    }

    public String getLogin() {
        return login;
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Set<Usuario> getSeguidores() {
        return seguidores;
    }

    public void setSeguidores(Set<Usuario> seguidores) {
        this.seguidores = seguidores;
    }

    @Override
    public String toString() {
        return "[" + login + "] " + nome + " | " + email + " | " + dataNascimento + " | " + seguidores.size() + " seguidores";
    }
     
    
    
}
