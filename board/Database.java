import java.sql.*;

public class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/board_db";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void salvarBoard(board board) throws SQLException {
        String query = "INSERT INTO boards (nome) VALUES (?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, board.getNome());
            stmt.executeUpdate();

            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                board.setId(generatedKeys.getInt(1));
            }
        }
    }

    public static void salvarColuna(coluna coluna) throws SQLException {
        String query = "INSERT INTO colunas (nome, tipo, ordem, board_id) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, coluna.getNome());
            stmt.setString(2, coluna.getTipo());
            stmt.setInt(3, coluna.getOrdem());
            stmt.setInt(4, coluna.getBoard().getId());
            stmt.executeUpdate();
        }
    }

    public static void excluirBoard(int id) throws SQLException {
        String query = "DELETE FROM boards WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
