import java.util.ArrayList;

public class Poruka {
    private Niska poruka;
    private Niska posiljalac;
    private Niska primalac;
    private int id;

    public Poruka() {
        poruka = posiljalac = primalac = null;
        id = 0;
    }

    public Poruka(Niska poruka, Niska posiljalac, Niska primalac, int id) {
        this.poruka = poruka;
        this.posiljalac = posiljalac;
        this.primalac = primalac;
        this.id = id;
    }

    public Niska getPoruka() {
        return poruka;
    }

    public Niska getPosiljalac() {
        return posiljalac;
    }

    public Niska getPrimalac() {
        return primalac;
    }

    public int getId() {
        return id;
    }

    public void sifrujZaK(int k) {
        char[] novaPoruka = new char[poruka.length()];
        for (int i = 0; i < novaPoruka.length; i++) {
            novaPoruka[i] = (char)((int)poruka.getChars()[i] + k);
        }
        poruka = new Niska(novaPoruka);
    }

    public void desifruj(int k) {
        char[] novaPoruka = new char[poruka.length()];
        for (int i = 0; i < novaPoruka.length; i++) {
            novaPoruka[i] = (char)((int)poruka.getChars()[i] - k);
        }
        poruka = new Niska(novaPoruka);
    }

    @Override
    public String toString() {
        return id + "\n" + posiljalac + " salje " + primalac + " poruku: \n" + poruka;
    }
}
