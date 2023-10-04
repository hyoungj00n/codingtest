n = int(input())
t = [0] * (n+1)

for i in range(n+1):
    if i == 1:
        t[i] = 1
    elif i == 2:
        t[i] = 2
    else:
        t[i] = t[i-1]+t[i-2]
print(t[i]%10007)
