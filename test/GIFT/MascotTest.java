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
 * Time: 下午3:30
 * To change this template use File | Settings | File Templates.
 */
public class MascotTest {
    protected AGift gift;
    AGamePlayer gamePlayer;

    @Before
    public void setUp(){
        gift = new Mascot();
        gamePlayer = new GamePlayer();
    }

    @Test
    public void should_mascotFlag_be_5_when_gamePlayer_gets_mascot() {
        assertThat(gamePlayer.getMascotFlag(), is(0));
        gift.use(gamePlayer);
        assertThat(gamePlayer.getMascotFlag(), is(5));
    }
}
