package Programmers;

public class 소수만들기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int totalCount = 0;
    public int solution(int[] nums) {
        int answer = -1;
        int numsLength = nums.length;
        boolean[] visited = new boolean[numsLength];
        for(int i=0; i<numsLength; i++){
            visited[i] = true;
            dfs(nums,visited,i,1);
            visited[i] = false;
        }
        
        System.out.println(totalCount);
        
        return totalCount;
    }
    public void dfs(int[] nums, boolean[] visited, int start, int count){
        if(count==3){
            // 소수 확인 로직
            int sum = 0;
            for(int i=0, numsLength=nums.length; i<numsLength; i++){
                if(visited[i]){
                    sum += nums[i];        
                }
            }
            boolean isPrime = true;
            int num = 2;
            while(true){
                if(sum%num==0){
                    isPrime = false;
                    break;
                }else {
                    num++;
                    if(num==sum) break;
                }
            }
            if(isPrime){
                totalCount++;
            }
            
            return;
        }
        
        for(int i = start, numsLength=nums.length; i< numsLength; i++){
            if(!visited[i]){
                visited[i]=true;
                dfs(nums,visited,i,count+1);
                visited[i]=false;
            }
        }
        
    }

}
