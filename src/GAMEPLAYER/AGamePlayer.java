package GAMEPLAYER;

import LANDFORM.ALandForm;
import MAP.Map;
import TOOL.ATool;

import java.io.IOException;
import java.util.Vector;


/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 13-2-3
 * Time: 下午8:41
 * To change this template use File | Settings | File Templates.
 */

//玩家
public abstract class AGamePlayer {
    protected int id;                               //玩家id
    protected String name;                          //玩家名字
    protected int currentlocation;              // 当前位置
    //protected Map map;                          //所在地图

    protected int money;                        //资金
    protected int pointcount;                  //点数

    protected Vector<ATool> tools;             //玩家拥有的道具

    protected int mascotflag;                 //福神附体标识
    protected int hospitalflag;              //是否在医院标识
    protected int prisonflag;                //是否在监狱标识

    AGamePlayer(){
        this.id = 0;
        this.name = "";
        this.currentlocation = 0;

        this.money = 10000;
        this.pointcount = 50;

        this.tools = new Vector<ATool>();

        this.mascotflag = 0;
        this.hospitalflag = -1;
        this.prisonflag = -1;
    }

    //玩家id
    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }

    //玩家名字
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

    //当前位置
    public int getCurrentLocation(){
        return this.currentlocation;
    }
    public void setCurrentLocation(int currentlocation){
        this.currentlocation = currentlocation;
    }

    //资金
    public int getMoney(){
        return this.money;
    }
    public void setMoney(int money){
        this.money = money;
    }

    //点数
    public int getPointCount(){
        return this.pointcount;
    }
    public void setPointCount(int pointcount){
        this.pointcount = pointcount;
    }

    //道具
    public Vector<ATool> getTools(){
        return this.tools;
    }
    public void setTools(Vector<ATool> tools){
        this.tools = tools;
    }

    //福神附身标识
    public int getMascotFlag(){
        return this.mascotflag;
    }
    public void setMascotFlag(int i){
        this.mascotflag = i;
    }

    //医院标识
    public int getHospitalFlag(){
        return this.hospitalflag;
    }
    public void setHospitalFlag(int i){
        this.hospitalflag = i;
    }

    //监狱标识
    public int getPrisonFlag(){
        return this.prisonflag;
    }
    public void setPrisonFlag(int i){
        this.prisonflag = i;
    }

    //增加玩家资金
    public abstract void addMoney(int i);
    //减少玩家资金
    public abstract boolean minusMoney(int i);
    //减少玩家点数
    public abstract boolean minusPointCount(int i);
    //增加玩家点数
    public abstract void addPointCount(int i);
    //获取道具个数
    public abstract int getToolCount(int id);

    //购买道具
    public abstract void buyTool(int toolid);
   //出售道具
    public abstract void sellTool(int toolid);
    //使用路障
    public abstract boolean useBlock(Map map,int steps);
    //使用炸弹
    public abstract boolean useBomb(Map map,int steps);
    //使用机器娃娃
    public abstract void useRobot(Map map);

    //使用魔法
    public abstract void useMagic();


    //购买地产
    public abstract void buyTerra(ALandForm terra);
    //升级地产
    public abstract void uplevelTerra(ALandForm terra);
    //出售土地
    public abstract void sellTerra(Map map,int terraid);


    //随机获取下一步的位置编号
    public abstract int getSteps();
    //行走命令
    public abstract ALandForm roll(Map map) throws IOException;

    //查询玩家信息
    public abstract void query(Map map);
}
