package GAMEPLAYER;

import LANDFORM.ALandForm;
import MAP.Map;
import TOOL.ATool;
import TOOL.Block;
import TOOL.Bomb;
import TOOL.Robot;

import java.io.IOException;
import java.util.Random;
import java.util.Vector;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 13-2-6
 * Time: 下午6:21
 * To change this template use File | Settings | File Templates.
 */
public class GamePlayer extends AGamePlayer{

    public GamePlayer(){
        this.id = -1;
        this.name = "";
        this.currentlocation = 0;

        this.money = 10000;
        this.pointcount = 50;

        this.tools = new Vector<ATool>();

        this.mascotflag = 0;
        this.hospitalflag = -1;
        this.prisonflag = -1;
    }

    public GamePlayer(int id,String name,int money){
        this.id = id;
        this.name = name;

        this.currentlocation = 0;

        this.money = money;
        this.pointcount = 50;

        this.tools = new Vector<ATool>();

        this.mascotflag = 0;
        this.hospitalflag = -1;
        this.prisonflag = -1;
    }

    //增加玩家资金
    public void addMoney(int i){
        this.money = this.money + i;
    }

    //减少玩家资金
    public boolean minusMoney(int i){
        if(i <= this.money){
            this.money = this.money - i;
            return true;
        }
        else
            return false;
            //System.out.println("资金不足，操作失败！");
    }

    //增加玩家点数
    public void addPointCount(int i){
        this.pointcount = this.pointcount + i;
    }

    //减少玩家点数
    public boolean minusPointCount(int i){
        if(i <= this.pointcount){
            this.pointcount = this.pointcount - i;
            return true;
        }
        else
            return false;

    }

    //获取道具个数
    public int getToolCount(int id) {
        int count = 0;
        for(int i = 0;i < tools.size();i++){
            if (tools.elementAt(i).getId() == id)
                count++;
        }
        return count;
    }

    //购买道具
    public void buyTool(int toolid){
        ATool tool;
        switch (toolid){
            case 1:
                tool = new Block();
                if(this.minusPointCount(tool.getValue())){
                    this.tools.addElement(tool);
                    System.out.println("购买路障成功！");
                }
                else{
                    System.out.println("点数不足，购买路障失败！");
                }
                break;
            case 2:
                tool = new Robot();
                if(this.minusPointCount(tool.getValue())){
                    this.tools.addElement(tool);
                    System.out.println("购买机器娃娃成功！");
                }
                else{
                    System.out.println("点数不足，购买机器娃娃失败！");
                }
                break;
            case 3:
                tool = new Bomb();
                if(this.minusPointCount(tool.getValue())){
                    this.tools.addElement(tool);
                    System.out.println("购买炸弹成功！");
                }
                else{
                    System.out.println("点数不足，购买炸弹失败！");
                }
                break;
            default:{
                System.out.println("输入错误参数，购买失败，自动退出！");
            }
        }
    }

   //出售道具
    public  void sellTool(int toolid){
        int i;
        int j = 0;
        if(this.getToolCount(toolid) == 0)
            System.out.println("玩家没有该道具，出售失败！");
        else{
            for(i = 0;i < tools.size();i++){
                if(tools.elementAt(i).getId() == toolid){
                    System.out.println("出售道具" + tools.elementAt(i).getName() + "成功！");
                    this.addPointCount(tools.elementAt(j).getValue());
                    tools.remove(j);
                    break;
                }
            }
        }
    }

    //使用路障
    public boolean useBlock(Map map,int steps){
        if(this.getToolCount(1) == 0){
            System.out.println("玩家没有该道具，不能使用！");
            return true;
        }
        if(steps < -10 || steps > 10){
            System.out.println("输入距离错误，请重新输入！");
            return false;
        }
        if(map.useBlock((this.currentlocation + steps) % 70)){
            for(int i = 0; i < tools.size();i++){
                if(tools.elementAt(i).getId() == 1){
                    tools.remove(i);
                    break;
                }
            }
             return true;
        }
        else
            return false;
    }

    //使用炸弹
    public boolean useBomb(Map map,int steps){
        if(this.getToolCount(3) == 0){
            System.out.println("玩家没有该道具，不能使用！");
            return true;
        }
        else{
            if(map.useBomb((this.currentlocation + steps) % 70)){
                for(int i = 0; i < tools.size();i++){
                    if(tools.elementAt(i).getId() == 3){
                        tools.remove(i);
                        break;
                    }
                }
                return true;
            }
            else
                return false;
        }
    }

    //使用机器娃娃
    public void useRobot(Map map){
        if(this.getToolCount(2) == 0)
            System.out.println("玩家没有该道具，不能使用！");
        else{
            for(int i = 0; i < tools.size();i++){
                if(tools.elementAt(i).getId() == 2){
                    tools.remove(i);
                    break;
                }
            }
            map.useRobot(this.currentlocation);
        }
    }

     //玩家使用魔法
    public void useMagic(){
        System.out.println("玩家暂无魔法");
    }

    //购买地产
    public void buyTerra(ALandForm terra){
        if(this.minusMoney(terra.getValue())){
            terra.setGamePlayerId(this.id);
            System.out.println("购买成功！共花费" + terra.getValue() + "元");
        }
        else{
            System.out.println("资金不足，购买土地失败！");
        }
    }
     //升级地产
    public void uplevelTerra(ALandForm terra){
        if(this.minusMoney(terra.getValue())){
           terra.setGrade(terra.getGrade() + 1);
            System.out.println("升级成功！共花费" + terra.getValue() + "元");
        }
        else{
            System.out.println("资金不足，升级土地失败！");
        }
    }

    //出售土地
    public void sellTerra(Map map,int terraid){
        ALandForm terra;
        terra = map.getLandform(terraid);
        if(terra.getGamePlayerId() == this.id){
            this.addMoney(2 * terra.getValue() * (terra.getGrade() + 1));
            terra.setGrade(0);
            terra.setGamePlayerId(0);
            System.out.println("出售成功！");
        }
        else
            System.out.println("玩家没有该土地，出售失败！");
    }

    //随机获取下一步的位置编号
    public int getSteps(){
        Random random = new Random();
        return (1 + random.nextInt(6));
    }

    //行走行走命令
    public ALandForm roll(Map map) throws IOException {
        int steps = this.getSteps();
        int nextLocation = (this.currentlocation + steps) % 70;
        int i;
        if(this.hospitalflag > 0){
            System.out.println("玩家" + this.name + "在医院" + "，空转一次!");
            this.hospitalflag--;
            System.out.println("剩余" + this.hospitalflag + "天");
            return null;
        }
        else if(this.prisonflag > 0){
            System.out.println("玩家" + this.name + "在监狱" + "，空转一次!");
            this.prisonflag--;
            System.out.println("剩余" + this.prisonflag + "天");
            return null;
        }
        else{
            if(this.hospitalflag == 0)
                this.hospitalflag--;
            if(this.prisonflag == 0)
                this.prisonflag--;
            System.out.println("玩家行走"+ steps +"步" + "应到达编号" + (this.currentlocation + steps) % 70 + "位置处！");
            for(i = 1;i <= steps;i++){
                nextLocation = (this.currentlocation + i) % 70;
                if(map.getLandform(nextLocation).getBombFlag() == 1){
                    System.out.println("编号" + nextLocation + "处有炸弹，玩家被炸伤，需送往医院");
                    map.getLandform(currentlocation).decreaseGamePlayerCount();
                    map.getLandform(map.getHospital().getId()).increaseGamePlayerCount();
                    map.getLandform(nextLocation).setBombFlag(0);
                    this.currentlocation = map.getHospital().getId();
                    return map.getHospital();
                }
                else if(map.getLandform(nextLocation).getBlockFlag() == 1){
                    System.out.println("编号" + nextLocation + "处有路障，玩家停留在此处");
                    map.getLandform(currentlocation).decreaseGamePlayerCount();
                    map.getLandform(nextLocation).increaseGamePlayerCount();
                    this.currentlocation = nextLocation;
                    return map.getLandform(nextLocation);
                }
                else
                    continue;
            }
            nextLocation = (this.currentlocation + steps) % 70;
            map.getLandform(currentlocation).decreaseGamePlayerCount();
            map.getLandform(nextLocation).increaseGamePlayerCount();
            this.currentlocation = nextLocation;
            return map.getLandform(nextLocation);
        }
    }

    //查询玩家信息
    public  void query(Map map){
        System.out.println("姓名：" + this.name);
        System.out.println("编号：" + this.id);
        System.out.println("资金：" + this.money);
        System.out.println("点数：" + this.pointcount);
        System.out.println("地产：空地" + map.getTerraCount(this,0) + "处；茅屋" + map.getTerraCount(this,1) + "处；洋房" + map.getTerraCount(this,2) + "处；摩天楼" + map.getTerraCount(this,3) + "处。");
        System.out.println("道具：路障" + this.getToolCount(1) + "个；炸弹" + this.getToolCount(3) + "个；机器娃娃" + this.getToolCount(2) + "个");
    }

}
