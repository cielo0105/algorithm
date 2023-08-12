import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 N개로 이루어진 집합
 부분집합 합 S되는 경우의 수
 */
public class Main {
    static int n,m;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        BigInteger bigN = BigInteger.ONE;
        BigInteger bigM = BigInteger.ONE;
        for(int i=0; i<m; i++){
            bigN = bigN.multiply(new BigInteger(String.valueOf(n-i)));
            bigM = bigM.multiply(new BigInteger(String.valueOf(i+1)));

        }
        System.out.println(bigN.divide(bigM));
    }


}