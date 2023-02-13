package edu.craptocraft.enzilum;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;

public class AddressTest {
    static Address sampleAddress;

    @BeforeClass
    public static void sampleAddressTest() {
        sampleAddress = new Address();

    }

    @Test
    public void constructorTest() {

        assertNotNull(sampleAddress);

        assertEquals("EZI", sampleAddress.getSymbol());
        assertEquals(0d, sampleAddress.getBalance(), 0);
        sampleAddress.generateKeyPair();

        int hasCodeKey = sampleAddress.getPK().hashCode();
        String sampleText = "Public key: " + hasCodeKey + "\nBalance: " + sampleAddress.getBalance() + " "
                + sampleAddress.getSymbol();
        
        assertEquals(sampleText, sampleAddress.toString());

    }

    @Test
    public void generateKeyPairTest() {

        sampleAddress.generateKeyPair();

        assertNotNull(sampleAddress.getPK());
        assertNotNull(sampleAddress.getPrivateKey());
    }
}
