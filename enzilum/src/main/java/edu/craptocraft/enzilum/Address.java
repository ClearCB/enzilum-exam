package edu.craptocraft.enzilum;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

public class Address {
    protected final KeyPair keyPair = GenSig.generateKeyPair();
    protected PrivateKey privateKey;
    protected PublicKey publicKey;
    private double balance = 0d;
    private String symbol = "EZI";

    protected PrivateKey getPrivateKey() {
        return this.privateKey;
    }

    public PublicKey getPK() {
        return this.publicKey;
    }

    private KeyPair getKeyPair() {
        return this.keyPair;
    }

    protected double getBalance() {
        return this.balance;
    }

    protected String getSymbol() {
        return this.symbol;
    }

    private void setPrivateKey(PrivateKey privateKey) {
        this.privateKey = privateKey;
    }

    private void setPublicKey(PublicKey publicKey) {
        this.publicKey = publicKey;

    }

    protected void generateKeyPair() {

        this.setPrivateKey(this.getKeyPair().getPrivate());
        this.setPublicKey(this.getKeyPair().getPublic());

    }

    protected void transferEZI(double ezis) {
        this.balance += ezis;
    }

    protected void send(TokenContract contract, double enzis) {
        if (this.getBalance() >= enzis) {
            contract.payable(this.getPK(), enzis);
            this.balance -= enzis;
        }
    }

    public String toString() {
        StringBuilder information = new StringBuilder();

        information.append("Public key: " + this.getPK().hashCode());
        information.append("\nBalance: " + this.getBalance() + " " + this.getSymbol());

        return information.toString();

    }
}
