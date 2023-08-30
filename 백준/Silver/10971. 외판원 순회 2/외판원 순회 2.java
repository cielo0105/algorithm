import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] graph;
    static boolean[] visited;
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        graph = new int[N][N];
        visited = new boolean[N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited[0] = true;
        find(0,0,0,0);
        System.out.println(ans);
    }

    static void find(int depth, int start, int curr, int sum){
        if(depth == N-1){
            if(graph[curr][start] != 0){ // 마지막으로 탐색한 곳이 시작점과 연결되면
                sum += graph[curr][start];
                ans = Math.min(ans,sum);
            }
            return;
        }

        for(int i=0; i<N; i++){
            if(!visited[i] && graph[curr][i] != 0){
                visited[i] = true;
                find(depth+1,start,i,sum+graph[curr][i]);
                visited[i] = false;
            }
        }
    }
}