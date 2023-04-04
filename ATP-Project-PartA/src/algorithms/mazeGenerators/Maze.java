package algorithms.mazeGenerators;

public class Maze {

    private int[][] frame;
    private int rows;
    private int coloums;

    private Position startPoint;
    private Position endPoint;

    public Maze(int rows, int coloums)
    {
        frame = new int[rows][coloums]; // default with 0
        this.rows = rows;
        this.coloums = coloums;
        this.startPoint = new Position(0,0);
        this.endPoint = new Position(rows - 1, coloums - 1);
    }

    public static void setAllMazeToWalls(Maze maze)
    {
        for(int i=0; i<maze.rows; i++)
        {
            for(int j=0; j<maze.coloums; j++)
            {
                maze.frame[i][j] = 1;
            }
        }
    }

    public void setCellInMaze(int row, int colum, int val)
    {
        if(0 <= row && row < this.rows && 0 <= colum && colum < this.coloums)
            this.frame[row][colum] = val;
    }

    public int[][] getFrame() {
        return frame;
    }

    public int getRows() {
        return rows;
    }

    public int getColoums() {
        return coloums;
    }

    public int getCellValue(int row, int colum)
    {
        if(0 <= row && row < this.rows && 0 <= colum && colum < this.coloums)
            return this.frame[row][colum];
        else
            return -1;
    }
    public Position getStartPosition() {
        return startPoint;
    }

    public Position getGoalPosition() {
        return endPoint;
    }

    public void print(){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < getColoums(); j++) {

                if (i == 0 && j == 0) {
                    System.out.print(" S "); // 'S' represents the entry point
                } else if (i == rows-1 && j == coloums-1) {
                    System.out.print(" E "); // 'E' represents the exit point
                }
                else if (this.frame[i][j] == 1) {
                    System.out.print(" \u2610 "); // '*' represents a wall
                }
                else {
                    System.out.print(" \u2605 "); // ' ' represents an empty cell
                }
            }
            System.out.println();
        }
    };
}

