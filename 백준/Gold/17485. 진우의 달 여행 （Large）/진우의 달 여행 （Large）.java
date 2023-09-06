import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        int[][][] dp = new int[N][M][3];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                for(int k=0; k<3; k++){
                    dp[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        for(int i=0; i<M; i++){
            for(int j=0; j<3; j++){
                dp[0][i][j] = map[0][i];
            }
        }


        for(int i=1; i<N; i++){
            for(int j=0; j<M; j++){
                if(j==0){
                    dp[i][j][1] = dp[i-1][j+1][0] + map[i][j];
                    dp[i][j][2] = Math.min(dp[i-1][j][1],dp[i-1][j+1][0]) + map[i][j];
                }
                else if(j==M-1){
                    dp[i][j][0] = Math.min(dp[i-1][j-1][2], dp[i-1][j][1]) + map[i][j];
                    dp[i][j][1] = dp[i-1][j-1][2] + map[i][j];
                }
                else{
                    dp[i][j][0] = Math.min(dp[i-1][j-1][2], dp[i-1][j][1]) + map[i][j];
                    dp[i][j][1] = Math.min(dp[i-1][j-1][2],dp[i-1][j+1][0]) + map[i][j];
                    dp[i][j][2] = Math.min(dp[i-1][j][1],dp[i-1][j+1][0]) + map[i][j];
                }

            }
        }
        int ans = Integer.MAX_VALUE;
        for(int[] d:dp[N-1]){
            for(int num:d){
                ans = Math.min(ans,num);
            }
        }
        System.out.println(ans);
    }


}