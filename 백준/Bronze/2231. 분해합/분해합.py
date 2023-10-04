N = int(input())

for i in range(N):
    if N < 2:
        print(0)
        break
    num_sum = sum(list(map(int, str(i))))
    if N == num_sum + i:
        print(i)
        break
    elif i == N-1:
        print(0)