def solution(n, m, section):
    answer = 0
    start = section[0]
    for i in range(len(section)):
        if section[i] >= start:
            start = section[i]+m
            answer+=1
        
        
    return answer