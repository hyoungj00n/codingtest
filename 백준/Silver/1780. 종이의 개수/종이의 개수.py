n = int(input())

field = [list(map(int, input().split())) for _ in range(n)]

count1 = 0
count0 = 0
count_minus = 0


def paper(n, x, y):

    global count1, count0, count_minus
    flag = field[x][y]

    for i in range(x, x+n):
        for j in range(y, y+n):
            if flag != field[i][j]:
                n = n//3
                paper(n, x, y)
                paper(n, x, y+n)
                paper(n, x+n, y)
                paper(n, x+n, y+n)
                paper(n, x+2*n, y)
                paper(n, x+2*n, y+n)
                paper(n, x, y+2*n)
                paper(n, x+n, y+2*n)
                paper(n, x+2*n, y+2*n)
                return
    if flag == 1:
        count1 += 1
        return

    elif flag == -1:
        count_minus += 1
        return

    else:
        count0 += 1
        return


paper(n, 0, 0)
print(count_minus)
print(count0)
print(count1)
