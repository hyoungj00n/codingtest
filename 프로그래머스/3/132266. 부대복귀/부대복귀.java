import java.util.*;
class Solution {
    static int[] result;
    static List<List<Integer>> graph;
    static void bfs(int destination){
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(destination);
        result[destination] = 0;
        
        while(!queue.isEmpty()){
            int tmp = queue.poll();
            List<Integer> tmpList = graph.get(tmp);
            for(int i = 0; i < tmpList.size(); i++){
                int check = tmpList.get(i);
                if(result[check] == -1){
                    result[check] = result[tmp] + 1;
                    queue.add(check);
                }
            }
        }
    }
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        
        graph = new ArrayList<>();
        
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i < roads.length; i++){
            graph.get(roads[i][0]).add(roads[i][1]);
            graph.get(roads[i][1]).add(roads[i][0]);
        }
        int[] answer = new int[sources.length];
        result = new int[n+1];
        Arrays.fill(result, -1);
        bfs(destination);
        
        for(int i = 0; i < sources.length; i++){
            answer[i] = result[sources[i]];
        }
        
        return answer;
    }
}