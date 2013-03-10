package GIFT;

import GAMEPLAYER.AGamePlayer;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 13-2-3
 * Time: 下午10:57
 * To change this template use File | Settings | File Templates.
 */

//福神
public class Mascot extends AGift {

    //初始化
    public Mascot(){
        this.id = 3;
        this.name = "福神卡";
    }
    //使用礼品
    public void use(AGamePlayer gameplayer){
        System.out.println("福神俯身，路过其它玩家地盘，均可免费！");
        System.out.println("5轮内有效（在监狱、医院中也计轮次）！");
        gameplayer.setMascotFlag(5);          //将玩家的福神附身次数设置为5
    }
}
