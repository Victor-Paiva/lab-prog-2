import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class Musuario extends Menuzao {

    private HashMap<String, Usuario> usuarios;

    private String opcoesUsuarios_principal[] = new String[]{"Listar Usuarios", "Buscar Usuario", "Cadastrar Usuario", "Remover Usuario", "Editar Usuario", "Voltar"};

    @Override
    public void run(HashMap<String, Usuario> usuarios) { // Precisa receber o hashmap das mensagens tambem (poder apagar)
        this.usuarios = usuarios;

        Integer escolha;

        do {
            this.show("Menu Usuarios", opcoesUsuarios_principal);

            escolha = this.getOpcaoMenu(opcoesUsuarios_principal.length);

            switch (escolha) {
                case 1: // Listar usuarios
                    menu_listaUsuarios();
                    break;
                case 2:
                    menu_buscarUsuario();
                    break;

                case 3: // Criar usuario
                    menu_criarUsuario();
                    break;

                case 4: // Remover usuario
                    menu_removerUsuario();
                    break;

                case 5: // Remover usuario
                    menu_editarUsuario();
                    break;

            }
        } while (escolha != opcoesUsuarios_principal.length);
    }

    public Musuario() {
    }


    private void menu_criarUsuario() {
        String nomeUsuario = this.getString("Qual o nome do usuario?");
        String loginUsuario = this.getString("Qual o login do usuario?", 3);
        String emailUsuario = this.getString("Qual o email do usuario?", 5);
        String dataNascimento = this.getString("Qual a data de nascimento do usuario?", 8);

        if (usuarios.get(loginUsuario) == null) {
            Usuario novoUsuario = new Usuario(loginUsuario, nomeUsuario, emailUsuario, dataNascimento);
            imprime("Usuario '" + loginUsuario + "' cadastrado com sucesso!");

            // Coloca na "base de dados", chave = login
            usuarios.put(loginUsuario, novoUsuario);
        } else {
            erro("Login '" + loginUsuario + "' ja existe!");
        }
    }

    private void menu_removerUsuario() {
        String loginUsuario = getString("Qual o login do usuario voce deseja EXCLUIR?", 3);
        Usuario removendo = usuarios.get(loginUsuario);

        if (removendo == null) {
            erro("Este login nao esta cadastrado!");
        } else {

            // Primeiro remove este usuario da lista de seguidores de todo mundo!
            for (Entry<String, Usuario> u : usuarios.entrySet()) {
                if (u.getValue() != removendo) { // ignora o proprio que esta sendo removido
                    u.getValue().delSeguidor(removendo);
                }
            }

            // FALTA CONEXAO PARA APAGAR AS MENSAGENS (deve receber no run?)
            usuarios.remove(loginUsuario);
            imprime("Usuario removido com sucesso!");
        }
    }

    private void menu_listaUsuarios() {
        imprime("Lista de usuarios: ");
        for (Entry<String, Usuario> u : usuarios.entrySet()) {
            imprime(u.toString());
        }
    }

    private void menu_editarUsuario() {
        String loginUsuario = getString("Qual o login do usuario voce deseja EDITAR?", 3);

        Usuario editando = usuarios.get(loginUsuario);

        if (editando == null) {
            erro("Este login nao esta cadastrado!");
        } else {
            String nomeUsuario = this.getString("Qual o novo nome do usuario? (Atual: '" + editando.getNome() + "')");
            String emailUsuario = this.getString("Qual o novo email do usuario? (Atual: '" + editando.getEmail() + "')", 5);
            String dataNascimento = this.getString("Qual a data de nascimento do usuario?", 8);

            editando.setNome(nomeUsuario);
            editando.setEmail(emailUsuario);
            editando.setDataNascimento(dataNascimento);

            imprime("Usuario editado com sucesso!");
        }
    }

    private void menu_buscarUsuario() {
        String loginUsuario = getString("Qual o login do usuario voce deseja BUSCAR?", 3);

        Usuario encontrado = usuarios.get(loginUsuario);

        if (encontrado == null) {
            erro("Este login nao esta cadastrado!");
        } else {
            imprime("Usuario encontrado: ");
            imprime(encontrado.toString());
        }
    }

}
