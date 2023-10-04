n = int(input())


def two(n):

    table = [0,1,1]

    for i in range(3, n+1):
        table.append(table[i-1]+table[i-2])

    return table[n]
print(two(n))