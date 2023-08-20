import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
* 상하좌우 토마토 영향
* 며칠이 지나야 다 익는지
* 0: 익지 않은 토마토
* 1: 익은 토마토
* -1: 토마토 없음
 */
public class Main {
    static int N,M;
    static int[][] graph;
    static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
    static Queue<int []> queue = new ArrayDeque<>();
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j] == 1) queue.add(new int[] {i,j,0}); // 익은 토마토 큐에 저장
            }
        }
        while(!queue.isEmpty()){
            int[] tomato = queue.poll();
            bfs(tomato[0],tomato[1],tomato[2]);
        }
        if(check()) System.out.println(ans);
        else System.out.println(-1);
    }

    static boolean check(){
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(graph[i][j] == 0) return false;
            }
        }
        return true;
    }
    static void bfs(int x, int y, int time){
        for(int i=0; i<4; i++){
            int nx = x + deltas[i][0];
            int ny = y + deltas[i][1];
            if(nx>=0 && nx<N && ny>=0 && ny<M && graph[nx][ny] == 0){
                graph[nx][ny] = 1;
                queue.add(new int[] {nx,ny,time+1});
                ans = time+1;
            }
        }
    }
    
}