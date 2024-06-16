package trabalhoa3psc;

import java.util.Scanner;

/**
 * Classe principal do sistema de gerenciamento da loja de produtos eletrônicos.
 * A classe fornece um menu de opções para adicionar, vender, listar, atualizar
 * a quantidade e excluir produtos.
 */
public class TrabalhoA3PSC {

    /**
     * Método principal que executa o sistema de gerenciamento da loja.
     *
     */
    public static void main(String[] args) {
        // cria uma instância da loja para gerenciar os produtos
        Loja loja = new Loja();
        // scanner para leitura de entrada do usuário
        Scanner entrada = new Scanner(System.in);
        int opcao;
        // loop do menu principal do sistema/ Foi usado Do while por mais compatibilidade com o sistema 
        do {
            //Menu de Opções(6 ao todo)
            System.out.println("=== Menu ===");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Vender Produto");
            System.out.println("3. Listar Produtos");
            System.out.println("4. Atualizar Quantidade de Produto");
            System.out.println("5. Excluir Produto");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = entrada.nextInt();//le a opção escolhida pelo usuário
            entrada.nextLine(); // consumir a nova linha após o número

            // switch case vai tratar a opção escolhida pelo usuário
            switch (opcao) {
                case 1:
                    // Adicionar Produto
                    System.out.print("Nome do Produto: ");
                    String nomeProduto = entrada.nextLine();// lê o nome do produto
                    System.out.print("Código do Produto: ");
                    String codigoProduto = entrada.nextLine();// lê o código do produto
                    System.out.print("Preço do Produto: ");
                    double precoProduto = entrada.nextDouble();// lê o preço do produto
                    System.out.print("Quantidade em Estoque: ");
                    int quantidadeProduto = entrada.nextInt();// lê a quantidade em estoque
                    entrada.nextLine(); // consumir a nova linha após a quantidade
                    
                    // solicita ao usuário que selecione o tipo do produto
                    System.out.println("Selecione o tipo do produto:");
                    TipoProdutoEletronico.listarTipos();// lista os tipos disponíveis
                    int tipoProdutoIndice = entrada.nextInt();// lê o índice do tipo selecionado
                    entrada.nextLine();
                    TipoProdutoEletronico.Tipo tipoProduto;
                    try {
                         // obtém o tipo do produto baseado no índice fornecido pelo usuário
                        tipoProduto = TipoProdutoEletronico.obterTipoPorIndice(tipoProdutoIndice);
                    } catch (IllegalArgumentException e) {
                        // caso o índice seja inválido, informa ao usuário e interrompe a adição do produto
                        System.out.println("Índice inválido! Produto não adicionado.");
                        break;
                    }
                    // cria uma instância do produto com as informações fornecidas
                    Produto produto = new Produto(nomeProduto, codigoProduto, precoProduto, quantidadeProduto, tipoProduto);
                    loja.adicionarProduto(produto);
                    System.out.println("Produto adicionado com sucesso.");
                    break;
                case 2:
                    // Vender Produto
                    System.out.print("Código do Produto a ser vendido: ");
                    String codigoVenda = entrada.nextLine(); // lê o código do produto a ser vendido
                    System.out.print("Nome do Cliente: ");
                    String nomeCliente = entrada.nextLine();// lê o nome do cliente
                    Cliente cliente = new Cliente(nomeCliente, 1);// cria uma instância do cliente (ID é fixo como 1 neste exemplo)
                    loja.venderProduto(codigoVenda, cliente);// realiza a venda do produto
                    break;
                case 3:
                    // Listar Produtos
                    loja.listarProdutos();
                    break;
                case 4:
                    // Atualizar Quantidade de Produto
                    System.out.print("Código do Produto a ser atualizado: ");
                    String codigoAtualizar = entrada.nextLine();// lê o código do produto a ser atualizado
                    System.out.print("Quantidade a ser adicionada: ");
                    int quantidadeAdicionar = entrada.nextInt();// lê a quantidade a ser adicionada ao estoque
                    entrada.nextLine();
                    loja.atualizarQuantidadeProduto(codigoAtualizar, quantidadeAdicionar);// atualiza a quantidade do produto
                    break;
                case 5:
                    // Excluir Produto
                    System.out.print("Código do Produto a ser excluído: ");
                    String codigoExcluir = entrada.nextLine();// lê o código do produto a ser excluído
                    loja.excluirProduto(codigoExcluir); // exclui o produto da loja
                    break;
                case 6:
                    //sair 
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 6); // continua executando até que essa opção seja escolhida

        entrada.close();  // fechar o scanner/encerrar o programa.
    }
}
