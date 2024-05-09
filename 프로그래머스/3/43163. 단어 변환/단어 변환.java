class Solution {
    static int answer;
    static boolean[] visited;
    public static void dfs(int depth,String begin, String target, String[] words){
        if(begin.equals(target)){
            answer = depth;
            return;
        }
        
        for(int i = 0; i < words.length; i++){
            if(visited[i] == true){
                continue;
            }
            int check = 0;
            for(int j = 0; j < begin.length(); j++){
                if(begin.charAt(j) == words[i].charAt(j)){
                    check++;
                }
            }    
            if(check == begin.length()-1){
                visited[i]= true;
                dfs(depth+1,words[i],target,words);
                visited[i] = false;
            }
            

        }
    }
    public int solution(String begin, String target, String[] words) {
        answer = 0;
        int flag = 0;
        visited = new boolean[words.length];
        for(String word: words){
            if(target.equals(word)){
                flag=1;
            }
        }
        if (flag == 0){
            return 0;
        }
        
        
        dfs(0,begin,target,words);
        
        return answer;
    }
}