package killjoy.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author annapiir
 */
public class KuluTest {
    
    public KuluTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void kuluLaskeeHinnanYhteensaOikein() {
        Kulu kulu = new Kulu(13.5, 2) {};
        double vastaus = kulu.hintaYht();
        
        assertEquals(27, vastaus, 0.001);
    }
}
