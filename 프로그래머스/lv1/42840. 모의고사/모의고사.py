def solution(answers):
    answer = []
    field1 = [1,2,3,4,5]
    field2 = [2,1,2,3,2,4,2,5]
    field3 = [3,3,1,1,2,2,4,4,5,5]
    score = [0,0,0]
    
    for i, ans in enumerate(answers):
        if ans == field1[i % len(field1)]:
            score[0] +=1
        if ans == field2[i % len(field2)]:
            score[1] +=1
        if ans == field3[i % len(field3)]:
            score[2] +=1
    
    for i, ans in enumerate(score):
        if ans == max(score):
            answer.append(i+1)
    return answer