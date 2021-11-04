package cinema;

import java.util.Scanner;

public class Cinema {

    static char[][] room;
    static int rows;
    static int seats;

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        setRoom();
        showMenu();
    }

    private static void showMenu() {
        int item;
        while (true) {
            System.out.println(
                    "1. Show the seats\n" +
                            "2. Buy a ticket\n" +
                            "3. Statistics\n" +
                            "0. Exit");
            item = sc.nextInt();
            System.out.println();
            switch (item) {
                case 1:
                    printRoom();
                    continue;
                case 2:
                    buySeat();
                    continue;
                case 3:
                    printStatistics();
                    continue;
                case 0:
                    return;
            }
        }
    }

    private static void printStatistics() {
        int numberOfPurchasedTickets = 0;
        double percentageOfPurchasedTickets;
        int currentIncome = 0;
        int totalIncome;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seats; j++) {
                if ('B' == room[i][j]) {
                    numberOfPurchasedTickets++;
                    currentIncome += getPrice(i + 1);
                }
            }
        }

        totalIncome = rows * seats <= 60
                ? rows * seats * 10
                : ((rows / 2) * seats * 10) + ((rows - (rows / 2)) * seats * 8);

        percentageOfPurchasedTickets = (double) (numberOfPurchasedTickets * 100) / (room.length * room[0].length);

        System.out.printf(
                "Number of purchased tickets: %d%n" +
                        "Percentage: %.2f%%%n" +
                        "Current income: $%d%n" +
                        "Total income: $%d%n%n",
                numberOfPurchasedTickets,
                percentageOfPurchasedTickets,
                currentIncome,
                totalIncome);
    }

    private static void buySeat() {
        int row;
        int seat;
        int price;

        while (true) {
            System.out.println("Enter a row number:");
            row = sc.nextInt();
            System.out.println("Enter a seat number in that row:");
            seat = sc.nextInt();

            try {
                if (room[row - 1][seat - 1] == 'B') {
                    System.out.println("That ticket has already been purchased!");
                } else {
                    room[row - 1][seat - 1] = 'B';
                    break;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Wrong input!");
            }
        }

        price = getPrice(row);
        System.out.printf("Ticket price: $%d\n\n", price);
    }

    private static int getPrice(int row) {
        return rows * seats <= 60 ? 10 : rows / 2 < row ? 8 : 10;
    }

    private static void printRoom() {
        System.out.print("Cinema:\n ");
        for (int i = 1; i <= seats; i++) {
            System.out.print(" " + i);
        }
        System.out.println();

        for (int i = 0; i < rows; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < seats; j++) {
                System.out.print(" " + room[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void setRoom() {
        System.out.println("Enter the number of rows:");
        rows = sc.nextInt();
        System.out.println("Enter the number of seats in each row:");
        seats = sc.nextInt();

        room = new char[rows][seats];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seats; j++) {
                room[i][j] = 'S';
            }
        }
        System.out.println();
    }
}
