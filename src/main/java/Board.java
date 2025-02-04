public class Board {
    private char[][] oxTable;
    private final int size;

    public Board(int size) {
        this.size = size;
    }

    public void create() {
        oxTable = new char[size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                oxTable[i][j] = ' ';
    }

    public boolean xyInput(int [] coordinates, char playerKey) {
        boolean allowed = true;
        Dialogs dialogs = new Dialogs();

        if (oxTable[coordinates[0]][coordinates[1]] == ' ')
            oxTable[coordinates[0]][coordinates[1]] = playerKey;
        else {
            dialogs.occupied();
            allowed = false;
        }
        return allowed;
    }

    public int getSize() {
        return size;
    }

    public char[][] getTable() {
        return oxTable;
    }
}
