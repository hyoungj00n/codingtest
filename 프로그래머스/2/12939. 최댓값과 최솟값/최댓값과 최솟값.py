def solution(s):
    answer = ''
    nums = list(map(int,s.split(" ")))
    print(nums)
    answer = "{} {}".format(min(nums),max(nums))
    return answer