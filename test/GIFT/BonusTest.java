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
 * Time: 下午3:20
 * To change this template use File | Settings | File Templates.
 */
public class BonusTest {

    protected AGift gift;
    AGamePlayer gamePlayer;

    @Before
    public void setUp(){
        gift = new Bonus();
        gamePlayer = new GamePlayer();
    }

    @Test
    public void should_money_be_12000_when_gameplayer_gets_Bonus() {
        assertThat(gamePlayer.getMoney(), is(10000));
        gift.use(gamePlayer);
        assertThat(gamePlayer.getMoney(), is(12000));
    }

}
