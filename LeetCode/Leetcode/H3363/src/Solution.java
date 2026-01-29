public class Solution {
    public int maxCollectedFruits(int[][] fruits) {
        int n=fruits.length;
        int ans=0;
        for(int i=0;i<n;++i){
            ans+=fruits[i][i];
        }

        int[][] dp=new int[n][n];

        dp[0][n-1]=fruits[0][n-1];
        for(int i=1;i<=n-2;++i){
            for(int j=n-1;j>i;--j){
                int l=Math.max(i,j-1),r=Math.min(n-1,j+1);
                dp[i][j]=Math.max(dp[i-1][j],Math.max(dp[i-1][l],dp[i-1][r]));
                dp[i][j]+=fruits[i][j];
            }
        }
        ans+=dp[n-2][n-1];


        dp[n-1][0]=fruits[n-1][0];
        for(int i=1;i<=n-2;++i){
            for(int j=n-1;j>i;--j){
                int l=Math.max(i,j-1),r=Math.min(n-1,j+1);
                dp[j][i]=Math.max(dp[j][i-1],Math.max(dp[l][i-1],dp[r][i-1]));
                dp[j][i]+=fruits[j][i];
            }
        }
        ans+=dp[n-1][n-2];

        return ans;
    }
}

