import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        find(0,map);
        System.out.println(answer);
    }
    static void find(int nth, int[][] map){
        if(nth == 5){
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    answer = Math.max(answer,map[i][j]);
                }
            }
            return;
        }
        int[][] copy = new int[N][N];
        for(int i=0; i<4; i++){
        	for(int j=0; j<N; j++){
        		copy[j] = map[j].clone();
        	}
            find(nth+1,move(i, copy));
        }
    }

    static int[][] move(int n, int[][] copy){
        int start_x, start_y;
        if(n==0) { // 위로 이동
            start_x = 0;
            for(int i=0; i<N; i++){
                addUpDown(start_x,i,n,copy);
            }
        }
        else if(n==1){ // 오른쪽 이동
            start_y = N-1;
            for(int i=0; i<N; i++) {
                addLeftRight(i,start_y,n,copy);
            }
        }
        else if(n==2){ // 아래 이동
            start_x = N-1;
            for(int i=0; i<N; i++){
                addUpDown(start_x,i,n,copy);
            }
        }
        else if(n==3){ // 왼쪽 이동
            start_y = 0;
            for(int i=0; i<N; i++) {
                addLeftRight(i,start_y,n,copy);
            }
        }
        return copy;
    }

    static int[][] addUpDown(int x, int y, int n,int[][] copy){
        int curr = 0; // 이전 숫자
        int nth = 0;
        int dir = deltas[n][0];
        for(int i=0; i<N; i++){
            int nx = x - dir*i;
            if(copy[nx][y] == 0) continue;
            if(curr == copy[nx][y]) {
                copy[x-dir*(nth-1)][y] *= 2;
                copy[nx][y] = 0;
                curr = 0;
            }
            else if(curr==0 || curr!=copy[nx][y]){
                curr = copy[nx][y];
                if(x-dir*nth!=nx) copy[nx][y] = 0;
                copy[x-dir*nth][y] = curr;
                nth++;
            }

        }
        return copy;
    }

    static int[][] addLeftRight(int x, int y, int n,int[][] copy){
        int curr = 0; // 이전 숫자
        int nth = 0;
        int dir = deltas[n][1];
        for(int i=0; i<N; i++){
            int ny = y - dir*i;
            if(copy[x][ny] == 0) continue;
            if(curr == copy[x][ny]) {
                copy[x][y-dir*(nth-1)] *= 2;
                copy[x][ny] = 0;
                curr = 0;
            }
            else if(curr==0 || curr!=copy[x][ny]){
                curr = copy[x][ny];
                if(y-dir*nth!=ny) copy[x][ny] = 0;
                copy[x][y-dir*nth] = curr;
                nth++;
            }

        }
        return copy;
    }
}