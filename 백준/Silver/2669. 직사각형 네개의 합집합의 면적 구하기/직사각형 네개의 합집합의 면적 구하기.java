import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    입력 4줄
    왼쪽아래 x1,y1 오른쪽 위 x2,y2
 */
public class Main {
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int x1,y1,x2,y2;
        boolean[][] visited = new boolean[100][100];
        int answer = 0;
        for(int t=0; t<4; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            for(int i=x1; i<x2; i++){
                for(int j=y1; j<y2; j++){
                    if(!visited[i][j]) {
                        answer++;
                        visited[i][j] = true;
                    }
                }
            }
        }
        System.out.println(answer);

    }

}