package Algorithm_DataStructures.Exercise7.Financial_Forecasting;

public class FutureValueCalculator {

    // Recursive method to calculate the future value based on past growth rates
    public static double calculateFutureValue(double presentValue, double growthRate, int years) {
        if (years == 0) {
            return presentValue;
        } else {
            double futureValue = presentValue * (1 + growthRate);
            return calculateFutureValue(futureValue, growthRate, years - 1);
        }
    }

    public static void main(String[] args) {
        double presentValue = 1000.0; // Initial investment
        double growthRate = 0.05; // Growth rate per year
        int years = 5; // Number of years into the future

        double futureValue = calculateFutureValue(presentValue, growthRate, years);

        System.out.printf("The future value after %d years is: %.2f", years, futureValue);
    }
}

