format long;
n=0;
E = (5^(n+1)*10^6/factorial(2*n + 1));
while E >= 1
    E = (5^(n+1)*10^6/factorial(2*n + 1));
    iteration = [n,E]
    n = n+1;
end

