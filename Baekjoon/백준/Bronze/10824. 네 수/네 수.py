import sys

a, b, c, d = map(int,sys.stdin.readline().split())

a_b = str(a)+str(b)
c_d = str(c)+str(d)

print(int(a_b)+int(c_d))