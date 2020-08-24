local GameOfLife = {}

function GameOfLife : createFirstGeneration(m, n)

   first_generation  = {} -- create the matrix
   for i=1,m do
      first_generation[i] = {}     -- create a new row

      for j=1,n do
        first_generation[i][j] = math.random(0,1)
      end
   end

   return first_generation

end

function GameOfLife : printMatrix(matrix, m, n)

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

function GameOfLife : createNextGeneration(first_generation, m, n)
    
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

   return next_generation

end

function GameOfLife : playGOL()

   m,n  = 5,5
   generation = 5

   first_generation = GameOfLife : createFirstGeneration(m,n)

   print("------ Let's play Game of Life ------  " , '\n')
   GameOfLife : printMatrix(first_generation, m, n)

   while( generation > 0)
   do
      next_generation = GameOfLife : createNextGeneration(first_generation, m, n)
      GameOfLife : printMatrix(next_generation, m, n)
      first_generation = next_generation
      generation = generation - 1
   end

end

GameOfLife : playGOL()

return GameOfLife

 


