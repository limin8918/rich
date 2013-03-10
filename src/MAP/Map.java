package MAP;

import GAMEPLAYER.AGamePlayer;
import LANDFORM.*;

//import enigma.console.Console;
//import enigma.console.TextAttributes;
//import enigma.core.Enigma;


/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 13-2-3
 * Time: 下午10:09
 * To change this template use File | Settings | File Templates.
 */
public class Map {

    ALandForm landforms[];
    final int width = 29, height = 8;

    public Map(){
        int i = 0;
        this.landforms = new ALandForm[70];
        this.landforms[i] = new Start();
        for(++i;i <= 13;i++){
            this.landforms[i] = new Terra(i,200);
        }
        this.landforms[i] = new Hospital();
        for(++i;i <= 27;i++){
            this.landforms[i] = new Terra(i,200);
        }
        this.landforms[i] = new ToolHouse();
        for(++i;i <= 34;i++){
            this.landforms[i] = new Terra(i,500);
        }
        this.landforms[i] = new GiftHouse();
        for(++i;i <= 48;i++){
            this.landforms[i] = new Terra(i,300);
        }
        this.landforms[i] = new Prison();
        for(++i;i <= 62;i++){
            this.landforms[i] = new Terra(i,300);
        }
        this.landforms[i] = new MagicHouse();
        i++;
        this.landforms[i]= new Mineral(i,20);
        i++;
        this.landforms[i]= new Mineral(i,80);
        i++;
        this.landforms[i]= new Mineral(i,100);
        i++;
        this.landforms[i]= new Mineral(i,40);
        i++;
        this.landforms[i]= new Mineral(i,80);
        i++;
        this.landforms[i]= new Mineral(i,60);
    }

    public ALandForm getLandform(int i) {
        return this.landforms[i];
    }

    //在编号id处设置路障
    public boolean useBlock(int id) {
        if(this.landforms[id].getGamePlayerCount() != 0){
            System.out.println("编号" + id +"处有玩家，请重新输入步数！");
            return false;
        }
        if(this.landforms[id].getBlockFlag() != 0){
            System.out.println("编号" + id +"处已设置路障，请重新输入步数！");
            return false;
        }
        if(this.landforms[id].getBombFlag() != 0){
            System.out.println("编号" + id +"处已设置炸弹，请重新输入步数！");
            return false;
        }
        this.landforms[id].setBlockFlag(1);
        System.out.println("编号" + id +"处使用路障成功！");
        return true;
    }

    //在编号id处设置炸弹
    public boolean useBomb(int id) {
        if(this.landforms[id].getGamePlayerCount() != 0){
            System.out.println("编号" + id +"处有玩家，请重新输入步数！");
            return false;
        }
        if(this.landforms[id].getBlockFlag() != 0){
            System.out.println("编号" + id +"处已设置路障，请重新输入步数！");
            return false;
        }
        if(this.landforms[id].getBombFlag() != 0){
            System.out.println("编号" + id +"处已设置炸弹，请重新输入步数！");
            return false;
        }
        this.landforms[id].setBombFlag(1);
        System.out.println("编号" + id +"处使用炸弹成功！");
        return true;
    }

    //当前位置的前方10步以内使用机器娃娃
    public void useRobot(int currentLocation) {
        for(int i = 1;i <= 10; i++){
            this.landforms[(currentLocation + i) % 70].setBlockFlag(0);
            this.landforms[(currentLocation + i) % 70].setBombFlag(0);
        }
         System.out.println("使用机器娃娃成功！");
    }

    //获取医院位置
    public ALandForm getHospital(){
        return this.landforms[14];
    }

    //获取玩家地产个数
    public int getTerraCount(AGamePlayer gamePlayer,int grade) {
        int count = 0;
        for(int i = 0;i < this.landforms.length;i++){
            if(this.landforms[i].getGamePlayerId() == gamePlayer.getId() && this.landforms[i].getGrade() == grade)
                count++;
        }
        return count;
    }


    //显示地图信息
    public void print(){
        for(int i = 0;i < width;i++)
            this.landforms[i].print();
        for(int i = 0;i < height - 2;i++){
            System.out.println();
            this.landforms[width * 2 + height * 2 - 5 -i].print();
            for(int j = 0;j < width - 3;j++)
                System.out.print("    ");
            this.landforms[width + i].print();
        }
        System.out.println();
        for(int i = 0; i < width;i++){
            this.landforms[width * 2 + height - 3 - i].print();
        }
        System.out.println();
    }

}
