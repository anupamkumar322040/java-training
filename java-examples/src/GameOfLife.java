public class GameOfLife {
    //Symbol for living cell is # and dead cell is .

    //driver code
    public static void main(String[] args) {
        int rows = 4, columns = 5, iterations = 3;

        // Initialization
        int[][] grid = {{0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0}
        };

        // Display the original grid
        System.out.println("Original Generation");
        display(grid, rows, columns);

        //compute and display future generations
        for (int index = 1; index < iterations; index++) {
            System.out.println("After " + index + " Generation");
            grid = nextGeneration(grid, rows, columns);
            display(grid, rows, columns);
        }
    }

    static int[][] nextGeneration(int[][] grid, int rows, int columns) {
        int[][] nextGenGrid = new int[rows][columns];

        // Loop through every column
        for (int rowIndex = 0; rowIndex < rows; rowIndex++) {
            //Loop through every rowIndex
            for (int columnIndex = 0; columnIndex < columns; columnIndex++) {
                // finding total alive neighbours
                int aliveNeighbours = countAliveNeighbours(grid, rowIndex, columnIndex, rows, columns);

                // Apply the rules
                // Cell dies due to being lonely
                if ((grid[rowIndex][columnIndex] == 1) && (aliveNeighbours < 2))
                    nextGenGrid[rowIndex][columnIndex] = 0;

                    // Cell dies due to over population
                else if ((grid[rowIndex][columnIndex] == 1) && (aliveNeighbours > 3))
                    nextGenGrid[rowIndex][columnIndex] = 0;

                    // new cell is born
                else if ((grid[rowIndex][columnIndex] == 0) && (aliveNeighbours == 3))
                    nextGenGrid[rowIndex][columnIndex] = 1;

                    // leave the cell as it is
                else
                    nextGenGrid[rowIndex][columnIndex] = grid[rowIndex][columnIndex];
            }
        }
        return nextGenGrid;
    }

    public static int countAliveNeighbours(int[][] grid, int rowIndex, int columnIndex, int rows, int columns) {
        int aliveNeighbours = 0;
        for (int i = -1; i <= 1; i++)
            for (int j = -1; j <= 1; j++)
                if ((rowIndex + i >= 0 && rowIndex + i < rows) && (columnIndex + j >= 0 && columnIndex + j < columns))
                    aliveNeighbours += grid[rowIndex + i][columnIndex + j];

        //subtract the cell itself
        aliveNeighbours -= grid[rowIndex][columnIndex];
        return aliveNeighbours;
    }

    public static void display(int[][] grid, int rows, int columns) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 0)
                    System.out.print(" . ");
                else
                    System.out.print(" # ");
            }
            System.out.println();
        }
    }
}