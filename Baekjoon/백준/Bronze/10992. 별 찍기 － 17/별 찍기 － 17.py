n = int(input())
space =1
for i in range(1,n+1):
    if i == n:
        print("*" * (i*2-1))
        break

    print(' ' * (n-i), end='')
    print("*",end='')
    if i>=2:
        print(" " *space ,end='')
        print("*",end='')
        space +=2


    print()