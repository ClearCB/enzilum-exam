package edu.craptocraft.enzilum;

public class TokenContract {
    protected Address owner;
    protected String name;
    protected String symbol;
    protected int totalSupply;
    protected double tokenPrice;

    TokenContract(Address owner) {
        this.owner = owner;
    }

    public Address getOwner() {
        return owner;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int totalSupply() {
        return this.totalSupply;
    }

    public void setTotalSupply(int supply) {
        this.totalSupply = supply;
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

    public String toString() {
        StringBuilder information = new StringBuilder();

        information.append("Token name: " + this.getName());
        information.append("\nToken symbol: " + this.getSymbol());
        information.append("\nTotal supply: " + this.totalSupply());

        return information.toString();
    }
}
