function output = Int_To_Bin(x)
output = "";
for i = 1:floor(log2(x+1) + 1)
   output = mod(x,2) + output;
   x = floor(x/2);
end
end