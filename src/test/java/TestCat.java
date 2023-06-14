import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TestCat {

    @Spy
    private Feline feline;

    private Cat cat;

    @Before
    public void setUp() {
        cat = new Cat(feline);
    }


    @Test
    public void testGetSoundMethod() {
        Assert.assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testGetFoodMethod() throws Exception {
        when(feline.eatMeat()).thenReturn(List.of("Value"));
        cat.getFood();
        verify(feline, Mockito.times(2)).eatMeat();
    }
}
