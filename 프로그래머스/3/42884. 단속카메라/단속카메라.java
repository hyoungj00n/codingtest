import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[1] - o2[1];
            }
        });
        int cam = Integer.MIN_VALUE;
        
        for(int i = 0; i < routes.length; i++){
            if(cam < routes[i][0]){
                cam = routes[i][1];
                answer++;
            }
        }

        return answer;
    }
}