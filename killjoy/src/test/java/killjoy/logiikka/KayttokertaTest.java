
package killjoy.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KayttokertaTest {
    
    public KayttokertaTest() {
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
    public void konstruktoriAsettaaPvmnOikein() {
        Kayttokerta kerta = new Kayttokerta();
        kerta.setPvm("24.01.2017");
        String vastaus = kerta.toString();
         
        assertEquals("Illan 24.01.2017 saldo:\nei alkoholia eikä muita kuluja\nPuhdasta alkoholia joit 0.0l\nKaikkiaan kuluja koitui 0.0 euroa", vastaus);
    }

    
    
}