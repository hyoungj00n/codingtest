n, m = map(int, input().split())
arr = []
visited = [False] * (n + 1)


def dfs():
    if len(arr) == m:
        return print(" ".join(map(str, arr)))

    for i in range(1, n + 1):
        if visited[i] == True:
            continue
        arr.append(i)
        visited[i] = True
        dfs()
        arr.pop()
        visited[i] = False


dfs()
