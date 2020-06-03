package Servise;

import Player.Player;

import javax.management.loading.PrivateMLet;
import java.io.*;
import java.lang.reflect.AnnotatedType;
import java.util.ArrayList;

public class Rank {

    public static String name;
    public static int step = 20;
    public static ArrayList<Player> players;

    {
        players = read();
    }

    public void add(String name,int step){
        File file = new File("Y:\\马踏棋盘\\src\\Servise\\Rank");
        FileWriter fw = null;
        BufferedWriter bw = null;
        try{
            fw = new FileWriter(file,true);
            bw = new BufferedWriter(fw);
            bw.write(name+":"+step);
            bw.newLine();
        }catch (IOException e ){
            e.printStackTrace();
        }finally {
            try{
            if(bw !=null){
                bw.close();
            }
        }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    public ArrayList<Player> read(){
        ArrayList<Player> players = new ArrayList<Player>();
        File file = new File("Y:\\马踏棋盘\\src\\Servise\\Rank");
        FileReader fr = null;
        BufferedReader br = null;
        try{
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String line;
            String[] PlayerArray;
            Player player;
            while ((line = br.readLine())!=null){
                ;
                player = new Player(line.split(":")[0], Integer.valueOf(  line.split(":")[1]));
                players.add(player);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return players;
    }
    public int  rank(String name,int step){
        int r = 1;
        for(int i = 0;i<players.size();i++){
            if(players.get(i).step>step){
               r=r+1;
            }
        }
        return r;
    }
    public Boolean findname(String name){
        Boolean a = true;
        for(int i = 0;i<players.size();i++){
            if(name.equals(players.get(i).name)) {
                a = false;
            }
        }
        return a;

}
}
