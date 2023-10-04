import sys
from collections import deque

n, v = map(int,sys.stdin.readline().split())
visit = [False]*(n+1)
graph = [[0]*(n+1) for _ in range(n+1)]


def bfs(v):
    queue = deque()
    queue.append(v)
    visit[v] = True

    while queue:
        v = queue.popleft()
        for i in range(1, n+1):
            if visit[i] == False and graph[v][i] == 1:
                queue.append(i)
                visit[i] = True



for i in range(v):
    a, b = map(int, sys.stdin.readline().split())
    graph[a][b] = graph[b][a] = 1

count = 0
for i in range(1, n+1):
    if not visit[i]:
        bfs(i)
        count+=1

print(count)