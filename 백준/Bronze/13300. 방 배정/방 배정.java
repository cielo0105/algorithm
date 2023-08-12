import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    1~6학년 같은 성별, 같은 학년
    한 방에 한 명 가능
    총 N명
    최대 인원수 K
    S 0:여 1:남
    N개의 줄에 S(성별) Y(학년)
 */
public class Main {
    static List<Long> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] grade = new int[7][2]; // 학년마다 여자 남자 수
        int s,y;
        int rooms = 0;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            grade[y][s]++;
        }
        for(int[] g:grade) {
            rooms += (g[0]+1)/2;
            rooms += (g[1]+1)/2;
        }
        System.out.println(rooms);
    }

}