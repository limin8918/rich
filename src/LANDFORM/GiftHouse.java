package LANDFORM;

import GAMEPLAYER.*;
import GIFT.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 13-2-3
 * Time: 下午9:12
 * To change this template use File | Settings | File Templates.
 */

//礼品屋
public class GiftHouse extends ALandForm {
    AGift gift;
    public GiftHouse(){
        this.id = 35;
        this.name = 'G';

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

        System.out.println("欢迎光临礼品屋，请选择一件您喜欢的礼品：");
        System.out.println("礼品       编号");
        System.out.println("奖金        1");
        System.out.println("点数卡      2");
        System.out.println("福神        3");

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        int giftid;
        try {
            giftid = Integer.parseInt(br.readLine());
            switch (giftid){
                case 1:{
                    gift = new Bonus();
                    gift.use(gamePlayer);
                    return true;
                }
                case 2:{
                    gift = new PointCard();
                    gift.use(gamePlayer);
                    return true;
                }
                case 3:{
                    gift = new Mascot();
                    gift.use(gamePlayer);
                    return true;
                }
                default:{
                    System.out.println("输入错误,玩家放弃此次机会！");
                    return true;
                }
            }
        }catch (IOException e) {
            System.out.println("输入错误！");
            return true;
        }
    }

    public void print(){
        System.out.print(" " + this.name);
    }

}
