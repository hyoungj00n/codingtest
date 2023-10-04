def solution(players, callings):
    answer = []
    rank = {index : player for index,player in enumerate(players)}
    player = {player : index for index, player in enumerate(players)}
    
    for i in callings:
        now = player[i] # 현재 선수 인덱스
        front = now-1 # 앞선수 인덱스
        down = rank[front] # 앞선수명 저장 
        
        
        rank[now] = down 
        rank[front] = i
        
        player[down] = now
        player[i] = front
         
    
    return list(rank.values())