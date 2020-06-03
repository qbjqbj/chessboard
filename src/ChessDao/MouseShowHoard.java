package ChessDao;

import Chess.*;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.GenericArrayType;
import java.net.spi.URLStreamHandlerProvider;
import java.util.ArrayList;

public class MouseShowHoard {
    public int column_x = Chess.getColumn();
    public int row_y = Chess.getRow();
    public ArrayList<Point> points = ChessAlgorithm.getNextPoints(new Point(column_x-1,row_y-1));

    public MouseShowHoard(int column,int row){
        System.out.println(points);
        for(int i = 0;i<points.size();i++){
            if(column == points.get(i).x&&row == points.get(i).y){
                System.out.println(Chess.column+":"+Chess.row);
                Chess.setColumn(column+1);
                Chess.setRow(row+1);
                Chess.visited[row*8+column] = true;
                Chess.step++;
                System.out.println(Chess.column+":"+Chess.row);
            }
        }
    }
}
