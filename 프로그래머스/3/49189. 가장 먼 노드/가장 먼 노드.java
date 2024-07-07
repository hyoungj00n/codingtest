import java.util.*;
class Solution {
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    static int answer;
    static void bfs( boolean[] visited, int n ){
        Queue<int[]> queue = new LinkedList<>();
        visited[1] = true;
        queue.add(new int[] {1,0});
        int max = 0;
        
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            int v = tmp[0];
            int depth = tmp[1];
            
            if(max == depth){
                answer++;
            }else{
                max = depth;
                answer = 1;
            }
            
            for(int i = 0; i < list.get(v).size(); i++){
                int tempVertex = list.get(v).get(i);
                if(!visited[tempVertex]){
                    queue.add(new int[] {tempVertex, depth+1});
                    visited[tempVertex] = true;                
                }
                
            }
            
        }
        
        
        
    }
    
    public int solution(int n, int[][] edge) {
        answer = 0;
        for(int i = 0; i <= n; i++){
            list.add(new ArrayList<>());
        }
        
        for( int[] e : edge){
            int v1 = e[0];
            int v2 = e[1];
            
            list.get(v1).add(v2);
            list.get(v2).add(v1);
        }
        
        visited = new boolean[n+1];
        
        bfs(visited, n);
        
        return answer;
    }
}