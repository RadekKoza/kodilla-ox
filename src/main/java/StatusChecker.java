public class StatusChecker {

    private String theWinner = "no winner";
    private boolean end = false;

    private void isLineFinished(String mark, int marksNumber, int size) {
        int winLength = 5;
        if (marksNumber == winLength || marksNumber == size) {
            theWinner = mark;
            end = true;
        }
    }

    public boolean check(char[][] oxTable) {
        String mark;
        int emptyCount = 0;
        int marksNumber;
        int size = oxTable.length;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                marksNumber = 0;

                if (oxTable[i][j] != ' ') {
                    mark = String.valueOf(oxTable[i][j]);

                    while (j + marksNumber < size && oxTable[i][j] == oxTable[i][j + marksNumber])
                        marksNumber += 1;
                    isLineFinished(mark, marksNumber, size);
                    marksNumber = 0;

                    while (i + marksNumber < size && oxTable[i][j] == oxTable[i + marksNumber][j])
                        marksNumber += 1;
                    isLineFinished(mark, marksNumber, size);
                    marksNumber = 0;

                    while (i + marksNumber < size && j + marksNumber < size
                            && oxTable[i][j] == oxTable[i + marksNumber][j + marksNumber])
                        marksNumber += 1;
                    isLineFinished(mark, marksNumber, size);
                    marksNumber = 0;

                    while (i + marksNumber < size && j - marksNumber >= 0
                            && oxTable[i][j] == oxTable[i + marksNumber][j - marksNumber])
                        marksNumber += 1;
                    isLineFinished(mark, marksNumber, size);

                } else emptyCount++;
            }
        }

        if (emptyCount == 0) {
            end = true;
        }
        return end;
    }

    public String getTheWinner() {
        return theWinner;
    }
}