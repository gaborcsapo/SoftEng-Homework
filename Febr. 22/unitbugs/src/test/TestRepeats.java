package test;

import impl.WordAnalyzer;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestRepeats {
    @Test
    public void testAardvark() {
        WordAnalyzer wa = new WordAnalyzer("aardvark");
        assertEquals(wa.firstRepeatedCharacter(), 'a');
    }
}
