package com.view.dashboard;

import com.model.database.DBManager;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class Dashboard extends javax.swing.JFrame {
    ConcurrentHashMap<Integer, Registro> previusStates;
    ConcurrentHashMap<Integer, Registro> nextStates;
    
    public DBManager DBManager;
    public PreparedStatement SQLStatement;
    public ResultSet RS;
    
    DefaultTableModel TableModel;
    
    public Dashboard() {
        initComponents();
        
        DBManager = new DBManager();
        TableModel = (DefaultTableModel) jTable1.getModel();
        FillTable();
        
        // Inicializamos los HashMaps
        previusStates = new ConcurrentHashMap<>();
        nextStates = new ConcurrentHashMap<>();
        
        // Evento para la tabla cuando hagamos clic en una fila
        jTable1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                TableClicRow(evt);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        nameTxt = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        phoneLabel = new javax.swing.JLabel();
        phoneTxt = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        addPanel = new javax.swing.JPanel();
        addBtn = new javax.swing.JLabel();
        updPanel = new javax.swing.JPanel();
        udpBtn = new javax.swing.JLabel();
        delPanel = new javax.swing.JPanel();
        delBtn = new javax.swing.JLabel();
        undoPanel = new javax.swing.JPanel();
        undoBtn = new javax.swing.JLabel();
        redoPanel = new javax.swing.JPanel();
        redoBtn = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nameLabel.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        nameLabel.setText("NOMBRE");
        bg.add(nameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        nameTxt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        nameTxt.setBorder(null);
        bg.add(nameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 290, 40));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        bg.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 290, -1));

        phoneLabel.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        phoneLabel.setText("TELÉFONO");
        bg.add(phoneLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        phoneTxt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        phoneTxt.setBorder(null);
        bg.add(phoneTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 290, 40));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        bg.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 290, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Teléfono"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        bg.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, 430, 380));

        addPanel.setBackground(new java.awt.Color(0, 102, 255));

        addBtn.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        addBtn.setForeground(new java.awt.Color(255, 255, 255));
        addBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addBtn.setText("Agregar");
        addBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addBtnMouseExited(evt);
            }
        });

        javax.swing.GroupLayout addPanelLayout = new javax.swing.GroupLayout(addPanel);
        addPanel.setLayout(addPanelLayout);
        addPanelLayout.setHorizontalGroup(
            addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );
        addPanelLayout.setVerticalGroup(
            addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        bg.add(addPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 90, 30));

        updPanel.setBackground(new java.awt.Color(0, 102, 255));

        udpBtn.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        udpBtn.setForeground(new java.awt.Color(255, 255, 255));
        udpBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        udpBtn.setText("Modificar");
        udpBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        udpBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                udpBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                udpBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                udpBtnMouseExited(evt);
            }
        });

        javax.swing.GroupLayout updPanelLayout = new javax.swing.GroupLayout(updPanel);
        updPanel.setLayout(updPanelLayout);
        updPanelLayout.setHorizontalGroup(
            updPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(udpBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );
        updPanelLayout.setVerticalGroup(
            updPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(udpBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        bg.add(updPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, 90, 30));

        delPanel.setBackground(new java.awt.Color(0, 102, 255));

        delBtn.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        delBtn.setForeground(new java.awt.Color(255, 255, 255));
        delBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        delBtn.setText("Eliminar");
        delBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        delBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                delBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                delBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                delBtnMouseExited(evt);
            }
        });

        javax.swing.GroupLayout delPanelLayout = new javax.swing.GroupLayout(delPanel);
        delPanel.setLayout(delPanelLayout);
        delPanelLayout.setHorizontalGroup(
            delPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(delBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );
        delPanelLayout.setVerticalGroup(
            delPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(delBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        bg.add(delPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 320, 90, 30));

        undoPanel.setBackground(new java.awt.Color(204, 204, 204));

        undoBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        undoBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        undoBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lib/images/undo.png"))); // NOI18N
        undoBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        undoBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                undoBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                undoBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                undoBtnMouseExited(evt);
            }
        });

        javax.swing.GroupLayout undoPanelLayout = new javax.swing.GroupLayout(undoPanel);
        undoPanel.setLayout(undoPanelLayout);
        undoPanelLayout.setHorizontalGroup(
            undoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(undoBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );
        undoPanelLayout.setVerticalGroup(
            undoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(undoBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        bg.add(undoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 360, 40, 40));

        redoPanel.setBackground(new java.awt.Color(204, 204, 204));

        redoBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        redoBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        redoBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lib/images/redo.png"))); // NOI18N
        redoBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        redoBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                redoBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                redoBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                redoBtnMouseExited(evt);
            }
        });

        javax.swing.GroupLayout redoPanelLayout = new javax.swing.GroupLayout(redoPanel);
        redoPanel.setLayout(redoPanelLayout);
        redoPanelLayout.setHorizontalGroup(
            redoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(redoBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );
        redoPanelLayout.setVerticalGroup(
            redoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(redoBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        bg.add(redoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 360, 40, 40));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lib/images/logo.png"))); // NOI18N
        bg.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    // BUTTONS HOVER EFFECTS
    private void addBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBtnMouseEntered
        HoverButton(addPanel);
    }//GEN-LAST:event_addBtnMouseEntered

    private void addBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBtnMouseExited
        ResetButton(addPanel);
    }//GEN-LAST:event_addBtnMouseExited

    private void udpBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_udpBtnMouseEntered
        HoverButton(updPanel);
    }//GEN-LAST:event_udpBtnMouseEntered

    private void udpBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_udpBtnMouseExited
        ResetButton(updPanel);
    }//GEN-LAST:event_udpBtnMouseExited

    private void delBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delBtnMouseEntered
        HoverButton(delPanel);
    }//GEN-LAST:event_delBtnMouseEntered

    private void delBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delBtnMouseExited
        ResetButton(delPanel);
    }//GEN-LAST:event_delBtnMouseExited

    private void undoBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_undoBtnMouseEntered
        if (!getPreviusStates().isEmpty())
            HoverButton(undoPanel);
    }//GEN-LAST:event_undoBtnMouseEntered

    private void undoBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_undoBtnMouseExited
        if (!getPreviusStates().isEmpty())
            ResetButton(undoPanel);
    }//GEN-LAST:event_undoBtnMouseExited

    private void redoBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_redoBtnMouseEntered
        if (!getNextStates().isEmpty())
            HoverButton(redoPanel);
    }//GEN-LAST:event_redoBtnMouseEntered

    private void redoBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_redoBtnMouseExited
        if (!getNextStates().isEmpty())
            ResetButton(redoPanel);
    }//GEN-LAST:event_redoBtnMouseExited

    // ADD BUTTON
    private void addBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBtnMouseClicked
        if (nameTxt.getText().isEmpty() || phoneTxt.getText().isEmpty())
            AlertError("No debe dejar campos vacíos");
        else
            InsertPersona(0, nameTxt.getText(), phoneTxt.getText());
    }//GEN-LAST:event_addBtnMouseClicked
    
    // UPDATE BUTTON
    private void udpBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_udpBtnMouseClicked
        if (nameTxt.getText().isEmpty() || phoneTxt.getText().isEmpty())
            AlertError("No debe dejar campos vacíos");
        else {
            // Obtenemos el ID de la fila seleccionada
            int index = jTable1.getSelectedRow();
            
            // Validamos que tenga seleccionado una fila
            if (index < 0) {
                AlertError("Debe seleccionar una fila.");
                return;
            }
            
            int curId = Integer.parseInt(TableModel.getValueAt(index, 0).toString());
            
            UpdatePersona(nameTxt.getText(), phoneTxt.getText(), curId, index);
        }
    }//GEN-LAST:event_udpBtnMouseClicked

    // DELETE BUTTON
    private void delBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delBtnMouseClicked
        // Obtenemos el ID de la fila seleccionada
        int index = jTable1.getSelectedRow();

        // Validamos que tenga seleccionado una fila
        if (index < 0) {
            AlertError("Debe seleccionar una fila.");
            return;
        }

        int curId = Integer.parseInt(TableModel.getValueAt(index, 0).toString());
        
        DeletePersona(curId, index);
    }//GEN-LAST:event_delBtnMouseClicked

    // UNDO BUTTON
    private void undoBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_undoBtnMouseClicked
        System.out.println("---------UNDO----------");
        
        int c = 1;
        for (Registro r:getPreviusStates()) {
            System.out.println(c + " - " + r.action);
            c++;
        }
        
        if (getPreviusStates().isEmpty())
            return;
        
        Registro lastReg = previusStates.get(getPreviusStates().size());
        
        if (lastReg == null)
            return;
        
        Registro oldReg;
        switch(lastReg.action) {
            case "insert":
                // Eliminamos en la DB
                DeletePersonaSQL(lastReg.Id);
                
                // Enviamos el evento de inserción al REDO
                oldReg = new Registro("insert", lastReg.Id, lastReg.Name, lastReg.Phone);
                addNextStates((getNextStates().size() + 1), oldReg);
                
                // Eliminamos el evento anterior del UNDO
                removePreviusStates(getPreviusStates().size());
                break;
            case "update":
                // Actualizamos el registro actual con los datos del state anterior
                Registro lastRegOLD = previusStates.get(getPreviusStates().size() - 1);
                UpdatePersonaSQL(lastReg.Id, lastRegOLD.Name, lastRegOLD.Phone);
                
                // Enviamos dos eventos de actualización al REDO, con el update de datos originales y el actualizado
                oldReg = new Registro("update", lastReg.Id, lastReg.Name, lastReg.Phone);
                addNextStates((getNextStates().size() + 1), lastRegOLD);
                addNextStates((getNextStates().size() + 1), oldReg);
                
                // Eliminamos los dos eventos anteriores del UNDO (tupla update con insert)
                removePreviusStates(getPreviusStates().size());
                removePreviusStates(getPreviusStates().size());
                break;
            case "delete":
                // Insertamos el registro anteriormente eliminado a la DB
                InsertPersonaSQL(lastReg.Id, lastReg.Name, lastReg.Phone);
                
                // Enviamos el evento delete al REDO
                oldReg = new Registro("delete", lastReg.Id, lastReg.Name, lastReg.Phone);
                addNextStates((getNextStates().size() + 1), oldReg);
                
                // Eliminamos el evento anterior del UNDO
                removePreviusStates(getPreviusStates().size());
                break;
            default:
                break;
        }
        
        System.out.println("---------UNDO----------");
        
        c = 1;
        for (Registro r:getPreviusStates()) {
            System.out.println(c + " - " + r.action);
            c++;
        }
        
        // Refrescamos el contenido de la tabla
        ClearTable();
        FillTable();
    }//GEN-LAST:event_undoBtnMouseClicked

    // REDO BUTTON
    private void redoBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_redoBtnMouseClicked
        System.out.println("---------REDO----------");
        
        int c = 1;
        for (Registro r:getNextStates()) {
            System.out.println(c + " - " + r.action);
            c++;
        }
        
        if (getNextStates().isEmpty())
            return;
        
        Registro lastReg = nextStates.get(getNextStates().size());
        
        if (lastReg == null)
            return;
        
        Registro oldReg;
        switch(lastReg.action) {
            case "insert":
                InsertPersonaSQL(lastReg.Id, lastReg.Name, lastReg.Phone);
                
                // Enviamos el evento de inserción al UNDO
                oldReg = new Registro("insert", lastReg.Id, lastReg.Name, lastReg.Phone);
                addPreviusStates((getPreviusStates().size() + 1), oldReg);
                
                // Eliminamos el evento anterior del REDO
                removeNextStates(getNextStates().size());
                break;
            case "update":
                // Actualizamos el registro con los datos del último state
                UpdatePersonaSQL(lastReg.Id, lastReg.Name, lastReg.Phone);
                
                // Enviamos dos eventos de actualización al UNDO, con el update de datos originales y el actualizado
                Registro lastRegOLD = nextStates.get(getNextStates().size() - 1);
                oldReg = new Registro("update", lastReg.Id, lastReg.Name, lastReg.Phone);
                addPreviusStates((getPreviusStates().size() + 1), lastRegOLD);
                addPreviusStates((getPreviusStates().size() + 1), oldReg);
                
                // Eliminamos los dos eventos anteriores del REDO (tupla update con insert)
                removeNextStates(getNextStates().size());
                removeNextStates(getNextStates().size());
                break;
            case "delete":
                // Eliminamos el último registro de la DB
                DeletePersonaSQL(lastReg.Id);
                
                // Enviamos el evento de delete al UNDO
                oldReg = new Registro("delete", lastReg.Id, lastReg.Name, lastReg.Phone);
                addPreviusStates((getPreviusStates().size() + 1), oldReg);
                
                // Eliminamos el evento anterior del REDO
                removeNextStates(getNextStates().size());
                break;
            default:
                break;
        }
        
        System.out.println("---------REDO----------");
        
        c = 1;
        for (Registro r:getNextStates()) {
            System.out.println(c + " - " + r.action);
            c++;
        }
        
        // Refrescamos el contenido de la tabla
        ClearTable();
        FillTable();
    }//GEN-LAST:event_redoBtnMouseClicked
    
    // HOVER EFFECTS
    private void HoverButton(JPanel panel) {
        panel.setBackground(new Color(0,153,255));
    }
    
    private void ResetButton(JPanel panel) {
        panel.setBackground(new Color(0,102,255));
    }
    
    private void DisabledButton(JPanel panel) {
        panel.setBackground(new Color(204,204,204));
    }
    
    // ALERTS
    private void AlertInfo(String msg) {
        javax.swing.JOptionPane.showMessageDialog(this, msg, "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void AlertError(String msg) {
        javax.swing.JOptionPane.showMessageDialog(this, msg, "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
    }
    
    // SQL Methods
    private void InsertPersona(int InsertID, String Name, String Phone) {
        InsertID = InsertPersonaSQL(InsertID, Name, Phone);
            
        if (InsertID == -1) {
            AlertError("Ocurrió un problema al intentar insertar el registro.");
            return;
        }

        TableModel.addRow(new Object [] {InsertID, Name, Phone});
        ClearInputs();

        // Agregamos el registro al Hashmap de previus states
        Registro newReg = new Registro("insert", InsertID, Name, Phone);
        addPreviusStates((getPreviusStates().size() + 1), newReg);
        // Limpiamos el hashmap de eventos posteriores
        ClearNextStates();

        AlertInfo("Registro agregado exitosamente.");    
    }
    
    private int InsertPersonaSQL(int InsertID, String Name, String Phone) {
        
        try {
            int Rows = 0;
            if (InsertID == 0) {
                SQLStatement =  DBManager.getConnection().prepareStatement("INSERT INTO `personas` (`name`, `phone`) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
                SQLStatement.setString(1, Name);
                SQLStatement.setString(2, Phone);
                Rows = SQLStatement.executeUpdate();
                
                // Get Inserted ID
                RS = SQLStatement.getGeneratedKeys();
                if (RS.next()) {
                    InsertID = RS.getInt(1);
                }
            }
            else {
                SQLStatement =  DBManager.getConnection().prepareStatement("INSERT INTO `personas` (`id`, `name`, `phone`) VALUES (?, ?, ?)");
                SQLStatement.setInt(1, InsertID);
                SQLStatement.setString(2, Name);
                SQLStatement.setString(3, Phone);
                Rows = SQLStatement.executeUpdate();
            }
            
            if (Rows == 0)
                InsertID = -1;
            
            DBManager.CloseAll(SQLStatement, RS);            
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return InsertID;
    }
    
    private void UpdatePersona(String Name, String Phone, int curId, int index) {
        try {            
            // Agregamos al hashmap un evento simulando la inserción del registro antes de ser modificado
            SQLStatement =  DBManager.getConnection().prepareStatement("SELECT * FROM `personas` WHERE `id` = ?");
            SQLStatement.setInt(1, curId);
            RS = SQLStatement.executeQuery();
            
            if (RS.next()) {
                Registro newReg = new Registro("insert", RS.getInt("id"), RS.getString("name"), RS.getString("phone"));
                addPreviusStates((getPreviusStates().size() + 1), newReg);
            }
            
            int Rows = UpdatePersonaSQL(curId, Name, Phone);
            
            if (Rows == 0) {
                AlertError("Ocurrió un problema al intentar actualizar el registro.");
                return;
            }
            
            if (index >= 0) {
                TableModel.setValueAt(Name, index, 1);
                TableModel.setValueAt(Phone, index, 2);
            }
            
            // Agregamos el registro al Hashmap de previus states
            Registro newReg = new Registro("update", curId, Name, Phone);
            addPreviusStates((getPreviusStates().size() + 1), newReg);
            // Limpiamos el hashmap de eventos posteriores
            ClearNextStates();
            
            AlertInfo("Registro modificado exitosamente.");
                        
            DBManager.CloseAll(SQLStatement, RS);            
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    
    private int UpdatePersonaSQL(int curId, String Name, String Phone) {
        int Rows = 0;
        
        try {
            SQLStatement =  DBManager.getConnection().prepareStatement("UPDATE `personas` SET `name` = ?, `phone` = ? WHERE `id` = ?");
            SQLStatement.setString(1, Name);
            SQLStatement.setString(2, Phone);
            SQLStatement.setInt(3, curId);
            Rows = SQLStatement.executeUpdate();
            
            DBManager.CloseAll(SQLStatement, RS);            
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return Rows;
    }
    
    private void DeletePersona(int curId, int index) {
        int Rows = DeletePersonaSQL(curId);

        if (Rows == 0) {
            AlertError("Ocurrió un problema al intentar eliminar el registro.");
            return;
        }

        // Agregamos el registro al Hashmap de previus states
        Registro newReg = new Registro("delete", curId, TableModel.getValueAt(index, 1).toString(), TableModel.getValueAt(index, 2).toString());
        addPreviusStates((getPreviusStates().size() + 1), newReg);
        // Limpiamos el hashmap de eventos posteriores
        ClearNextStates();

        if (index >= 0)
            TableModel.removeRow(index);
        ClearInputs();

        AlertInfo("Registro eliminado exitosamente.");

    }
    
    private int DeletePersonaSQL(int curId) {
        int Rows = 0;
        
        try {
            SQLStatement =  DBManager.getConnection().prepareStatement("DELETE FROM `personas` WHERE `id` = ?");
            SQLStatement.setInt(1, curId);
            Rows = SQLStatement.executeUpdate();
            
            DBManager.CloseAll(SQLStatement, RS);            
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return Rows;
    }
    
    // TABLE METHODS
    private void FillTable() {
        try {
            // Rellenamos la tabla
            SQLStatement = DBManager.getConnection().prepareStatement("SELECT * FROM personas");
            RS = SQLStatement.executeQuery();
            
            Object [] fila = new Object[3];
            while (RS.next())
            {
                for (int i = 1; i <= fila.length; i++)
                    fila[i - 1] = RS.getObject(i);
               
                TableModel.addRow(fila);
            }
            
            DBManager.CloseAll(SQLStatement, RS);
            
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void ClearTable() {
        while (TableModel.getRowCount() > 0)
            TableModel.removeRow(0);
    }
    
    private void TableClicRow(MouseEvent evt){
        int index = jTable1.getSelectedRow();
        
        nameTxt.setText(TableModel.getValueAt(index, 1).toString());
        phoneTxt.setText(TableModel.getValueAt(index, 2).toString());
    }
    
    // INPUT METHODS
    private void ClearInputs() {
        nameTxt.setText("");
        phoneTxt.setText("");
        
        nameTxt.requestFocus();
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }
    
    // HASHMAPS METHODS
    public Collection<Registro> getPreviusStates() {
        return previusStates.values();
    }
    
    public Collection<Registro> getNextStates() {
        return nextStates.values();
    }
    
    public boolean addPreviusStates(int ID, Registro reg) {
        Registro put = previusStates.put(ID, reg);
        ResetButton(undoPanel);
        return (put != null);
    }
    
    public void removePreviusStates(int key) {
        previusStates.remove(key);
        
        if (getPreviusStates().isEmpty())
            DisabledButton(undoPanel);
    }
    
    public boolean addNextStates(int ID, Registro reg) {
        Registro put = nextStates.put(ID, reg);
        ResetButton(redoPanel);
        return (put != null);
    }
    
    public void removeNextStates(int key) {
        nextStates.remove(key);
        
        if (getNextStates().isEmpty())
            DisabledButton(redoPanel);
    }
    
    public void ClearNextStates() {
        nextStates.clear();
        DisabledButton(redoPanel);
    }
    
    public class Registro {
        String action; // insert, update, delete
        int Id;
        String Name;
        String Phone;
        
        public Registro(String action, int Id, String Name, String Phone) {
            this.action = action;
            this.Id = Id;
            this.Name = Name;
            this.Phone = Phone;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addBtn;
    private javax.swing.JPanel addPanel;
    private javax.swing.JPanel bg;
    private javax.swing.JLabel delBtn;
    private javax.swing.JPanel delPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTxt;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JTextField phoneTxt;
    private javax.swing.JLabel redoBtn;
    private javax.swing.JPanel redoPanel;
    private javax.swing.JLabel udpBtn;
    private javax.swing.JLabel undoBtn;
    private javax.swing.JPanel undoPanel;
    private javax.swing.JPanel updPanel;
    // End of variables declaration//GEN-END:variables
}
