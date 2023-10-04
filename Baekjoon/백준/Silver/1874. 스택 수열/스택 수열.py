import sys

N = int(sys.stdin.readline())
arr = []
list1 = []
count = 1
flag = True
for i in range(N):
    n = int(sys.stdin.readline())
    while count <= n:
        arr.append('+')
        list1.append(count)
        count += 1

    if list1[-1] == n:
        arr.append('-')
        list1.pop()
    else:
        flag = False

if flag == False:
    print('NO')
else:
    for i in range(len(arr)):
        print(arr[i])
