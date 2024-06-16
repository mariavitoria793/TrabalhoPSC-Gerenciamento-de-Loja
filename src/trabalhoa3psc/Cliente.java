package trabalhoa3psc;

/**
 * Classe que representa um cliente na loja. Essa classe contém informações do
 * cliente.
 */
public class Cliente {

    private String nome;
    private int id;

    /**
     * Construtor da classe Cliente. Inicializa um novo cliente com o nome e ID
     * fornecidos.
     *
     * @param nome Nome do cliente
     * @param id ID do cliente
     */
    public Cliente(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }

    /**
     * Obtém o nome do cliente.
     *
     * @return O nome do cliente
     */
    public String getNome() {
        return nome;
    }

    /**
     * Obtém o ID do cliente.
     *
     * @return O ID do cliente
     */
    public int getId() {
        return id;
    }
}
