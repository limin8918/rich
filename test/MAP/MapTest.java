package MAP;

import GAMEPLAYER.AGamePlayer;
import GAMEPLAYER.GamePlayer;
import LANDFORM.ALandForm;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 13-2-4
 * Time: 下午9:36
 * To change this template use File | Settings | File Templates.
 */
public class MapTest {
    private Map map;
    private ALandForm landform1;
    private ALandForm landform2;
    private int id1;
    private int id2;

    @Before
    public void setUp() throws IOException {
        map = new Map();
    }

    @Test
    public void should_area_be_start_when_id_is_0() {
        id1 = 0;
        landform1 = map.getLandform(id1);
        assertThat(landform1.getId(), is(0));
        assertThat(landform1.getName(),is('S'));
    }

    @Test
    public void should_area_be_Terra_when_id_between_1_to_13() {
        id1 = 1;
        landform1 = map.getLandform(id1);
        assertThat(landform1.getId(), is(1));
        assertThat(landform1.getName(),is('0'));
        assertThat(landform1.getValue(),is(200));
        id1 = 13;
        landform1 = map.getLandform(id1);
        assertThat(landform1.getId(), is(13));
        assertThat(landform1.getName(),is('0'));
        assertThat(landform1.getValue(),is(200));
    }

    @Test
    public void should_area_be_Hospital_when_id_is_14() {
        id1 = 14;
        landform1 = map.getLandform(id1);
        assertThat(landform1.getId(), is(14));
        assertThat(landform1.getName(),is('H'));
    }

    @Test
    public void should_area_be_Terra_when_id_between_15_to_27() {
        id1 = 15;
        landform1 = map.getLandform(id1);
        assertThat(landform1.getId(), is(15));
        assertThat(landform1.getName(),is('0'));
        assertThat(landform1.getValue(),is(200));
        id1 = 27;
        landform1 = map.getLandform(id1);
        assertThat(landform1.getId(), is(27));
        assertThat(landform1.getName(),is('0'));
        assertThat(landform1.getValue(),is(200));
    }

    @Test
    public void should_area_be_ToolHouse_when_id_is_28() {
        id1 = 28;
        landform1 = map.getLandform(id1);
        assertThat(landform1.getId(), is(28));
        assertThat(landform1.getName(),is('T'));
    }

    @Test
    public void should_area_be_Terra_when_id_between_29_to_34() {
        id1 = 29;
        landform1 = map.getLandform(id1);
        assertThat(landform1.getId(), is(29));
        assertThat(landform1.getName(),is('0'));
        assertThat(landform1.getValue(),is(500));
        id1 = 34;
        landform1 = map.getLandform(id1);
        assertThat(landform1.getId(), is(34));
        assertThat(landform1.getName(),is('0'));
        assertThat(landform1.getValue(),is(500));
    }

    @Test
    public void should_area_be_GiftHouse_when_id_is_35() {
        id1 = 35;
        landform1 = map.getLandform(id1);
        assertThat(landform1.getId(), is(35));
        assertThat(landform1.getName(),is('G'));
    }

    @Test
    public void should_area_be_Terra_when_id_between_36_to_48() {
        id1 = 36;
        landform1 = map.getLandform(id1);
        assertThat(landform1.getId(), is(36));
        assertThat(landform1.getName(),is('0'));
        assertThat(landform1.getValue(),is(300));
        id1 = 48;
        landform1 = map.getLandform(id1);
        assertThat(landform1.getId(), is(48));
        assertThat(landform1.getName(),is('0'));
        assertThat(landform1.getValue(),is(300));
    }

    @Test
    public void should_area_be_Prision_when_id_is_49() {
        id1 = 49;
        landform1 = map.getLandform(id1);
        assertThat(landform1.getId(), is(49));
        assertThat(landform1.getName(),is('P'));
    }

    @Test
    public void should_area_be_Terra_when_id_between_50_to_62() {
        id1 = 50;
        landform1 = map.getLandform(id1);
        assertThat(landform1.getId(), is(50));
        assertThat(landform1.getName(),is('0'));
        assertThat(landform1.getValue(),is(300));
        id1 = 62;
        landform1 = map.getLandform(id1);
        assertThat(landform1.getId(), is(62));
        assertThat(landform1.getName(),is('0'));
        assertThat(landform1.getValue(),is(300));
    }

    @Test
    public void should_area_be_MagicHouse_when_id_is_63() {
        id1 = 63;
        landform1 = map.getLandform(id1);
        assertThat(landform1.getId(), is(63));
        assertThat(landform1.getName(),is('M'));
    }

    @Test
    public void should_area_be_Mineral_when_id_is_64() {
        id1 = 64;
        landform1 = map.getLandform(id1);
        assertThat(landform1.getId(), is(64));
        assertThat(landform1.getName(),is('$'));
        assertThat(landform1.getValue(),is(20));
    }

    @Test
    public void should_return_true_when_block_is_used(){
        id1 = 1;
        landform1 = map.getLandform(id1);
        assertThat(landform1.getBlockFlag(),is(0));
        assertThat(map.useBlock(id1),is(true));
        assertThat(landform1.getBlockFlag(),is(1));
    }

    @Test
    public void should_return_false_when_block_is_used_and_landForm_has_gamePlayer(){
        id1 = 1;
        landform1 = map.getLandform(id1);
        landform1.setGamePlayerCount(2);
        assertThat(landform1.getBlockFlag(), is(0));
        assertThat(map.useBlock(id1),is(false));
        assertThat(landform1.getBlockFlag(),is(0));
    }

    @Test
    public void should_return_false_when_block_is_used_and_landForm_has_block(){
        id1 = 1;
        landform1 = map.getLandform(id1);
        landform1.setBlockFlag(1);
        assertThat(landform1.getBlockFlag(), is(1));
        assertThat(map.useBlock(id1),is(false));
        assertThat(landform1.getBlockFlag(),is(1));
    }

    @Test
    public void should_return_false_when_block_is_used_and_landForm_has_bomb(){
        id1 = 1;
        landform1 = map.getLandform(id1);
        landform1.setBombFlag(1);
        assertThat(landform1.getBombFlag(),is(1));
        assertThat(landform1.getBlockFlag(),is(0));
        assertThat(map.useBlock(id1),is(false));
        assertThat(landform1.getBlockFlag(),is(0));
    }

    @Test
    public void should_return_true_when_bomb_is_used(){
        id1 = 1;
        landform1 = map.getLandform(id1);
        assertThat(landform1.getBombFlag(),is(0));
        assertThat(map.useBomb(id1),is(true));
        assertThat(landform1.getBombFlag(),is(1));
    }

    @Test
    public void should_return_false_when_bomb_is_used_and_landForm_has_gamePlayer(){
        id1 = 1;
        landform1 = map.getLandform(id1);
        landform1.setGamePlayerCount(2);
        assertThat(landform1.getBombFlag(),is(0));
        assertThat(map.useBomb(id1),is(false));
        assertThat(landform1.getBombFlag(),is(0));
    }

    @Test
    public void should_return_false_when_bomb_is_used_landForm_has_bomb(){
        id1 = 1;
        landform1 = map.getLandform(id1);
        landform1.setBombFlag(1);
        assertThat(landform1.getBombFlag(),is(1));
        assertThat(map.useBomb(id1),is(false));
        assertThat(landform1.getBombFlag(),is(1));
    }

    @Test
    public void should_return_false_when_bomb_is_used_landForm_has_block(){
        id1 = 1;
        landform1 = map.getLandform(id1);
        landform1.setBlockFlag(1);
        assertThat(landform1.getBombFlag(),is(0));
        assertThat(landform1.getBlockFlag(),is(1));
        assertThat(map.useBomb(id1),is(false));
        assertThat(landform1.getBombFlag(),is(0));
    }

    @Test
    public void should_blockFlag_and_bombFlag_be_0_when_robot_is_used(){
        int id1 = 1;
        int id2 = 10;
        landform1 = map.getLandform(id1);
        landform2 = map.getLandform(id2);
        map.useBlock(id1);
        map.useBomb(id2);
        assertThat(landform1.getBlockFlag(),is(1));
        assertThat(landform2.getBombFlag(),is(1));
        map.useRobot(0);
        assertThat(landform1.getBlockFlag(),is(0));
        assertThat(landform2.getBombFlag(),is(0));
    }

    @Test
    public void should_TerraCount_be_2_when_gamePlayer_has_two_terra_whose_grade_is_1(){
        AGamePlayer gamePlayer = new GamePlayer(1,"张三",10000);
        int id1 = 1;
        int id2 = 2;
        landform1 = map.getLandform(id1);
        landform2 = map.getLandform(id2);
        gamePlayer.buyTerra(landform1);
        gamePlayer.uplevelTerra(landform1);
        gamePlayer.buyTerra(landform2);

        assertThat(map.getTerraCount(gamePlayer,0),is(1));
        assertThat(map.getTerraCount(gamePlayer,1),is(1));
        gamePlayer.uplevelTerra(landform2);
        assertThat(map.getTerraCount(gamePlayer,0),is(0));
        assertThat(map.getTerraCount(gamePlayer,1),is(2));
    }

    @Test
    public void should_show_map_information(){
        map.print();
    }
}
