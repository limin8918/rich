package TOOL;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 13-2-3
 * Time: 下午10:05
 * To change this template use File | Settings | File Templates.
 */
public abstract class ATool {
    protected int id;               //道具编号
    protected String name;          //道具名称
    protected int value;            //道具价值
    protected char display;        //道具显示方式

    public ATool()
    {
        this.id = 0;
        this.name = "无";
        this.value = 0;
        this.display = ' ';
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getValue(){
        return value;
    }

    public void setValue(int value){
        this.value = value;
    }

    public char getDisplay(){
        return display;
    }

    public void setDisplay(char display){
        this.display = display;
    }
}
