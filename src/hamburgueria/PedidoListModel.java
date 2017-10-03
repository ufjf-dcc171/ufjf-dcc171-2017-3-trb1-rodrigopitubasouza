package hamburgueria;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

public class PedidoListModel implements ListModel {
    private final List<Pedidos> pedidos;
    private final List<ListDataListener> dataLinisters;

    public PedidoListModel(List<Pedidos> pedidos) {
        this.pedidos = pedidos;
        this.dataLinisters = new ArrayList();
    }

    public int getSize() {
        return pedidos.size();
    }

    public Pedidos getElementAt(int index) {
        return pedidos.get(index);
    }

    public void addListDataListener(ListDataListener l) {
        this.dataLinisters.add(l);
    }

    public void removeListDataListener(ListDataListener l) {
        this.dataLinisters.remove(l);
    }
}