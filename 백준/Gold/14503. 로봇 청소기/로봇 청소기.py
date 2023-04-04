n,m = map(int,input().split())
r,c,d = map(int,input().split())
graph = []

back_x = [1,0,-1,0]
back_y = [0,-1,0,1] # 북,동,남,서 순서대로 뒤쪽 방향
front_x = [-1,0,1,0]
front_y = [0,1,0,-1] 
dir = [0,1,2,3]
def check(a,b):
   for i in range(4):
        if graph[a+back_x[i]][b+back_y[i]] == 0:
            return True
   return False

for i in range(n):
    n_list = list(map(int,input().split()))
    graph.append(n_list)
cnt = 0
while True:
   if graph[r][c] == 0:
      graph[r][c] = 2
      cnt += 1
   if check(r,c): 
      d = dir[d-1]
      if graph[r+front_x[d]][c+front_y[d]] == 0:
         r += front_x[d]
         c += front_y[d]
   else:
      if graph[r+back_x[d]][c+back_y[d]] != 1:
         r += back_x[d]
         c += back_y[d]
      else: break
print(cnt)