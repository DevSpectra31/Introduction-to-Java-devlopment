from collections import deque

maze = [
    "S..#",
    "#.E#",
    "#..E"
]

rows = len(maze)
cols = len(maze[0])

for r in range(rows):
    for c in range(cols):
        if maze[r][c] == 'S':
            start = (r, c)
        elif maze[r][c] == 'E':
            end = (r, c)

queue = deque([start])
visited = {start}
parent = {start: None}

directions = [
    (-1, 0),
    (1, 0),
    (0, -1),
    (0, 1)
]

while queue:
    r, c = queue.popleft()

    if (r, c) == end:
        break

    for dr, dc in directions:
        nr = r + dr
        nc = c + dc

        if not (0 <= nr < rows and 0 <= nc < cols):
            continue

        if maze[nr][nc] == '#':
            continue

        if (nr, nc) in visited:
            continue

        visited.add((nr, nc))
        parent[(nr, nc)] = (r, c)
        queue.append((nr, nc))

if end in parent:
    path = []
    current = end

    while current is not None:
        path.append(current)
        current = parent[current]

    path.reverse()

    print("Shortest path:", path)
    print("Distance:", len(path) - 1)
else:
    print("No path exists")