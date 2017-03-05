
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
        String vastaus = kerta.getPvm();
         
        assertEquals("24.01.2017", vastaus);
    }
    
    @Test
    public void lisaaKertaAnnosLisaaAlkoholin() {
        Kayttokerta kerta = new Kayttokerta();
        kerta.lisaaKertaAnnos(1.0, 1, 4.7, 0.33);
        
        String vastaus = kerta.tulostaAlkoholit();
        
        assertEquals("Nautittu alkoholi:\n - 4.7% vahvuista alkoholia, hinta 1.0e/0.33l, 1 kpl\n\n", vastaus);
    }
    
    @Test
    public void lisaaKertaAnnosLisaaKulun() {
        Kayttokerta kerta = new Kayttokerta();
        kerta.lisaaKertaAnnos(1.0, 1, 4.7, 0.33);
        
        String vastaus = kerta.tulostaKulut();
        
        assertEquals("Kulut:\n - 1 x 1.0 euroa = 1.0 euroa\n", vastaus);
    }
    
    @Test 
    public void lisaaMuuKuluLisaaKulun() {
        Kayttokerta kerta = new Kayttokerta();
        kerta.lisaaMuuKulu(6.5, 2);
        
        String vastaus = kerta.tulostaKulut();
        
        assertEquals("Kulut:\n - 2 x 6.5 euroa = 13.0 euroa\n", vastaus);
    }
    
    @Test
    public void laskeAlkoholiKayttokerrastaLaskeeOikein() {
        Kayttokerta kerta = new Kayttokerta();
        kerta.lisaaKertaAnnos(1.0, 1, 4.7, 0.33);
        
        Double vastaus = kerta.laskeAlkoholiKayttokerrasta();
        
        assertEquals(0.01551, vastaus, 0.0001);
    }
    
    @Test 
    public void laskeAlkoholiKayttokerrastaPalauttaaTyhjalleNolla() {
        Kayttokerta kerta = new Kayttokerta();
        
        Double vastaus = kerta.laskeAlkoholiKayttokerrasta();
        
         assertEquals(0.0, vastaus, 0.0);

    }
    
    @Test
    public void laskeKulutLaskeeKulutOikein() {
        Kayttokerta kerta = new Kayttokerta();
        kerta.lisaaMuuKulu(6.5, 2);
        
        Double vastaus = kerta.laskeKulut();
        
        assertEquals(13.0, vastaus, 0.0);
    }
    
    @Test
    public void laskeKulutPalauttaaTyhjalleNolla() {
        Kayttokerta kerta = new Kayttokerta();
        
        Double vastaus = kerta.laskeKulut();
        
        assertEquals(0.0, vastaus, 0.0);
    }
    
    @Test
    public void alkoholinKokonaiskulutusLasketaanOikein() {
        Kayttokerta kerta = new Kayttokerta();
        kerta.lisaaKertaAnnos(1.0, 3, 4.7, 0.33);
        
        Double vastaus = kerta.laskeAlkoholinKokonaiskulutus();
        
        assertEquals(1, vastaus, 0.1);
    }
    
    @Test
    public void laskeAlkoholinKokonaiskulutusPalauttaaNollaTyhjalle() {
        Kayttokerta kerta = new Kayttokerta();
        
        Double vastaus = kerta.laskeAlkoholinKokonaiskulutus();
        
        assertEquals(0.0, vastaus, 0.0);
    }
    

    
    
}