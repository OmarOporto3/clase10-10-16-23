import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.register.RegisterFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

public class RegisterFactoryTest {
    private RegisterFactory registerFactory;

    @BeforeEach
    void setUp()
    {
        registerFactory = new RegisterFactory();
    }

    @Test
    void testConstructor()
    {
         assertNotNull(registerFactory);
    }

    @Test
    void testGetCondorList()
    {
        assertEquals(10,registerFactory.getCondorList().size());
    }

    @Test
    void testGetCondorLocations()
    {
        List<String> locations = new ArrayList<>();
        locations.add("Colombia");
        locations.add("Venezuela");
        locations.add("Bolivia");
        locations.add("Ecuador");
        locations.add("Peru");
        List<String> testedLocations = registerFactory.getCondorLocations();

        for (String testedLocation : testedLocations)
        {
            assertTrue(locations.contains(testedLocation), "invalid country founded " + testedLocation);
        }
    }

    @Test
    void testFormatCondorIds() {
        String pattern = "^AC\\d+$";
        Pattern regexPattern = Pattern.compile(pattern);
        List<String> Ids = registerFactory.getCondorIds();

        for (String Id : Ids) {
            Matcher matcher = regexPattern.matcher(Id);
            assertTrue(matcher.matches(),"Fail in Format : " +Id);
        }
    }
}
