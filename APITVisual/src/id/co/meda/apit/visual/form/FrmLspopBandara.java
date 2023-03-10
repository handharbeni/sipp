/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.visual.form;

import id.co.meda.apit.visual.controller.ControlLspopBandara;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import java.util.EventObject;
import java.util.List;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author PT. Databumi Indonesia
 */
public class FrmLspopBandara extends javax.swing.JDialog {

    private ControlLspopBandara control = new ControlLspopBandara();
    private String nop = "";
    /**
     * Creates new form FrmLspopBandara
     */
    public FrmLspopBandara(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        isiTableBng();
        this.btnTambahBng.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNop = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableBng = new javax.swing.JTable();
        btnTambahBng = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        try {
            txtNop.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.##.###.###.###-####.#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtNop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNopActionPerformed(evt);
            }
        });
        txtNop.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNopKeyPressed(evt);
            }
        });

        jLabel1.setText("NOP");

        tableBng.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableBng);

        btnTambahBng.setText("Tambah Data Bangunan");
        btnTambahBng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahBngActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNop, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnTambahBng)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTambahBng)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNopActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNopActionPerformed

    private void txtNopKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNopKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String tmpNop = txtNop.getText().replace(".", "").replace("-", "");
                if (control.cekNOP(tmpNop)) {
                    
                    this.nop = tmpNop;
                    isiTableBng();
                    this.btnTambahBng.setEnabled(true);
                } 
        }
    }//GEN-LAST:event_txtNopKeyPressed
 
    public void isiTableBng()
    {
        this.tableBng.setModel(control.getModelBng(nop));
        this.tableBng.setRowHeight(35);
        

        TableColumn columnEdit = tableBng.getColumnModel().getColumn(3);
        columnEdit.setCellRenderer(new ButtonsRenderer());
        columnEdit.setCellEditor(new ButtonsEditor(tableBng));

        TableColumn columnDelete = tableBng.getColumnModel().getColumn(4);
        columnDelete.setCellRenderer(new ButtonsRendererDelete());
        columnDelete.setCellEditor(new ButtonsEditorDelete(this.tableBng));

    }
    
    public void editTrigger(int id)
    {
        
        FrmIsiLspopBandara isiLspop = new FrmIsiLspopBandara(new JFrame(),true,true,id,nop);
        isiLspop.setVisible(true);
        isiLspop.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosed(WindowEvent e)
            {
                isiTableBng();
            }
        });
    }
    
    public void deleteTrigger(int id)
    {
        int reply = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus data ini ?",
                    "Konfirmasi Penghapusan Data", JOptionPane.YES_NO_OPTION);
        
        if(reply == JOptionPane.YES_OPTION)
        {
            control.delete(id, nop);
            isiTableBng();
        }
        
    }




 //...............UNTUK RENDER BUTTON TABLE......................//
    
  //-----------untuk edit---------------//  
    
  class ButtonsPanelEdit extends JPanel {
    public final List<JButton> buttons = Arrays.asList(new JButton("Edit"));
    public ButtonsPanelEdit() {
        super();
        setOpaque(false);
        for(JButton b: buttons) {
            b.setFocusable(false);
            b.setRolloverEnabled(false);
            add(b);
        }
    }
//     @Override public void updateUI() {
//         super.updateUI();
//     }
}
    
class ButtonsRenderer extends ButtonsPanelEdit implements TableCellRenderer {
    public ButtonsRenderer() {
        super();
        setName("Table.cellRenderer");
    }
    @Override public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        this.setBackground(isSelected?table.getSelectionBackground():table.getBackground());
        return this;
    }
}
class ButtonsEditor extends ButtonsPanelEdit implements TableCellEditor {
    transient protected ChangeEvent changeEvent = null;

    public ButtonsEditor(final JTable table) {
        super();
        //---->
        //DEBUG: view button click -> control key down + edit button(same cell) press -> remain selection color
        MouseListener ml = new MouseAdapter() {
            @Override public void mousePressed(MouseEvent e) {
                ButtonModel m = ((JButton)e.getSource()).getModel();
                if(m.isPressed() && table.isRowSelected(table.getEditingRow()) && e.isControlDown()) {
                    setBackground(table.getBackground());
                }
            }
        };
        buttons.get(0).addMouseListener(ml);
        //<----

        buttons.get(0).addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                int row = table.convertRowIndexToModel(table.getEditingRow());
                Object o = table.getModel().getValueAt(row, 0);
              
                editTrigger(Integer.parseInt(o.toString()));
                fireEditingStopped();
            }

        });

        addMouseListener(new MouseAdapter() {
            @Override public void mousePressed(MouseEvent e) {
                fireEditingStopped();
            }
        });
    }
    @Override public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.setBackground(table.getSelectionBackground());
        return this;
    }
    @Override public Object getCellEditorValue() {
        return "";
    }

    //Copid from AbstractCellEditor
    //protected EventListenerList listenerList = new EventListenerList();
    //transient protected ChangeEvent changeEvent = null;
    @Override public boolean isCellEditable(EventObject e) {
        return true;
    }
    @Override public boolean shouldSelectCell(EventObject anEvent) {
        return true;
    }
    @Override public boolean stopCellEditing() {
        fireEditingStopped();
        return true;
    }
    @Override public void cancelCellEditing() {
        fireEditingCanceled();
    }
    @Override public void addCellEditorListener(CellEditorListener l) {
        listenerList.add(CellEditorListener.class, l);
    }
    @Override public void removeCellEditorListener(CellEditorListener l) {
        listenerList.remove(CellEditorListener.class, l);
    }
    public CellEditorListener[] getCellEditorListeners() {
        return listenerList.getListeners(CellEditorListener.class);
    }
    protected void fireEditingStopped() {
        // Guaranteed to return a non-null array
        Object[] listeners = listenerList.getListenerList();
        // Process the listeners last to first, notifying
        // those that are interested in this event
        for(int i = listeners.length-2; i>=0; i-=2) {
            if(listeners[i]==CellEditorListener.class) {
                // Lazily create the event:
                if(changeEvent == null) {
                    changeEvent = new ChangeEvent(this);
                }
                ((CellEditorListener)listeners[i+1]).editingStopped(changeEvent);
            }
        }
    }
    protected void fireEditingCanceled() {
        // Guaranteed to return a non-null array
        Object[] listeners = listenerList.getListenerList();
        // Process the listeners last to first, notifying
        // those that are interested in this event
        for(int i = listeners.length-2; i>=0; i-=2) {
            if(listeners[i]==CellEditorListener.class) {
                // Lazily create the event:
                if(changeEvent == null) {
                    changeEvent = new ChangeEvent(this);
                }
                ((CellEditorListener)listeners[i+1]).editingCanceled(changeEvent);
            }
        }
    }
}    
  
 //------------------------------------------------------//  
    
//-----------untuk dekete---------------//  
    
  class ButtonsPanelDelete extends JPanel {
    public final List<JButton> buttons = Arrays.asList(new JButton("Delete"));
    public ButtonsPanelDelete() {
        super();
        setOpaque(false);
        for(JButton b: buttons) {
            b.setFocusable(false);
            b.setRolloverEnabled(false);
            add(b);
        }
    }
//     @Override public void updateUI() {
//         super.updateUI();
//     }
}
    
class ButtonsRendererDelete extends ButtonsPanelDelete implements TableCellRenderer {
    public ButtonsRendererDelete() {
        super();
        setName("Table.cellRenderer");
    }
    @Override public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        this.setBackground(isSelected?table.getSelectionBackground():table.getBackground());
        return this;
    }
}
class ButtonsEditorDelete extends ButtonsPanelDelete implements TableCellEditor {
    transient protected ChangeEvent changeEvent = null;

    public ButtonsEditorDelete(final JTable table) {
        super();
        //---->
        //DEBUG: view button click -> control key down + edit button(same cell) press -> remain selection color
        MouseListener ml = new MouseAdapter() {
            @Override public void mousePressed(MouseEvent e) {
                ButtonModel m = ((JButton)e.getSource()).getModel();
                if(m.isPressed() && table.isRowSelected(table.getEditingRow()) && e.isControlDown()) {
                    setBackground(table.getBackground());
                }
            }
        };
        buttons.get(0).addMouseListener(ml);
        //<----

        buttons.get(0).addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                int row = table.convertRowIndexToModel(table.getEditingRow());
                Object o = table.getModel().getValueAt(row, 0);
                
                   deleteTrigger(Integer.parseInt(o.toString()));
                
                //manggil Spop sesuai Nop yang dipilih dan kode editnya (ingat: 1 edit, 2 hapus)
               fireEditingStopped();
            }

        });

        addMouseListener(new MouseAdapter() {
            @Override public void mousePressed(MouseEvent e) {
                fireEditingStopped();
            }
        });
    }
    @Override public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.setBackground(table.getSelectionBackground());
        return this;
    }
    @Override public Object getCellEditorValue() {
        return "";
    }

    //Copid from AbstractCellEditor
    //protected EventListenerList listenerList = new EventListenerList();
    //transient protected ChangeEvent changeEvent = null;
    @Override public boolean isCellEditable(EventObject e) {
        return true;
    }
    @Override public boolean shouldSelectCell(EventObject anEvent) {
        return true;
    }
    @Override public boolean stopCellEditing() {
        fireEditingStopped();
        return true;
    }
    @Override public void cancelCellEditing() {
        fireEditingCanceled();
    }
    @Override public void addCellEditorListener(CellEditorListener l) {
        listenerList.add(CellEditorListener.class, l);
    }
    @Override public void removeCellEditorListener(CellEditorListener l) {
        listenerList.remove(CellEditorListener.class, l);
    }
    public CellEditorListener[] getCellEditorListeners() {
        return listenerList.getListeners(CellEditorListener.class);
    }
    protected void fireEditingStopped() {
        // Guaranteed to return a non-null array
        Object[] listeners = listenerList.getListenerList();
        // Process the listeners last to first, notifying
        // those that are interested in this event
        for(int i = listeners.length-2; i>=0; i-=2) {
            if(listeners[i]==CellEditorListener.class) {
                // Lazily create the event:
                if(changeEvent == null) {
                    changeEvent = new ChangeEvent(this);
                }
                ((CellEditorListener)listeners[i+1]).editingStopped(changeEvent);
            }
        }
    }
    protected void fireEditingCanceled() {
        // Guaranteed to return a non-null array
        Object[] listeners = listenerList.getListenerList();
        // Process the listeners last to first, notifying
        // those that are interested in this event
        for(int i = listeners.length-2; i>=0; i-=2) {
            if(listeners[i]==CellEditorListener.class) {
                // Lazily create the event:
                if(changeEvent == null) {
                    changeEvent = new ChangeEvent(this);
                }
                ((CellEditorListener)listeners[i+1]).editingCanceled(changeEvent);
            }
        }
    }
}    
  
    private void btnTambahBngActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahBngActionPerformed
        // TODO add your handling code here:
        int id = this.tableBng.getRowCount()+1;
      
       
        FrmIsiLspopBandara isiLspop = new FrmIsiLspopBandara(new JFrame(),true,false,id,nop);
        isiLspop.setVisible(true);
        isiLspop.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosed(WindowEvent e)
            {
                isiTableBng();
            }
        });
        
    }//GEN-LAST:event_btnTambahBngActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTambahBng;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableBng;
    private javax.swing.JFormattedTextField txtNop;
    // End of variables declaration//GEN-END:variables
}
