import sys

n, k = map(int,sys.stdin.readline().split())
stack = []
num_list = []

for i in range(1,n+1):
    num_list.append(i)

count = 0
stack = []

while True:

    if not num_list:
        break

    count += k-1

    count = count % len(num_list)

    stack.append(num_list.pop(count))

print("<",end="")

for i in range(len(stack)-1):
    print(f"{stack[i]}",end=", ")

print(f'{stack[-1]}>')