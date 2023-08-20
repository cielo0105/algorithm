import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 모두 0 : 흰색
 * 모두 1 : 파란색
 */
public class Main {
    static int[][] graph;
    static int[] cnt = new int[2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        for(int i=0; i<N; i++){ // graph 정보 저장
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        find(0,0,N);
        for(int i:cnt) System.out.println(i);
    }
    static boolean check(int width, int height, int size){
        int num = graph[width][height];
        for(int i=width; i<width+size; i++){
            for(int j=height; j<height+size; j++){
                if(graph[i][j] != num) return false;
            }
        }
        return true;
    }
    static void find(int width, int height, int size){
        if(check(width,height,size)){
            cnt[graph[width][height]]++;
            return;
        }
        find(width,height,size/2);
        find(width+size/2,height,size/2);
        find(width,height+size/2,size/2);
        find(width+size/2,height+size/2,size/2);
    }
}