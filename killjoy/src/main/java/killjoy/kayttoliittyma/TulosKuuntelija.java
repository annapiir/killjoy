
package killjoy.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextArea;
import killjoy.logiikka.KayttokertaIF;


public class TulosKuuntelija implements ActionListener{
    private JButton laskeTulokset;
    private JTextArea tuloksetTeksti;
    private KayttokertaIF kayttokerta;

    TulosKuuntelija(JButton laskeTulokset, JTextArea tuloksetTeksti, KayttokertaIF kayttokerta) {
        this.laskeTulokset = laskeTulokset;
        this.tuloksetTeksti = tuloksetTeksti;
        this.kayttokerta = kayttokerta;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String tulokset = "";
        tulokset = tulokset + this.kayttokerta;
        
        this.tuloksetTeksti.setText(tulokset);
    }
    
}
