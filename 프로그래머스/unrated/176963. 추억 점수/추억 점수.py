def solution(name, yearning, photo):
    
    ny = {}
    for i in range(len(name)):
        ny[name[i]] = yearning[i]
    
    answer = []
    for i in range(len(photo)):
        count = 0
        for j in range(len(photo[i])):
            if photo[i][j] not in ny:
                continue
            count += ny[photo[i][j]]
        answer.append(count)
        
    
    return answer