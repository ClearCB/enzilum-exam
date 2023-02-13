package edu.craptocraft.enzilum;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;

public class TokenContractTest {
    static TokenContract ricknillosTest;

    @BeforeClass
    public static void ricknillosTestCreate() {

        Address rick = new Address();
        rick.generateKeyPair();
        ricknillosTest = new TokenContract(rick);
    }

    @Test
    public void constructorTest() {

        assertNotNull(ricknillosTest);


        

    }

    @Test
    public void gettersSettersTest() {

        ricknillosTest.setName("Ricknillos");
        ricknillosTest.setSymbol("RNiLL");
        ricknillosTest.setTotalSupply(100);
        ricknillosTest.setTokenPrice(5d);
        assertEquals("Ricknillos", ricknillosTest.getName());
        assertEquals("RNiLL", ricknillosTest.getSymbol());
        assertEquals(100, ricknillosTest.totalSupply());
        assertEquals(5d, ricknillosTest.getTokenPrice(), 0);

        String sampleText = "Token name: Ricknillos\nToken symbol: RNiLL\nTotal supply: 100";
     
        assertEquals(sampleText, ricknillosTest.toString()); 
        
    }
}
