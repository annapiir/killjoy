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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     
    @Test
    public void konstruktoriAsettaaPvmnOikein() {
        Kayttokerta kerta = new Kayttokerta("24.01.2017");
        String vastaus = kerta.toString();
         
        assertEquals("Illan 24.01.2017 saldo:\nei alkoholia eikä muita kuluja", vastaus);
    }
     
    @Test 
    public void lisaaKertaAnnosEiLisaaTyhjaa() {
        Kayttokerta kerta = new Kayttokerta("24.01.2017");
        kerta.lisaaKertaAnnos(null);
        String vastaus = kerta.toString();
       
        assertEquals("Illan 24.01.2017 saldo:\nei alkoholia eikä muita kuluja", vastaus);
    }
    
    @Test 
    public void lisaaKertaAnnosLisaaAnnoksenListaan() {
        Kayttokerta kerta = new Kayttokerta("24.01.2017");
        KertaAnnos annos = new KertaAnnos("Perusolut", 4.7, 2.1, 0.33, 6);
        kerta.lisaaKertaAnnos(annos);
        String vastaus = kerta.toString();
        
        assertEquals("Illan 24.01.2017 saldo:\n - Perusolut: vahvuus 4.7%, hinta 2.1e/0.33l, 6kpl\n", vastaus);
    }
}
