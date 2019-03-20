import fr.gosecuri.model.Kit;
import org.junit.Assert;
import org.junit.Test;

public class KitTest {
    @Test
    public void getUserFromDB() {
//        Kit kit = new Kit("lampe torche", 11);
//        String id = kit.store(kit);
//
//        kit.setId(id);
//
//        kit.getQuantity();

        Kit kit = new Kit("-LXP5u7JjeQUCA8C_Fmh");
        int q = kit.getQuantity();
        System.out.println(q);
//        kit.addItem(5);
//
//        kit.delete("lampe torche");

//        DataSnapshot dataSnapshot = kit.get("-LXP5u7JjeQUCA8C_Fmh");
//        System.out.println(dataSnapshot.getValue(Kit.class).getQuantity());
//
//        kit.takeItem(2);
//
//        kit.setName("lampe torche");
//        kit.store(kit.getId(), "name", kit.getName());
//
//        kit.delete(kit.getId());
    }
}