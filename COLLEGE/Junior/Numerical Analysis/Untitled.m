current = 1;

for i = 1:6
    last = current;
    current = exp(-last);
    iteration = [current, i]
end