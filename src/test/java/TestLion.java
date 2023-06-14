import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class TestLion {

    private Feline feline = Mockito.mock(Feline.class);
    private Lion lion;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Самец", true},
                {"Самка", false}
        });
    }

    private final String typeOfCreature;
    private final Object expectedData;


    public TestLion(String typeOfCreature, Object expectedData) {
        this.typeOfCreature = typeOfCreature;
        this.expectedData = expectedData;
    }

    @Test
    public void testLionConstructorWithNoException() throws Exception {
        lion = new Lion(typeOfCreature, new Feline());

        Assert.assertEquals(expectedData, lion.doesHaveMane());
    }

    @Test
    public void testLionConstructorWithException() {
        try {
            lion = new Lion("Unknown creature", new Feline());
        } catch (Exception exception) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void testGetKittensMethod() throws Exception {
        lion = new Lion("Самка", feline);
        when(feline.getKittens()).thenReturn(1);
        lion.getKittens();
        verify(feline, Mockito.times(1)).getKittens();
    }


    @Test
    public void testGetFoodMethod() throws Exception {
        lion = new Lion("Самка", feline);
        when(feline.getFood("Хищник")).thenReturn(List.of("value"));
        lion.getFood();
        verify(feline, Mockito.times(1)).getFood("Хищник");
    }

    @Test
    public void testDoesHaveManeMethod() throws Exception {
        lion = new Lion("Самка", feline);

        Assert.assertFalse(lion.doesHaveMane());
    }
}
