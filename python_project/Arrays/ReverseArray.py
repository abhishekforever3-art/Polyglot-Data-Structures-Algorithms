a = [10, 20, 30, 40, 50]
b = []
left = 0
right = len(a) - 1
while left < right:
    temp = a[left]
    a[left] = a[right]
    a[right] = temp

    left = left + 1
    right = right - 1
print(a)