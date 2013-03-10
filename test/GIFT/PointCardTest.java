package GIFT;

import GAMEPLAYER.AGamePlayer;
import GAMEPLAYER.GamePlayer;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 13-3-10
 * Time: 下午3:32
 * To change this template use File | Settings | File Templates.
 */
public class PointCardTest {
    protected AGift gift;
    AGamePlayer gamePlayer;

    @Before
    public void setUp(){
        gift = new PointCard();
        gamePlayer = new GamePlayer();
    }

    @Test
    public void should_pointCount_be_250_when_gamePlayer_gets_pointCard() {
        assertThat(gamePlayer.getPointCount(), is(50));
        gift.use(gamePlayer);
        assertThat(gamePlayer.getPointCount(), is(250));
    }
}
