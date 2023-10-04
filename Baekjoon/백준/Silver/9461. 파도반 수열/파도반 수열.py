import sys
N = int(input())
list = []

for i in range(N):
    list.append(int(input()))

case = [0 for i in range(101)]
case[1] = 1
case[2] = 1
case[3] = 1

for i in range(0, 98):
    case[i + 3] = case[i] + case[i + 1]

for i in range(len(list)):
    print(case[list[i]])