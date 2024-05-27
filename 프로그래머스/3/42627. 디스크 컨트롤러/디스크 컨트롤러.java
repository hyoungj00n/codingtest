import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        Arrays.sort(jobs, (o1, o2) -> o1[0]-o2[0]);
        
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        int end = 0;
        int i = 0;
        int index = 0;
        while(i<jobs.length){
            while(index<jobs.length && end >= jobs[index][0]){
                queue.add(jobs[index++]);
            }
            if(queue.isEmpty()){
                end = jobs[i][0];
            }else{
                int[] temp = queue.poll();
                answer += temp[1] + end - temp[0];
                end += temp[1];
                i++;
            }
        }
        return answer / jobs.length;
    }
}