import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 바이러스 - 활성 / 비활성 상태
 * 처음 바이러스 비활성 상태
 * 활성 상태 되면 상하좌우 동시 복제
 * 연구소 크기 N*N  빈칸(0), 벽(1), 바이러스(2) 로 이루어짐
 * 바이러스 M개를 활성 상태로 변경하는데 걸리는 시간
 */
public class Main {
    static int N,M;
    static int blank = 0;
    static int[][] graph;
    static int answer = Integer.MAX_VALUE;
    static boolean[][] visited;
    static List<Virus> allVirus = new ArrayList<>();
    static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); // 바이러스 개수
        graph = new int[N][N];

        int n;
        for(int i=0; i<N; i++){ // graph 정보 입력
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                n = Integer.parseInt(st.nextToken());
                graph[i][j] = n;
                if(n==2){ // 비활성화 바이러스 정보 큐에 저장
                    allVirus.add(new Virus(i,j,0));
                }
                if(n==0) blank++;
            }
        }
        choose(0,0,new int[M]);

        if(answer == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(answer);
    }

    static void choose(int depth, int start, int[] choose){
        if(depth == M){
            int total = bfs(choose);
            if(total != -1) answer = Math.min(answer, total);
            return;
        }
        for(int i=start; i<allVirus.size(); i++){
            choose[depth] = i;
            choose(depth+1,i+1,choose);
        }
    }

    static int bfs(int[] choose){
        visited = new boolean[N][N];
        int total = 0;
        int zero = blank;
        int x, y, time;
        Queue<Virus> q = new ArrayDeque<>();
        for(int c: choose){  // 고른 활성 바이러스 큐에 넣음
            q.add(allVirus.get(c));
            visited[allVirus.get(c).x][allVirus.get(c).y] = true;
        }
        while(!q.isEmpty()){
            Virus v = q.poll();
            x = v.x;
            y = v.y;
            time = v.time;
            total = time;
            for(int i=0; i<4; i++){
                int nx = x + deltas[i][0];
                int ny = y + deltas[i][1];
                if(nx>=0 && nx<N && ny>=0 && ny<N && !visited[nx][ny] && zero>0){
                    if(graph[nx][ny] == 0){
                        zero--;
                        visited[nx][ny] = true;
                        q.add(new Virus(nx,ny,time+1));
                    }
                    else if(graph[nx][ny] == 2){
                        if(zero==0) continue;
                        visited[nx][ny] = true;
                        q.add(new Virus(nx,ny,time+1));
                    }

                }
            }
        }
        if(zero==0) return total;
        else return -1;
    }

    public static class Virus{
        int x, y, time;
        public Virus(int x, int y, int time){
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}