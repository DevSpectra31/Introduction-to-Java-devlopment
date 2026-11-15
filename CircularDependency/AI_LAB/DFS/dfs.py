maze = [
    "S..#",
    "#.#.",
    "#..E"
]

rows = len(maze)
cols = len(maze[0])

for r in range(rows):
    for c in range(cols):
        if maze[r][c] == "S":
            start = (r, c)
        if maze[r][c] == "E":
            end = (r, c)

stack = [start]
seen = {start}

while stack:
    r, c = stack.pop()

    if (r, c) == end:
        print("Found")
        break

    for dr, dc in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
        nr = r + dr
        nc = c + dc

        if 0 <= nr < rows and 0 <= nc < cols:
            if maze[nr][nc] != "#" and (nr, nc) not in seen:
                seen.add((nr, nc))
                stack.append((nr, nc))
else:
    print("Not Found")