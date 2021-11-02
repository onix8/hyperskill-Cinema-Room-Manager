package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {

        int rows;
        int seats;
        int income;
        int totalSeats;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        rows = sc.nextInt();
        System.out.println("Enter the number of seats in each row:");
        seats = sc.nextInt();

        totalSeats = rows * seats;
        income = totalSeats <= 60 ? totalSeats * 10 : ((rows / 2) * seats * 10) + ((rows - (rows / 2)) * seats * 8);

        System.out.println("Total income:");
        System.out.println("$" + income);
    }
}
