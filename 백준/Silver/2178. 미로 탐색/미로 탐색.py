import sys
from collections import deque
input = sys.stdin.readline

V, E = map(int, input().split())


graph = [list(map(int, input().rstrip())) for i in range(V)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def bfs(x, y):
    queue = deque()
    queue.append((x, y))

    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = dx[i]+x
            ny = dy[i]+y

            if 0 <= nx < V and 0 <= ny < E and graph[nx][ny] == 1:
                queue.append((nx, ny))
                graph[nx][ny] = graph[x][y]+1

    return graph[V-1][E-1]


print(bfs(0, 0))
