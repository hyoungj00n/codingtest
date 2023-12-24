import java.util.*;
class Solution {
    static int[][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};
    
    public void bfs(int[][] maps, int[][] visited){
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{0,0});
        
        while(!deque.isEmpty()){
            int[] temp = deque.poll();
            int x = temp[0];
            int y = temp[1];
            
            for(int i = 0; i< 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                
                if(nx>=0 && nx < maps.length && ny>=0 && ny< maps[0].length && visited[nx][ny] == 0 && maps[nx][ny]==1){
                visited[nx][ny] = visited[x][y] +1;
                deque.add(new int[]{nx, ny});
                }
            }
    
            
        }
    }
    public int solution(int[][] maps) {
        int answer = 0;
        
        visited = new int[maps.length][maps[0].length];
        
        visited[0][0] = 1;
        bfs(maps, visited);
        answer = visited[maps.length-1][maps[0].length-1];
        if (answer==0){
            answer = -1;
        }
        return answer;
    }
    
    
}