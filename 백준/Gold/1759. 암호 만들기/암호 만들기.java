import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    서로 다른 알파벳 L개로 구성
    최소 1개의 모음, 2개의 자음
    알파벳순
    가능한 알파벳 C개
 */
public class Main {
    static String[] vowel = {"a","e","i","o","u"};
    static String[] alpha;
    static int L,C;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        alpha = br.readLine().split(" ");
        Arrays.sort(alpha);
        find(0,0,new String[L],0,0);
        System.out.println(sb);
    }
    static void add(String[] choose){
        for(String c:choose){
            sb.append(c);
        }
        sb.append("\n");
    }
    static boolean isVowel(String s){
        for(String v: vowel){
            if(s.equals(v)) return true;
        }
        return false;
    }
    static void find(int vo,int co,String[] choose, int start,int depth){
        if(depth == L){
            if(vo>=1 && co>=2){
                add(choose);
            }
            return;
        }
        for(int i=start; i<C; i++){
            choose[depth] = alpha[i];
            if(isVowel(alpha[i])) {
                find(vo+1,co,choose,i+1, depth+1);
            }
            else find(vo,co+1,choose,i+1,depth+1);
        }

    }
}