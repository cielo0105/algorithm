import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**

 @author 임현지
 @since 2023. 8. 10.
 @note

  * 회전 연산 (r, c, s)
  * (r-s, c-s)
 *
 */
public class Main {
    static int N,M,K;
    static int[][] graph;
    static int[][] copyGraph;
    static Info[] infos;
    static boolean[] visited;
    static int answer;
    static int[][] deltas = {{0,-1},{-1,0},{0,1},{1,0}};
    static int[][] move = {{0,1},{1,0},{0,-1},{-1,0}};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken()); // 회전 연산 횟수
        infos = new Info[K];
        visited = new boolean[K];
        graph = new int[N][M];
        copyGraph = new int[N][M];
        answer = Integer.MAX_VALUE;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int r,c,s;
        for(int i=0; i<K; i++) { // infos : 회전 연산 정보 저장
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());
            infos[i] = new Info(r,c,s);
        }
        perm(0,new Info[K]);
        System.out.println(answer);
    }

    static void rotate(int a, int b, int len) { // graph[a][b]를 기준으로 길이 len인 정사각형
        // 시계방향으로 한 칸씩
        int width = b + len - 1; // 가로 최댓값
        int height = a + len - 1; // 세로 최댓값
        int startx = a;
        int starty = b;
        int[][] copy = new int[N][M];
        for (int i = 0; i < N; i++) { // 깊은 복사
            System.arraycopy(copyGraph[i],0,copy[i],0,M);
        }
        int nth = 0;
        for(int i=0; i<len*4-4; i++){ // len*4-4 개
            int temp = copy[a][b];
//            System.out.println(a+" "+b+ " "+copy[a][b]);
            while(true) {
                int nx = a + move[nth][0];
                int ny = b + move[nth][1];
                if(nx>=startx && nx <= height && ny>=starty && ny<=width){
                    copyGraph[nx][ny] = temp;
                    a = nx;
                    b = ny;
                    break;
                }
                nth = (nth+1)%4;
            }
        }

    }
    static void getStart(Info[] choose){
        int len,min,sum;
        int startX, startY;
        for(Info info: choose){
            len = info.s * 2 + 1;
            startX = info.r-info.s-1;
            startY = info.c-info.s-1;
            for(int i=0; i<len/2; i++){
                rotate(startX+i, startY+i, len-2*i);
            }

            /*System.out.println("-------------------------");
            System.out.println(info);
            for(int[] g:copyGraph){
                System.out.println(Arrays.toString(g));
            }*/

        }
        min = Integer.MAX_VALUE;
        for(int[] cg: copyGraph){
            sum = 0;
            for(int num:cg){
                sum += num;
            }
            min = min > sum ? sum : min;
        }
        answer = answer > min ? min : answer;
    }
    static void perm(int depth,Info[] choose) {
        if(depth == K) {
            for (int i = 0; i < N; i++) { // 깊은 복사
                System.arraycopy(graph[i],0,copyGraph[i],0,M);
            }
            getStart(choose);
            return;
        }
        for(int i=0; i<K; i++) {
            if(!visited[i]) {
                choose[depth] = infos[i];
                visited[i] = true;
                perm(depth+1,choose);
                visited[i] = false;
            }
        }
    }

    public static class Info{
        int r, c, s;
        public Info(int r, int c, int s) {
            this.r = r;
            this.c = c;
            this.s = s;
        }
        @Override
        public String toString() {
            return r+" "+c+" "+s;
        }
    }
}