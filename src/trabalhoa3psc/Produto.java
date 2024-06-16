package trabalhoa3psc;

/**
 * Classe que representa um produto eletrônico na loja.
 */
public class Produto {

    private int id;
    private String nome;
    private String codigo;
    private double preco;
    private int quantidade;
    private TipoProdutoEletronico.Tipo tipo;

    /**
     * Construtor da classe Produto.
     *
     * @param nome Nome do produto
     * @param codigo Código do produto
     * @param preco Preço do produto
     * @param quantidade Quantidade do produto em estoque
     * @param tipo Tipo do produto (eletrônico)
     */
    public Produto(String nome, String codigo, double preco, int quantidade, TipoProdutoEletronico.Tipo tipo) {
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
        this.quantidade = quantidade;
        this.tipo = tipo;
    }

    /**
     * Obtém o ID do produto.
     *
     * @return O ID do produto
     */
    public int getId() {
        return id;
    }

    /**
     * Define o ID do produto.
     *
     * @param id O ID do produto
     */

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtém o nome do produto.
     *
     * @return O nome do produto
     */
    public String getNome() {
        return nome;
    }

    /**
     * Obtém o código do produto.
     *
     * @return O código do produto
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Obtém o preço do produto.
     *
     * @return O preço do produto
     */
    public double getPreco() {
        return preco;
    }

    /**
     * Obtém a quantidade do produto em estoque.
     *
     * @return A quantidade do produto em estoque
     */

    public int getQuantidade() {
        return quantidade;
    }

    /**
     * Obtém o tipo do produto.
     *
     * @return O tipo do produto
     */
    public TipoProdutoEletronico.Tipo getTipo() {
        return tipo;
    }

    /**
     * Retorna uma representação em String do produto.
     *
     * @return Uma string que representa o produto
     */
    @Override
    public String toString() {
        return "Produto [id=" + id + ", nome=" + nome + ", codigo=" + codigo + ", preco=" + preco
                + ", quantidade=" + quantidade + ", tipo=" + tipo + "]";
    }
}
