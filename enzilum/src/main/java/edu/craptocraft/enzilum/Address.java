package edu.craptocraft.enzilum;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

public class Address{
    protected final KeyPair keyPair = GenSig.generateKeyPair();
    protected PrivateKey privateKey;
    protected PublicKey publicKey;
    private double balance = 0d;
    private String symbol = "EZI";
    

    protected PrivateKey getPrivateKey(){
        return this.privateKey;
    }

    public PublicKey getPublicKey(){
        return this.publicKey;
    }

    private KeyPair getKeyPair(){
        return this.keyPair;
    }

    protected double getBalance(){
        return this.balance;
    }

    protected String getSymbol(){
        return this.symbol;
    }

    private void setPrivateKey(PrivateKey privateKey){
        this.privateKey = privateKey;
    }

    private void setPublicKey(PublicKey publicKey){
        this.publicKey = publicKey;

    }

    protected void generateKeyPair(){

        this.setPrivateKey(this.getKeyPair().getPrivate());
        this.setPublicKey(this.getKeyPair().getPublic());

    }

    public String toString(){
        StringBuilder information = new StringBuilder();

        information.append("Public key: " + this.getPublicKey().hashCode());
        information.append("\nBalance: " + this.getBalance() + " " + this.getSymbol());

        return information.toString();

    }
}
