package Chess;

import java.awt.*;
import java.util.*;

public class HorseChessboard {
    public static int X;   //棋盘的列
    public static int Y;   //棋盘的行
    public static boolean visited[];
    public static boolean finished;


    public static void main(String[] args) {
        X=8;
        Y=8;
         int row = 2;//从1开始编号
         int column = 3;//从1开始编号
        int [][] chessboard = new int[X][Y];
        visited = new boolean[X*Y];
        long start = System.currentTimeMillis();
        traversalChessboard(chessboard,row-1,column-1,1);
        long end = System.currentTimeMillis();
        System.out.println(end-start+"毫秒");
        for(int[] rows :chessboard){
            for (int step :rows){
                System.out.print(step+"\t");
            }
            System.out.println();
        }
    }
    /**
     * 功能：得到下一个能走位置的集合
     * nowPoint:当前马所处的位置
     * ArrayList<Point>马可以行走的下一步的位置的集合
     */
    public static ArrayList<Point> getNextPoints(Point nowPoint) {
        ArrayList<Point> points = new ArrayList<Point>();
        Point p = new Point();
        if (((p.x = nowPoint.x - 2) >= 0) && ((p.y = nowPoint.y - 1) >= 0)) {
            points.add(new Point(p));
        }
        if (((p.x = nowPoint.x - 1) >= 0) && ((p.y = nowPoint.y - 2) >= 0)) {
            points.add(new Point(p));

        }
        if (((p.x = nowPoint.x + 1) < X) && ((p.y = nowPoint.y - 2) >= 0)) {
            points.add(new Point(p));

        }
        if (((p.x = nowPoint.x + 2) < X) && ((p.y = nowPoint.y - 1) >= 0)) {
            points.add(new Point(p));

        }
        if (((p.x = nowPoint.x + 2) < X) && ((p.y = nowPoint.y + 1) < Y)) {
            points.add(new Point(p));

        }
        if (((p.x = nowPoint.x + 1) < X) && ((p.y = nowPoint.y + 2) < Y)) {
            points.add(new Point(p));

        }
        if (((p.x = nowPoint.x - 1) >= 0) && ((p.y = nowPoint.y + 2) < Y)) {
            points.add(new Point(p));

        }
        if (((p.x = nowPoint.x - 2) >= 0) && ((p.y = nowPoint.y + 1) < Y)) {
            points.add(new Point(p));
        }

         return points;
    }

    /**
     *完成马踏棋盘的算法
     * chessboard 棋盘
     * row 当前位置的行  从零开始
     * column 当前位置的列    从零开始
     * step 第几步 初始位置为第一步
     */

    public static void traversalChessboard(int[][] chessboard,int row,int column,int step){
        chessboard[row][column] = step;
        visited[row*X+column] = true;
        ArrayList<Point> points = getNextPoints(new Point(column,row));
        sort(points);
        while (!points.isEmpty()){
            Point p = points.remove(0);
            if(!visited[p.y*X+p.x]){
                traversalChessboard(chessboard,p.y,p.x,step+1);
            }
        }
        if(step<X*Y&&!finished){
            chessboard[row][column] = 0;
            visited[row*X+column] = false;
        }else finished = true;
    }


    /***
     * 贪心算法 对当前位置的points对象的下一步位置的数目，进行非递减排序
     *
     */

    public static void sort(ArrayList<Point> points){
        points.sort(new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                int count1 = getNextPoints(p1).size();
                int count2 = getNextPoints(p2).size();
                if(count1<count2){
                    return -1;
                }else if(count1 == count2){
                    return 0;
                }else {
                    return 1;
                }
            }
        });
    }
}
