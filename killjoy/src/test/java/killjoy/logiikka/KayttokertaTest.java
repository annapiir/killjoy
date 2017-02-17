
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
        Kayttokerta kerta = new Kayttokerta("24.01.2017");
        String vastaus = kerta.toString();
         
        assertEquals("Illan 24.01.2017 saldo:\nei alkoholia eikä muita kuluja\nPuhdasta alkoholia joit 0.0l\nKaikkiaan kuluja koitui 0.0 euroa", vastaus);
    }
     
    @Test 
    public void lisaaKertaAnnosEiLisaaTyhjaa() {
        Kayttokerta kerta = new Kayttokerta("24.01.2017");
        kerta.lisaaKertaAnnos(null);
        String vastaus = kerta.toString();
       
        assertEquals("Illan 24.01.2017 saldo:\nei alkoholia eikä muita kuluja\nPuhdasta alkoholia joit 0.0l\nKaikkiaan kuluja koitui 0.0 euroa", vastaus);
    }
    
    @Test 
    public void lisaaKertaAnnosLisaaAnnoksenListaan() {
        Kayttokerta kerta = new Kayttokerta("24.01.2017");
        KertaAnnos annos = new KertaAnnos(2.1, 6, 4.7, 0.33);
        kerta.lisaaKertaAnnos(annos);
        String vastaus = kerta.toString();
        
        assertEquals("Illan 24.01.2017 saldo:\n - 4.7% vahvuista alkoholia, hinta 2.1e/0.33l, 6 kpl\n\nPuhdasta alkoholia joit 0.09306l\nKaikkiaan kuluja koitui 12.600000000000001 euroa", vastaus);
    }
    
    @Test 
    public void lisaaMuuKuluEiLisaaTyhjaa() {
        Kayttokerta kerta = new Kayttokerta("24.01.2017");
        kerta.lisaaMuuKulu(null);
        String vastaus = kerta.toString();
       
        assertEquals("Illan 24.01.2017 saldo:\nei alkoholia eikä muita kuluja\nPuhdasta alkoholia joit 0.0l\nKaikkiaan kuluja koitui 0.0 euroa", vastaus);
    }
    
    @Test 
    public void lisaaMuuKuluLisaaKulunListaan() {
        Kayttokerta kerta = new Kayttokerta("24.01.2017");
        KertaAnnos annos = new KertaAnnos(2, 6, 4.7, 0.33);
        kerta.lisaaKertaAnnos(annos);
        Kulu muuKulu = new Kulu(13.5, 2) {};
        kerta.lisaaMuuKulu(muuKulu);
        String vastaus = kerta.toString();
        
        assertEquals("Illan 24.01.2017 saldo:\n - 4.7% vahvuista alkoholia, hinta 2.0e/0.33l, 6 kpl\n\nPuhdasta alkoholia joit 0.09306l\nKaikkiaan kuluja koitui 39.0 euroa", vastaus);
    }
}