n,x = map(int,input().split())
visit = list(map(int,input().split()))
v_max = sum(visit[:x])
num = sum(visit[:x])
cnt = 1
start = 0
end = x-1
while end < n-1:
   num = num - visit[start] + visit[end+1]
   if num > v_max:
      v_max = num
      cnt = 1
   elif num == v_max:
      cnt += 1
   
   start += 1
   end += 1

if v_max == 0:
   print("SAD")
else:
	print(v_max)	
	print(cnt)	