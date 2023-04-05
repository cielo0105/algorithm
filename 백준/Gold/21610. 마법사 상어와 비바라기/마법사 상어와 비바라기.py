n,m = map(int,input().split())
graph = []
cloud = [(n-1,0),(n-1,1),(n-2,0),(n-2,1)]
visit = [[0]*n for _ in range(n)]
dx = [0,0,-1,-1,-1,0,1,1,1]
dy = [0,-1,-1,0,1,1,1,0,-1]
dia_x = [-1,1,1,-1] 
dia_y = [1,1,-1,-1]

def copy(x,y):
   cnt = 0
   for i in range(4):
      nx = x + dia_x[i]
      ny = y + dia_y[i]

      if 0<=nx<n and 0<=ny<n and graph[nx][ny] >= 1:
         cnt += 1
  
   return cnt     

def make_cloud():
   n_cloud = []
   for i in range(n):
       for j in range(n):
          if graph[i][j] >= 2 and visit[i][j] == 0:
             graph[i][j] -= 2
             n_cloud.append((i,j))
   return n_cloud

for _ in range(n):
   n_list = list(map(int,input().split()))
   graph.append(n_list)

for _ in range(m):
   d,s = map(int,input().split())
   n_cloud = []
   for i,j in cloud:
      i = (i+dx[d]*s)%n
      j = (j+dy[d]*s)%n
      if i < 0: i += n
      if j < 0: j += n
      graph[i][j] += 1
      n_cloud.append((i,j))
   cloud = n_cloud
   visit = [[0]*n for _ in range(n)]
   for i,j in cloud:
      cnt = copy(i,j)
      graph[i][j] += cnt
      visit[i][j] = 1
   
   cloud = make_cloud()
ans = 0
for i in range(n):
   for j in range(n):
      ans += graph[i][j]
      
print(ans)