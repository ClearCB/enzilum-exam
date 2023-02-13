package edu.craptocraft.enzilum;

import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

public class TokenContract {
    protected Address ownerAddress;
    protected PublicKey owner;
    protected String name;
    protected String symbol;
    protected double totalSupply;
    protected Double tokenPrice = 5d;
    private Map<PublicKey, Double> contracts = new HashMap<PublicKey, Double>();

    TokenContract(Address owner) {
        this.ownerAddress = owner;
        this.owner = owner.getPK();
    }

    public Address getOwner() {
        return this.ownerAddress;
    }

    public Map<PublicKey, Double> getContracts() {
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

    public String symbol() {
        return symbol;
    }

    public void addOwner(PublicKey user, Double quantityAdquired) {
        this.getContracts().putIfAbsent(user, quantityAdquired);

    }

    public int numOwners() {
        return this.getContracts().size();
    }

    public double balanceOf(PublicKey key) {
        return this.getContracts().containsKey(key) ? this.getContracts().get(key) : 0d;
    }

    public void transfer(PublicKey keyObjective, double quantityTransfered) {

        if (quantityTransfered <= this.totalSupply()) {

            this.getContracts().replace(this.owner, this.getContracts().get(this.owner) - quantityTransfered);
            this.getContracts().put(keyObjective, balanceOf(keyObjective) + quantityTransfered);

        }

    }

    public void transfer(PublicKey keyUser, PublicKey keyObjective, double quantityTransfered) {

        if (quantityTransfered <= this.balanceOf(keyUser)) {

            this.getContracts().replace(keyUser, this.getContracts().get(keyUser) - quantityTransfered);
            this.getContracts().put(keyObjective, balanceOf(keyObjective) + quantityTransfered);

        }

    }

    public double totalTokensSold() {
        return this.totalSupply - this.balanceOf(owner);
    }

    public void owners() {
        this.getContracts().entrySet().stream()
                .filter(entry -> entry.getKey() != this.owner)
                .forEach(entry -> System.out
                        .println("Owner PK: " + entry.getKey().hashCode() + "\nTokens: " + entry.getValue()));
    }

    public void payable(PublicKey objectPublicKey, double enzis) {
        double tokensToBuy = Math.floor(enzis / this.getTokenPrice()) ;

        if (tokensToBuy > 0) {
            this.transfer(this.owner, objectPublicKey, tokensToBuy);
            this.getOwner().transferEZI(enzis);
            
        }
    }



    public String toString() {
        StringBuilder information = new StringBuilder();

        information.append("Token name: " + this.getName());
        information.append("\nToken symbol: " + this.symbol());
        information.append("\nTotal supply: " + this.totalSupply());

        return information.toString();
    }
}
