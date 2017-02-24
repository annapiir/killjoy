/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class KertaAnnosTest {
    
    public KertaAnnosTest() {
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
    public void konsturktoriAsettaaKertaAnnoksenOikein() {
        KertaAnnos annos = new KertaAnnos(2.1, 6, 4.7, 0.33);
        String vastaus = annos.toString();
        
        assertEquals("4.7% vahvuista alkoholia, hinta 2.1e/0.33l, 6 kpl", vastaus);
    }
    
    @Test
    public void laskeeKertaAnnoksenAlkoholimaaranOikein() {
        KertaAnnos annos = new KertaAnnos(2.1, 6, 4.7, 0.33);
        double vastaus = annos.laskeAlkoholi();

        assertEquals(0.09306, vastaus, 0.001);
    }
}
