import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M,T;
    static int ans = Integer.MAX_VALUE;
    static int[][] map;
    static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        if(find()) System.out.println(ans);
        else System.out.println("Fail");
    }
    static boolean find(){
        visited[0][0] = true;
        int time = 0;
        Queue<Info> q = new ArrayDeque<>();
        q.add(new Info(0,0,0));
        while(!q.isEmpty()){
            Info info = q.poll();
            time = info.time;
            if(time==T) break;
            if(info.x==N-1 && info.y==M-1){
                ans = Math.min(ans,time);
                return true;
            }
            for(int i=0; i<4; i++){
                int nx = info.x + deltas[i][0];
                int ny = info.y + deltas[i][1];

                if(nx>=0 && nx<N && ny>=0 && ny<M && !visited[nx][ny] && map[nx][ny]!=1){
                    visited[nx][ny] = true;
                    if(map[nx][ny]==2) {
                        int t = time+1+ (N-1)-nx + (M-1)-ny;
                        if(t<=T) ans = Math.min(ans,t);
                    }
                    else q.add(new Info(nx,ny,time+1));
                }
            }

        }
        if(ans==Integer.MAX_VALUE) return false;
        return true;
    }

    static class Info{
        int x, y, time;
        public Info(int x, int y, int time){
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}