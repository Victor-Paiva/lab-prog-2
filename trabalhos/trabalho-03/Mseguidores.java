import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Mseguidores extends Menuzao {

    private HashMap<String, Usuario> usuarios;

    private static String opcoesSeguidores_principal[] = new String[]{"Listar Seguidores", "Seguir", "Cancelar Seguir", "Voltar"};

    @Override
    public void run(HashMap<String, Usuario> usuarios) {
        this.usuarios = usuarios;

        Integer escolha;
        do {
            this.show("Menu Usuarios", opcoesSeguidores_principal);

            escolha = this.getOpcaoMenu(opcoesSeguidores_principal.length);

            switch (escolha) {
                case 1: // Listar seguidores de um usuario
                    menu_listarSeguidores();
                    break;

                case 2: // Seguir alguem
                    menu_seguir();
                    break;
                case 3: // Parar de seguir alguem
                    menu_cancelarSeguir();
                    break;

            }
        } while (escolha != opcoesSeguidores_principal.length);
    }

    private void menu_seguir() {
        String loginUsuario = getString("Qual o login do usuario que voce deseja adicionar um seguidor?", 3);
        Usuario editando = usuarios.get(loginUsuario);

        if (editando == null) {
            erro("Este login nao esta cadastrado!");
        } else {
            String loginPraSeguir = getString("Qual o login do usuario que voce deseja adicionar como seguidor para '" + editando.getNome() + "'?", 3);
            Usuario praSeguir = usuarios.get(loginPraSeguir);
            if (praSeguir == null) {
                erro("Este login nao esta cadastrado!");
            } else {
                editando.addSeguidor(praSeguir);
                imprime("Agora '" + praSeguir.getNome() + "' esta seguindo '" + editando.getNome() + "'!"); //
            }
        }
    }

    private void menu_cancelarSeguir() {
        String loginUsuario = getString("Qual o login do usuario voce deseja remover um seguidor?", 3);
        Usuario editando = usuarios.get(loginUsuario);

        if (editando == null) {
            erro("Este login nao esta cadastrado!");
        } else {
            String loginPraSeguir = getString("Qual o login do usuario voce deseja remover como seguidor para '" + editando.getNome() + "'?", 3);
            Usuario praNaoSeguir = usuarios.get(loginPraSeguir);
            if (praNaoSeguir == null) {
                erro("Este login nao esta cadastrado!");
            } else {
                editando.delSeguidor(praNaoSeguir);
                imprime("Agora '" + editando.getNome() + "' nao esta mais seguindo '" + praNaoSeguir.getNome() + "'!");
            }
        }
    }

    private void menu_listarSeguidores() {
        String loginUsuario = getString("Qual o login do usuario voce quer ver os seguidores?", 3);
        Usuario visualizar = usuarios.get(loginUsuario);

        if (visualizar == null) {
            erro("Este login nao esta cadastrado!");
        } else {
            imprime("Listando seguidores de '" + visualizar.getNome() + "'");
            Set<Usuario> seguidores = visualizar.getSeguidores();
            Iterator<Usuario> it = seguidores.iterator();
            
            while (it.hasNext()) {
                Usuario atual = it.next();
                imprime(atual.toString());
            }
        }
    }

}
