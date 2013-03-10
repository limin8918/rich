package LANDFORM;

import GAMEPLAYER.AGamePlayer;

import java.util.Vector;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 13-2-3
 * Time: 下午9:22
 * To change this template use File | Settings | File Templates.
 */

//魔法屋
public class MagicHouse extends ALandForm {
    public MagicHouse(){
        this.id = 63;
        this.name = 'M';

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

        System.out.println("欢迎光临魔法屋，请玩家施展魔法：");
        gamePlayer.useMagic();
        return true;
    }

    public void print(){
        System.out.print(this.name);
    }

}
