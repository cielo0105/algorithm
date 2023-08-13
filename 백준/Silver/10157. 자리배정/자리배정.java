import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] deltas = {{0,1},{1,0},{0,-1},{-1,0}};
        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(br.readLine());
        int[][] graph = new int[width][height];
        int cnt = 1;
        int x = 0;
        int y = 0;
        int dir= 0;
        int nx,ny;
        if(num > width*height) System.out.println(0);
        else {
            graph[0][0] = 1;
            while (cnt < num) {
                nx = x + deltas[dir][0];
                ny = y + deltas[dir][1];
                if (nx >= 0 && nx < width && ny >= 0 && ny < height && graph[nx][ny] == 0) {
                    graph[nx][ny] = cnt++;
                    x = nx;
                    y = ny;
                } else {
                    dir = (dir + 1) % 4;
                }
            }
            System.out.println((x + 1) + " " + (y + 1));
        }
    }


}