import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Deque<Integer> queue = new ArrayDeque<>();
        Deque<Integer> location_arr = new ArrayDeque<>();
        int i = 0;
        for (int priority:priorities){
            queue.add(priority);
            location_arr.add(i);
            i++;
        }
            
        
        while(!queue.isEmpty()){
            int check = Arrays.stream(priorities).max().getAsInt();
            int tmp = queue.poll();
            int loc = location_arr.poll();
            if (tmp == check){
                answer++;
                if (loc==location){
                    break;
                }
                else{
                    priorities[loc]=0;
                }
            }else{
                queue.add(tmp);
                location_arr.add(loc);
                
            }
        }
        return answer;
    }
}