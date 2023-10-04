import heapq
def solution(scoville, K):
    heap=[]
    
    answer = 0
    
    for i in range(len(scoville)):
        heapq.heappush(heap,scoville[i])
    
    flag = False
    for i in range(len(scoville)):
        
        x1 = heapq.heappop(heap)
        
        if K <=x1:
            flag =True
            break
        if len(scoville)-1== i:
            break
        else:
            x2 = heapq.heappop(heap)
            heapq.heappush(heap,x1+(x2*2))
            
            answer +=1
    if flag == False:
        answer = -1
    return answer