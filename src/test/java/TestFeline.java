import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TestFeline {

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
        Assert.assertEquals(1, feline.getKittens());
    }

    @Test
    public void testGetKittensWithParams() {
        Assert.assertEquals(1, feline.getKittens(1));
    }
}
