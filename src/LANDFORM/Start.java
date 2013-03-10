package LANDFORM;

import GAMEPLAYER.AGamePlayer;

import java.util.Vector;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 13-2-3
 * Time: 下午8:42
 * To change this template use File | Settings | File Templates.
 */

//开始位置地形
public class Start extends ALandForm {

    public Start(){
        this.id = 0;
        this.name = 'S';

        this.gameplayerid = 0;
        this.grade = 0;
        this.value = 0;

        this.bombflag = 0;
        this.blockflag = 0;

        this.gameplayercount = 0;
    }

    public boolean execute(Vector<AGamePlayer> list,int index){
        System.out.println("这里是起始点！");
        return true;
    }

    public void print(){
        System.out.print(this.name);
    }

}
