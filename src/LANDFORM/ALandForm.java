package LANDFORM;

import GAMEPLAYER.AGamePlayer;

import java.util.Vector;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 13-2-3
 * Time: 下午4:21
 * To change this template use File | Settings | File Templates.
 */

//抽象类：地形
public abstract class ALandForm {
    protected int id;                      //地形编号
    protected char name;                  //地形名字

    protected int gameplayerid;             //所属玩家编号
    protected int grade;                    //等级
    protected int value;                    //地形价值

    protected int bombflag;                   //炸弹标识
    protected int blockflag;                  //路障标识

    protected int gameplayercount;         //当前位置玩家个数

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setName(char name){
        this.name = name;
    }

    public char getName(){
        return name;
    }

    public void setGamePlayerId(int gameplayerid){
        this.gameplayerid = gameplayerid;
    }

    public int getGamePlayerId(){
        return this.gameplayerid;
    }

    public void setGrade(int grade){
        this.grade = grade;
    }

    public int getGrade(){
        return this.grade;
    }

    public void setValue(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }


    public void setBlockFlag(int blockflag){
        this.blockflag = blockflag;
    }

    public int getBlockFlag(){
        return this.blockflag;
    }

    public void setBombFlag(int bombflag){
        this.bombflag = bombflag;
    }

    public int getBombFlag(){
        return this.bombflag;
    }

    public void setGamePlayerCount(int count){
        this.gameplayercount = count;
    }

    public int getGamePlayerCount(){
        return this.gameplayercount;
    }

    public void increaseGamePlayerCount(){
        this.gameplayercount++;
    }

    public void decreaseGamePlayerCount(){
        this.gameplayercount--;
    }

    public abstract boolean execute(Vector<AGamePlayer> list,int index);
    public abstract void print();
}
