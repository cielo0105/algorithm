import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    N*M
    N+1번 행에 성이 있음
    성을 지키기 위해 3명의 궁수 배치
    - 거리 D 이하인 적 중 가장 가까운 적 동시에 공격
    - 여러명인 경우 가장 왼쪽에 있는 적 공격
    - 적은 각 턴마다 한 칸 아래로 이동 (적 이동시키지 않고 궁수 위치를 위쪽으로 한칸씩 전진시킴)

    1. 조합을 이용하여 궁수 3명을 선택
    2. 각 턴마다 궁수 3명이 어떤 적을 죽일지 왼쪽, 위쪽, 오른쪽 순서로 탐색 (중복 가능)
      - 탐색을 하다가 D(최대 거리보다 먼 경우 null 반환)
      - boolean 배열에 죽일 적 위치 false였으면 true로 바꾸고 cnt(제거한 적) 1 증가
    3. 모든 궁수가 어떤 적 죽일지 골랐다면 이중for문 돌면서 한번에 제거
    4. 모든 조합 다 확인하면서 죽일 수 있는 최대 적 찾기
 */
public class Main {
    static int N,M,D, cnt;
    static int[][] map, copyMap;
    static int max = Integer.MIN_VALUE;
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
    static void choose(int depth, int start, int[] choose){  // 조합을 통해 궁수 3명 고르기
        if(depth == 3){ // 궁수 3명 위치 선택 완료한 경우
            check(choose);
            return;
        }
        for(int i=start; i<M; i++){
            choose[depth] = i;
            choose(depth+1, i+1, choose);
        }
    }

    static void check(int[] choose){ // 3명의 궁수가 몇 명의 적을 죽일 수 있는지 확인하는 메서드
        boolean[][] kill = new boolean[N][M];  // 어느 적 죽일지 저장해놓는 배열
        copyMap = new int[N][M];
        for(int i=0; i<N; i++){  // 2차원 배열 복사
            copyMap[i] = map[i].clone();
        }
        cnt = 0; // 제거한 적 수
        for(int i=0; i<N; i++){  // 총 N턴 동안 반복
            for(int nth: choose){  // 각 궁수에 대해 bfs 탐색
                // 궁수의 위치 한 턴 끝나면 x-1 해줘서 앞으로 전진시킴, y값은 동일
                Enemy enemy = bfs(N-i,nth);  // 궁수가 죽일 적 위치 반환함
                if(enemy == null) continue;  // null인 경우 해당 궁수는 범위 내에 죽일 적이 없다는 뜻임
                if(!kill[enemy.x][enemy.y]){  // 처음 죽이는 적일 경우
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
        int map_length = x;  // 맵의 세로 길이 저장
        while(!queue.isEmpty()){
            Enemy location = queue.poll();
            x = location.x;
            y = location.y;
            int depth = location.dist;

            for(int i=0; i<3; i++){  // 왼쪽, 위, 오른쪽 순으로 탐색 (왼쪽 적 우선 죽이기 때문)
                int nx = x + deltas[i][0];
                int ny = y + deltas[i][1];
                if(nx>=0 && nx<map_length && ny>=0 && ny<M){
                    if(depth+1 > D) return null;  // 적의 거리가 공격 가능한 범위보다 멀면 null 반환
                    if(copyMap[nx][ny] == 1) {
                        return new Enemy(nx,ny,depth+1); //공격 범위 안에 있는 적
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