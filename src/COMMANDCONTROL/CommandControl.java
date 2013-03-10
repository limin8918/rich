package COMMANDCONTROL;

import GAMEPLAYER.*;
import LANDFORM.ALandForm;
import MAP.Map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 13-2-10
 * Time: 下午10:52
 * To change this template use File | Settings | File Templates.
 */
public class CommandControl {
    protected Vector<AGamePlayer> gamePlayerVector;
    protected Map map;

    public CommandControl(){
        this.gamePlayerVector = new Vector<AGamePlayer>();
        this.map = new Map();
    }

    //初始化命令
    public void initialize(){
        AGamePlayer gamePlayer;
        System.out.println("欢迎光临大富翁游戏！");
        System.out.println("请选择2~4位不重复玩家，输入编号即可。(1.钱夫人; 2.阿土伯; 3.孙小美; 4.金贝贝):");
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String thisLine;
        try {
            thisLine = br.readLine();
            map.getLandform(0).setGamePlayerCount(thisLine.length());
            for(int i = 0;i < thisLine.length();i++){
                switch (Integer.parseInt(thisLine.substring(i,i + 1))){
                    case 1:{gamePlayer = new GamePlayer(1,"钱夫人",3000);gamePlayerVector.addElement(gamePlayer);break;}
                    case 2:{gamePlayer = new GamePlayer(2,"阿土伯",3000);gamePlayerVector.addElement(gamePlayer);break;}
                    case 3:{gamePlayer = new GamePlayer(3,"孙小美",3000);gamePlayerVector.addElement(gamePlayer);break;}
                    case 4:{gamePlayer = new GamePlayer(4,"金贝贝",1000);gamePlayerVector.addElement(gamePlayer);break;}
                    default:
                        System.out.println(Integer.parseInt(thisLine.substring(i,i + 1)) + "为无效编号");
                }
            }
        }catch (IOException e) {
            System.out.println("输入错误！");
        }
    }

    //帮助命令
    public void help(){
        System.out.println("roll：掷骰子命令，行走1~6步，步数由随即算法产生。");
        System.out.println("block：玩家拥有路障，可将路障放置到离当前位置前后10步的距离，任一玩家经过路障，都将被拦截。该道具一次有效。n：前后的相对距离，负数表示后方。");
        System.out.println("bomb：可将路障放置到离当前位置前后10步的距离，任一玩家j经过该位置，将被炸伤，送往医院，住院三天。n：前后的相对距离，负数表示后方。");
        System.out.println("robot：使用该道具，可清扫前方路面上10步以内的其它道具，如炸弹、路障。");
        System.out.println("sell：出售自己的房产，x：地图上的绝对位置，即地产的编号。");
        System.out.println("sellTool：出售道具，x：道具编号");
        System.out.println("query：显示自家资产信息");
        System.out.println("help：查看命令帮助");
        System.out.println("quit：强制退出");
        System.out.println("printmap：输出地图");
    }

    //打印地图信息
    private void print() {
        System.out.println("当前地图状态如下：");
        this.map.print();
    }

    //出售道具命令
    public void sellTool(AGamePlayer gamePlayer){
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String thisLine;
        System.out.println("输入要出售的道具编号！");
        try {
            thisLine = br.readLine();
            int toolid = Integer.parseInt(thisLine.substring(0,thisLine.length()));
            gamePlayer.sellTool(toolid);
        } catch (IOException e) {
            System.out.println("输入错误");
        }
    }

    //出售地产命令
    public void sellLandform(AGamePlayer gamePlayer){
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String thisLine;
        System.out.println("输入要出售的地产编号！");
        try {
            thisLine = br.readLine();
            int terraid = Integer.parseInt(thisLine.substring(0,thisLine.length()));
            gamePlayer.sellTerra(map,terraid);
        } catch (IOException e) {
            System.out.println("输入错误");
        }
        this.print();
    }

    //查询玩家信息命令
    public void queryGameplayerInformation(AGamePlayer gamePlayer){
        gamePlayer.query(map);
    }

    //使用路障命令
    public void useBlock(AGamePlayer gamePlayer) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String thisLine;
        System.out.println("输入距离(-10~10)！");
        try {
            thisLine = br.readLine();
            int distance = Integer.parseInt(thisLine.substring(0,thisLine.length()));
            while(!gamePlayer.useBlock(map,distance) ){
                thisLine = br.readLine();
                distance = Integer.parseInt(thisLine.substring(0,thisLine.length()));
            }
        } catch (IOException e) {
            System.out.println("输入错误");
        }
    }

    //使用炸弹命令
    public void useBomb(AGamePlayer gamePlayer) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String thisLine;
        System.out.println("输入距离(-10~10)！");
        try {
            thisLine = br.readLine();
            int distance = Integer.parseInt(thisLine.substring(0,thisLine.length()));
            while(!gamePlayer.useBomb(map, distance)){
                thisLine = br.readLine();
                distance = Integer.parseInt(thisLine.substring(0,thisLine.length()));
            }
        } catch (IOException e) {
            System.out.println("输入错误");
        }
    }

    //使用机器娃娃命令
    public void useRobot(AGamePlayer gamePlayer){
        gamePlayer.useRobot(map);
    }

    //强制退出命令
    public void quit(){
        gamePlayerVector.clear();
        System.out.println("强制退出， 游戏结束！");
    }

    //行走命令
    public boolean roll(int index) throws IOException {
        ALandForm landForm;
        AGamePlayer gamePlayer;
        gamePlayer = gamePlayerVector.elementAt(index);
        landForm = gamePlayer.roll(map);

        if(landForm != null && !landForm.execute(gamePlayerVector, index) && gamePlayer.getMoney() == 0){
            System.out.println("玩家破产！");
            for(int j = 0;j <= 69;j++){
                if(map.getLandform(j).getGamePlayerId() == gamePlayer.getId()){
                    map.getLandform(j).setGamePlayerId(0);
                    map.getLandform(j).setGrade(0);
                }
            }
            gamePlayerVector.remove(index);
            this.print();
            return false;
        }
        this.print();
        return true;
    }
    //开始命令
    public void start(){
        AGamePlayer gamePlayer;
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String thisLine;
        int index = 0;
        while(gamePlayerVector.size() != 1 && index < gamePlayerVector.size()){
            gamePlayer = gamePlayerVector.elementAt(index);
            System.out.print(gamePlayer.getName() + ">");
            try {
                thisLine = br.readLine();
                while(thisLine.toLowerCase().compareTo("roll") != 0 && thisLine.toLowerCase().compareTo("quit") != 0){
                    if(thisLine.toLowerCase().compareTo("selltool") == 0)
                        this.sellTool(gamePlayer);
                    else if(thisLine.toLowerCase().compareTo("sell") == 0)
                        this.sellLandform(gamePlayer);
                    else if(thisLine.toLowerCase().compareTo("query") == 0)
                        this.queryGameplayerInformation(gamePlayer);
                    else if(thisLine.toLowerCase().compareTo("help") == 0)
                        this.help();
                    else if(thisLine.toLowerCase().compareTo("block") == 0)
                        this.useBlock(gamePlayer);
                    else if(thisLine.toLowerCase().compareTo("bomb") == 0)
                        this.useBomb(gamePlayer);
                    else if(thisLine.toLowerCase().compareTo("robot") == 0)
                        this.useRobot(gamePlayer);
                    else if(thisLine.toLowerCase().compareTo("printmap") == 0)
                        this.print();
                    else
                        System.out.println("输入错误命令，请重新输入！");
                    thisLine = br.readLine();
                }
                if(thisLine.toLowerCase().compareTo("quit") == 0){
                    this.quit();
                    break;
                }
                if(thisLine.toLowerCase().compareTo("roll") == 0 && this.roll(index))
                    index = (++index) % gamePlayerVector.size();
            } catch (IOException e) {
            System.out.println("输入错误");
            }
        }

        if(gamePlayerVector.size() == 1){
            System.out.println("游戏结束");
            System.out.println("玩家 “" + gamePlayerVector.elementAt(0).getName() +"” 为最终赢家");
        }
    }


}
