
package com.pkgmain.fornecedores.view.dashboard.screens;


import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import utils.Conexao;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;


public class Vendas extends javax.swing.JFrame {
    
    private Conexao conexao;
    private MongoCollection colecao;
    private MongoCursor cursor;
   
    public Vendas() {
        initComponents();
        this.conexao = new Conexao();
        this.colecao = conexao.getbanco().getCollection("vendas");
        this.cursor = colecao.find().iterator();
        ShowProdutos();
    }
    
    private void ShowProdutos(){
         DefaultTableModel modelo = (DefaultTableModel) ProdutoLista.getModel();
         FindIterable<Document> documentos = colecao.find();
         ArrayList<Document> documentosList = new ArrayList<>();
         modelo.setNumRows(0);
         
        try{
           for(Document documento : documentos)
               documentosList.add(documento);
            
            Object[][] data = new Object[documentosList.size()][];
            for (int i = 0; i < documentosList.size(); i++){
                var documento = documentosList.get(i);
                Object[] row = new Object[documento.size()];
                int j = 0;
                for(String key: documento.keySet()) {
                    row[j] = documento.get(key);
                    j++;
                }
                data[i] = row;
                modelo.addRow(row);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            cursor.close();
        }
    }
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        PrNome = new javax.swing.JTextField();
        Preço = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ProdutoLista = new javax.swing.JTable();
        DeletarBtn = new javax.swing.JButton();
        AddBtn = new javax.swing.JButton();
        EditBtn = new javax.swing.JButton();
        PrCat = new javax.swing.JComboBox<>();
        Quantidade = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gerenciamento das Vendas");

        PrNome.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        PrNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrNomeActionPerformed(evt);
            }
        });

        Preço.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        Preço.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreçoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nome");

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Preço");

        ProdutoLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Categoria", "Preço", "Quantidade"
            }
        ));
        ProdutoLista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProdutoListaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ProdutoLista);

        DeletarBtn.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        DeletarBtn.setForeground(new java.awt.Color(0, 51, 51));
        DeletarBtn.setText("Deletar");
        DeletarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeletarBtnActionPerformed(evt);
            }
        });

        AddBtn.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        AddBtn.setForeground(new java.awt.Color(0, 51, 51));
        AddBtn.setText("Adicionar");
        AddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBtnActionPerformed(evt);
            }
        });

        EditBtn.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        EditBtn.setForeground(new java.awt.Color(0, 51, 51));
        EditBtn.setText("Editar");
        EditBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditBtnActionPerformed(evt);
            }
        });

        PrCat.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        PrCat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bebidas", "Lanches", " ", " " }));
        PrCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrCatActionPerformed(evt);
            }
        });

        Quantidade.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        Quantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuantidadeActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Quantidade");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PrNome, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addComponent(PrCat, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Preço, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(62, 62, 62)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(Quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 857, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(289, 289, 289)
                        .addComponent(DeletarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(107, 107, 107)
                        .addComponent(AddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(111, 111, 111)
                        .addComponent(EditBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(383, 383, 383)
                        .addComponent(jLabel1)))
                .addContainerGap(150, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DeletarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EditBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PrCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PrNome, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Preço, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PrNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PrNomeActionPerformed

    private void PreçoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreçoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PreçoActionPerformed
    
    int Chave = 0;
    private void ProdutoListaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProdutoListaMouseClicked
            DefaultTableModel modelo = (DefaultTableModel) ProdutoLista.getModel();
            int MeuIndex = ProdutoLista.getSelectedRow();
//            Chave = Integer.valueOf(modelo.getValueAt(MeuIndex, 0).toString());
            PrNome.setText((String) modelo.getValueAt(MeuIndex, 1).toString());
//            PrCat.setText(modelo.getValueAt(MeuIndex, 2).toString());
            Preço.setText(modelo.getValueAt(MeuIndex, 3).toString());
            
    }//GEN-LAST:event_ProdutoListaMouseClicked

    private void DeletarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeletarBtnActionPerformed
        if(PrNome.getText().isEmpty() || Preço.getText().isEmpty() || PrCat.getSelectedIndex() == -1)
        {
            JOptionPane.showMessageDialog(this, "Faltando informações !!");
        }else {
            DefaultTableModel modelo = (DefaultTableModel) ProdutoLista.getModel();
            try {
               int linhaSelecionada = ProdutoLista.getSelectedRow();
               String id = modelo.getValueAt(linhaSelecionada, 0).toString();
               
               Document query =  new Document("_id", new ObjectId(id));
               
               colecao.deleteOne(query);
               JOptionPane.showMessageDialog(this, "Deletado com sucesso!!!");
               ShowProdutos();
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex);
            }
        }
    }//GEN-LAST:event_DeletarBtnActionPerformed

    private void AddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBtnActionPerformed
        if(PrNome.getText().isEmpty() || Preço.getText().isEmpty() || PrCat.getSelectedIndex() == -1)
        {
            JOptionPane.showMessageDialog(this, "Faltando informações !!");
        }else {
            Document produtos = new Document();
            produtos.append("Nome", PrNome.getText())
                    .append("Categoria", PrCat.getSelectedItem().toString())
                    .append("Preço", Preço.getText())
                    .append("Quantidade", Quantidade.getText());
            try {
                colecao.insertOne(produtos);
                JOptionPane.showMessageDialog(this, "Produtos cadastrados com sucesso !!!");
                ShowProdutos();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex);
            }
        }
    }//GEN-LAST:event_AddBtnActionPerformed

    private void EditBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditBtnActionPerformed
        if(PrNome.getText().isEmpty() || Preço.getText().isEmpty() || PrCat.getSelectedIndex() == -1)
        {
            JOptionPane.showMessageDialog(this, "Faltando informações !!");
        }else {
            int linhaSelecionada = ProdutoLista.getSelectedRow();
            if(linhaSelecionada == -1){
                JOptionPane.showMessageDialog(this, "Linha não selecionada");
            }else {
                JOptionPane.showMessageDialog(this, "Edite pela tabela");
                try {
                 String id = ProdutoLista.getValueAt(linhaSelecionada, 0).toString();
                 
                 Bson filter = Filters.eq("_id", new ObjectId(id));
                 Bson update = Updates.combine(
                         Updates.set("Nome", ProdutoLista.getValueAt(linhaSelecionada, 1)),
                         Updates.set("Categoria", ProdutoLista.getValueAt(linhaSelecionada, 2)),
                         Updates.set("Preço", ProdutoLista.getValueAt(linhaSelecionada, 3)),
                         Updates.set("Quantidade", ProdutoLista.getValueAt(linhaSelecionada, 4))
                 );
                 
                 colecao.updateOne(filter, update);
                 JOptionPane.showMessageDialog(this, "Editado com sucesso !!!");
                
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex);
            }
        } 
        }
    }//GEN-LAST:event_EditBtnActionPerformed

    private void PrCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrCatActionPerformed
        
    }//GEN-LAST:event_PrCatActionPerformed

    private void QuantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuantidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_QuantidadeActionPerformed

    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vendas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBtn;
    private javax.swing.JButton DeletarBtn;
    private javax.swing.JButton EditBtn;
    private javax.swing.JComboBox<String> PrCat;
    private javax.swing.JTextField PrNome;
    private javax.swing.JTextField Preço;
    private javax.swing.JTable ProdutoLista;
    private javax.swing.JTextField Quantidade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
