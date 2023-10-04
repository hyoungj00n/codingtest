import sys

n = int(sys.stdin.readline())
blue = 0
white = 0

field = [list(map(int, input().split())) for _ in range(n)]


def color_paper(n, x, y):

    global blue, white
    flag = field[x][y]

    for i in range(x, x+n):
        for j in range(y, y+n):
            if flag != field[i][j]:
                color_paper(n//2, x, y)
                color_paper(n//2, x, y+n//2)
                color_paper(n//2, x+n//2, y)
                color_paper(n//2, x+n//2, y+n//2)
                return

    if flag == 1:
        blue += 1
        return

    else:
        white += 1
        return


color_paper(n, 0, 0)
print(white)
print(blue)