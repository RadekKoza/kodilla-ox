public class OXGame {

    public static final char FIRST_PLAYER = 'o';
    public static final char SECOND_PLAYER = 'x';

    public static void main(String[] args) {

        Dialogs dialogs = new Dialogs();
        int size = dialogs.getSize();
        boolean end = false;
        char player = FIRST_PLAYER;
        int[] coordinates;
        Board board = new Board(size);
        board.create();
        BoardPrinter boardPrinter = new BoardPrinter(board);
        boardPrinter.showBoard();
        StatusChecker statusChecker = new StatusChecker();

        while (!end) {
            switch (player) {
                case FIRST_PLAYER: {
                    coordinates = dialogs.playerInput(FIRST_PLAYER);
                    if (board.xyInput(coordinates, FIRST_PLAYER))
                        player = SECOND_PLAYER;
                }
                break;

                case SECOND_PLAYER: {
                    coordinates = dialogs.playerInput(SECOND_PLAYER);
                    if (board.xyInput(coordinates, SECOND_PLAYER))
                        player = FIRST_PLAYER;
                }
            }

            boardPrinter.showBoard();

            if (statusChecker.check(board.getTable())) {
                dialogs.lineFinished(statusChecker.getTheWinner());
                end = statusChecker.check(board.getTable());
            }
        }
    }
}