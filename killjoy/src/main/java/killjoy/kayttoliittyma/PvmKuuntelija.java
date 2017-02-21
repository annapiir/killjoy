
package killjoy.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import killjoy.logiikka.KayttokertaRajapinta;

public class PvmKuuntelija implements ActionListener{
    private JTextField pvmKentta;
    private KayttokertaRajapinta kayttokerta;

    public PvmKuuntelija(KayttokertaRajapinta kayttokerta, JTextField pvmKentta) {
        this.pvmKentta = pvmKentta;  
        this.kayttokerta = kayttokerta;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        this.pvmKentta.setEditable(false);
        this.kayttokerta.setPvm(this.pvmKentta.getText());
    }
    
}
