import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
/*
 * 나무 M미터 필요
 * 나무 길이 내림차순 정렬
 * 이분탐색 -> 짧으면 start -> mid로 이동
 *           길면 end -> mid로 이동
 */
public class Main {
    static Integer[] tree;
    static int N,M;
    static long min = Integer.MAX_VALUE;
    static int len;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 나무 수
        M = Integer.parseInt(st.nextToken()); // 필요한 길이
        st = new StringTokenizer(br.readLine());
        tree = new Integer[N];
        for(int i=0; i<N; i++){
            tree[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(tree, Collections.reverseOrder());
        find(0,tree[0]);
        System.out.println(len);
    }

    static void find(int start, int end){
        while(start<=end) {
            int mid = (start + end) / 2;
            long length = check(mid);
            if (length == M) {
                len = mid;
                return;
            }
            if(length < M){ // 필요한 길이보다 짧은 경우
                end = mid-1;
            }
            else { // 필요한 길이보다 긴 경우
                if(min > length){
                    len = mid;
                    min = length;
                }
                start = mid+1;
            }
        }
    }

    static long check(int mid){
        long length = 0;
        for(int t: tree){
            if(t > mid){
                length += t-mid;
            }
            else break; // 내림차순 정렬이므로 길이가 mid보다 작아지면 break
        }
        return length;

    }
}