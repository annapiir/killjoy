
package killjoy.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MuuKuluTest {
    
    public MuuKuluTest() {
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

    @Test
    public void konstruktoriAsettaaHinnanJaMaaranOikein() {
        MuuKulu muuKulu = new MuuKulu(13.5, 2);
        String vastaus = muuKulu.toString();
        
        assertEquals(" - 2 x 13.5 euroa", vastaus);
    }
}
