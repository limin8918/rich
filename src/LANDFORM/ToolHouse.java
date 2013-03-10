package LANDFORM;

import GAMEPLAYER.AGamePlayer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 13-2-3
 * Time: 下午9:02
 * To change this template use File | Settings | File Templates.
 */

//道具屋
public class ToolHouse extends ALandForm{

    public ToolHouse(){
        this.id = 28;
        this.name = 'T';

        this.gameplayerid = 0;
        this.grade = 0;
        this.value = 0;

        this.bombflag = 0;
        this.blockflag = 0;

        this.gameplayercount = 0;
    }

    public boolean execute(Vector<AGamePlayer> list,int index){
        AGamePlayer gamePlayer;
        gamePlayer = list.elementAt(index);

        System.out.println("欢迎光临道具屋， 请选择您所需要的道具：");
        System.out.println("道具       编号      价值（点数）");
        System.out.println("路障        1            50");
        System.out.println("机器娃娃    2            30");
        System.out.println("炸弹        3            50");

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        int toolid;
        try {
            toolid = Integer.parseInt(br.readLine());
            gamePlayer.buyTool(toolid);
            return true;
        }catch (IOException e) {
            System.out.println("输入错误！");
            return true;
        }
    }

    public void print(){
        System.out.print(" " + this.name);
    }

}
