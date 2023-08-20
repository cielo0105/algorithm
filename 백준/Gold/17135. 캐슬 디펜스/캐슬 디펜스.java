import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    N*M
    N+1번행에 성이 있음
    성을 지키기 위해 3명의 궁수 배치
    - 거리 D 이하인 적 중 가장 가까운 적 동시에 공격
    - 여러명인 경우 가장 왼쪽에 있는 적 공격
    - 적은 각 턴마다 한 칸 아래로 이동

 */
public class Main {
    static int N,M,D, cnt;
    static int[][] map, copyMap;
    static int max = Integer.MIN_VALUE;
    static boolean[][] visited;
    static int[][] deltas = {{0,-1},{-1,0},{0,1}}; // 왼쪽, 위, 오른쪽 순서로 탐색
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i=0; i<N; i++){ // 맵 정보 저장
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        choose(0,0,new int[3]);
        System.out.println(max);
    }
    static void choose(int depth, int start, int[] choose){
        if(depth == 3){ // 궁수 3명 위치 선택 완료한 경우
            check(choose);
            return;
        }
        for(int i=start; i<M; i++){
            choose[depth] = i;
            choose(depth+1, i+1, choose);
        }
    }

    static void check(int[] choose){ // 한 턴 끝나면 궁수 x위치 -1 해줌
        boolean[][] kill = new boolean[N][M];
        copyMap = map.clone();
        for(int i=0; i<N; i++){
            copyMap[i] = map[i].clone();
        }
        cnt = 0;
        visited = new boolean[N][M];
        for(int i=0; i<N; i++){
            for(int nth: choose){
                Enemy enemy = bfs(N-i,nth);
                if(enemy == null) continue;
                if(!kill[enemy.x][enemy.y]){
                    kill[enemy.x][enemy.y] = true;
                    cnt++;
                }
            }
            for(int a=0; a<N; a++){
                for(int b=0; b<M; b++){
                    if(kill[a][b])  copyMap[a][b] = 0;
                }
            }
            // 한 턴에서 각 궁수가 어떤 적을 죽일지 정했으면 한번에 죽임

        }
        max = Math.max(max,cnt);
    }
    static Enemy bfs(int x, int y){
        Queue<Enemy> queue = new ArrayDeque<>();

        queue.add(new Enemy(x,y,0)); // 처음 궁수 위치
        int map_length = x;
        while(!queue.isEmpty()){
            Enemy location = queue.poll();
            x = location.x;
            y = location.y;
            int depth = location.dist;
            if(depth > D) return null;
            for(int i=0; i<3; i++){
                int nx = x + deltas[i][0];
                int ny = y + deltas[i][1];
                if(nx>=0 && nx<map_length && ny>=0 && ny<M && !visited[nx][ny]){
                    if(copyMap[nx][ny] == 1) {
                        if(depth+1 <= D) return new Enemy(nx,ny,depth+1);
                        return null;
                    }
                    queue.add(new Enemy(nx,ny,depth+1));
                }
            }
        }
        return null;
    }

    static class Enemy{
        int x, y, dist;
        public Enemy(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

    }
}