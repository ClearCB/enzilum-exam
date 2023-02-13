package edu.craptocraft.enzilum;

import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

public class TokenContract {
    protected PublicKey owner;
    protected String name;
    protected String symbol;
    protected double totalSupply;
    protected Double tokenPrice;
    private Map<PublicKey, Double> contracts = new HashMap<PublicKey, Double>();

    TokenContract(Address owner) {
        this.owner = owner.getPK();
    }

    public PublicKey getOwner() {
        return this.owner;
    }

    public Map<PublicKey, Double> getContracts(){
        return this.contracts;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double totalSupply() {
        return this.totalSupply;
    }

    public void setTotalSupply(int i) {
        this.totalSupply = i;
    }

    public double getTokenPrice() {
        return this.tokenPrice;
    }

    public void setTokenPrice(double tokenPrice) {
        this.tokenPrice = tokenPrice;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public void addOwner(PublicKey user, Double quantityAdquired){
        this.getContracts().putIfAbsent(user, quantityAdquired);
        
    }



    public String toString() {
        StringBuilder information = new StringBuilder();

        information.append("Token name: " + this.getName());
        information.append("\nToken symbol: " + this.getSymbol());
        information.append("\nTotal supply: " + this.totalSupply());

        return information.toString();
    }
}
