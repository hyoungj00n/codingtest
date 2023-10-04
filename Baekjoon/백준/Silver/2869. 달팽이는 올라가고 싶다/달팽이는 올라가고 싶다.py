import math
a, b, v = map(int, input().split())


def snail(go, back, day):
    total = day
    count_day = 1
    # while True:
    #     total = total - go
    #
    #     if total <= 0:
    #         break
    #
    #     count_day += 1
    #     total = total + back
    # return count_day

    total= (total-back) / (go-back)
    return total


print(math.ceil(snail(a, b, v)))