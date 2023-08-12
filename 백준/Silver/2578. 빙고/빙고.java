import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    x,y 에 빙고
    [x][5+y]
    x==y면 10
    x+y == 4면 11
 */
public class Main {
    static int[][] bingo;
    static int[] cnt;
    static int total = 0; // 3 되면 빙고
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bingo = new int[5][5];
        cnt = new int[12]; // 가로 세로 대각선 개수(5 되면 빙고)
        for(int i=0; i<5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++){
                bingo[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int num;
        loop:
        for(int i=0; i<5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++){
                num = Integer.parseInt(st.nextToken());
                if(find(num)){
                    answer = 5*i+j+1;
                    break loop;
                }

            }
        }
        System.out.println(answer);

    }
    static boolean find(int num){
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if(bingo[i][j] == num){
                    erase(i,j);
                    return check();

                }
            }
        }
        return false;
    }
    static void erase(int x, int y){
        cnt[x]++;
        cnt[5+y]++;
        if(x==y) cnt[10]++;
        if(x+y==4) cnt[11]++;
    }
    static boolean check(){
        int count = 0;
        for(int i=0; i<12; i++){
            if(cnt[i] == 5) count++;
        }
        if(count >= 3) return true;
        return false;
    }

}