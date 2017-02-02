
package killjoy.logiikka;

public abstract class Kulu {
    protected double hinta;
    protected int maara;

    public Kulu(double hinta, int maara) {
        this.hinta = hinta;
        this.maara = maara;
    }

    public double getHinta() {
        return hinta;
    }

    public int getMaara() {
        return maara;
    }
    
    public double hintaYht() {
        return this.hinta * this.maara;
    }
    
}
