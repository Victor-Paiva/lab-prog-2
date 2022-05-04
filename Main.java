import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        final int max = 100;
        Produto[] produtos = new Produto[max];
        int index = 0, opcao;
        boolean loop = true;
        Produto encontrado;

        while(loop)
        {
            mostrarMenu();

            System.out.print("\n> Escolha uma opcao: ");
            opcao = in.nextInt();

            switch (opcao)
            {
                case 1:
                    adicionarProduto(produtos, index, max);
                    index++;
                    break;

                case 2:
                    buscaProdutoMaisCaro(produtos, index);
                    break;

                case 3:
                    buscaProdutoMaiorQuantidade(produtos, index);
                    break;

                case 4:
                    encontrado = buscaProdutoPorId(produtos,index);
                    if(encontrado == null)
                        System.out.println("> Produto com este ID não encontrado.");
                    else
                        mostrarProduto(encontrado);
                    break;

                case 5:
                    encontrado = buscaProdutoPorId(produtos,index);
                    if(encontrado == null)
                        System.out.println("> Produto com este ID não encontrado.");
                    else
                        alterarValorProduto(encontrado);
                    break;
                
                default:
                    loop = false;
                    break;
            }
        }

        in.close();
    }

    public static void mostrarMenu()
    {
        System.out.println("\n" + "-".repeat(55));
        System.out.println("|" + " ".repeat(19) + "MENU PRINCIPAL" + " ".repeat(20) + "|");
        System.out.println("-".repeat(55));
        System.out.printf("| 1 | %-48s|\n", "ADICIONAR UM PRODUTO");
        System.out.println("-".repeat(55));
        System.out.printf("| 2 | %-48s|\n", "ENCONTRAR O PRODUTO COM MAIOR VALOR DE VENDA");
        System.out.println("-".repeat(55));
        System.out.printf("| 3 | %-48s|\n", "ENCONTRAR O PRODUTO EM MAIOR QUANTIDADE");
        System.out.println("-".repeat(55));
        System.out.printf("| 4 | %-48s|\n", "ENCONTRAR PRODUTO POR ID");
        System.out.println("-".repeat(55));
        System.out.printf("| 5 | %-48s|\n", "ALTERAR O VALOR DE UM PRODUTO");
        System.out.println("-".repeat(55));
        System.out.printf("| 6 | %-48s|\n", "SAIR");
        System.out.println("-".repeat(55));
    }

    public static void mostrarProduto(Produto produto)
    {
        int n = Math.max(10 + produto.obterNome().length(), 60);
        int pts, disp = n - 11, atual = 0;
        String texto;

        System.out.println("-".repeat(n));
        System.out.printf("| %-6s| %d" + " ".repeat(n - 11 - Integer.toString(produto.obterID()).length()) + "|\n", "ID", produto.obterID());
        System.out.println("-".repeat(n));
        System.out.printf("| %-6s| %s" + " ".repeat(n - 11 - produto.obterNome().length()) + "|\n", "NOME", produto.obterNome());
        System.out.println("-".repeat(n));
        System.out.printf("| %-6s| %d" + " ".repeat(n - 11 - Integer.toString(produto.obterQuantidade()).length()) + "|\n", "QNT", produto.obterQuantidade());
        System.out.println("-".repeat(n));
        System.out.printf("| %-6s| %.2f" + " ".repeat(n - 14 - Integer.toString((int) produto.obterValor()).length()) + "|\n", "VALOR", produto.obterValor());
        System.out.println("-".repeat(n));

        pts = produto.obterDesc().length() / (disp-1) + 1;
        for(int i = 0; i < pts; i++)
        {
            texto = i != 0 ? " " : "DESC";
            if(i == pts - 1)
            {
                System.out.printf("| %-6s| %s" + " ".repeat(n - 11 - produto.obterDesc().substring(atual).length()) + "|\n", texto, produto.obterDesc().substring(atual));
            }
            else
            {
                System.out.printf("| %-6s| %s |\n", texto, produto.obterDesc().substring(atual, atual+disp-1));
                atual += disp-1;
            }
        }
        System.out.println("-".repeat(n));
    }

    public static Produto buscaProdutoPorId(Produto[] produtos, int index)
    {
        Scanner in = new Scanner(System.in);
        int idProduto = 0, i;
        
        System.out.print("\n> Digite o ID do produto: ");
        idProduto = in.nextInt();
        
        Produto produtoEncontrado = null;
        for(i = 0; i < index; i++)
        {
            Produto produtoAtual = produtos[i];
            if(produtoAtual.obterID() == idProduto)
            {
                produtoEncontrado = produtoAtual;
                break;
            }
        }
  
        return produtoEncontrado;
    }

    public static void adicionarProduto(Produto[] produtos, int index, int max)
    {
        Scanner in = new Scanner(System.in);
        int ID, qnt;
        double valor;
        String nome, desc;
        boolean valido = true;

        // Confere se o vetor esta cheio
        if(index == max)
        {
            System.out.println("> O vetor de produtos esta cheio.");
            return;
        }

        produtos[index] = new Produto();

        do
        {
            if(!valido)
                System.out.println("> Ao menos um dos campos e invalido, tente novamente.");

            System.out.print("> ID: ");
            ID = in.nextInt();
            in.nextLine();
            System.out.print("> Nome: ");
            nome = in.nextLine();
            System.out.print("> Quantidade: ");
            qnt = in.nextInt();
            System.out.print("> Valor: ");
            valor = in.nextDouble();
            in.nextLine();
            System.out.print("> Descricao: ");
            desc = in.nextLine();

            valido = produtos[index].alterarID(ID) && produtos[index].alterarNome(nome) && produtos[index].alterarQuantidade(qnt);
            valido = valido && produtos[index].alterarValor(valor) && produtos[index].alterarDesc(desc);

            if(valido)
            {
                for(int i = 0; i < index; i++)
                {
                    if(produtos[index].obterID() == produtos[i].obterID())  // Valida o ID
                    {
                        System.out.println("> O ID inserido ja pertence a outro produto.");
                        valido = false;
                    }
                }
            }
        } while(!valido);

        System.out.println("\n> Produto adicionado com sucesso.");
    }

    public static void buscaProdutoMaisCaro(Produto[] produtos, int index)
	{
		int i;

        if(index == 0)
            return;

	    Produto produtoEncontrado = produtos[0];
		for(i = 1; i < index; i++)
		{
			Produto produtoAtual = produtos[i];
			if(produtoEncontrado.obterValor() < produtoAtual.obterValor())  
			{
				produtoEncontrado = produtoAtual;
			}
		}
		
		mostrarProduto(produtoEncontrado);
    }

    public static void buscaProdutoMaiorQuantidade(Produto[] produtos, int index)
	{
		int i;

        if(index == 0)
            return;

		Produto produtoEncontrado = produtos[0];
		for(i = 1; i < index; i++)
		{
			Produto produtoAtual = produtos[i];
			if(produtoEncontrado.obterQuantidade() < produtoAtual.obterQuantidade())
			{
				produtoEncontrado = produtoAtual;
			}
		}
		
		mostrarProduto(produtoEncontrado);	
	}

    public static void alterarValorProduto(Produto produtoParaAlterar){
        Scanner in = new Scanner(System.in);
        
        System.out.printf("\n> Digite o novo valor para o produto '%s': ",produtoParaAlterar.obterNome());
        
        double novoValor = in.nextDouble();
        produtoParaAlterar.alterarValor(novoValor);
        
        System.out.printf("\n> Alterado o valor de '%s' para '%.2f' com sucesso!\n\n", produtoParaAlterar.obterNome(),produtoParaAlterar.obterValor());
    }
}
