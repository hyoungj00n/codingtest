def solution(citations):
    
    citations.sort(reverse = True)
    count = 0
    for citation in citations:
        
        
        if citation <count+1 :
            return count
        count +=1
        
    return count
        
        
    
