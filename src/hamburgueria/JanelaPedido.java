
package hamburgueria;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class JanelaPedido extends JFrame{
    
    private final List<Pedidos> pedidos = new ArrayList<>();    
    private final JButton btncriaPedido = new JButton("Cria Pedido");
    private final JButton btneditaPedido = new JButton("Edita Pedido");
    private final JButton btnexcluiPedido = new JButton("Exclui Pedido");
    private final JButton btnadicionaItem = new JButton("Adiciona Item");
    private final JButton btnadicionaMesa = new JButton("Adiciona mesa");
    private final JButton btnexcluiMesa = new JButton("Exclui mesa");
    private final JButton btnNota = new JButton("Exibir Detalhamento");
    private final JLabel lblMesa = new JLabel("Mesas");
    private final JLabel lblInicio = new JLabel("Horario de abertura");
    private final JLabel lblFim = new JLabel("Horario de fechamento");
    private final JLabel lblStatus = new JLabel("Status");
    private final JTextField txtInicio = new JTextField();
    private final JTextField txtFim = new JTextField();
    private final JCheckBox boxStatus = new JCheckBox("Aberto");
    private final JCheckBox boxStatus2 = new JCheckBox("Fechado");
    private final JList<Pedidos> lstPedidos = new JList<>(new DefaultListModel<>());
    private final JList lstMesa = new JList();
    DefaultListModel modelo = new DefaultListModel();
    
    
    
    
    
    
    
   
    public JanelaPedido() throws HeadlessException  {
        super("Hamburgueria Sjn");
        
        
        lstMesa.setModel(modelo);
        lstPedidos.setModel(new PedidoListModel(pedidos));
        lstMesa.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lstPedidos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        
        modelo.addElement("1");
        modelo.addElement("2");
        modelo.addElement("3");
        modelo.addElement("4");
        modelo.addElement("5");
        modelo.addElement("6");
        modelo.addElement("7");
        modelo.addElement("8");
        modelo.addElement("9");
        modelo.addElement("10");
        modelo.addElement("11");
        modelo.addElement("12");
        modelo.addElement("13");
        modelo.addElement("14");
         
        
       
        JPanel mesas = new JPanel(new GridBagLayout());
        
        
        JPanel botoes = new JPanel(new GridLayout(4,2));
        JPanel dados = new JPanel(new GridLayout(14,2));
        
        add(botoes,BorderLayout.SOUTH);
        btnadicionaItem.setEnabled(false);
        btneditaPedido.setEnabled(false);
        btnexcluiPedido.setEnabled(false);
        btncriaPedido.setEnabled(false);
        btnNota.setEnabled(false);
        
        botoes.add(btncriaPedido);
        botoes.add(btnadicionaItem);
        botoes.add(btneditaPedido);
        botoes.add(btnexcluiPedido);
        botoes.add(btnNota);
        
        add(dados,BorderLayout.CENTER);
        
        dados.add(lblStatus);
        dados.add(boxStatus);
        boxStatus.setSelected(true);
        boxStatus2.setEnabled(false);
        dados.add(boxStatus2);
        dados.add(lblInicio);
        dados.add(txtInicio);
        dados.add(lblFim);
        dados.add(txtFim);
        
        add(mesas,BorderLayout.WEST);
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        mesas.setLayout(gbl);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.ipadx = 10; //espaçamento horizontal
        gbc.ipady = 10; //espaçamento vertical
       
        gbc.gridx = 0; //posição
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE; // não será preechido 
        
        mesas.add(lblMesa);
        gbl.setConstraints(lblMesa, gbc);
        gbc.gridy = 1;
        
        JScrollPane scroll = new JScrollPane(lstMesa);
        mesas.add(scroll);
        gbc.ipadx = 100;
        gbc.ipady = 380;
        gbl.setConstraints(scroll, gbc);
       
        gbc.ipadx = 10;
        gbc.ipady = 10;
        gbc.gridy = 2;
        
        mesas.add(btnadicionaMesa);
        gbl.setConstraints(btnadicionaMesa, gbc);
        gbc.gridy = 3;
        
        mesas.add(btnexcluiMesa);
        gbl.setConstraints(btnexcluiMesa, gbc);
        gbc.gridy = 4;
        
        
        
        add(new JScrollPane(lstPedidos),BorderLayout.EAST);
        
        lstMesa.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(!lstMesa.isSelectionEmpty()){
                    btncriaPedido.setEnabled(true);
                    txtInicio.setText("");
                    txtFim.setText("");
                    boxStatus.setEnabled(true);
                    boxStatus2.setEnabled(false);
                    boxStatus.setSelected(true);
                    
                }
               }            
        });
        
        btncriaPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
              try{
                  int mesa = Integer.parseInt(lstMesa.getSelectedValue().toString());
                  SimpleDateFormat s = new SimpleDateFormat("HH:mm");
                  Date data = new Date();
                  Date termino = new Date();
                  s.format(data);
                  s.format(termino);
                  s.setLenient(false);
                  if(txtFim.getText().equals("")){
                      termino = null;
                  }
                  Pedidos p = new Pedidos(mesa, s.parse(txtInicio.getText()));
                  pedidos.add(p);
                  
                  lstMesa.clearSelection();
                  
                  
                  txtInicio.setText("");
                  txtFim.setText("");
                  btncriaPedido.setEnabled(false);
                  lstPedidos.updateUI();
                  
              }catch (NumberFormatException | ParseException ex  ) {
                  JOptionPane.showMessageDialog(null, "Não foi possível criar o pedido. Favor verificar se todos os campos foram corretamente preechidos.");
              }
            }
        });
        
        btnadicionaItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pedidos p = pedidos.get(lstPedidos.getSelectedIndex());
                List<Item> i = getSampleData();
                JanelaItem janela = new JanelaItem(p,i);
                if(lstPedidos.isSelectionEmpty()){
                    JOptionPane.showMessageDialog(null,"Por favor selecione algum pedido em aberto");
                }
                else if(lstPedidos.getSelectedValue().getStatus() == false){
                    JOptionPane.showMessageDialog(null,"Não é possivel adicionar novos itens,este pedido ja foi fechado");
                    return;
                }
                else
                    
                    janela.setSize(500, 500);
                    janela.setLocationRelativeTo(null);
                    
                    janela.setVisible(true);
                    
            }
        });
        
        btnexcluiPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(lstPedidos.isSelectionEmpty())
                    return;
                pedidos.remove(lstPedidos.getSelectedValue());
                lstPedidos.updateUI();
                btnexcluiPedido.setEnabled(false);
                btneditaPedido.setEnabled(false);
                btnadicionaItem.setEnabled(false);
                btncriaPedido.setEnabled(false);
               
                lstMesa.clearSelection();
            }
        });
        
        btneditaPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (lstPedidos.isSelectionEmpty()) {
                    return;
                }
                Pedidos p = pedidos.get(lstPedidos.getSelectedIndex());
                if (p.getStatus()) { //verifica se o status está Aberto
                    
                    Date data = new Date();
                    Date termino = new Date();
                    SimpleDateFormat s = new SimpleDateFormat("HH:mm");
                    s.format(data);
                    s.format(termino);
                    
                    s.setLenient(false);
                    try {
                        p.setData(s.parse(txtInicio.getText()));
                        p.setTermino(s.parse(txtFim.getText()));
                    } catch (ParseException ex) { //caso a hora de termino não seja inserida não deixa fechar o pedido
                        JOptionPane.showMessageDialog(null, "Nenhuma data de termino foi inserida\n Por favor insira o horário de termino caso deseje fechar o pedido");
                        boxStatus2.setSelected(false);
                    }
                    

                    if (boxStatus2.isSelected()) { //se estiver marcado fechado, altera para false o status do pedido
                        p.setStatus(false);
                        boxStatus.setEnabled(false);
                        boxStatus2.setEnabled(false);
                    }

                    lstMesa.clearSelection();
                    txtInicio.setText("");
                    txtFim.setText("");
                    
                    lstPedidos.updateUI();

                    
                } else {
                    lstMesa.clearSelection(); //se o pedido estiver fechado, mostra mensagem de erro
                    boxStatus.setEnabled(false);
                    boxStatus2.setEnabled(false);
                    txtInicio.setText("");
                    txtFim.setText("");
                    JOptionPane.showMessageDialog(null, "O pedido está fechado, não pode ser editado");
                }
                    btnexcluiPedido.setEnabled(false);
                    btneditaPedido.setEnabled(false);
                    btnadicionaItem.setEnabled(false);
                    btncriaPedido.setEnabled(false);
                    lstMesa.clearSelection();
                    
                    
                    
                    
                    
            }
        });
        
         lstPedidos.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Pedidos selecionada = lstPedidos.getSelectedValue();
                
                if (selecionada != null) {
                    int i = 0;
                    btnexcluiPedido.setEnabled(true);
                    btneditaPedido.setEnabled(true);
                    btnadicionaItem.setEnabled(true);
                    btnNota.setEnabled(true);
                    boxStatus.setEnabled(true);
                    boxStatus2.setEnabled(true);
                    lstMesa.setSelectedIndex(i);
                    while(selecionada.getMesa() != Integer.parseInt(lstMesa.getSelectedValue().toString()) ){
                        if(i <= lstMesa.getLastVisibleIndex()){
                            lstMesa.setSelectedIndex(i);
                            i++;
                        }
                        else{
                            lstMesa.clearSelection();
                            break;
                        }
                    
                    }
                    if (selecionada.getStatus()) { //Organiza os checkbox de status de acordo com o pedido
                        boxStatus.setSelected(true);
                        boxStatus2.setEnabled(true);
                        
                    } else { 
                        boxStatus2.setSelected(true);
                        boxStatus.setEnabled(false);//Desativa os checkbox pois o pedido ja terminou
                        boxStatus2.setEnabled(false);
                    }
                   
                    SimpleDateFormat s = new SimpleDateFormat("HH:mm");

                    s.setLenient(false);
                    txtInicio.setText(s.format(selecionada.getData()));
                    if(selecionada.getTermino() != null)
                    txtFim.setText(s.format(selecionada.getTermino()));
                    else
                    txtFim.setText("");
                } else {
                    lstPedidos.setModel(new DefaultListModel<>());
                }
            }
        });
         
        btnadicionaMesa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelo.addElement(lstMesa.getLastVisibleIndex() + 2); //mais dois pois o index conta o primeiro elemento como 0
                lstMesa.clearSelection();
                
            }
        });
        
        btnexcluiMesa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelo.removeElementAt(lstMesa.getLastVisibleIndex());
                lstMesa.clearSelection();
            }
        });
         
        btnNota.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pedidos p = pedidos.get(lstPedidos.getSelectedIndex()); //usado para pegar o pedido que esta selecionado
                if(!p.getItens().isEmpty()){
                JanelaNota janela = new JanelaNota(p);
                janela.setSize(500, 500);
                janela.setLocationRelativeTo(null);
                janela.setVisible(true);
                }else
                    JOptionPane.showMessageDialog(null, "Ainda não foi adicionado nenhum item ao pedido");
            }
            
            
        });
        
        boxStatus.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(boxStatus.isSelected()){
                    boxStatus2.setSelected(false);
                }
                else
                    boxStatus2.setSelected(true);
            }
        });
        
        boxStatus2.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(boxStatus2.isSelected()){
                    boxStatus.setSelected(false);
                }
                else
                    boxStatus.setSelected(true);
            }
        });
        
        
            
        
        
               
        
        
        
    }
    private static List<Item> getSampleData(){
        List<Item> item;
        item = new ArrayList<Item>(){
            {
                add(new Item("Hamburguer", 2.99));
                add(new Item("Coca", 3.00));
                add(new Item("X-Tudo", 19.30));
            }
        };
        return item;
    }
}
