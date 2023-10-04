import sys
from collections import deque

n, m, v = map(int,sys.stdin.readline().split())

def bfs(v):
    queue = deque()
    visit1[v]=1
    queue.append(v)

    while queue:
        v = queue.popleft()
        print(v,end= " ")
        for i in range(1,n+1):
            if visit1[i] == 0 and graph[v][i]==1:
                queue.append(i)
                visit1[i]=1

def dfs(v):

    visit2[v]=1
    print(v,end=" ")
    for i in range(1,n+1):
        if visit2[i]==0 and graph[v][i] == 1:
            dfs(i)

graph = [[0]*(n+1) for i in range(n+1)]
visit1 = [0]*(n+1)
visit2 = [0]*(n+1)

for i in range(m):
    a, b=map(int,sys.stdin.readline().split())
    graph[a][b] = graph[b][a] = 1

dfs(v)
print()
bfs(v)