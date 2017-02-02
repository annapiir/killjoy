/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package killjoy.logiikka;

public class MuuKulu extends Kulu {
    
    public MuuKulu(double hinta, int maara) {
        super(hinta, maara);
    }

    @Override
    public String toString() {
        return " - " + this.maara + " x " + this.hinta + " euroa";
    }
    
    
    
}
