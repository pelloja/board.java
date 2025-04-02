import java.util.ArrayList;
import java.util.List;

public class board {
    private int id;
    private String nome;
    private List<coluna> colunas;

    public board(String nome) {
        this.nome = nome;
        this.colunas = new ArrayList<>();
    }

    public board(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.colunas = new ArrayList<>();
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

    public List<coluna> getColunas() {
        return colunas;
    }

    public void setColunas(List<coluna> colunas) {
        this.colunas = colunas;
    }
}
