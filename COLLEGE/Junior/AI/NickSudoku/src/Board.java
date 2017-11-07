import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Board {

    Square[][] board;
    ArrayList<Square> topLeft = new ArrayList<>();
    ArrayList<Square> topCenter = new ArrayList<>();
    ArrayList<Square> topRight = new ArrayList<>();
    ArrayList<Square> middleLeft = new ArrayList<>();
    ArrayList<Square> middleCenter = new ArrayList<>();
    ArrayList<Square> middleRight = new ArrayList<>();
    ArrayList<Square> bottomLeft = new ArrayList<>();
    ArrayList<Square> bottomCenter = new ArrayList<>();
    ArrayList<Square> bottomRight = new ArrayList<>();

    ArrayList<ArrayList<Square>> subSections = new ArrayList<>();



    public Board(String file) {

        board = new Square[9][9];


        try {
            Scanner fileIn = new Scanner(new File(file));
            int row = 0;

            while (fileIn.hasNextLine()) {
                String line = fileIn.nextLine();
                for (int col = 0; col < 9; col++) {

                    // Parse integer values from lines, dashes become zeros
                    String valueStr = Character.toString(line.charAt(col));
                    int value;
                    try {
                        value = Integer.parseInt(valueStr);
                    }
                    catch (Exception e) {
                        value = 0;
                    }
                    board[row][col] = new Square(value, row, col);
                }
                row++;
            }
            subSections.add(topLeft);
            subSections.add(topCenter);
            subSections.add(topRight);
            subSections.add(middleLeft);
            subSections.add(middleCenter);
            subSections.add(middleRight);
            subSections.add(bottomLeft);
            subSections.add(bottomCenter);
            subSections.add(bottomRight);
            createSubsections();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error reading file");
        }
    }

    private void createSubsections() {
        int maxcol = 3;
        int col = 0;
        int row = 0;
        int maxrow = 3;
        for (ArrayList<Square> subsection : subSections) {
            for (; row < maxrow; row++) {
                for (; col < maxcol; col++) {
                    subsection.add(board[row][col]);
                }
                col -= 3;
            }
            row -= 3;
            col += 3;
            maxcol += 3;
            if (maxcol > 9) {
                col = 0;
                maxcol = 3;
                row += 3;
                maxrow += 3;
            }
        }
    }

    public void restoreDomains(ArrayList<Square> squares, int i) {
        for (Square square : squares) square.domain.add(i);
    }

    public ArrayList<Square> deleteFromDomains(Square square, int value) {
        ArrayList<Square> affectedSquares = new ArrayList<>();

        for (Square rowSquare : getRow(square.row)) {
            if (!square.equals(rowSquare))
            if (rowSquare.domain.remove(new Integer(value))) {
                affectedSquares.add(rowSquare);
            }
        }
        for (Square colSquare : getColumn(square.col)) {
            if (!square.equals(colSquare))
            if (colSquare.domain.remove(new Integer(value))) {
                affectedSquares.add(colSquare);
            }
        }
        for (Square secSquare : getSubsection(square.row, square.col)) {
            if (!square.equals(secSquare))
            if (secSquare.domain.remove(new Integer(value))) {
                affectedSquares.add(secSquare);
            }
        }

        return affectedSquares;
    }

    public boolean hasEmptyDomains() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col].domain.size() == 0) return true;
            }
        }
        return false;
    }

    public ArrayList<Square> getUnassignedSquares() {
        ArrayList<Square> result = new ArrayList<>();
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col].domain.size() > 1) result.add(board[row][col]);
            }
        }
        return result;
    }

    public boolean isComplete() {
        return getUnassignedSquares().size() == 0;
    }

    public Square[] getRow(int row) {
        return board[row];
    }

    public Square[] getColumn(int col) {
        Square[] result = new Square[9];
        for (int row = 0; row < 9; row++) {
            result[row] = board[row][col];
        }
        return result;
    }

    public ArrayList<Square> getSubsection(int row, int col) {
        if (row < 3 && col < 3) return topLeft;
        if (row < 3 && col >= 3 && col < 6) return topCenter;
        if (row < 3 && col >= 6 && col < 9) return topRight;

        if (col >= 3 && col < 6 && col < 3) return middleLeft;
        if (col >= 3 && col < 6 && col >= 3 && col < 6) return middleCenter;
        if (col >= 3 && col < 6 && col >= 6 && col < 9) return middleRight;

        if (col >= 6 && col < 9 && col < 3) return bottomLeft;
        if (col >= 6 && col < 9 && col >= 3 && col < 6) return bottomCenter;
        return bottomRight;
    }

    @Override
    public String toString() {
        String result = "";
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                result += board[row][col] + " ";
            }
            result += '\n';
        }
        return result;
    }

}
