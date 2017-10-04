package hamburgueria;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;


public class JanelaNota extends JFrame {
private Pedidos pedido = new Pedidos();
private final JButton btnExcluirItem = new JButton("Excluir Item do Pedido");
private final JList<Item> lstItens = new JList<>(new DefaultListModel<>());
private final JLabel lblValorTotal = new JLabel("Valor Final: ");
private double valorFinal = 0;
    public JanelaNota(Pedidos p) throws HeadlessException{
        super("Detalhamento do Pedido");
        
        pedido = p;
        
        if(pedido.getItens() != null){
        for(Item i : pedido.getItens()){
            
            valorFinal += i.getValor();
        }
        }
        
        
        lblValorTotal.setText(lblValorTotal.getText() + valorFinal);
        lstItens.setModel(new ItemListModel(pedido.getItens()));
        lstItens.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(lstItens), BorderLayout.CENTER);
        add(lblValorTotal,BorderLayout.SOUTH);
        add(btnExcluirItem,BorderLayout.EAST);
        
        btnExcluirItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(lstItens.isSelectionEmpty())
                    return;
                valorFinal = valorFinal - lstItens.getSelectedValue().getValor();
                pedido.getItens().remove(lstItens.getSelectedValue());
                lblValorTotal.setText("Valor Final: " + valorFinal);
                lstItens.updateUI();
            }
        });
    }

    
    
}
