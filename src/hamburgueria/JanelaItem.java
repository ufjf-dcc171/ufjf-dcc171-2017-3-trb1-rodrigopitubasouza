package hamburgueria;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class JanelaItem extends JFrame{
    
private final List<Item> itens;
private Pedidos pedido = new Pedidos();
private final JButton btnAdiciona = new JButton("Adicionar Item");
private final JButton btnExcluir = new JButton("Excluir Item");
private final JButton btnAddPedido = new JButton("Adicionar ao Pedido");
private final JTextField txtItem = new JTextField("");
private final JTextField txtValor = new JTextField("");
private final JLabel lblItem = new JLabel("Nome do novo item");
private final JLabel lblValor = new JLabel("Valor do item");
private final JList<Item> lstItens = new JList<>(new DefaultListModel<>());



public JanelaItem(Pedidos p,List<Item> i) throws HeadlessException {
        super("Itens");
        pedido = p;
        itens = i;
        lstItens.setModel(new ItemListModel(itens));
        lstItens.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
       
        JPanel botoes = new JPanel(new GridLayout(4, 2));
        JPanel dadosnovos = new JPanel(new GridLayout(14, 2));
        JPanel adicionar = new JPanel(new GridLayout(14,2));

       
        add(dadosnovos, BorderLayout.WEST);
        dadosnovos.add(lblItem);
        dadosnovos.add(txtItem);
        dadosnovos.add(lblValor);
        dadosnovos.add(txtValor);
        dadosnovos.add(btnAdiciona);
        dadosnovos.add(btnExcluir);
        add(new JScrollPane(lstItens),BorderLayout.CENTER);
        add(adicionar, BorderLayout.EAST);
        adicionar.add(btnAddPedido);
        
        
        
        
        btnAdiciona.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome;
                double valor;
                
                nome = txtItem.getText();
                
                valor = Double.parseDouble(txtValor.getText());
                Item i = new Item(nome,valor);
                itens.add(i);
                lstItens.updateUI();
                
            }
        });
        
        btnExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(lstItens.isSelectionEmpty())
                    return;
                itens.remove(lstItens.getSelectedValue());
                lstItens.updateUI();                             
            }
        });
        
        btnAddPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Item i = lstItens.getSelectedValue();
                pedido.setItens(i);
                JOptionPane.showMessageDialog(null, "Foi adicionado o item " +i.getNome() + " a mesa: " + pedido.getMesa());
                
            }
            
        });
        
        
        
        
}

    
    
    
}