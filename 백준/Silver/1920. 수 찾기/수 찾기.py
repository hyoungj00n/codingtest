import sys

input = sys.stdin.readline

N = int(input())
list1 = list(map(int, input().split()))

M = int(input())
list2 = list(map(int, input().split()))

list1.sort()


for i in range(len(list2)):
    start = 0
    end = len(list1)-1
    flag = 0
    while start <= end:
        mid = (start+end) // 2
        if list2[i] == list1[mid]:
            print(1)
            flag = 1
            break
        elif list2[i] > list1[mid]:
            start = mid+1
        else:
            end = mid-1
    if flag == 0:
        print(0)
