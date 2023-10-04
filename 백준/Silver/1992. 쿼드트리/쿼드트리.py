import sys

n = int(sys.stdin.readline())

field = [list(map(int, input())) for _ in range(n)]


def quadtree(n, x, y):

    flag = field[x][y]
    for i in range(x, x+n):
        for j in range(y, y+n):
            if flag != field[i][j]:
                flag = -1
                break

    if flag == -1:
        print("(", end='')
        quadtree(n//2, x, y)
        quadtree(n//2, x, y+n//2)
        quadtree(n//2, x+n//2, y)
        quadtree(n//2, x+n//2, y+n//2)
        print(")", end='')
    elif flag == 1:
        print("1", end='')
    else:
        print("0", end='')


quadtree(n, 0, 0)