import java.sql.SQLException;
import java.util.Scanner;

public class main {
    public main (String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Menu:");
            System.out.println("1 - Criar novo board");
            System.out.println("2 - Selecionar board");
            System.out.println("3 - Excluir board");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    criarNovoBoard(scanner);
                    break;
                case 3:
                    excluirBoard(scanner);
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 4);

        scanner.close();
    }

    public static void criarNovoBoard(Scanner scanner) throws SQLException {
        System.out.print("Digite o nome do novo board: ");
        String nomeBoard = scanner.nextLine();

        board board = new board(nomeBoard);
        Database.salvarBoard(board);

        // Criando colunas padrão para o board
        coluna colunaInicial = new coluna("A Fazer", "Inicial", 1, board);
        coluna colunaFinal = new coluna("Concluído", "Final", 2, board);
        coluna colunaCancelada = new coluna("Cancelado", "Cancelamento", 3, board);

        Database.salvarColuna(colunaInicial);
        Database.salvarColuna(colunaFinal);
        Database.salvarColuna(colunaCancelada);

        System.out.println("Novo board criado com sucesso. ID: " + board.getId());
    }

    public static void excluirBoard(Scanner scanner) throws SQLException {
        System.out.print("Digite o ID do board a ser excluído: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        Database.excluirBoard(id);

        System.out.println("Board excluído com sucesso.");
    }
}
