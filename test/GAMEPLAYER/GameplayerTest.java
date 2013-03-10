package GAMEPLAYER;

import MAP.Map;
import TOOL.ATool;
import TOOL.Block;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 13-2-6
 * Time: 下午6:30
 * To change this template use File | Settings | File Templates.
 */
public class GameplayerTest {
    public static final int basemoney = 10000;
    public static final int basepointcount = 50;

    private AGamePlayer gameplayer;
    private Map map;
    private ATool tool;

    @Before
    public void setUp(){
        map = new Map();
        gameplayer = new GamePlayer(1,"张三",basemoney);
    }

    @Test
    public void should_money_be_basemoney_when_gameplayer_is_setup() {
        assertThat(gameplayer.getMoney(), is(basemoney));
    }

    @Test
    public void shoule_money_be_increased_when_it_is_added() {
        int i = 100;
        gameplayer.addMoney(i);
        assertThat(gameplayer.getMoney(), is(basemoney + i));
    }

    @Test
    public void shoule_money_be_decreased_when_parameters_is_less_than_money() {
        int i = 100;
        assertThat(gameplayer.minusMoney(i), is(true));
        assertThat(gameplayer.getMoney(), is(basemoney - i));
    }

     @Test
    public void shoule_return_false_when_parameters_is_big_than_money() {
        int i = 20000;
        assertThat(gameplayer.minusMoney(i), is(false));
    }

    @Test
    public void shoule_pointcount_be_increased_when_it_is_added() {
        int i = 100;
        gameplayer.addPointCount(i);
        assertThat(gameplayer.getPointCount(), is(basepointcount + i));
    }

    @Test
    public void shoule_pointcount_be_decreased_when_parameters_is_less_than_pointcount() {
        int i = 10;
        gameplayer.minusPointCount(i);
        assertThat(gameplayer.getPointCount(), is(basepointcount - i));
    }

    @Test
    public void shoule_return_false_when_parameters_is_big_than_basepointcount() {
        int i = 100;
        assertThat(gameplayer.minusPointCount(i), is(false));
    }

    @Test
    public void should_buy_tool_successfully_when_pointcount_is_enough(){
        tool = new Block();
        assertThat(gameplayer.getToolCount(tool.getId()), is(0));
        gameplayer.buyTool(tool.getId());
        assertThat(gameplayer.getPointCount(), is(basepointcount - tool.getValue()));
        assertThat(gameplayer.getToolCount(tool.getId()), is(1));
    }

    @Test
    public void should_print_message_when_pointcount_is_not_enough(){
        tool = new Block();
        gameplayer.setPointCount(10);
        gameplayer.buyTool(tool.getId());
        assertThat(gameplayer.getPointCount(), is(10));
        assertThat(gameplayer.getToolCount(tool.getId()), is(0));
    }

    @Test
    public void should_sell_tool_successfully_when_gameplayer_has_it(){
        tool = new Block();
        gameplayer.buyTool(tool.getId());
        gameplayer.sellTool(tool.getId());
        assertThat(gameplayer.getPointCount(), is(basepointcount));
        assertThat(gameplayer.getToolCount(tool.getId()), is(0));
    }

    @Test
    public void should_sell_tool_failed_when_gameplayer_has_not_it(){
        gameplayer.sellTool(1);
        assertThat(gameplayer.getPointCount(), is(basepointcount));
        assertThat(gameplayer.getToolCount(1), is(0));
    }

    @Test
    public void should_block_used_successfully_when_steps_less_then_10(){
        int steps = 5;
        gameplayer.buyTool(1);
        assertThat(gameplayer.useBlock(map,steps),is(true));
        assertThat(map.getLandform(gameplayer.currentlocation + steps).getBlockFlag(),is(1));
    }

    @Test
    public void should_block_used_failed_when_steps_less_then_10(){
        int steps = 11;
        gameplayer.buyTool(1);
        assertThat(gameplayer.useBlock(map,steps),is(false));
        assertThat(map.getLandform(gameplayer.currentlocation + steps).getBlockFlag(),is(0));
    }

    @Test
    public void should_robot_is_used(){
        map.getLandform(gameplayer.currentlocation + 3).setBombFlag(1);
        map.getLandform(gameplayer.currentlocation + 3).setBlockFlag(1);
        map.getLandform(gameplayer.currentlocation + 10).setBlockFlag(1);
        gameplayer.buyTool(2);
        gameplayer.useRobot(map);
        assertThat(map.getLandform(3).getBombFlag(),is(0));
        assertThat(map.getLandform(3).getBlockFlag(),is(0));
        assertThat(map.getLandform(10).getBlockFlag(),is(0));
    }

    @Test
    public void should_buy_terra_successfully_when_terra_is_public_and_money_is_enough(){
        gameplayer.setId(1);
        gameplayer.setCurrentLocation(1);
        gameplayer.buyTerra(map.getLandform(1));

        assertThat(gameplayer.getMoney(),is(basemoney - map.getLandform(1).getValue()));
        assertThat(map.getLandform(1).getGamePlayerId(),is(gameplayer.getId()));
    }

    @Test
    public void should_buy_terra_failed_when_terra_is_public_and_money_is_lack(){
        gameplayer.setCurrentLocation(1);
        gameplayer.setMoney(100);
        gameplayer.buyTerra(map.getLandform(1));

        assertThat(gameplayer.getMoney(),is(100));
    }

    @Test
    public void should_uplevel_terra_successfully_when_terra_is_own_and_money_is_enough(){
        gameplayer.setCurrentLocation(1);
        gameplayer.buyTerra(map.getLandform(1));
        gameplayer.uplevelTerra(map.getLandform(1));

        assertThat(gameplayer.getMoney(),is(basemoney - map.getLandform(1).getValue() * 2));
        assertThat(map.getLandform(1).getGrade(),is(1));
    }

    @Test
    public void should_uplevel_terra_failed_when_terra_is_own_and_money_is_lack(){
        gameplayer.setCurrentLocation(1);
        gameplayer.setMoney(300);
        gameplayer.buyTerra(map.getLandform(1));
        gameplayer.uplevelTerra(map.getLandform(1));

        assertThat(gameplayer.getMoney(),is(100));
        assertThat(map.getLandform(1).getGrade(),is(0));
    }


    @Test
    public void should_sell_terra_successfully_when_terra_is_own(){
        AGamePlayer gamePlayer = null;
        gameplayer.setCurrentLocation(1);
        gameplayer.buyTerra(map.getLandform(1));
        gameplayer.sellTerra(map,1);
        assertThat(gameplayer.getMoney(),is(basemoney + 200));
        assertThat(map.getLandform(1).getGrade(),is(0));
        assertThat(map.getLandform(1).getGamePlayerId(),is(0));
    }

    @Test
    public void should_stay_when_gameplayer_is_in_hospital() throws IOException {
        gameplayer.setHospitalFlag(3);
        gameplayer.roll(map);
    }

    @Test
    public void should_stay_when_gameplayer_is_in_prison() throws IOException {
        gameplayer.setPrisonFlag(2);
        gameplayer.roll(map);
    }

}
