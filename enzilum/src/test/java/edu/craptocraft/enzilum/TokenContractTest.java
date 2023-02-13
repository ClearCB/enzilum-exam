package edu.craptocraft.enzilum;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

public class TokenContractTest {
    static TokenContract ricknillosTest;
    static Address rick;

    @BeforeClass
    public static void ricknillosTestCreate() {

        rick = new Address();
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
        assertEquals("RNiLL", ricknillosTest.symbol());
        assertEquals(100, ricknillosTest.totalSupply(),0);
        assertEquals(5d, ricknillosTest.getTokenPrice(), 0);
        assertEquals(rick.getPK().hashCode(), ricknillosTest.getOwner().hashCode());

        String sampleText = "Token name: Ricknillos\nToken symbol: RNiLL\nTotal supply: 100.0";

        assertEquals(sampleText, ricknillosTest.toString());

    }

    @Test
    public void ownersTest(){

        ricknillosTest.setName("Ricknillos");
        ricknillosTest.setSymbol("RNiLL");
        ricknillosTest.setTotalSupply(100);
        ricknillosTest.setTokenPrice(5d);
        assertTrue(ricknillosTest.getContracts().isEmpty());
        ricknillosTest.addOwner(rick.getPK(), ricknillosTest.totalSupply());
        assertEquals(1,ricknillosTest.getContracts().size());
        assertFalse(ricknillosTest.getContracts().isEmpty());
        assertEquals(1, ricknillosTest.numOwners());

        assertEquals(100d, ricknillosTest.balanceOf(rick.getPK()),0);

        Address morty = new Address();
        morty.generateKeyPair();

        ricknillosTest.transfer(morty.getPK(),2d);
        assertEquals(98d, ricknillosTest.balanceOf(rick.getPK()),0);
        ricknillosTest.transfer(morty.getPK(),4500d);
        assertEquals(98d, ricknillosTest.balanceOf(rick.getPK()),0);

    }


}
