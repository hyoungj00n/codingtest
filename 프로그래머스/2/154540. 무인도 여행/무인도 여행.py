from collections import deque


def bfs(maps, i, j, visited):

    queue = deque()
    dx = [1, 0, 0, -1]
    dy = [0, -1, 1, 0]

    visited[i][j] = 1
    queue.append((i, j))
    count = int(maps[i][j])
    while queue:
        x, y = queue.popleft()

        for p in range(4):
            nx = x + dx[p]
            ny = y + dy[p]
            if 0 <= nx < len(maps) and 0 <= ny < len(maps[0]):

                if visited[nx][ny] == 0 and maps[nx][ny] != 'X':
                    visited[nx][ny] = 1

                    queue.append((nx, ny))
                    count += int(maps[nx][ny])


    return count


def solution(maps):
    answer = []
    visited = [[0] * len(maps[0]) for _ in range(len(maps))]
    for i in range(len(maps)):
        for j in range(len(maps[0])):
            if maps[i][j] != 'X' and visited[i][j] == 0:
                answer.append(bfs(maps, i, j, visited))
    if not answer:
        answer.append((-1))
    answer = sorted(answer)
    return answer