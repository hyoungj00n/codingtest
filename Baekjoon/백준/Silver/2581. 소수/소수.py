m = int(input())
n = int(input())



def prime_num(a, b):
    count = 0
    pcount = 0
    min = 10000
    while a <= b:
        if a <= 1:
            a += 1
            continue

        for i in range(2,a+1):
            if a % i == 0:
                count += 1
        if count < 2:
            pcount += a
            if min > a:
                min = a
        count = 0

        
        a += 1

    if pcount == 0:
        return print(-1)

    return print("{}\n{}".format(pcount, min))

prime_num(m,n)