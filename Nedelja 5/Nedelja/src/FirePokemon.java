
public class FirePokemon extends Pokemon {
    private String name;
    public FirePokemon(String name, String type, int health) {
        super(name, type, health);
        this.name = name;
    }

    @Override
    public String logAll() {
        return name+ ": \n"
                +"napada: " + napada() + "\n"
                + "brani se: " + braniSe() + "\n"
                + "pobedjuje: " + pobedjuje() + "\n"
                + "gubi od: " + gubiOd();
    }

    @Override
    public String napada() {
        return "Vatrom";
    }

    @Override
    public String braniSe() {
        return "Telesno";
    }

    @Override
    public String pobedjuje() {
        return "Grass type";
    }

    @Override
    public String gubiOd() {
        return "Water type";
    }
}

