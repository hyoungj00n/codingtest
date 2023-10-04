import sys

def is_prime(num):
    if num==1:
        return False

    for i in range(2,int(num**0.5)+1):
        if num % i == 0:
            return False
    return True

while True:

    num = int(sys.stdin.readline())

    if num == 0:
        break

    for i in range(3, num+1,2):
        flag = True

        if is_prime(i):
            if is_prime(num-i):
                print(f"{num} = {i} + {num-i}")
                flag=False
                break

    if flag:
        print("Goldbach's conjecture is wrong.")
