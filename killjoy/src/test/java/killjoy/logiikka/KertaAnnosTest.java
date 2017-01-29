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
        KertaAnnos annos = new KertaAnnos("Perusolut", 4.7, 2.1, 0.33, 6);
        String vastaus = annos.toString();
        
        assertEquals("Perusolut: vahvuus 4.7%, hinta 2.1e/0.33l, 6kpl", vastaus);
    }
    
}
