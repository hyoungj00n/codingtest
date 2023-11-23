import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        boolean flag = false;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        
        for (int i = 0; i<scoville.length; i++){
            heap.add(scoville[i]);
        }
        
        
        for (int i = 0; i< scoville.length; i++){
            int x1 = heap.poll();
            
            if (x1 >=K){
                flag = true;
                break;
            }
            if (scoville.length -1 == i){
                break;
            }
            else{
                int x2 = heap.poll();
                heap.add(x1+(x2*2));
                answer += 1;
            }
        }
        if(flag == false){
            answer = -1;
        }
        
        return answer;
    }
}