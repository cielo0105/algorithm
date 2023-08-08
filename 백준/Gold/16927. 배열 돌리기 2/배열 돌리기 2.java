import javax.xml.transform.sax.SAXSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int R;
    static int[][] graph;
    static int[][] deltas = {{0,1},{1,0},{0,-1},{-1,0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        for(int i=0; i<N; i++){  // graph에 값 저장
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int layer = (int)(Math.ceil(Math.min(N,M)/2)); // layer 개수
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i=0; i<layer; i++){
            queue = getLocation(i,0,null);
            queue = change(queue);
            getLocation(i,1,queue);
        }
        for(int[] g:graph){
            for(int i:g){
                sb.append(i).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }


    static Queue<Integer> change(Queue<Integer> queue){
        for(int i=0; i<R%queue.size(); i++){
            queue.offer(queue.poll());
        }
        return queue;
    }

    static Queue<Integer> getLocation(int layer, int type, Queue<Integer> changeQ){
        int width,height,x,y;
        int nx = 0;
        int ny = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        width = M - 2*layer;
        height = N - 2*layer - 1;
        x = layer; y = layer;
        for(int j=0; j<width; j++){
            nx = x + deltas[0][0]*j;
            ny = y + deltas[0][1]*j;
            if (type==0) queue.add(graph[nx][ny]); // 배열 가지고 오는 경우
            else graph[nx][ny] = changeQ.poll();
        }
        x = nx; y = ny;
        width -= 1;
        for(int j=1; j<=height; j++){
            nx = x + deltas[1][0]*j;
            ny = y + deltas[1][1]*j;
            if (type==0) queue.add(graph[nx][ny]); // 배열 가지고 오는 경우
            else graph[nx][ny] = changeQ.poll();
        }
        x = nx; y = ny;
        height -= 1;
        for(int j=1; j<=width; j++){
            nx = x + deltas[2][0]*j;
            ny = y + deltas[2][1]*j;
            if (type==0) queue.add(graph[nx][ny]); // 배열 가지고 오는 경우
            else graph[nx][ny] = changeQ.poll();
        }
        x = nx; y = ny;
        for(int j=1; j<=height; j++){
            nx = x + deltas[3][0]*j;
            ny = y + deltas[3][1]*j;
            if (type==0) queue.add(graph[nx][ny]); // 배열 가지고 오는 경우
            else graph[nx][ny] = changeQ.poll();
        }
        if(type==0) return queue;
        else return null;
    }
}