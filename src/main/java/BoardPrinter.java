public class BoardPrinter {

    private final Board board;

    public BoardPrinter(Board board) {
        this.board = board;
    }

    public void showBoard() {
        int size = board.getSize();
        System.out.print("\\ y ");
        for (int n = 0; n < size ; n++)
            System.out.print(n/10 + " ");
        System.out.println();
        System.out.print("x \\ ");
        for (int n = 0; n < size ; n++)
            System.out.print(n%10 + " ");
        System.out.println();

        for (int i = 0; i < size; i++) {
            System.out.print(i/10 + "" + i%10 + " ");
            for (int j = 0; j < size; j++) {
                System.out.print("|" + board.getTable()[i][j]);
            }
            System.out.println("|");
        }
    }
}