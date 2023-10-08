def game(check,board):
    if board[0][0] == check and board[1][1] ==check and board[2][2]== check:
        return True
    if board[0][2] == check and board[1][1] ==check and board[2][0]== check:
        return True
    for i in range(len(board)): 
        if board[i][0] == check and board[i][1] == check and board[i][2] == check: 
            return True
        elif board[0][i] == check and board[1][i] == check and board[2][i] == check:
            return True
    
def solution(board):
    answer = 1
    
    count_o = 0
    count_x = 0
    for i in range(len(board)):
        for j in range(len(board[i])):
            if board[i][j] == 'O':
                count_o +=1
            elif board[i][j] == 'X':
                count_x +=1
    
    if not (0 <= count_o - count_x <= 1):
        return 0
    elif count_o == count_x and (count_o == 3 or count_o == 4) :
        if game("O",board):
            return 0
    if count_o == 4 or count_o == 5:
           if game("X",board):
                return 0
    return answer
