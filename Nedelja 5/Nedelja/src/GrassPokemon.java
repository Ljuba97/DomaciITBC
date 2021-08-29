
public class GrassPokemon extends Pokemon {
    private String name;
    public GrassPokemon(String name, String type, int health) {
        super(name, type, health);
        this.name = name;
    }

    @Override
    public String logAll() {
        return  name + ": \n"
                + "napada: " + napada() + "\n"
                + "brani se: " + braniSe() + "\n"
                + "pobedjuje: " + pobedjuje() + "\n"
                + "gubi od: " + gubiOd();
    }

    @Override
    public String napada() {
        return "Travom";
    }

    @Override
    public String braniSe() {
        return "Izbegava";
    }

    @Override
    public String pobedjuje() {
        return "Water type";
    }

    @Override
    public String gubiOd() {
        return "Fire Type";
    }
}

