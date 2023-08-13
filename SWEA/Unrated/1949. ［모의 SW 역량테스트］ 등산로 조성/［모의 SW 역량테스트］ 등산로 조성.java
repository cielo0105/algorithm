import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

/*
    N*N 등산로 최대한 긴 등산로 만들기
    각 숫자는 지형의 높이
    1. 가장 높은 봉우리에서 시작
    2. 높은 지형 -> 낮은 지형 (가로 세로)
    3. 한 곳 정해서 최대 K 만큼 지형 깍기 가능
 */
public class Solution {
    static int N,K;
    static int[][] mountain;
    static boolean[][] visited;
    static List<int[]> high;
    static int maxCnt; /////////////////
    static int[][] deltas = {{0,1},{1,0},{0,-1},{-1,0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int num,max;
        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            mountain = new int[N][N];
            visited = new boolean[N][N];
            high = new ArrayList<>();
            max = Integer.MIN_VALUE;
            int answer = Integer.MIN_VALUE;
            for(int i=0; i<N; i++){  // 산 높이 저장
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    num = Integer.parseInt(st.nextToken());
                    mountain[i][j] = num;
                    if(max<=num){
                        if(max<num) {
                            max = num;
                            high.clear();
                        }
                        high.add(new int[] {i,j}); // 높은 봉우리 위치 리스트에 저장
                    }

                }
            }
            for(int[] h:high){ // 가장 높은 봉우리에서 시작
                visited = new boolean[N][N];
                visited[h[0]][h[1]] = true;
                maxCnt = Integer.MIN_VALUE;
                dfs(h[0],h[1],0,1,max);
                answer = answer < maxCnt ? maxCnt : answer;
            }
            sb.append(String.format("#%d %d\n",t,answer));
        }
        System.out.println(sb);
    }
    static void dfs(int x, int y,int flag, int cnt,int before){ // flag 1이면 산 깎음
        maxCnt = maxCnt < cnt ? cnt : maxCnt;
        for(int i=0; i<4; i++){
            int nx = x + deltas[i][0];
            int ny = y + deltas[i][1];
            if(nx>=0 && nx<N && ny>=0 && ny <N && !visited[nx][ny]){

                if(mountain[nx][ny] < before) { // 전보다 낮은 경우
                    visited[nx][ny] = true;
                    dfs(nx, ny, flag, cnt + 1, mountain[nx][ny]);
                    visited[nx][ny] =false;
                }
                else{ // 전보다 높은 경우
                    if(flag != 0) continue; // 이미 깎음
                    if(mountain[nx][ny]-before >= K) continue; // 깎을 수 있는 높이보다 차이 큰 경우
                    visited[nx][ny] = true;
                    dfs(nx,ny,flag+1,cnt+1,before-1);
                    visited[nx][ny] = false;
                }
            }
        }
    }


}