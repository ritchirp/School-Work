function output = Bisection_Method(f, a, b, E)

c = (a+b)/2;
count = 0;

while(b - c >= E)
    iteration = [count, a ,b ,c, b - c];
    if(f(b) * f(c) < 0)
        a = c;
    elseif(f(a) * f(c) < 0)
        b = c;
    else
        break;
    end
    c = (a+b)/2;
    count = count + 1;
end
count
output = c;
