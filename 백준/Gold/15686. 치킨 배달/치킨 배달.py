from itertools import combinations
n,m = map(int,input().split())
graph = [list(map(int,input().split())) for _ in range(n)]
chicken = []
house = []
for i in range(n):
   for j in range(n):
      if graph[i][j] == 2:
         chicken.append((i,j))
      elif graph[i][j] == 1:
         house.append((i,j))

length = int(1e9)
for comb in combinations(chicken,m):
	l = 0
	for i,j in house:
		h = int(1e9)
		for a,b in comb:
			h = min(h,abs(i-a)+abs(j-b))
		l += h
	length = min(length,l)

print(length)
	
      