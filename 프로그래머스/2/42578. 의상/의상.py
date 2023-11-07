def solution(clothes):
    answer = 1
    hash = {}
    for cloth in clothes:
        
        if cloth[1] in hash:
            hash[cloth[1]] +=1
        else:
            hash[cloth[1]] = 1
    
    for cloth in hash:
        answer *= hash[cloth]+1
    
    return answer-1