import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        hamletText = String.valueOf(hamletParser.replaceHamlet());
        Assert.assertTrue(hamletText.contains("Leon"));
        Assert.assertFalse(hamletText.contains("Hamlet"));
    }

    @Test
    public void testChangeHoratioToTariq() {
        hamletText = String.valueOf(hamletParser.replaceHoratio());
        Assert.assertTrue(hamletText.contains("Tariq"));
        Assert.assertFalse(hamletText.contains("Horatio"));
    }

    @Test
    public void testFindHoratio() {
        hamletText = String.valueOf(hamletParser.replaceHoratio());
        Assert.assertFalse(hamletParser.findHoratio(hamletText));
    }

    @Test
    public void testFindHamlet() {
        hamletText = String.valueOf(hamletParser.replaceHamlet());
        Assert.assertFalse(hamletParser.findHamlet(hamletText));
    }
}