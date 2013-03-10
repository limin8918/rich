package LANDFORM;

import GAMEPLAYER.AGamePlayer;
import GAMEPLAYER.GamePlayer;
import org.junit.Before;
import org.junit.Test;

import java.util.Vector;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 13-3-10
 * Time: 下午4:09
 * To change this template use File | Settings | File Templates.
 */
public class MineralTest {
    protected ALandForm landform;
    protected Vector<AGamePlayer> gamePlayerVector;
    protected AGamePlayer gamePlayer;

    @Before
    public void setUp(){
        landform = new Mineral(69,60);
        this.gamePlayerVector = new Vector<AGamePlayer>();
        gamePlayer = new GamePlayer(1,"钱夫人",3000);
        gamePlayerVector.addElement(gamePlayer);
    }

    @Test
    public void should_pointCount_be_increased_when_gamepler_arrive_Mineral(){
        assertThat(gamePlayerVector.elementAt(0).getPointCount(), is(50));
        landform.execute(gamePlayerVector,0);
        assertThat(gamePlayerVector.elementAt(0).getPointCount(), is(110));
    }
}
