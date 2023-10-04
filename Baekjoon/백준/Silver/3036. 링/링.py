from fractions import Fraction

n = int(input())
num_list = list(map(int,input().split()))

for i in range(1,len(num_list)):
    f = Fraction(num_list[0],num_list[i])
    print(f"{f.numerator}/{f.denominator}")
