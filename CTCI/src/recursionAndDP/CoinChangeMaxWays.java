package recursionAndDP;

import java.util.HashMap;

public class CoinChangeMaxWays {

	public static int makeChange(int coins[], int money)
	{
		return makeChangeCoins(coins, money, 0,  new HashMap<String,Integer>());
	}
	
	public static int makeChangeCoins(int coins[], int money, int index, HashMap<String,Integer> map)
	{
		if(money==0) return 1;
		if(index>=coins.length)	return 0;
		int amountWithCurrentCoin=0;
		int ways=0;
		String key=money+"-"+coins[index];
		if(map.containsKey(key))
			return map.get(key);
		while(amountWithCurrentCoin<=money)
		{
			int remaining=money-amountWithCurrentCoin;
			ways+=makeChangeCoins(coins,remaining,index+1,map);
			amountWithCurrentCoin+=coins[index];
		}
		map.put(key,ways);
		return ways;
	}
	
	public static void main(String[] args) {
		int coins[]= {1,2,5,10};
		
		System.out.println(makeChange(coins, 12));
	}

}
