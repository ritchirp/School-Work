function output = Float_To_Bin(x, n)
output = "0."
    for i = 1:n
        a = floor(2*x);
        output = output + a;
        x = 2*x - a;
    end
end

