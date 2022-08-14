import java.util.Scanner;

public class SeaBittle {
    static String playerOne = "Evgenii ";
    static String playerTwo;
    static Scanner scanner = new Scanner(System.in);
    static int[][] seaBittleOne = new int[10][10];
    static int[][] seaBittleTwo = new int[10][10];
    static int[][] monitirOne = new int[10][10];
    static int[][] monitorTwo = new int[10][10];

    public static void main(String[] args) {
        System.out.println("Player#1: Please enter your name:");
        playerOne = scanner.nextLine();
        System.out.println("Player#2: Please enter your name:");
        playerTwo = scanner.nextLine();
        placeShips(playerOne, seaBittleOne);
        placeShips(playerTwo, seaBittleTwo);
        boolean endGame = false;
        do {
            makeTurn(playerOne, monitirOne, seaBittleTwo);
            makeTurn(playerTwo, monitorTwo, seaBittleOne);
        } while (!endGame);

    }

    public static void placeShips(String playerName, int[][] Bittle) {
        int countDeck = 4;
        while (countDeck >= 1) {
            System.out.println(playerName + "Please place your " + countDeck + " deck ships on the deck:");
            field(Bittle);
            System.out.println("Please enter OX coordinate: ");
            int OX = scanner.nextInt();
            System.out.println("Please enter OY coordinate: ");
            int OY = scanner.nextInt();
            System.out.println("Choose direction: ");
            System.out.println("1. Vertical");
            System.out.println("2. Horizontal");
            int directoin = scanner.nextInt();

            for (int i = 0; i < countDeck; i++) {
                if (directoin == 1) {
                    Bittle[OX][OY + i] = 1;
                } else {
                    Bittle[OX + i][OY] = 1;
                }
            }
            countDeck--;
        }
    }

    public static void field(int[][] dittle) {
        System.out.print("  0 1 2 3 4 5 6 7 8 9");
        for (int i = 0; i < dittle.length; i++) {
            System.out.println("");
            System.out.print(i + " ");
            for (int j = 0; j < dittle[i].length; j++) {
                if (dittle[j][i] == 0) {
                    System.out.print("- ");
                } else {
                    System.out.print("X ");
                }
            }
        }
    }

    public static void makeTurn(String playerName, int[][] monitor, int[][] Bittle) {
        while (true) {
            System.out.println(playerName + "Please, make your turn. ");
            System.out.print("  0 1 2 3 4 5 6 7 8 9");
            for (int i = 0; i < monitor.length; i++) {
                System.out.println("");
                System.out.print(i + " ");
                for (int j = 0; j < monitor[i].length; j++) {
                    if (monitor[j][i] == 0) {
                        System.out.print("- ");
                    } else if (monitor[j][i] == 1) {
                        System.out.print("* ");
                    } else {
                        System.out.print("X ");
                    }
                }
            }
            System.out.println("Please enter OX coordinate: ");
            int OX = scanner.nextInt();
            System.out.println("Please enter OY coordinate: ");
            int OY = scanner.nextInt();
            if (Bittle[OY][OX] == 1) {
                System.out.println("Hit! Make your turn again!");
                monitor[OY][OX] = 2;
            } else {
                System.out.println("Miss! Your opponent turn!");
                monitor[OY][OX] = 1;
                break;
            }
        }
    }
}
