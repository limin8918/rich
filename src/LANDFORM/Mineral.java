package LANDFORM;

import GAMEPLAYER.AGamePlayer;

import java.util.Vector;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 13-2-4
 * Time: 下午7:01
 * To change this template use File | Settings | File Templates.
 */
public class Mineral extends ALandForm {

    public Mineral(){
        this.name = '$';

        this.gameplayerid = 0;
        this.grade = 0;

        this.bombflag = 0;
        this.blockflag = 0;

        this.gameplayercount = 0;
    }

    public Mineral(int id, int value) {
        this.id = id;
        this.name = '$';

        this.gameplayerid = 0;
        this.grade = 0;
        this.value = value;

        this.bombflag = 0;
        this.blockflag = 0;
    }

    public boolean execute(Vector<AGamePlayer> list,int index){
        AGamePlayer gamePlayer;
        gamePlayer = list.elementAt(index);

        System.out.println("欢迎矿地，您将获得" + this.getValue() + "的点数！");
        gamePlayer.addPointCount(this.getValue());          //玩家增加相应的点数
        return true;
    }

    public void print(){
        System.out.print(this.name);
    }

}
