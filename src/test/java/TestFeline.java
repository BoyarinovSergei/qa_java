import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TestFeline {

    private int numberOfCats = 1;
    private int numberOfMethodInvokes = 1;

    private Feline feline = new Feline();

    @Test
    public void testEatMeatMethod() throws Exception {
        List<String> list = feline.eatMeat();

        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), list);
    }

    @Test
    public void testGetFamilyMethod() {
        Assert.assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void testGetKittensWithNoParams() {
        Assert.assertEquals(numberOfMethodInvokes, feline.getKittens());
    }

    @Test
    public void testGetKittensWithParams() {
        Assert.assertEquals(numberOfCats, feline.getKittens(numberOfCats));
    }
}
