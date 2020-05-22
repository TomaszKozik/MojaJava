import java.lang.reflect.Array;
import java.util.*;

public class Test {

    public static String[][] input(int n) {
        Scanner sc = new Scanner(System.in);
        String[][] lines = new String[n][n];
        for (int i = 0; i < n; i++) {
            lines[i] = sc.nextLine().split(" ");
        }
        return lines;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer n = sc.nextInt();
        String[][] stringSudoku = input(n);

    }


    public static String[] getSquare(int n, String[][] sudoku) {
        String[] col = new String[n];
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n; j++) {
                col[i + j] = sudoku[i][j];
            }
        }
        return col;
    }


    public static String[][] rowCols(int n, String[][] sudoku) {
        String[][] col = new String[n][n];
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n; j++) {
                col[j][i] = sudoku[i][j];
            }
        }
        return col;
    }

    public static Boolean checkRow(int n, String[] row) {
        return (int) Arrays.stream(row).mapToInt(Integer::parseInt).distinct().count() == n;
    }


    public static void check(int n, String[][] sudoku) {
        boolean isOk = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (sudoku[i][j].equals(sudoku[i][i + j])) {
                    isOk = false;
                }
            }
        }
    }


//    String[] lines1 = {"WWWW", "AAAA", "CCCC", "DDDD"}; test(lines1);
//    String[] lines2 = {"WWWW", "AZZA", "CZZC", "DDDD"}; test(lines2);
//    String[] lines3 = {"WWWW", "AAGG", "CCGG", "DDDD"}; test(lines3);
//    String[] lines4 = {"WWWW", "AYZG", "CZYG", "DDDD"}; test(lines4);
//    String[] lines5 = {"BYBY", "YBGG", "BYGG", "YBYB"}; test(lines5);

}
