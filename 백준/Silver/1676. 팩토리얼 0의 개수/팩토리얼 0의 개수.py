import sys

n = int(sys.stdin.readline())


def fac_count(n):
    count = 0
    while n != 0:
        n = n // 5
        count += n
    return count

print(fac_count(n))