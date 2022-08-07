n = int(input())

num_list = list(map(int, input().split()))

def prime_num():
    count = 0
    pnum_count=0
    for i in range(len(num_list)):
        if num_list[i] == 1:
            continue
        for j in range(2, num_list[i]+1):

            if num_list[i] % j == 0:
                count += 1
        if count < 2:
            pnum_count += 1
        count = 0
    return pnum_count

print(prime_num())
