import java.util.LinkedList;

public class Posta {
    private LinkedList<Poruka> mail;

    public Posta(LinkedList<Poruka> mail) {
        this.mail = mail;
    }

    public void add(Poruka p){
        for (Poruka por : mail) {
            if (por.equals(p))
                return;
        }
        mail.add(p);
    }

    public void add(Poruka p, int index){
        if (!mail.get(index).equals(p))
            mail.add(p);
    }

    public void remove(Poruka p){
        for (Poruka por : mail) {
            if (por.equals(p))
                return;
        }
        mail.remove(p);
    }

    public void remove(int index){
        mail.remove(index);
    }

    public void sifruj(Poruka p, int k){
        for (Poruka por : mail) {
            if (por.equals(p))
                p.sifrujZaK(k);
        }
    }

    public void sifruj(int index, int k){
        mail.get(index).sifrujZaK(k);
    }

    public void desifruj(Poruka p, int k){
        for (Poruka por : mail) {
            if (por.equals(p))
                p.desifruj(k);
        }
    }

    public void desifruj(int index, int k){
        mail.get(index).desifruj(k);
    }

    public void sifrujSveZaK(int k){
        for (Poruka por : mail)
            por.sifrujZaK(k);
    }

    public void desifruj(int k){
        for (Poruka por : mail)
            por.desifruj(k);
    }

    public void send(Poruka p) {
        for (Poruka por : mail) {
            if (por.equals(p)) {
                System.out.println(p);
                mail.remove(por);
                return;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Poruka p : mail) {
            sb.append(p.getId()).append(":").append(p.getPoruka()).append("\n");
        }
        return sb.toString();
    }
}
