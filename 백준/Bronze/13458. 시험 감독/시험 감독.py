import math
n = int(input())
n_list = list(map(int,input().split()))
b,c = map(int,input().split())
cnt = 0
for i in n_list:
    cnt+=1
    if i-b>0:
    	cnt+=math.ceil((i-b)/c)
    
print(cnt)