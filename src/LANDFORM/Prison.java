package LANDFORM;

import GAMEPLAYER.AGamePlayer;

import java.util.Vector;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 13-2-3
 * Time: 下午9:15
 * To change this template use File | Settings | File Templates.
 */

//监狱
public class Prison extends ALandForm {

    public Prison(){
        this.id = 49;
        this.name = 'P';

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

        System.out.println("欢迎光临监狱，您将被扣留两天！");
        gamePlayer.setPrisonFlag(2);                            //将玩家的监狱标识设置为2，表示玩家轮空2次
        return true;
    }

    public void print(){
        System.out.print(" " + this.name);
    }

}
