def solution(n, k):
    answer = 0
    price = [12000, 2000]
    service = n // 10
    
    answer = price[0]*n + price[1]*k - price[1]*service
    
    return answer