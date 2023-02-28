from itertools import combinations
n = int(input())
ing = [list(map(int,input().split())) for _ in range(n)]
n_min = int(1e9)
for comb in (combinations(ing,i+1) for i in range(n)):
   for c in comb:
      
      sour, bitter = 1,0
      for a,b in c:
         sour *= a
         bitter += b

      n_min = min(n_min,abs(sour-bitter))
      
print(n_min)