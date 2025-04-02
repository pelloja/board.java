public class coluna {
    private int id;
    private String nome;
    private String tipo;
    private int ordem;
    private board board;

    public coluna(String nome, String tipo, int ordem, board board) {
        this.nome = nome;
        this.tipo = tipo;
        this.ordem = ordem;
        this.board = board;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getOrdem() {
        return ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }

    public board getBoard() {
        return board;
    }

    public void setBoard(board board) {
        this.board = board;
    }
}
