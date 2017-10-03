package hamburgueria;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

class Pedidos {
    
   private int mesa;    
   private Date data;
   private Date termino;
   private boolean status;
   private List<Item> itens;
    
    public Pedidos () {
        
    }  
    
    public Pedidos (int mesa, Date data) {
        this.mesa = mesa;
        this.data = data;        
        this.status = true;
        this.termino = null;
        itens = new ArrayList<>();
    }   

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(Item item) {
       itens.add(item);
    }
    
    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }
    
   

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    public Date getTermino() {
        return termino;
    }

    public void setTermino(Date termino) {
        this.termino = termino;
    }   
    
    
    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
   

    @Override
    public String toString() {
        String s; // Por ser boolean iria aparecer true ou false se usasse status
        if (status) {
            s = "Aberto";
        } else {
            s = "Fechado";
        }
        
        String horaTermino = "";
        if (termino != null){
            horaTermino = termino.getHours()+":"+termino.getMinutes();
        }
        else{
            horaTermino = " Pedido aberto";
        }
        return "Pedido{"+ "mesa= " + mesa + ", status= " + s + ", abertura= " + data.getHours() + ":" + data.getMinutes() + " término= " + horaTermino + '}';
    }

    
    
}