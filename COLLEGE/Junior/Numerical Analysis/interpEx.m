N = 6;
xData = linspace(0,1, N+1);
yData = cos(xData);
%yData = rand(1,N+1); % random data
a = 0.1;
b = interp(xData, yData, a);

w = linspace(0, 1, 200);
z = zeros(1,200);
for k = 1:200
   z(k) = interp(xData, yData, w(k)); 
end

plot(w,z,'r', 'linewidth', 2);