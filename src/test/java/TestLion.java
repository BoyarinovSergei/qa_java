import com.example.Feline;
import com.example.Lion;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

public class TestLion {

    private Feline feline = Mockito.mock(Feline.class);
    private Lion lion;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void testLionConstructorWithException() throws Exception {
        exceptionRule.expect(Exception.class);
        exceptionRule.expectMessage("Используйте допустимые значения пола животного - самей или самка");

        lion = new Lion("Unknown creature", new Feline());
    }
}
