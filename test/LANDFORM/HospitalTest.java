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
 * Date: 13-2-10
 * Time: 下午10:19
 * To change this template use File | Settings | File Templates.
 */
public class HospitalTest {

    protected ALandForm landform;
    protected Vector<AGamePlayer> gamePlayerVector;
    protected AGamePlayer gamePlayer;

    @Before
    public void setUp(){
        landform = new Hospital();
        this.gamePlayerVector = new Vector<AGamePlayer>();
        gamePlayer = new GamePlayer(1,"钱夫人",3000);
        gamePlayerVector.addElement(gamePlayer);
    }

    @Test
    public void should_hospitalflag_be_3_when_gamepler_arrive_hospital(){
        assertThat(gamePlayerVector.elementAt(0).getHospitalFlag(), is(-1));
        landform.execute(gamePlayerVector,0);
        assertThat(gamePlayerVector.elementAt(0).getHospitalFlag(), is(3));
    }

}
