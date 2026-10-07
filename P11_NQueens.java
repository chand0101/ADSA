import java.util.Arrays;
import java.util.Scanner;

public class P11_NQueens{
    static int n;
    static int[] board;

    public static boolean isSafe(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i] == col) {
                return false;
            }
            if (Math.abs(board[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }

    public static boolean solve(int row) {
        if (row == n) {
            return true;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(row, col)) {
                board[row] = col;

                if (solve(row + 1)) {
                    return true;
                }

                board[row] = -1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value of N: ");
        n = sc.nextInt();

        board = new int[n];
        Arrays.fill(board, -1);

        if (solve(0)) {
            System.out.println("Solution:");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i] == j) {
                        System.out.print("Q ");
                    } else {
                        System.out.print(". ");
                    }
                }
                System.out.println();
            }
        } else {
            System.out.println("No solution exists");
        }

        sc.close();
    }
}