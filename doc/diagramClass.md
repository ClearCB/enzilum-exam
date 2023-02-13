# Diagram

## Clase Address

### Atributos

* PublicKey  
* PrivateKey  
* balance  
* symbol  

### Métodos

* toString()
* addEZI(Double EZI)
* transferEZI(Double EZI)
* send(TokenContract contract, Double EZI)

## Clase TokenContract

### Atributos

### Métodos

* name
* symbol()
* totalSupply()
* addOwner(PublicKey PK, Double units)
* numOwners()
* balanceOf(PublicKey owner)
* transfer(PublicKey recipient, Double units)
* transfer(PublicKey sender, PublicKey recipient, Double units)
* require(Boolean holds)
* owners()
* payable(PublicKey recipient, Double EnZinIums)

## Clase GenSig

NO MODIFICAR ESTA CLASE...PREDEFINIDA