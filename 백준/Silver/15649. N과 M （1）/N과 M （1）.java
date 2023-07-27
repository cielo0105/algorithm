import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int m;
    private static int[] arr;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        visited = new boolean[n+1];
        permutation(0);
    }
    public static void permutation(int cnt){
        if(cnt == m){
            for(int i=0; i<m; i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }
        for(int i=1; i<=n; i++){
            if(!visited[i]){
                visited[i] = true;
                arr[cnt] = i;
                permutation(cnt+1);
                visited[i] = false;
            }
        }
    }
}
