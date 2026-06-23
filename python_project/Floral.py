import turtle
import math
import colorsys

t = turtle.Turtle()
t.speed (0)
t.width(2)
turtle.bgcolor("black")

for a in range (5000):
    r = 250 * math.cos(math.radians(8*a))

    x = r* math.cos(math.radians(a*1.5))
    y = r* math.sin(math.radians(a*1.5))

    t.goto(x,y)

    t.pencolor(colorsys.hsv_to_rgb(a / 5000, 1, 1))


turtle.done()