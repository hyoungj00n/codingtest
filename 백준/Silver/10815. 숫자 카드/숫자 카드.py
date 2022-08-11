m = int(input())
set1 = set(list(map(int, input().split())))

n = int(input())
set2 = set(list(map(int, input().split())))

set3 = set1 & set2

for i in set2:
    if i in set3:
        print(1,end=" ")
    else:
        print(0,end=" ")