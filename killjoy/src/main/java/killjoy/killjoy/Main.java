package killjoy.killjoy;

import javax.swing.SwingUtilities;
import killjoy.kayttoliittyma.Kayttoliittyma;
import killjoy.logiikka.Kayttokerta;
import killjoy.logiikka.KayttokertaIF;

/**
 * Luokka käynnistää ohjelman. Siinä luodaan uusi käyttöliittymä ja uusi
 * käyttökerta, joka annetaan parametrina käyttöliittymälle.
 *
 */
public class Main {

    public static void main(String[] args) {
        KayttokertaIF kayttokerta = new Kayttokerta();

        //Testataan käyttöliittymää
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(kayttokerta);
        SwingUtilities.invokeLater(kayttoliittyma);

    }
}
