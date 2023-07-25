import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[][] graph;
    static int[][] delta = {{1,0},{0,1},{-1,0},{0,-1}};
//    static int[] cnt = new int[25*25];
    static List<Integer> cnt = new ArrayList<>();
    static int count = 0;
    public static void dfs(int x,int y){
        graph[x][y] = 0;
        count++;
        for(int i=0; i<4; i++){
            int nx = x + delta[i][0];
            int ny = y + delta[i][1];
            if(nx>=0 && nx<n && ny>=0 && ny<n && graph[nx][ny]!=0){
                dfs(nx,ny);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        for(int i=0; i<n; i++) {
            String input = br.readLine();
            for(int j=0; j<n;j++) {
                graph[i][j] = Character.getNumericValue(input.charAt(j));
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(graph[i][j]!=0){
                    count = 0;
                    dfs(i,j);
                    cnt.add(count);
                }
            }
        }
        System.out.println(cnt.size());
        Collections.sort(cnt);
        for(int i:cnt){
            System.out.println(i);
        }
    }
}
