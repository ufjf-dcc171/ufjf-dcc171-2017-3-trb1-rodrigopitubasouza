
package hamburgueria;

public class Item {
    private String nome;
    private double valor;

    public Item (String nome, double valor){
            this.nome = nome;
            this.valor = valor;
    }

    Item() {
       
    }
 
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public double getValor() {
        return valor;
    }
    
    public void setValor (double valor) {
        this.valor = valor;
    }
    
    @Override
    public String toString(){
       return (nome + " Valor:R$" + valor);
    }
}
