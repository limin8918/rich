package LANDFORM;

import GAMEPLAYER.AGamePlayer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 13-2-4
 * Time: 下午6:59
 * To change this template use File | Settings | File Templates.
 */

//地产类
public class Terra extends ALandForm {

    public Terra(){
        this.name = '0';

        this.gameplayerid = 0;
        this.grade = 0;

        this.bombflag = 0;
        this.blockflag = 0;

        this.gameplayercount = 0;
    }

    public Terra(int id, int value) {
        this.id = id;
        this.name = '0';

        this.gameplayerid = 0;
        this.grade = 0;
        this.value = value;

        this.bombflag = 0;
        this.blockflag = 0;

        this.gameplayercount = 0;
    }

    public boolean execute(Vector<AGamePlayer> list,int index){
        AGamePlayer gamePlayer;
        gamePlayer = list.elementAt(index);

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String answer;
        int i;

        if(this.gameplayerid == 0){
            System.out.println("该处为空地，是否购买？Y/N");
            try {
                answer = br.readLine();
                if(answer.toLowerCase().compareTo("y") == 0){
                    gamePlayer.buyTerra(this);
                }
                else if(answer.toLowerCase().compareTo("n") == 0){}
                else
                    System.out.println("输入错误！");

            }catch (IOException e) {
                System.out.println("输入错误！");
            }
            return true;
        }
        else if(this.gameplayerid == gamePlayer.getId()){
            System.out.println("是否升级土地？Y/N");
            try {
                answer = br.readLine();
                if(answer.toLowerCase().compareTo("y") == 0){
                    gamePlayer.uplevelTerra(this);
                }
                else if(answer.toLowerCase().compareTo("n") == 0){}
                else
                    System.out.println("输入错误！");

            }catch (IOException e) {
                System.out.println("输入错误！");
            }
            return true;
        }
        else{
            for(i = 0;i < list.size();i++){
                if(list.elementAt(i).getId() == this.gameplayerid){
                    break;
                }
            }
            int earning = this.value * (this.grade + 1) / 2;
            if(gamePlayer.getMascotFlag() == 0){
                if(list.elementAt(i).getHospitalFlag() < 0 && list.elementAt(i).getPrisonFlag() < 0){
                    System.out.println("停留在玩家 “" + list.elementAt(i).getName() + "” 的土地处，需支付" + earning + "元的费用");
                    if(gamePlayer.minusMoney(earning)){
                        list.elementAt(i).addMoney(earning);
                        return true;
                    }
                    else{
                        System.out.println("玩家 “" + list.elementAt(index).getName() + "” 资金不足，支付失败");
                        list.elementAt(i).addMoney(list.elementAt(index).getMoney());
                        list.elementAt(index).setMoney(0);
                        return false;
                    }

                }
                else{
                    System.out.println("地产主人在医院或者监狱，免费路过");
                    return true;
                }
            }
            else
            {
                System.out.println("福神附身，可免过路费");
                gamePlayer.setMascotFlag(gamePlayer.getMascotFlag() - 1);
                return true;
            }
        }
    }

    public void print(){
        String gamePlayerName = "";
        switch (this.gameplayerid){
            case 0: gamePlayerName = " 空";break;
            case 1: gamePlayerName = " 钱";break;
            case 2: gamePlayerName = " 阿";break;
            case 3: gamePlayerName = " 孙";break;
            case 4: gamePlayerName = " 金";break;
        }
        System.out.print(gamePlayerName + this.grade);
    }

}
