/*
 * N K
 * N개의 단어
 * K개 글자 가르침
 * 학생들 읽을 수 있는 최대 단어 개수
 * anta tica 무조건 포함 -> a c i n t 읽을 수 있어야 됨
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static char[] include = {'a','c','i','n','t'};
    static int N,K;
    static String[] word;
    static Character[] arr;
    static boolean[] visited;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        word = new String[N];
        Set<Character> set = new HashSet<>(); // 알아야하는 알파벳
        for(int i=0; i<N; i++) {
            word[i] = br.readLine();
            word[i] = replace(word[i]); // a c i t n 제거
            for(char c: word[i].toCharArray()) {
                set.add(c);
            }
        }

        if(K < 5) System.out.println(0); // 5개보다 작으면 모든 단어 읽을 수 없음
        else {
            K -= 5;
            arr = set.toArray(new Character[set.size()]); // 알아야하는 알파벳
            if(K>= set.size()) System.out.println(N); /// 모두 읽을 수 있음
            else {
                visited = new boolean[26];
                choose(0,0);
                System.out.println(max);
            }
        }
    }

    static void choose(int depth, int start) {
        if(depth==K) {
            max = Math.max(max, check());
            return;
        }
        for(int i=start; i<arr.length; i++) {
            visited[arr[i]-'a'] = true;
            choose(depth+1,i+1);
            visited[arr[i]-'a'] = false;
        }
    }

    static int check() {
        int cnt = 0;
        for(String w:word){
            int flag = 0;
            for(char c:w.toCharArray()){
                if(!visited[c-'a']) {
                    flag = 1;
                    break;
                }
            }
            if(flag == 0) cnt++;

        }
        return cnt;
    }
    static String replace(String word) {
        for(char ch: include) {
            word = word.replaceAll(Character.toString(ch), "");
        }
        return word;

    }

}