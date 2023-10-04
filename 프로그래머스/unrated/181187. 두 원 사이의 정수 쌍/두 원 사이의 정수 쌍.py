import math

def solution(r1, r2):
    answer = 0
    for i in range(1,r2+1):
        total1 = math.floor(math.sqrt(r2**2-i**2))
        if i<=r1:
            total2 = math.ceil(math.sqrt(r1**2 - i**2))
        else:
            total2 = 0
        answer += total1 - total2+1     
    return 4 * answer