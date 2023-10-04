
def solution(progresses, speeds):
    answer = []
         
    while progresses:
        count = 0
        progresses = [x+y for x,y in zip(progresses,speeds)]
        
        for i in range(len(progresses)):
            if progresses[0] <100:
                break
            if progresses[i-count]>= 100:
                del progresses[i-count]
                del speeds[i-count]
                count+=1
        if count!=0:
            answer.append(count)
        
    return answer