v = 0: 0.2: 1.2;
m = length(v);
F = zeros(m,m);

F(:,1) = cos(v);

for j=2:m
   for i = 1:(m-j+1)
       F(i,j) = (F(i+1,j-1) - F(i,j-1))/(v(i+j-1) - v(i));

   end
end
F