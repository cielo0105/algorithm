import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/*
    * : 지뢰
    . : 지뢰 없음
 */
public class Solution {
    static int N;
    static char[][] maze;
    static int[][] bomb;
    static int[][] deltas = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
    static boolean[][] visited;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            N = Integer.parseInt(br.readLine());
            maze = new char[N][N];
            visited = new boolean[N][N];
            bomb = new int[N][N];
            answer = 0;
            for(int i=0; i<N; i++){
                maze[i] = br.readLine().toCharArray();
            }
            for(int i=0; i<N; i++){ // 지뢰 개수 세어줌
                for(int j=0; j<N; j++){
                    if(maze[i][j]=='.') getBomb(i,j);
                    else if(maze[i][j]=='*') bomb[i][j] = -1;
                }
            }
            for(int i=0; i<N; i++){

                for(int j=0; j<N; j++){
                    if(bomb[i][j]==0 && !visited[i][j]){
                        answer++;
                        bfs(i,j);
                    }
                }
            }
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(maze[i][j]=='.' && !visited[i][j]){
                        answer++;
                    }
                }
            }
            sb.append(String.format("#%d %d\n",t,answer));
        }
        System.out.println(sb);
    }
    static void getBomb(int x, int y){
        int nx,ny;
        int cnt = 0;
        for(int i=0; i<8; i++){
            nx = x + deltas[i][0];
            ny = y + deltas[i][1];
            if(nx>=0 && nx<N && ny>=0 && ny<N){
                if(maze[nx][ny]=='*') cnt++;
            }
        }
        bomb[x][y] = cnt;
    }
    static void bfs(int x, int y){
        Queue<int[]> queue = new ArrayDeque<>();
        visited[x][y] = true;
        queue.add(new int[]{x,y});
        int nx,ny;
        int[] info;
        while(!queue.isEmpty()){
            info = queue.poll();
            x = info[0];
            y = info[1];
            for(int i=0; i<8; i++){
                nx = x+deltas[i][0];
                ny = y+deltas[i][1];
                if(nx>=0 && nx<N && ny>=0 && ny<N && maze[nx][ny]=='.' && !visited[nx][ny]){
                    if(bomb[nx][ny]==0) queue.add(new int[] {nx,ny});
                    visited[nx][ny] = true;

                }
            }
        }
    }
}