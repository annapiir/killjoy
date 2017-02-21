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
import javax.swing.JComponent;
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
        frame.setPreferredSize(new Dimension(700, 300));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);
        
        //Luodaan käyttöliittymään tietojen syöttämistä ja esittämistä varten paneelit
        JPanel pvmPaneeli = luoPvmPaneeli();
        JPanel alkoholiPaneeli = luoAlkoholiPaneeli();
        JPanel kuluPaneeli = luoKuluPaneeli();
        JPanel tietoPaneeli = luoTietoPaneeli();
        JTextArea tuloksetTeksti = luoTulosLaatikko();
        JButton laskeTulokset = luoTulosNappi();
 
        
        
        //Lisätään kaikki osaset ikkunaan
        container.add(pvmPaneeli); 
        container.add(alkoholiPaneeli);
        container.add(kuluPaneeli);
        container.add(tietoPaneeli);
        container.add(laskeTulokset);
        container.add(tuloksetTeksti);

    }

    public JFrame getFrame() {
        return frame;
    }

    private JPanel luoPvmPaneeli() {
        JPanel pvmPaneeli = new JPanel();
        BoxLayout pvmLayout = new BoxLayout(pvmPaneeli, BoxLayout.X_AXIS);
        pvmPaneeli.setLayout(pvmLayout);
        JLabel pvmTeksti = new JLabel("Päivämäärä: ");
        JTextField pvmKentta = new JTextField();
        pvmPaneeli.add(pvmTeksti);
        pvmPaneeli.add(pvmKentta);
        
        return pvmPaneeli;
    }

    private JPanel luoAlkoholiPaneeli() {
        JPanel alkoholiPaneeli = new JPanel();
        BoxLayout alkoholiLayout = new BoxLayout(alkoholiPaneeli, BoxLayout.X_AXIS);
        alkoholiPaneeli.setLayout(alkoholiLayout);
        
        //Luodaan valikot
        //Annosten määrälle
        JLabel maaraTeksti = new JLabel(" x ");
        JComboBox<Integer> maaraValikko= new JComboBox<>(maaraLista());
        //Alkoholiannoksen kokoluokalle
        JComboBox<Double> kokoValikko = new JComboBox<>(alkoholiKokoLista());
        //Alkoholin vahvuudelle
        JLabel vahvuusTeksti = new JLabel(" l, vahvuus ");
        JComboBox<Double> vahvuusValikko = new JComboBox<>(alkoholiVahvuusLista());
        //Annoksen hinnalle
        JLabel hintaTeksti = new JLabel(" %, hinta ");
        JComboBox<Double> hintaValikko = new JComboBox<>(hintaLista());
        hintaValikko.setEditable(true);
        JLabel hintaTeksti2 = new JLabel("euroa ");
        //ja nappi tulosten tallettamiselle
        JButton lisaaAlkoholi = new JButton("Lisää");

        luoRajat(alkoholiPaneeli, "Lisää alkoholiannoksia");

        
        alkoholiPaneeli.add(maaraValikko);
        alkoholiPaneeli.add(maaraTeksti);
        alkoholiPaneeli.add(kokoValikko);
        alkoholiPaneeli.add(vahvuusTeksti);
        alkoholiPaneeli.add(vahvuusValikko);
        alkoholiPaneeli.add(hintaTeksti);
        alkoholiPaneeli.add(hintaValikko);
        alkoholiPaneeli.add(hintaTeksti2);
        alkoholiPaneeli.add(lisaaAlkoholi);
        
        return alkoholiPaneeli;
    }
    
    private Integer[] maaraLista() {
        Integer[] lista = {1,2,3,4,5,6,7,8,9,10};
        return lista;
    }
    
    private Double[] alkoholiKokoLista() {
        Double[] lista = {0.04, 0.08, 0.12, 0.16, 0.24, 0.33, 0.5, 0.568, 0.75, 3.0};
        return lista;
    }
    
    private Double[] alkoholiVahvuusLista() {
        Double[] lista = {2.6, 4.7, 5.2, 12.5, 22.0, 38.5};
        return lista;
    }
    
    private Double[] hintaLista() {
        Double[] lista = {1.2, 3.5, 5.2, 6.9, 9.9, 15.0};
        return lista;
    }

    private JPanel luoKuluPaneeli() {
        JPanel kuluPaneeli = new JPanel();
        BoxLayout kuluLayout = new BoxLayout(kuluPaneeli, BoxLayout.X_AXIS);
        kuluPaneeli.setLayout(kuluLayout);
        
        //Luodaan valikot
        //Määrälle
        JLabel maaraKuluTeksti = new JLabel(" x ");
        JComboBox<Integer> maaraKuluValikko= new JComboBox<>(maaraLista());
        //Hinnalle
        JLabel hintaKuluTeksti = new JLabel(" hinta ");
        JComboBox<Double> hintaKuluValikko = new JComboBox<>(hintaLista());
        hintaKuluValikko.setEditable(true);
        JLabel hintaKuluTeksti2 = new JLabel("euroa  ");
        //ja nappi tulosten tallettamiselle
        JButton lisaaKulu = new JButton("Lisää");

        luoRajat(kuluPaneeli, "Lisää muita kuluja");
        
        kuluPaneeli.add(maaraKuluValikko);
        kuluPaneeli.add(maaraKuluTeksti);
        kuluPaneeli.add(hintaKuluTeksti);
        kuluPaneeli.add(hintaKuluValikko);
        kuluPaneeli.add(hintaKuluTeksti2);
        kuluPaneeli.add(lisaaKulu);
        
        return kuluPaneeli;   
    }

    private JPanel luoTietoPaneeli() {
        JPanel tietoPaneeli = new JPanel();
        BoxLayout tekstiLayout = new BoxLayout(tietoPaneeli, BoxLayout.Y_AXIS);
        tietoPaneeli.setLayout(tekstiLayout);

        //Täytetään laatikko oletusviestillä
        JTextArea tietoAlkoholi = new JTextArea("Et ole vielä syöttänyt yhtään alkoholia laskuriin");
        JTextArea tietoMuuKulu = new JTextArea("Et ole syöttänyt muita kuluja");
        tietoPaneeli.add(tietoAlkoholi);
        tietoPaneeli.add(tietoMuuKulu);

        luoRajat(tietoPaneeli, "Juomasi alkoholi");
        
        return tietoPaneeli;
    }

    private JTextArea luoTulosLaatikko() {
        JTextArea tuloksetTeksti= new JTextArea("Ei vielä tuloksia...");
        luoRajat(tuloksetTeksti, "Tulokset");
        
        return tuloksetTeksti;
    }

    private JButton luoTulosNappi() {
        JButton laskeTulokset = new JButton("Laske tulokset");
        
        return laskeTulokset;     
    }
    
    private void luoRajat(JComponent objekti, String otsikko) {
        objekti.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(otsikko),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
    }
}
