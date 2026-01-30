import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CloudCostEstimator {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter VM size (small/medium/large): ");
        String vmSize = sc.next();

        System.out.print("Enter usage hours per month: ");
        int hours = sc.nextInt();

        System.out.print("Enter storage (GB): ");
        int storage = sc.nextInt();

        double vmRate = switch (vmSize) {
            case "small" -> 0.02;
            case "medium" -> 0.05;
            case "large" -> 0.10;
            default -> 0;
        };

        double vmCost = vmRate * hours;
        double storageCost = storage * 0.01;
        double total = vmCost + storageCost;

        FileWriter writer = new FileWriter("cloud_cost_report.csv");
        writer.write("VM Size,Hours,Storage,VM Cost,Storage Cost,Total Cost\n");
        writer.write(vmSize + "," + hours + "," + storage + "," + vmCost + "," + storageCost + "," + total);
        writer.close();

        System.out.println("Total Monthly Cost: $" + total);
    }
}
