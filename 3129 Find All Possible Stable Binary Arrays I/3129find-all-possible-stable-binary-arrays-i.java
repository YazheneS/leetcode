class Solution {

    Integer[][][][] dp;
    int MOD = 1000000007;

    public int numberOfStableArrays(int zero, int one, int limit) {
        dp = new Integer[zero+1][one+1][2][limit+1];
        return backtrack(zero, one, limit, -1, 0);
    }

    int backtrack(int zero, int one, int limit, int last, int cons) {

        if (zero == 0 && one == 0)
            return 1;

        if(last != -1 && dp[zero][one][last][cons] != null)
            return dp[zero][one][last][cons];

        int count = 0;

        if (zero > 0) {
            if (last != 0 || cons < limit) {
                count = (count + backtrack(zero - 1, one, limit, 0, last == 0 ? cons + 1 : 1)) % MOD;
            }
        }

        if (one > 0) {
            if (last != 1 || cons < limit) {
                count = (count + backtrack(zero, one - 1, limit, 1, last == 1 ? cons + 1 : 1)) % MOD;
            }
        }

        if(last != -1)
            dp[zero][one][last][cons] = count;

        return count;
    }
}