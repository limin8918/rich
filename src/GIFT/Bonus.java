package GIFT;

import GAMEPLAYER.AGamePlayer;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 13-2-3
 * Time: 下午10:53
 * To change this template use File | Settings | File Templates.
 */

//2000元的奖金
public class Bonus extends AGift {

    //初始化
    public Bonus(){
        this.id = 1;
        this.name = "奖金卡";
    }
    //使用礼品
    public void use(AGamePlayer gameplayer){
        System.out.println("奖励玩家2000元的奖金！");
        gameplayer.addMoney(2000);          //增加玩家资金
    }
}
