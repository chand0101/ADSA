import java.util.Arrays;
import java.util.Scanner;

public class HashFunction_02 {
    static int size = 10;
    static int[] table = new int[size];

    public static int hashFunc(int key) {
        return key % size;
    }

    public static void insert(int key) {
        int index = hashFunc(key);

        while (table[index] != -1) {
            index = (index + 1) % size;
        }

        table[index] = key;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Arrays.fill(table, -1);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter key: ");
            int key = sc.nextInt();
            insert(key);
        }

        System.out.println("Hash table:");
        for (int i = 0; i < size; i++) {
            System.out.println(i + " : " + table[i]);
        }
        sc.close();
    }
}