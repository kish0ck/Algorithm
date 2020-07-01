package BOJ;

// 2020-06-25

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2931_가스관_Main {

   private static int answer_row;
   private static int answer_col;
   private static char answer_c;
   private static char[][] map;
   private static int R;
   private static int C;
   private static boolean[] visited;
   private static boolean check_flag;

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      R = Integer.parseInt(st.nextToken());
      C = Integer.parseInt(st.nextToken());
      Queue<int[]> q = new LinkedList<int[]>();
      map = new char[R][C];
      for (int i = 0; i < R; i++) {
         String str = br.readLine();
         for (int j = 0; j < C; j++) {
            map[i][j] = str.charAt(j);
            if(map[i][j]=='M') {
               q.offer(new int[] {i,j,map[i][j]});
            }
         }
      }
      check_flag=false;
      answer_row = 0;
      answer_col = 0;
      answer_c = 0;
loop:   for (int i = 0; i < R; i++) {
         for (int j = 0; j < C; j++) {
            if(map[i][j]=='.') {
               visited = new boolean[7];
               go(i,j,0);
               if(check_flag) break loop;
            } 
         }
      }

      System.out.println(answer_row+" "+answer_col+" "+answer_c);
   }

   private static void go(int r, int c, int cnt) {
      if(cnt==1) {
         if(check_map()) {
            answer_row = r+1;
            answer_col = c+1;
            answer_c = map[r][c];
            check_flag = true;
         }
         return;
      }
      
      if(check_flag) return;
      for (int i = 0; i < 7; i++) {
         if(!visited[i]) {
            visited[i]=true;
            if(i==0) {
               map[r][c]='|';
            }else if(i==1) {
               map[r][c]='1';
            }else if(i==2) {
               map[r][c]='2';
            }else if(i==3) {
               map[r][c]='3';
            }else if(i==4) {
               map[r][c]='4';
            }else if(i==5) {
               map[r][c]='-';
            }else {
               map[r][c]='+';
            }
            go(r,c,cnt+1);
            if(check_flag) return;
            map[r][c]='.';
            visited[i]=false;
         }
      }
      
      
      
   }

   private static boolean check_map() {
      for (int i = 0; i < R; i++) {
         for (int j = 0; j < C; j++) {
            if(map[i][j]!='.') {
               switch(map[i][j]) {
                  case '|' :
                     if(i-1>-1&&(map[i-1][j]=='|'||map[i-1][j]=='+'||map[i-1][j]=='1'||map[i-1][j]=='4'||map[i-1][j]=='Z'||map[i-1][j]=='M')) {
                        
                     }else {
                        return false;
                     }
                     
                     if(i+1<R&&(map[i+1][j]=='|'||map[i+1][j]=='+'||map[i+1][j]=='2'||map[i+1][j]=='3'||map[i+1][j]=='Z'||map[i+1][j]=='M')) {
                        
                     }else {
                        return false;
                     }
                     break;
                  case '-' :
                     if(j-1>-1&&(map[i][j-1]=='-'||map[i][j-1]=='+'||map[i][j-1]=='1'||map[i][j-1]=='2'||map[i][j-1]=='Z'||map[i][j-1]=='M')) {
                        
                     }else {
                        return false;
                     }
                     
                     if(j+1<C&&(map[i][j+1]=='-'||map[i][j+1]=='+'||map[i][j+1]=='3'||map[i][j+1]=='4'||map[i][j+1]=='Z'||map[i][j+1]=='M')) {
                        
                     }else {
                        return false;
                     }
                     break;
                  case '+' :
                     if(i-1>-1&&(map[i-1][j]=='|'||map[i-1][j]=='+'||map[i-1][j]=='1'||map[i-1][j]=='4'||map[i-1][j]=='Z'||map[i-1][j]=='M')) {
                        
                     }else {
                        return false;
                     }
                     
                     if(i+1<R&&(map[i+1][j]=='|'||map[i+1][j]=='+'||map[i+1][j]=='2'||map[i+1][j]=='3'||map[i+1][j]=='Z'||map[i+1][j]=='M')) {
                        
                     }else {
                        return false;
                     }
                     if(j-1>-1&&(map[i][j-1]=='-'||map[i][j-1]=='+'||map[i][j-1]=='1'||map[i][j-1]=='2'||map[i][j-1]=='Z'||map[i][j-1]=='M')) {
                        
                     }else {
                        return false;
                     }
                     
                     if(j+1<C&&(map[i][j+1]=='-'||map[i][j+1]=='+'||map[i][j+1]=='3'||map[i][j+1]=='4'||map[i][j+1]=='Z'||map[i][j+1]=='M')) {
                        
                     }else {
                        return false;
                     }
                     break;
                  case '1' :
                     if(j+1<C&&(map[i][j+1]=='-'||map[i][j+1]=='+'||map[i][j+1]=='3'||map[i][j+1]=='4'||map[i][j+1]=='Z'||map[i][j+1]=='M')) {
                        
                     }else {
                        return false;
                     }
                     if(i+1<R&&(map[i+1][j]=='|'||map[i+1][j]=='+'||map[i+1][j]=='2'||map[i+1][j]=='3'||map[i+1][j]=='Z'||map[i+1][j]=='M')) {
                        
                     }else {
                        return false;
                     }
                     break;
                  case '2' :
                     if(i-1>-1&&(map[i-1][j]=='|'||map[i-1][j]=='+'||map[i-1][j]=='1'||map[i-1][j]=='4'||map[i-1][j]=='Z'||map[i-1][j]=='M')) {
                        
                     }else {
                        return false;
                     }
                     if(j+1<C&&(map[i][j+1]=='-'||map[i][j+1]=='+'||map[i][j+1]=='3'||map[i][j+1]=='4'||map[i][j+1]=='Z'||map[i][j+1]=='M')) {
                        
                     }else {
                        return false;
                     }
                     break;
                  case '3' :
                     if(j-1>-1&&(map[i][j-1]=='-'||map[i][j-1]=='+'||map[i][j-1]=='1'||map[i][j-1]=='2'||map[i][j-1]=='Z'||map[i][j-1]=='M')) {
                        
                     }else {
                        return false;
                     }
                     
                     if(i-1>-1&&(map[i-1][j]=='|'||map[i-1][j]=='+'||map[i-1][j]=='1'||map[i-1][j]=='4'||map[i-1][j]=='Z'||map[i-1][j]=='M')) {
                        
                     }else {
                        return false;
                     }
                     break;
                  case '4' :
                     if(j-1>-1&&(map[i][j-1]=='-'||map[i][j-1]=='+'||map[i][j-1]=='1'||map[i][j-1]=='2'||map[i][j-1]=='Z'||map[i][j-1]=='M')) {
                        
                     }else {
                        return false;
                     }
                     if(i+1<R&&(map[i+1][j]=='|'||map[i+1][j]=='+'||map[i+1][j]=='2'||map[i+1][j]=='3'||map[i+1][j]=='Z'||map[i+1][j]=='M')) {
                        
                     }else {
                        return false;
                     }
                     break;
               }
            }
         }
      }
      return true;
   }

}