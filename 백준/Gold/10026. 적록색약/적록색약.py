import sys
from collections import deque
n = int(sys.stdin.readline())
graph = [list(map(str, sys.stdin.readline())) for i in range(n)]
visit1 = [[0]*(n+1) for i in range(n+1)]
visit2 = [[0]*(n+1) for i in range(n+1)]
dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]


def bfs1(graph, x, y):
    queue = deque()
    queue.append((x, y))
    visit1[x][y] = 1
    count1 = 1
    count2 = 1
    while queue:
        x, y = queue.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or ny < 0 or nx >= n or ny >= n:
                continue
            if visit1[nx][ny] == 0 and graph[x][y] == graph[nx][ny]:
                visit1[nx][ny] = 1
                queue.append((nx, ny))


def findG(R, G):
    if R == 'R' and G == 'G':
        return True


def findR(G, R):
    if G == 'G' and R == 'R':
        return True


def bfs2(graph, x, y):
    queue = deque()
    queue.append((x, y))
    visit2[x][y] = 1
    count1 = 1
    count2 = 1
    while queue:
        x, y = queue.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or ny < 0 or nx >= n or ny >= n:
                continue
            if visit2[nx][ny] == 0 and (graph[x][y] == graph[nx][ny] or findG(graph[x][y], graph[nx][ny]) or findR(graph[x][y], graph[nx][ny])):
                visit2[nx][ny] = 1
                queue.append((nx, ny))


count1 = 0
count2 = 0
for i in range(n):
    for j in range(n):
        if visit1[i][j] == 0:
            bfs1(graph, i, j)
            count1 += 1
for i in range(n):
    for j in range(n):
        if visit2[i][j] == 0:
            bfs2(graph, i, j)
            count2 += 1
print(count1, count2)
