function [root, count] = Aitken(f, x_0, eps)
count = 0;
x = x_0;
y = f(x);
E = y-x;
a = 1.288091313211;

while(abs(E) > eps)
 count = count + 1;
 iteration = [count, x , y, E];
 x = y;
 y = f(x);
 E = y - x;
 what = [count, y, a - y, (a-y)/(a-x)]
    
end
count