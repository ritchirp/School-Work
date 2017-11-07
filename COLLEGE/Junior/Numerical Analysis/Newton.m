function [root, count] = Newton(f, deriv, x0, E)
xn = @(x) x - f(x)/deriv(x);

current = x0;
next = xn(x0);
count = 0;

while(abs(next - current) >= E)
    if(deriv(current) ~= 0)
        current = next;
        next = xn(current);
        count = count + 1;
    else
        disp("Error, 0 in sequence")
        break;
    end
end
count
root = current;
