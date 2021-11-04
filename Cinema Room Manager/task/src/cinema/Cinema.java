package cinema;

import java.util.Scanner;

public class Cinema {

    static Scanner sc = new Scanner(System.in);
    static char[][] room;

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
                            "0. Exit"
            );
            item = sc.nextInt();
            System.out.println();
            switch (item) {
                case 1:
                    printRoom();
                    continue;
                case 2:
                    buySeat();
                    continue;
                case 0:
                    return;
            }
        }
    }

    private static void buySeat() {
        int row;
        int seat;
        int price;

        System.out.println("Enter a row number:");
        row = sc.nextInt();
        System.out.println("Enter a seat number in that row:");
        seat = sc.nextInt();

        room[row - 1][seat - 1] = 'B';

        price = room.length * room[0].length <= 60 ? 10 : room.length / 2 < row ? 8 : 10;
        System.out.printf("Ticket price: $%d\n\n", price);
    }

    private static void printRoom() {
        int rows = room.length;
        int seats = room[0].length;

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
        int rows;
        int seats;

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
