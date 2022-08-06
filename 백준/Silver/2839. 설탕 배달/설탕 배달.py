n = int(input())

def sugar(n):

    if n % 5 ==0:
        return n//5
    else:
        total=0
        while n > 0:
            n -= 3
            total +=1

            if n % 5==0:
                total += n//5
                return total

            elif n == 1 or n == 2:
                return -1

            elif n == 0:
                return total




print(sugar(n))