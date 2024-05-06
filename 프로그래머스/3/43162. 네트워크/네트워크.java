class Solution {
    public static void dfs(int[][] computers, int n, boolean[] visited){
        visited[n] = true;
        
        for(int i = 0; i < computers[n].length; i++){
            if(computers[n][i] == 1 && visited[i] == false){
                dfs(computers, i, visited);
            }
        }
    }
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[computers.length];
        for(int i = 0; i < computers.length; i++){
            if(visited[i] == false ){
                dfs(computers, i, visited);
                answer++;
            }
        }
        return answer;
    }
}