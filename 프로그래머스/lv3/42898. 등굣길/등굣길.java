import java.awt.*;
import java.util.*;
class Solution {
    static int[][] dp;
    static int NUM = 1000000007;
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        dp = new int[n][m];
       
        
        for(int[] pud:puddles){
            dp[pud[1]-1][pud[0]-1] = -1;
        }
        find(n,m);
        
        return dp[n-1][m-1] % NUM;
    }
    
    public void find(int n, int m){
        dp[0][0] = 1;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(dp[i][j] == -1) continue; // 물웅덩이
                if(i-1>=0 && dp[i-1][j]!=-1) dp[i][j] += dp[i-1][j] % NUM;
                if(j-1>=0 && dp[i][j-1]!=-1) dp[i][j] += dp[i][j-1] % NUM;
                
            }
        }
    }
    
}