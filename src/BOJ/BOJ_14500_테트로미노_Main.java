package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14500_테트로미노_Main {

   private static boolean[][] visited;
   private static int max;
   private static int[] dx;
   private static int[] dy;
   private static int N;
   private static int M;
   private static int[][] map;

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      map = new int[N][M];
      for (int i = 0; i < N; i++) {
         st = new StringTokenizer(br.readLine()," ");
         for (int j = 0; j < M; j++) {
            map[i][j] = Integer.parseInt(st.nextToken());
         }
      }
      dx = new int[] {0,0,1,-1};
      dy = new int[] {1,-1,0,0};
      max = 0;
      visited = new boolean[N][M];
      for (int i = 0; i < N; i++) {
         for (int j = 0; j < M; j++) {
            visited[i][j]=true;
            dfs(i,j,1,map[i][j]);
            visited[i][j]=false;
            if(j+2<M) {
               int sum1 = map[i][j] + map[i][j+1] + map[i][j+2];
               if(i-1>-1) {
                  int sum11 = sum1 + map[i-1][j+1];
                  if(max<sum11) max = sum11;
               }
               
               if(i+1<N) {
                  int sum12 = sum1 + map[i+1][j+1];
                  if(max<sum12) max = sum12;
               }
            }
            
            if(i+2<N) {
               int sum2 = map[i][j] + map[i+1][j] + map[i+2][j];
               if(j-1>-1) {
                  int sum21 = sum2+map[i+1][j-1];
                  if(max<sum21) max = sum21;
               }
               
               if(j+1<M) {
                  int sum22 = sum2+map[i+1][j+1];
                  if(max<sum22) max = sum22;
               }
            }
         }
      }
      System.out.println(max);
      
   }

   private static void dfs(int i, int j, int cnt, int sum) {
      if(cnt==4) {
         if(max<sum) max=sum;
         return;
      }
      
      for (int k = 0; k < 4; k++) {
         int nx = i + dx[k];
         int ny = j + dy[k];
         if(nx>-1&&ny>-1&&nx<N&&ny<M&&!visited[nx][ny]) {
            visited[nx][ny] = true;
            dfs(nx, ny, cnt+1, sum+map[nx][ny]);
            visited[nx][ny] = false;
         }
      }
      
      
   }

}