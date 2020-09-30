package leetCode;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        return coinChangeHelper(memo, coins, amount);
    }

    private int coinChangeHelper(int[] memo, int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }

        if (amount == 0) {
            return 0;
        }

        if (memo[amount] != 0) {
            return memo[amount];
        }

        int min = Integer.MAX_VALUE;

        for (int coin : coins) {
            int coinChange = coinChangeHelper(memo, coins, amount - coin);
            if (coinChange >= 0 && coinChange < min) {
                min = 1 + coinChange;
            }
        }

        memo[amount] = min == Integer.MAX_VALUE ? -1 : min;
        return memo[amount];
    }
}
