def hansu(n):

    count = 0

    for i in range(1,n+1):
        han = list(map(int, str(i)))

        if i < 100:
            count += 1
        elif han[1]-han[0] == han[2]-han[1]:
            count += 1
    return count

num = int(input())

print(hansu(num))