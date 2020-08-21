print("This is Game of Life")
m, n = 10, 10
-- This is a counter for the number of generations to be produced. Here, it is 10
generations = 100
print("value of m " ,m)
print("value of n ",n, "\n")

first_generation  = {} -- create the matrix

for i=1,m do
    first_generation[i] = {}     -- create a new row

      for j=1,n do
        first_generation[i][j] = math.random(0,1)
      end

end

function printMatrix(matrix)

    for i=1,m do

        for j=1,n do
            if(matrix[i][j] == 0) then
                io.write(".")
            else
                io.write("*")
            end
        end
        print("\n")

    end

end

-- Printing the first randomly produced value generation
print("First generation : ")
printMatrix(first_generation)

function nextGeneration()
    
    -- Initialising next generation
    local next_generation = {}
    for i=1,m do
        next_generation[i] = {}    
    
          for j=1,n do
            next_generation[i][j] = 0
          end
    
    end

    -- Logic for producing next generation
    for i = 1,m do
        for j = 1,n do
            local count = 0
            for p = i-1,i+1 do
                for q = j-1,j+1 do
                    if p > 0 and p <= m and q > 0 and q <= n then
                        count = count + tonumber(first_generation[p][q])
                    end                  
                end
            end

            count = count - tonumber(first_generation[i][j])

            if count == 2 or count == 3 then
                if first_generation[i][j] == 1 then
                    next_generation[i][j] = 1
                else
                    if count == 2 then
                        next_generation[i][j] = 0
                    else
                        next_generation[i][j] = 1
                    end

                end
            else
                next_generation[i][j] = 0
            end
        end
    end

    -- print(number_of_gen)
    printMatrix(next_generation)
    
    first_generation = next_generation
    generations = generations - 1

end

while( generations > 0)
do 
    nextGeneration()
end

