import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[][] word = new char[5][];
        int max = 0;
        for(int i=0; i<5; i++){
            word[i] = br.readLine().toCharArray();
            if(word[i].length > max) max = word[i].length;
        }
        for(int i=0; i<max; i++){
            for(int j=0; j<5; j++){
                if(word[j].length>i){
                    sb.append(word[j][i]);
                }
            }
        }
        System.out.println(sb);
    }
}

