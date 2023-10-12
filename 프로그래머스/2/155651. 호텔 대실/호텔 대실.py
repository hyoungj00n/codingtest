from collections import deque
from heapq import heappush, heappop

def change(num):
    hour,min = num.split(":")
    t = int(hour) * 60 + int(min)
    return t
def solution(book_time):
    answer = 0
    
    book_time.sort(key=lambda x : x[0])
    room = []
        
    for b in book_time:
        checkin = change(b[0])
        checkout = change(b[1]) + 10
        
        
        if len(room) != 0 and room[0]<= checkin:
            heappop(room)
        heappush(room,checkout)
    
        
    
    return len(room)