function output = Simpson(a,b,f,n)

format long;

x = linspace(a,b,n);
sum = 0;
for i = 1:n
   if(mod(i,2)==0)
       sum = sum + 2*f(x(i));
   else
       sum = sum + 4*f(x(i));
   end
end

output = (b-a)/(3*n) * (sum + f(a) + f(b));