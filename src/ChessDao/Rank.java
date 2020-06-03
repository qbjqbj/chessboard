package ChessDao;

import Player.Player;

import javax.management.relation.RelationNotFoundException;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class Rank {

    public static String name;
    public static int step = 20;
    public static List<Player> players ;

    public static List<Player> getPlayers() {
        return players;
    }

    public Rank() {
        players = sort();
    }

    public static void main(String[] args) {
        System.out.println(Rank.players);
    }

    public void add(String name,int step){
        File file = new File("src/ChessDao/RankDate");
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
            if (fw != null){
                fw.close();
                }
        }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    public static ArrayList<Player> read(){
        ArrayList<Player> players = new ArrayList<Player>();
        File file = new File("src/ChessDao/RankDate");
        FileReader fr = null;
        BufferedReader br = null;
        try{
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String line;
            String[] PlayerArray;
            Player player;
            while ((line = br.readLine())!=null){
                PlayerArray =line.split(":");
                player = new Player(PlayerArray[0],Integer.parseInt(PlayerArray[1]));
                players.add(player);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }}
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
public static ArrayList<Player> sort(){
    ArrayList<Player> playersArray = read();
    Player p ;
        for(int i = 0;i<playersArray.size();i++){
            for(int j = 0;j<playersArray.size()-i-1;j++){
                if(playersArray.get(j).getStep()<playersArray.get(j+1).getStep()){
                    Collections.swap(playersArray,j,j+1);


                }
            }
        }
        return playersArray;
}
    public static boolean isNumber(String s){
        if (s == null)
            return false;
        Pattern pattern = Pattern.compile("^[0-9]*[1-9][0-9]*$");
        return pattern.matcher(s).matches();
    }
}
