package LANDFORM;

import GAMEPLAYER.AGamePlayer;

import java.util.Vector;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 13-2-3
 * Time: 下午8:48
 * To change this template use File | Settings | File Templates.
 */

//医院
public class Hospital extends ALandForm {

    public Hospital(){
        this.id = 14;
        this.name = 'H';

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

        System.out.println("欢迎光临医院，请休息三天！");
        gamePlayer.setHospitalFlag(3);       //将玩家的医院标识设置为3，表示玩家轮空3次
        return true;
    }

    public void print(){
        System.out.print(" " + this.name);
    }

}
