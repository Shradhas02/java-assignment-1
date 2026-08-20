import java.util.Scanner;

public class FCFSScheduling {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        int[] pid = new int[n];
        int[] arrival = new int[n];
        int[] burst = new int[n];
        int[] completion = new int[n];
        int[] turnaround = new int[n];
        int[] waiting = new int[n];

        for (int i = 0; i < n; i++) {
            pid[i] = i + 1;
            System.out.print("Arrival time of P" + pid[i] + ": ");
            arrival[i] = sc.nextInt();
            System.out.print("Burst time of P" + pid[i] + ": ");
            burst[i] = sc.nextInt();
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arrival[j] > arrival[j + 1]) {
                    int t;
                    t = arrival[j]; arrival[j] = arrival[j+1]; arrival[j+1] = t;
                    t = burst[j]; burst[j] = burst[j+1]; burst[j+1] = t;
                    t = pid[j]; pid[j] = pid[j+1]; pid[j+1] = t;
                }
            }
        }

        int time = 0;
        for (int i = 0; i < n; i++) {
            if (time < arrival[i]) time = arrival[i];
            time += burst[i];
            completion[i] = time;
            turnaround[i] = completion[i] - arrival[i];
            waiting[i] = turnaround[i] - burst[i];
        }

        System.out.println("\nPID\tArrival\tBurst\tCompletion\tTurnaround\tWaiting");
        double totalTAT = 0, totalWT = 0;
        for (int i = 0; i < n; i++) {
            System.out.println("P" + pid[i] + "\t" + arrival[i] + "\t" + burst[i] + "\t"
                    + completion[i] + "\t\t" + turnaround[i] + "\t\t" + waiting[i]);
            totalTAT += turnaround[i];
            totalWT += waiting[i];
        }
        System.out.printf("\nAverage Turnaround Time: %.2f", totalTAT / n);
        System.out.printf("\nAverage Waiting Time: %.2f%n", totalWT / n);
        sc.close();
    }
}