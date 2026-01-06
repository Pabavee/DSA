// RabbitProblem.java
public class RabbitProblem {

    public static long countRabbitPairs(int months) {
        if (months <= 0) return 0;
        if (months == 1 || months == 2) return 1;

        long[] dp = new long[months + 1];
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= months; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[months];
    }

    public static void main(String[] args) {
        System.out.println("Month   Pairs");
        System.out.println("---------------");

        for (int month = 0; month <= 20; month++) {
            System.out.printf("%5d   %,12d%n", month, countRabbitPairs(month));
        }
    }
}
