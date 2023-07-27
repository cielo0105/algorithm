import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[][] arra = new String[n][m];
        String[][] arrb = new String[n][m];
        for(int i=0; i<n; i++){
            arra[i] = br.readLine().split(" ");
        }
        for(int i=0; i<n; i++){
            arrb[i] = br.readLine().split(" ");

        }


        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                sb.append(Integer.parseInt(arra[i][j])+Integer.parseInt(arrb[i][j])).append(" ");
            }
            sb.append("\n");

        }
        System.out.println(sb);
    }
}