n,x = map(int,input().split())
visit = list(map(int,input().split()))
v_max = sum(visit[:x])
num = sum(visit[:x])
cnt = 1

for i in range(x,n):
      num = num - visit[i-x] + visit[i]
      if num > v_max:
            v_max = num
            cnt = 1
      elif num == v_max:
            cnt += 1

if v_max == 0:
   print("SAD")
else:
	print(v_max)	
	print(cnt)	