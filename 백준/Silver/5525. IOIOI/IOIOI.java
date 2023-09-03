import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*
    IOI
    IOIOI
    IOIOIOI 개수
 */
public class Main {
    static int N;
    static int cnt = 0, answer = 0;
    static int total;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        int len = Integer.parseInt(br.readLine());
        char[] input = br.readLine().toCharArray();
        total = 2*N+1;
        int flag = -1;

        for(int i=0; i<len; i++){
            if(input[i] == 'I'){
                if(flag == -1){ // 처음 시작
                    cnt += 1;
                    flag = 1;
                }
                else if(flag == 1){ // I 연속 2번 나온 경우
                    calc();
                    cnt = 1;
                }
                else if(flag == 0) {
                    cnt++;
                    flag = 1;
                }
            }
            else{
                if(flag == 0){
                    calc();
                    cnt = 0;
                }
                else if(flag == 1){
                    cnt++;
                    flag = 0;
                }
            }
        }
        calc();
        System.out.println(answer);
    }
    static void calc(){
        if(cnt>=total){
            int i_total = cnt%2==0 ? cnt/2 : cnt/2+1;
            int i_cnt = N+1;
            answer += i_total - i_cnt + 1;
        }
    }
}