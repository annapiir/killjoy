package killjoy.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
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
        
        //Luodaan päivämääräryhmä
        //Luodaan tekstikenttä päivämäärän antamiselle
        JPanel pvmPaneeli = new JPanel();
        BoxLayout pvmLayout = new BoxLayout(pvmPaneeli, BoxLayout.X_AXIS);
        pvmPaneeli.setLayout(pvmLayout);
        JLabel pvmTeksti = new JLabel("Päivämäärä: ");
        JTextField pvmKentta = new JTextField();
        pvmPaneeli.add(pvmTeksti);
        pvmPaneeli.add(pvmKentta);
        

        //Luodaan alkoholin syöttämiselle alasvetovalikot ja ryhmä valikoille
        JPanel alkoholiPaneeli = new JPanel();
        BoxLayout alkoholiLayout = new BoxLayout(alkoholiPaneeli, BoxLayout.X_AXIS);
        alkoholiPaneeli.setLayout(alkoholiLayout);
        
        //Annosten määrälle
        JLabel maaraTeksti = new JLabel(" x ");
        JComboBox<Integer> maaraValikko= new JComboBox<>();
        //Alkoholiannoksen kokoluokalle
        JComboBox<String> kokoValikko = new JComboBox<>();
        //Alkoholin vahvuudelle
        JLabel vahvuusTeksti = new JLabel(" vahvuus ");
        JComboBox<Double> vahvuusValikko = new JComboBox<>();
        //Annoksen hinnalle
        JLabel hintaTeksti = new JLabel(" hinta ");
        JComboBox<Double> hintaValikko = new JComboBox<>();
        JLabel hintaTeksti2 = new JLabel("euroa/kpl  ");
        //ja nappi tulosten tallettamiselle
        JButton lisaaAlkoholi = new JButton("Lisää");
        //Asetetaan alkoholille rajat
        alkoholiPaneeli.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Lisää alkoholiannoksia"),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        
        alkoholiPaneeli.add(maaraValikko);
        alkoholiPaneeli.add(maaraTeksti);
        alkoholiPaneeli.add(kokoValikko);
        alkoholiPaneeli.add(vahvuusTeksti);
        alkoholiPaneeli.add(vahvuusValikko);
        alkoholiPaneeli.add(hintaTeksti);
        alkoholiPaneeli.add(hintaValikko);
        alkoholiPaneeli.add(hintaTeksti2);
        alkoholiPaneeli.add(lisaaAlkoholi);
        
        //Luodaan muiden kulujen syöttämiselle alasvetovalikot ja ryhmä valikoille
        JPanel kuluPaneeli = new JPanel();
        BoxLayout kuluLayout = new BoxLayout(kuluPaneeli, BoxLayout.X_AXIS);
        kuluPaneeli.setLayout(kuluLayout);
        //Määrälle
        JLabel maaraKuluTeksti = new JLabel(" x ");
        JComboBox<Integer> maaraKuluValikko= new JComboBox<>();
        //Hinnalle
        JLabel hintaKuluTeksti = new JLabel(" hinta ");
        JComboBox<Double> hintaKuluValikko = new JComboBox<>();
        JLabel hintaKuluTeksti2 = new JLabel("euroa/kpl  ");
        //ja nappi tulosten tallettamiselle
        JButton lisaaKulu = new JButton("Lisää");
        //Asetetaan kuluille rajat
        kuluPaneeli.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Lisää muita kuluja"),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        
        kuluPaneeli.add(maaraKuluValikko);
        kuluPaneeli.add(maaraKuluTeksti);
        kuluPaneeli.add(hintaKuluTeksti);
        kuluPaneeli.add(hintaKuluValikko);
        kuluPaneeli.add(hintaKuluTeksti2);
        kuluPaneeli.add(lisaaKulu);
        
        //Luodaan syötettyjen tietojen esittämiselle oma laatikko
        JPanel syottoPaneeli = new JPanel();
        BoxLayout tekstiLayout = new BoxLayout(syottoPaneeli, BoxLayout.Y_AXIS);
        syottoPaneeli.setLayout(tekstiLayout);

        //Täytetään laatikko oletusviestillä
        JTextArea tulosboksi = new JTextArea("Et ole vielä syöttänyt yhtään alkoholia laskuriin");
        JTextArea tulosMuuKulu = new JTextArea("Et ole syöttänyt muita kuluja");
        syottoPaneeli.add(tulosboksi);
        syottoPaneeli.add(tulosMuuKulu);

        //Luodaan laatikolle rajat ja otsikko
        syottoPaneeli.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createTitledBorder("Juomasi alkoholi"),
                        BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        
        //Lisätään tulosten laskemiselle nappi
        JButton laskeTulokset = new JButton("Laske tulokset");
        
        //Lisätään tulosten esittämiselle oma laatikko
        JTextArea tuloksetTeksti= new JTextArea("Ei vielä tuloksia...");
        //Tehdään tuloksille rajat
        tuloksetTeksti.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Tulokset"),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        

        container.add(pvmPaneeli); 
        container.add(alkoholiPaneeli);
        container.add(kuluPaneeli);
        container.add(syottoPaneeli);
        container.add(laskeTulokset);
        container.add(tuloksetTeksti);




    }

    public JFrame getFrame() {
        return frame;
    }
}
