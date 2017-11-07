function [root, count] = Secant (f, x_0, x_1, E)

prevprev = x_0;
prev = x_1;
current = prev - f(prev)*(prev - prevprev)/(f(prev) - f(prevprev));
count = 2;

while(abs(current - prev) >= E)
    out = [current, count]
    prevprev = prev;
    prev = current;
    current = prev - f(prev)*(prev - prevprev)/(f(prev) - f(prevprev));
    count = count + 1;
end
count
root = current;