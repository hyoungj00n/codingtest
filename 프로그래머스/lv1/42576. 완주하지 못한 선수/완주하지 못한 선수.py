def solution(participant, completion):
    answer = ''
    hash = {}
    
    for part in participant :
        if part in hash:
            hash[part] +=1
            continue
        hash[part] = 1
    
       
    for comp in completion:
        if comp in hash:
            if hash[comp] >1:
                hash[comp] -=1
            else:    
                del hash[comp]
    
    
        
    return list(hash.keys())[0]