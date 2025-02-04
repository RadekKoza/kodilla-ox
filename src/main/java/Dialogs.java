import java.util.Scanner;

public class Dialogs {
private int size;

    public int getSize() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter board size from 3 to 20: ");
        size = 0;
        while (size == 0) {
            if (scanner.hasNextInt()) {
                size = scanner.nextInt();
                if (size < 3 || size > 20) {
                    System.out.println("Invalid board size. Please enter number between 3 and 20: ");
                    size = 0;
                }
            } else {
                System.out.println("Wrong input. Please enter number between 3 and 20: ");
                scanner.nextLine();
            }
        }
        return size;
    }

    public int[] playerInput(char mark) {
        Scanner scanner = new Scanner(System.in);
        String[] xyCoordinates;
        int[] xyCoord = new int[2];
        int x;
        int y;

        while (true) {
            try {
                System.out.println("'" + mark + "'" + " turn - enter xy coordinates separated by space: ");
                String xy = scanner.nextLine().trim();
                xy = xy.replaceAll("[^0-9]", " ");
                xy = xy.replaceAll(" +", " ");
                xyCoordinates = xy.split(" ");
                x = Integer.parseInt(xyCoordinates[0]);
                y = Integer.parseInt(xyCoordinates[1]);
                if (x > size - 1 || y > size - 1 || x < 0 || y < 0) {
                    System.out.println("That coordinates are out of bounds. Try again.");
                } else {
                    xyCoord[0] = x;
                    xyCoord[1] = y;
                    return xyCoord;
                }
            } catch (Exception e) {
                System.out.println("At least one of the coordinates is incorrect. Try again.");
            }
        }
    }

    public void occupied() {
        System.out.println("Dear player - the field is occupied! Please try again");
    }

    public void lineFinished(String theWinner) {
        System.out.println("The winner is : " + theWinner);
    }
}