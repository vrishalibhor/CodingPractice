package recursionAndDP;

import java.util.Arrays;

/*You are given coins of different denominations and a total amount of money amount.
Write a function to compute the fewest number of coins that you need to make up that 
amount. If that amount of money cannot be made up by any combination of the coins, return -1.*/

public class CoinChangeMinCoins {

	public static int coinChange(int[] coins, int amount) {
        int dp[]=new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for(int amt=1;amt<=amount;amt++)
        {
            for(int currentCoin=0;currentCoin<coins.length;currentCoin++)
            {
                if(coins[currentCoin]<=amt)
                {
                    dp[amt]=Math.min(dp[amt],dp[amt-coins[currentCoin]]+1);
                }
            }
        }
        if(dp[amount]>amount)
            return -1;
        else
            return dp[amount];
    }
	
	public static void main(String[] args) {
		int coins[]= {5,10};
		
		System.out.println(coinChange(coins, 11));
	}
}
