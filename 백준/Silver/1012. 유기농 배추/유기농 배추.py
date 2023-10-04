import sys
from collections import deque
sys.setrecursionlimit(10000)


T = int(sys.stdin.readline())


dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def dfs(x, y):

    dx = [0, 0, -1, 1]
    dy = [1, -1, 0, 0]

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if (0 <= nx < M) and (0 <= ny < N):
            if graph[nx][ny] == 1:
                graph[nx][ny] = -1
                dfs(nx, ny)


for i in range(T):
    M, N, K = map(int, sys.stdin.readline().split())

    graph = [[0] * N for _ in range(M)]

    for j in range(K):
        a, b = map(int, sys.stdin.readline().split())
        graph[a][b] = 1

    count = 0
    for l in range(M):
        for k in range(N):
            if graph[l][k] == 1:
                dfs(l, k)
                count += 1
    print(count)