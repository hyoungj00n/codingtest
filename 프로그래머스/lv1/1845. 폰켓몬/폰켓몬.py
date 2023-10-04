def solution(nums):
    answer = 0
    hash = {}
    for i in nums:
        if i not in hash:
            hash[i] = 1
    if len(nums)//2 <= len(hash):
        answer = len(nums)//2
    else:
        answer = len(hash)
    return answer