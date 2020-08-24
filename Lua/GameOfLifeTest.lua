local GameOfLifeTest = {}

require('luaunit')
GOL = require('GameOfLife')

TestMyCode = {} --class
    function TestMyCode:testFirstGenerationType()

        first_gen = GOL : createFirstGeneration(m,n)
        assertEquals( type(first_gen), 'table' )

    end

    function TestMyCode:testNextGenerationType()

        m = 5
        n = 5
        first_generation = {
                {1,1,0,1,1},
                {0,1,0,1,1},
                {0,0,0,1,1},
                {1,1,0,1,0},
                {0,0,0,0,0}
            }

        next_gen = GOL : createNextGeneration(first_generation, m, n)

        expected_next_gen = {
            {'*', '*', '.', '*', '*'},
            {'*', '*', '.', '.', '.'},
            {'*', '*', '.', '.', '.'},
            {'.', '.', '*', '*', '*'},
            {'.', '.', '.', '.', '.'}
        }

        assertEquals(expected_next_gen[1][1], '*')
        assertEquals(expected_next_gen[1][2], '*')
        assertEquals(expected_next_gen[1][3], '.')
        assertEquals(expected_next_gen[1][4], '*')
        assertEquals(expected_next_gen[1][5], '*')
        assertEquals(expected_next_gen[2][1], '*')
        assertEquals(expected_next_gen[2][2], '*')
        assertEquals(expected_next_gen[2][3], '.')
        assertEquals(expected_next_gen[2][4], '.')
        assertEquals(expected_next_gen[2][5], '.')
        assertEquals(expected_next_gen[3][1], '*')
        assertEquals(expected_next_gen[3][2], '*')
        assertEquals(expected_next_gen[3][3], '.')
        assertEquals(expected_next_gen[3][4], '.')
        assertEquals(expected_next_gen[3][5], '.')
        assertEquals(expected_next_gen[4][1], '.')
        assertEquals(expected_next_gen[4][2], '.')
        assertEquals(expected_next_gen[4][3], '*')
        assertEquals(expected_next_gen[4][4], '*')
        assertEquals(expected_next_gen[4][5], '*')
        assertEquals(expected_next_gen[5][1], '.')
        assertEquals(expected_next_gen[5][2], '.')
        assertEquals(expected_next_gen[5][3], '.')
        assertEquals(expected_next_gen[5][4], '.')
        assertEquals(expected_next_gen[5][5], '.')

    end

LuaUnit:run()
