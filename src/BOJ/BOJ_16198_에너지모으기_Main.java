package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16198_에너지모으기_Main {

   private static int[] arr;
   private static boolean[] visited;
   private static int N, max = Integer.MIN_VALUE;

   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      N = Integer.parseInt(br.readLine());
      arr = new int[N];
      StringTokenizer st = new StringTokenizer(br.readLine()," ");
      for (int i = 0; i < N; i++) {
         arr[i] = Integer.parseInt(st.nextToken());
      }
      
      visited = new boolean[N];
      dfs(0, 0);
      System.out.println(max);
      
   }

   private static void dfs(int cnt, int sum) {
      boolean flag = true;
      for (int k = 1; k < N-1; k++) {
         if(!visited[k]) {
            flag = false;
            visited[k]=true;
            int val1=0, val2=0;
            for (int i = k+1; i < N; i++) {
               if(!visited[i]) {
                  val1 = arr[i]; 
                  break;
               } 
            }
            for (int i = k-1; i > -1; i--) {
               if(!visited[i]) {
                  val2 = arr[i]; 
                  break;
               } 
            }
            dfs(cnt+1 ,sum+(val1*val2));
            visited[k]=false;
         }
      }
      if(flag && (max<sum)) {
         max = sum;
      }
   }


}