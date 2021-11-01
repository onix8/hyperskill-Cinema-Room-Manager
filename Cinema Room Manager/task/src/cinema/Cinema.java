package cinema;

public class Cinema {

    static char[][] room = {
            {'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S'},
            {'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S'},
            {'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S'},
            {'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S'},
            {'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S'},
            {'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S'},
            {'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S'}
    };

    public static void main(String[] args) {
        printRoom();
    }

    private static void printRoom() {
        System.out.println("Cinema:\n  1 2 3 4 5 6 7 8 ");
        for (int i = 0; i < room.length; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < room[i].length; j++) {
                System.out.print(" " + room[i][j]);
            }
            System.out.println();
        }
    }
}
