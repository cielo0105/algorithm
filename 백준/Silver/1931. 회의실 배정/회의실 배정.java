import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
/*
    회의실 1개에 N개의 회의 배정
    끝나는 시간 기준으로 정렬
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Time[] meeting = new Time[N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            meeting[i] = new Time(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(meeting, (a, b) -> {
            if(a.end==b.end) return a.start-b.start;
            return a.end - b.end;
        });
        int answer = 1;
        int end = meeting[0].end;
        for(int i=1; i<N; i++){
            if(meeting[i].start >= end){
                end = meeting[i].end;
                answer ++;
            }
        }
        System.out.println(answer);
    }

    public static class Time{
        int start,end;
        public Time(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return this.start+" "+this.end;
        }
    }
 }