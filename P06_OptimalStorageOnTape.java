import java.util.*;

public class P06_OptimalStorageOnTape {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of programs: ");
        int n = sc.nextInt();

        List<Integer> programs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter program length: ");
            int length = sc.nextInt();
            programs.add(length);
        }

        Collections.sort(programs);

        System.out.println("Optimal storage order:");
        for (int length : programs) {
            System.out.print(length + " ");
        }

        double totalTime = 0;
        double currentTime = 0;

        for (int length : programs) {
            currentTime += length;
            totalTime += currentTime;
        }

        double mrt = totalTime / n;

        System.out.println("\nMean Retrieval Time: " + mrt);

        sc.close();
    }
}