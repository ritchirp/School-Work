% x - the set of x coordinates
% y - the set of y coordinates
% t - the value to evaluate the polynomial at
function f = interp( x, y, t )
f = 0;
n = length(x);
for j = 1:n
    
    L = 1;
    for i =1:n
       if(i ~= j)
           L = L*(t - x(i))/(x(j) - x(i));
        
       end
    end
    f = f + y(j)*L;
    
end


end

