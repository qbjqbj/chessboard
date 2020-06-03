package Chess;

public class Chess {
    public static int row;//马的初始行
    public static int startrow;
    public static int startcolumn;
    public static int column;//马的初始列
    public static boolean visited[] = new boolean[64];
    public static int step = 0;

    public static int getRow() {
        return row;
    }

    public static int getColumn() {
        return column;
    }

    public static void setRow(int row) {
        Chess.row = row;
    }

    public static void setColumn(int column) {
        Chess.column = column;
    }
}
