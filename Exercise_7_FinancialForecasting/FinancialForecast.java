import java.util.Random;

public class FinancialForecast {
    private double[] generateRevenueData(int months) {
        double[] data = new double[months];
        Random rand = new Random();
        for (int i = 0; i < months; i++) {
            data[i] = 1000 + rand.nextDouble() * 1000; // Random revenue between 1000 and 2000
        }
        return data;
    }

    private double calculateAverage(double[] data) {
        double sum = 0;
        for (double value : data) {
            sum += value;
        }
        return sum / data.length;
    }

    public void forecast() {
        double[] revenueData = generateRevenueData(12); // Forecast for 12 months
        double avg = calculateAverage(revenueData);
        System.out.println("Monthly Revenue Forecast:");
        for (int i = 0; i < revenueData.length; i++) {
            System.out.printf("Month %d: $%.2f%n", (i + 1), revenueData[i]);
        }
        System.out.printf("Average Monthly Revenue: $%.2f%n", avg);
    }

    public static void main(String[] args) {
        FinancialForecast forecast = new FinancialForecast();
        forecast.forecast();
    }
}