
package killjoy.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class Kayttoliittyma implements Runnable {

    private JFrame frame;

    public Kayttoliittyma() {
    }

    @Override
    public void run() {
        frame = new JFrame("KillJoy");
        frame.setPreferredSize(new Dimension(500, 300));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);
        
        //Luodaan alkoholin syöttämiselle alasvetovalikot ja ryhmä valikoille
        //Alkoholiannoksen kokoluokalle
        //Alkoholin vahvuudelle
        //Annosten määrälle
        //ja nappi tulosten tallettamiselle
        
        
        //Luodaan tulosten esittämiselle oma laatikko
        JPanel tekstiPaneeli = new JPanel();
        
        //Täytetään laatikko oletusviestillä
        JLabel tulosboksi = new JLabel("Et ole vielä syöttänyt yhtään alkoholia laskuriin");
        tekstiPaneeli.add(tulosboksi);
        
        //Luodaan tuloslaatikolle rajat ja otsikko
        tekstiPaneeli.setBorder(
                BorderFactory.createCompoundBorder(
                                BorderFactory.createTitledBorder("Juomasi alkoholi"),
                                BorderFactory.createEmptyBorder(5,5,5,5)));
        
        
        container.add(tekstiPaneeli);
        
    }

    public JFrame getFrame() {
        return frame;
    }
}