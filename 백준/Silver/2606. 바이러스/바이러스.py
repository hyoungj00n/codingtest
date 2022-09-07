import sys
from collections import deque

c = int(sys.stdin.readline())
n = int(sys.stdin.readline())
graph = [[0]*(c+1) for _ in range(c+1)]

for i in range(n):
    a,b = map(int,sys.stdin.readline().split())
    graph[a][b] = graph[b][a] = 1

visit =[0]*(c+1)


def bfs(v):
    queue = deque()
    visit[v] = 1
    queue.append(v)
    count = 0
    while queue:
        v = queue.popleft()

        for i in range(1,c+1):
            if visit[i] == 0 and graph[v][i]==1:
                count +=1
                visit[i]=1
                queue.append(i)
    return count


print(bfs(1))