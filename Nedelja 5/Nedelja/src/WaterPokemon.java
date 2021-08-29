
public class WaterPokemon extends Pokemon{
    private String name;
    public WaterPokemon(String name, String type, int health) {
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
        return "Vodom";
    }

    @Override
    public String braniSe() {
        return "Vodom";
    }

    @Override
    public String pobedjuje() {
        return "Fire type";
    }

    @Override
    public String gubiOd() {
        return "Grass type";
    }
}

