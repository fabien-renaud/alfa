package fr.gosecuri;
import fr.gosecuri.model.Kit;
import fr.gosecuri.model.User;

public class App {
    public static void main(String... args) {
        //new MainPage();
        
        Kit kit = new Kit("lampe torche");
        kit.addItem(5);
        kit.takeItem(4);

        //kit.delete("lampe torche");

        kit.get("brassard de sécurité");
        System.out.println(kit.retrieveData);
    }
}
