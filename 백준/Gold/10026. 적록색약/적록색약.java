import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

/*
*  N*N RGB
*
 */
public class Main {
    static char[][] graph;
    static boolean[][] visited;
    static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new char[N][N];
        for(int i=0; i<N; i++){
            graph[i] = br.readLine().toCharArray();
        }
        visited = new boolean[N][N];
        int normal = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j]){
                    normal++;
                    bfs(i,j);
                }
            }
        }
        int rg = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
               if(graph[i][j] == 'G') graph[i][j] = 'R';
            }
        }
        visited = new boolean[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j]){
                    rg++;
                    bfs(i,j);
                }
            }
        }
        System.out.println(normal+" "+rg);
    }
    static void bfs(int x, int y){
        Queue<int []> q = new ArrayDeque<>();
        q.add(new int[] {x,y});
        char color = graph[x][y]; // 현재 색상

        visited[x][y] = true;
        while(!q.isEmpty()){
            int[] next = q.poll();
            for(int i=0; i<4; i++){
                int nx = next[0] + deltas[i][0];
                int ny = next[1] + deltas[i][1];
                if(nx>=0 && nx<N && ny>=0 && ny<N && !visited[nx][ny] && graph[nx][ny]==color){
                    visited[nx][ny] = true;
                    q.add(new int[] {nx,ny});
                }
            }
            
        }
    }
    
}