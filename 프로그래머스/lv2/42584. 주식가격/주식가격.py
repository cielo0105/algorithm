from collections import deque
def solution(prices):
    answer = []
    queue = deque(prices)
    while queue:
        cnt = 0
        a = queue.popleft()
        for i in queue:
            cnt += 1
            if i < a: break
        answer.append(cnt)
    return answer