import java.io.*;
import java.util.*;

public class Main {
    static int m;
    static int n;
    static char[][] graph;
    static char[] color = {'W','B'};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        graph = new char[m][n];
        int min = Integer.MAX_VALUE;
        for(int i=0; i<m; i++){
            graph[i] = br.readLine().toCharArray();
        }
        for(int i=0; i<=m-8; i++){
            for(int j=0; j<=n-8; j++){
                int w = check(i,j,0);
                int b = check(i,j,1);
                min = Math.min(Math.min(w,b),min);
            }
        }
        System.out.println(min);
    }

    public static int check(int a, int b,int start){
        int change = 0;
        for(int i=a; i<a+8; i++){
            for(int j=b; j<b+8; j++){
                if(graph[i][j]!=color[start]) {
                    change++;
                }
                start = (start+1)%2;
            }
            start = (start+1)%2;
        }
        return change;

    }
}