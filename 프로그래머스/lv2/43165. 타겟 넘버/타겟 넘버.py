
def solution(numbers, target):
    global answer
    answer = 0
    
    
    def dfs(count,n):
        global answer
        if count == len(numbers):
            if target == n:
                answer += 1
                
            return 
        
        
            
        
        dfs(count+1,n+numbers[count])
        dfs(count+1,n-numbers[count])
            
        
        
    
    print(dfs(0,0))
    return answer