import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 4등분 모두 0이면 0 모두 1이면 1
 * 
 * 
 */
public class Main {
	static int N;
	static char[][] graph;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		graph = new char[N][N];
		for(int i=0; i<N; i++) {
			graph[i] = br.readLine().toCharArray();
		}
		divide(0,0,N);
		System.out.println(sb);
	}
	
	static void divide(int r, int c,int size) {
		if(size==1) {
			sb.append(graph[r][c]);
			return;
		}
		if(check(r,c,size)) {
			sb.append(graph[r][c]);
			
			return;
		}
		sb.append("(");
		divide(r, c, size/2);
		divide(r, c+size/2, size/2);
		divide(r+size/2, c, size/2);
		divide(r+size/2, c+size/2, size/2);
		sb.append(")");
	}
	
	static boolean check(int r, int c, int size) {
		int num = graph[r][c];
		for(int i=r; i<r+size; i++) {
			for(int j=c; j<c+size; j++) {
				if(num != graph[i][j]) return false;
			}
		}
		return true;
	}
}