package test;

import impl.WordAnalyzer;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestMultiples {
    @Test
    public void testAardvark() {
        WordAnalyzer wa = new WordAnalyzer("missisippi");
        assertEquals(wa.firstMultipleCharacter(), 'i');
    }
}
