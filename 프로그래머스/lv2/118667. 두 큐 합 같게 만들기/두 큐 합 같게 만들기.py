from collections import deque
def solution(queue1, queue2):
    queue1 = deque(queue1)
    queue2 = deque(queue2)
    sum1 = sum(queue1)
    sum2 = sum(queue2)
    cnt = 0
    flag = 0
    l = len(queue1)
    while cnt < l*4:
        if sum1 < sum2:
            num = queue2.popleft()
            queue1.append(num)
            sum1 += num
            sum2 -= num
            cnt += 1
        elif sum1 > sum2:
            num = queue1.popleft()
            queue2.append(num)
            sum1 -= num
            sum2 += num
            cnt += 1
        else:
            flag = 1
            break
            
    if flag == 0:
        return -1
    else:
        return cnt
        