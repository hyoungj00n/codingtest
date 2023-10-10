from collections import deque


def bfs(maps,start,end):
    n = len(maps)
    m = len(maps[0])
    visited = [[0]* m  for _ in range(n)]
    queue = deque()
    dy = [0,1,-1,0]
    dx = [1,0,0,-1]
    flag = 0
    for i in range(n):
        for j in range(m):
            if maps[i][j] == start:
                queue.append((i,j,0))
                visited[i][j] =1
                flag = 1
                break
        if flag == 1:
            break
                
    while queue:
        y,x,cost= queue.popleft()
        
        if maps[y][x] == end:
            return cost
        
        for i in range(4):
            nx = x+ dx[i]
            ny = y + dy[i]
            if 0 <= nx <m and 0 <= ny < n and maps[ny][nx] != 'X':
                if visited [ny][nx]==0:
                    visited[ny][nx] = 1
                    queue.append((ny,nx,cost+1))
    return -1
def solution(maps):
    answer = 0
    answer1 = bfs(maps,'S','L')
    answer2 = bfs(maps,'L','E')
    if answer1 != -1 and answer2 != -1:
        return answer1 + answer2
    return -1
    