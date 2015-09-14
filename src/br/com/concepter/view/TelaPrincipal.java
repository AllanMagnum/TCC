/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.concepter.view;

import br.com.concepter.model.enuns.TipoAtributoEnum;
import br.com.concepter.model.enuns.TipoEntidadeEnum;
import br.com.concepter.model.enuns.TipoEspecializacaoEnum;
import br.com.concepter.utils.FileUtils;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author AllanMagnum
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    
    private static int botao;
    private static TipoAtributoEnum tipoAtributo;
    private static TipoEspecializacaoEnum tipoEspecializacao;
    private static TipoEntidadeEnum tipoEntidade;
    
    
    
    public TelaPrincipal() {    
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        areaGrafica = new br.com.concepter.view.AreaGrafica();
        jToolBar1 = new javax.swing.JToolBar();
        jSeparator22 = new javax.swing.JToolBar.Separator();
        jButtonEntidade = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JToolBar.Separator();
        jButtonEntidadeFraca = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jSeparator18 = new javax.swing.JToolBar.Separator();
        jButtonAtributoSimples = new javax.swing.JButton();
        jSeparator10 = new javax.swing.JToolBar.Separator();
        jButtonAtributoChave = new javax.swing.JButton();
        jSeparator11 = new javax.swing.JToolBar.Separator();
        jButtonAtributoComposto = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        jButtonAtributoMultivalorado = new javax.swing.JButton();
        jSeparator9 = new javax.swing.JToolBar.Separator();
        jButtonAtributoDerivado = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        jSeparator20 = new javax.swing.JToolBar.Separator();
        jButtonRelacionamento = new javax.swing.JButton();
        jSeparator13 = new javax.swing.JToolBar.Separator();
        jButtonRelacionamentoTernario = new javax.swing.JButton();
        jSeparator12 = new javax.swing.JToolBar.Separator();
        jButtonRelacionamentoQuaternario = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        jSeparator19 = new javax.swing.JToolBar.Separator();
        jButtonEspecializacaoDisjuncao = new javax.swing.JButton();
        jSeparator17 = new javax.swing.JToolBar.Separator();
        jButtonEspecializacaoSobrePosicao = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        jSeparator21 = new javax.swing.JToolBar.Separator();
        jButtonEntidadeFraca1 = new javax.swing.JButton();
        jSeparator16 = new javax.swing.JToolBar.Separator();
        jButtonEntidadeFraca2 = new javax.swing.JButton();
        jSeparator15 = new javax.swing.JToolBar.Separator();
        jButtonEntidadeFraca3 = new javax.swing.JButton();
        jSeparator14 = new javax.swing.JToolBar.Separator();
        jMenuBarTelaPrincipal = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ConceptER");
        setLocationByPlatform(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        areaGrafica.setBackground(java.awt.Color.white);
        areaGrafica.setBorder(null);
        areaGrafica.setForeground(new java.awt.Color(255, 255, 255));
        areaGrafica.setPreferredSize(new java.awt.Dimension(400, 200));
        areaGrafica.setVisible(true);

        jToolBar1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jToolBar1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jToolBar1.setRollover(true);
        jToolBar1.setAlignmentY(0.0F);
        jToolBar1.setMinimumSize(new java.awt.Dimension(40, 349));
        jToolBar1.setPreferredSize(new java.awt.Dimension(40, 397));
        jToolBar1.add(jSeparator22);

        jButtonEntidade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/concepter/view/resources/imagens/Retanguloo.jpg"))); // NOI18N
        jButtonEntidade.setToolTipText("Entidade");
        jButtonEntidade.setFocusCycleRoot(true);
        jButtonEntidade.setFocusable(false);
        jButtonEntidade.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonEntidade.setMaximumSize(new java.awt.Dimension(34, 23));
        jButtonEntidade.setMinimumSize(new java.awt.Dimension(34, 23));
        jButtonEntidade.setName("JBtnEntidade"); // NOI18N
        jButtonEntidade.setPreferredSize(new java.awt.Dimension(34, 23));
        jButtonEntidade.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonEntidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEntidadeActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonEntidade);
        jToolBar1.add(jSeparator8);

        jButtonEntidadeFraca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/concepter/view/resources/imagens/Retangulo.png"))); // NOI18N
        jButtonEntidadeFraca.setToolTipText("Entidade Fraca");
        jButtonEntidadeFraca.setFocusable(false);
        jButtonEntidadeFraca.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonEntidadeFraca.setMaximumSize(new java.awt.Dimension(34, 23));
        jButtonEntidadeFraca.setMinimumSize(new java.awt.Dimension(34, 23));
        jButtonEntidadeFraca.setName("JBtnEntidade"); // NOI18N
        jButtonEntidadeFraca.setPreferredSize(new java.awt.Dimension(34, 23));
        jButtonEntidadeFraca.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonEntidadeFraca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEntidadeFracaActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonEntidadeFraca);
        jToolBar1.add(jSeparator3);
        jToolBar1.add(jSeparator18);

        jButtonAtributoSimples.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/concepter/view/resources/imagens/Circulo.png"))); // NOI18N
        jButtonAtributoSimples.setToolTipText("Atributo Simples");
        jButtonAtributoSimples.setMaximumSize(new java.awt.Dimension(34, 23));
        jButtonAtributoSimples.setMinimumSize(new java.awt.Dimension(34, 23));
        jButtonAtributoSimples.setPreferredSize(new java.awt.Dimension(34, 23));
        jButtonAtributoSimples.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtributoSimplesActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonAtributoSimples);
        jToolBar1.add(jSeparator10);

        jButtonAtributoChave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/concepter/view/resources/imagens/Circulo com traço.png"))); // NOI18N
        jButtonAtributoChave.setToolTipText("Atributo Chave");
        jButtonAtributoChave.setFocusable(false);
        jButtonAtributoChave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonAtributoChave.setMaximumSize(new java.awt.Dimension(34, 23));
        jButtonAtributoChave.setMinimumSize(new java.awt.Dimension(34, 23));
        jButtonAtributoChave.setPreferredSize(new java.awt.Dimension(34, 23));
        jButtonAtributoChave.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonAtributoChave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtributoChaveActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonAtributoChave);
        jToolBar1.add(jSeparator11);

        jButtonAtributoComposto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/concepter/view/resources/imagens/3 balões.png"))); // NOI18N
        jButtonAtributoComposto.setToolTipText("Atributo Composto");
        jButtonAtributoComposto.setFocusable(false);
        jButtonAtributoComposto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonAtributoComposto.setMaximumSize(new java.awt.Dimension(34, 23));
        jButtonAtributoComposto.setMinimumSize(new java.awt.Dimension(34, 23));
        jButtonAtributoComposto.setPreferredSize(new java.awt.Dimension(34, 23));
        jButtonAtributoComposto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonAtributoComposto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtributoCompostoActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonAtributoComposto);
        jToolBar1.add(jSeparator7);

        jButtonAtributoMultivalorado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/concepter/view/resources/imagens/Circulo dentro.png"))); // NOI18N
        jButtonAtributoMultivalorado.setToolTipText("Atributo Multivalorado");
        jButtonAtributoMultivalorado.setFocusable(false);
        jButtonAtributoMultivalorado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonAtributoMultivalorado.setMaximumSize(new java.awt.Dimension(34, 23));
        jButtonAtributoMultivalorado.setMinimumSize(new java.awt.Dimension(34, 23));
        jButtonAtributoMultivalorado.setPreferredSize(new java.awt.Dimension(34, 23));
        jButtonAtributoMultivalorado.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonAtributoMultivalorado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtributoMultivaloradoActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonAtributoMultivalorado);
        jToolBar1.add(jSeparator9);

        jButtonAtributoDerivado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/concepter/view/resources/imagens/Circulo tracejado.png"))); // NOI18N
        jButtonAtributoDerivado.setToolTipText("Atributo Derivado");
        jButtonAtributoDerivado.setFocusable(false);
        jButtonAtributoDerivado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonAtributoDerivado.setMaximumSize(new java.awt.Dimension(34, 23));
        jButtonAtributoDerivado.setMinimumSize(new java.awt.Dimension(34, 23));
        jButtonAtributoDerivado.setPreferredSize(new java.awt.Dimension(34, 23));
        jButtonAtributoDerivado.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonAtributoDerivado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtributoDerivadoActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonAtributoDerivado);
        jToolBar1.add(jSeparator4);
        jToolBar1.add(jSeparator20);

        jButtonRelacionamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/concepter/view/resources/imagens/binario.png"))); // NOI18N
        jButtonRelacionamento.setToolTipText("Relacionamento Binário");
        jButtonRelacionamento.setMaximumSize(new java.awt.Dimension(34, 23));
        jButtonRelacionamento.setMinimumSize(new java.awt.Dimension(34, 23));
        jButtonRelacionamento.setPreferredSize(new java.awt.Dimension(34, 23));
        jButtonRelacionamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRelacionamentoActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonRelacionamento);
        jToolBar1.add(jSeparator13);

        jButtonRelacionamentoTernario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/concepter/view/resources/imagens/ternario.png"))); // NOI18N
        jButtonRelacionamentoTernario.setToolTipText("Relacionamento Ternário");
        jButtonRelacionamentoTernario.setFocusable(false);
        jButtonRelacionamentoTernario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonRelacionamentoTernario.setMaximumSize(new java.awt.Dimension(34, 23));
        jButtonRelacionamentoTernario.setMinimumSize(new java.awt.Dimension(34, 23));
        jButtonRelacionamentoTernario.setPreferredSize(new java.awt.Dimension(34, 23));
        jButtonRelacionamentoTernario.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonRelacionamentoTernario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRelacionamentoTernarioActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonRelacionamentoTernario);
        jToolBar1.add(jSeparator12);

        jButtonRelacionamentoQuaternario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/concepter/view/resources/imagens/quaternario.png"))); // NOI18N
        jButtonRelacionamentoQuaternario.setToolTipText("Relacionamento Quaternário");
        jButtonRelacionamentoQuaternario.setFocusable(false);
        jButtonRelacionamentoQuaternario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonRelacionamentoQuaternario.setMaximumSize(new java.awt.Dimension(34, 23));
        jButtonRelacionamentoQuaternario.setMinimumSize(new java.awt.Dimension(34, 23));
        jButtonRelacionamentoQuaternario.setPreferredSize(new java.awt.Dimension(34, 23));
        jButtonRelacionamentoQuaternario.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonRelacionamentoQuaternario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRelacionamentoQuaternarioActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonRelacionamentoQuaternario);
        jToolBar1.add(jSeparator5);
        jToolBar1.add(jSeparator19);

        jButtonEspecializacaoDisjuncao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/concepter/view/resources/imagens/Círculo C.png"))); // NOI18N
        jButtonEspecializacaoDisjuncao.setToolTipText("Especialização por Disjunção");
        jButtonEspecializacaoDisjuncao.setFocusable(false);
        jButtonEspecializacaoDisjuncao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonEspecializacaoDisjuncao.setMaximumSize(new java.awt.Dimension(34, 23));
        jButtonEspecializacaoDisjuncao.setMinimumSize(new java.awt.Dimension(34, 23));
        jButtonEspecializacaoDisjuncao.setPreferredSize(new java.awt.Dimension(34, 23));
        jButtonEspecializacaoDisjuncao.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonEspecializacaoDisjuncao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEspecializacaoDisjuncaoActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonEspecializacaoDisjuncao);
        jToolBar1.add(jSeparator17);

        jButtonEspecializacaoSobrePosicao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/concepter/view/resources/imagens/Círculo O.png"))); // NOI18N
        jButtonEspecializacaoSobrePosicao.setToolTipText("Especialização por SobrePosição");
        jButtonEspecializacaoSobrePosicao.setFocusable(false);
        jButtonEspecializacaoSobrePosicao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonEspecializacaoSobrePosicao.setMaximumSize(new java.awt.Dimension(34, 23));
        jButtonEspecializacaoSobrePosicao.setMinimumSize(new java.awt.Dimension(34, 23));
        jButtonEspecializacaoSobrePosicao.setPreferredSize(new java.awt.Dimension(34, 23));
        jButtonEspecializacaoSobrePosicao.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonEspecializacaoSobrePosicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEspecializacaoSobrePosicaoActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonEspecializacaoSobrePosicao);
        jToolBar1.add(jSeparator6);
        jToolBar1.add(jSeparator21);

        jButtonEntidadeFraca1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/concepter/view/resources/imagens/Retangulo losango.jpg"))); // NOI18N
        jButtonEntidadeFraca1.setToolTipText("Entidade Fraca");
        jButtonEntidadeFraca1.setFocusable(false);
        jButtonEntidadeFraca1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonEntidadeFraca1.setMaximumSize(new java.awt.Dimension(34, 23));
        jButtonEntidadeFraca1.setMinimumSize(new java.awt.Dimension(34, 23));
        jButtonEntidadeFraca1.setName("JBtnEntidade"); // NOI18N
        jButtonEntidadeFraca1.setPreferredSize(new java.awt.Dimension(34, 23));
        jButtonEntidadeFraca1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonEntidadeFraca1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEntidadeFraca1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonEntidadeFraca1);
        jToolBar1.add(jSeparator16);

        jButtonEntidadeFraca2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/concepter/view/resources/imagens/Retangulo losango.jpg"))); // NOI18N
        jButtonEntidadeFraca2.setToolTipText("Entidade Fraca");
        jButtonEntidadeFraca2.setFocusable(false);
        jButtonEntidadeFraca2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonEntidadeFraca2.setMaximumSize(new java.awt.Dimension(34, 23));
        jButtonEntidadeFraca2.setMinimumSize(new java.awt.Dimension(34, 23));
        jButtonEntidadeFraca2.setName("JBtnEntidade"); // NOI18N
        jButtonEntidadeFraca2.setPreferredSize(new java.awt.Dimension(34, 23));
        jButtonEntidadeFraca2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonEntidadeFraca2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEntidadeFraca2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonEntidadeFraca2);
        jToolBar1.add(jSeparator15);

        jButtonEntidadeFraca3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/concepter/view/resources/imagens/Retangulo losango.jpg"))); // NOI18N
        jButtonEntidadeFraca3.setToolTipText("Entidade Fraca");
        jButtonEntidadeFraca3.setFocusable(false);
        jButtonEntidadeFraca3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonEntidadeFraca3.setMaximumSize(new java.awt.Dimension(34, 23));
        jButtonEntidadeFraca3.setMinimumSize(new java.awt.Dimension(34, 23));
        jButtonEntidadeFraca3.setName("JBtnEntidade"); // NOI18N
        jButtonEntidadeFraca3.setPreferredSize(new java.awt.Dimension(34, 23));
        jButtonEntidadeFraca3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonEntidadeFraca3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEntidadeFraca3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonEntidadeFraca3);
        jToolBar1.add(jSeparator14);

        jMenu1.setLabel("Arquivo");

        jMenuItem1.setText("Novo");
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Abrir ...");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Importar ...");
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Salvar");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem5.setText("Salvar como ...");
        jMenu1.add(jMenuItem5);
        jMenu1.add(jSeparator1);

        jMenuItem6.setText("Imprimir");
        jMenu1.add(jMenuItem6);

        jMenuItem7.setText("Exportar");
        jMenu1.add(jMenuItem7);
        jMenu1.add(jSeparator2);

        jMenuItem8.setText("Sair");
        jMenu1.add(jMenuItem8);

        jMenuBarTelaPrincipal.add(jMenu1);

        jMenu2.setLabel("Inserir");
        jMenuBarTelaPrincipal.add(jMenu2);

        jMenu3.setActionCommand("Ajuda");
        jMenu3.setLabel("Ajuda");
        jMenuBarTelaPrincipal.add(jMenu3);

        setJMenuBar(jMenuBarTelaPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(areaGrafica, javax.swing.GroupLayout.DEFAULT_SIZE, 797, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(areaGrafica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static int getBotao(){
        return TelaPrincipal.botao;
    }
    public static void setBotao(int botao){
        TelaPrincipal.botao = botao;
    }
    public static TipoAtributoEnum getTipoAtributo(){
        return tipoAtributo;
    }
    public static void setTipoAtributo(){
        tipoAtributo = null;
    }
    public static TipoEspecializacaoEnum getTipoEspecializacao(){
        return tipoEspecializacao;
    }
    public static void setTipoEspecializacao(){
        tipoEspecializacao = null;
    }
    public static TipoEntidadeEnum getTipoEntidade(){
        return tipoEntidade;
    }
    public static void setTipoEntidade(){
        tipoEntidade = null;
    }
   
    private void jButtonEntidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEntidadeActionPerformed
        botao = 1; 
        tipoEntidade = tipoEntidade.forte;
    }//GEN-LAST:event_jButtonEntidadeActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        ((BasicInternalFrameUI)areaGrafica.getUI()).setNorthPane(null);
    }//GEN-LAST:event_formWindowActivated

    private void jButtonAtributoSimplesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtributoSimplesActionPerformed
        botao = 2;
        tipoAtributo = tipoAtributo.simples;
    }//GEN-LAST:event_jButtonAtributoSimplesActionPerformed

    private void jButtonRelacionamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRelacionamentoActionPerformed
        botao =3;
    }//GEN-LAST:event_jButtonRelacionamentoActionPerformed

    private void jButtonAtributoMultivaloradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtributoMultivaloradoActionPerformed
        botao = 2;
        tipoAtributo = tipoAtributo.multivalorado;
    }//GEN-LAST:event_jButtonAtributoMultivaloradoActionPerformed

    private void jButtonAtributoCompostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtributoCompostoActionPerformed
        botao = 2;
        tipoAtributo = tipoAtributo.composto;
    }//GEN-LAST:event_jButtonAtributoCompostoActionPerformed

    private void jButtonAtributoChaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtributoChaveActionPerformed
        botao = 2;
        tipoAtributo = tipoAtributo.chave;
    }//GEN-LAST:event_jButtonAtributoChaveActionPerformed

    private void jButtonAtributoDerivadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtributoDerivadoActionPerformed
        botao = 2;
        tipoAtributo = tipoAtributo.derivado;
    }//GEN-LAST:event_jButtonAtributoDerivadoActionPerformed

    private void jButtonRelacionamentoTernarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRelacionamentoTernarioActionPerformed
        botao = 4;
    }//GEN-LAST:event_jButtonRelacionamentoTernarioActionPerformed

    private void jButtonEntidadeFracaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEntidadeFracaActionPerformed
        botao = 1;
        tipoEntidade = tipoEntidade.fraco;
    }//GEN-LAST:event_jButtonEntidadeFracaActionPerformed

    private void jButtonRelacionamentoQuaternarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRelacionamentoQuaternarioActionPerformed
        botao = 5;
    }//GEN-LAST:event_jButtonRelacionamentoQuaternarioActionPerformed

    private void jButtonEspecializacaoDisjuncaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEspecializacaoDisjuncaoActionPerformed
        botao = 6;
        tipoEspecializacao = tipoEspecializacao.disjuncao;
    }//GEN-LAST:event_jButtonEspecializacaoDisjuncaoActionPerformed

    private void jButtonEspecializacaoSobrePosicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEspecializacaoSobrePosicaoActionPerformed
        botao = 6;
        tipoEspecializacao = tipoEspecializacao.sobreposicao;
    }//GEN-LAST:event_jButtonEspecializacaoSobrePosicaoActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        JFileChooser jfc = new JFileChooser();
        
        FileUtils fileUtils = new FileUtils();
        
        if(jfc.showSaveDialog(jMenu1) == JFileChooser.APPROVE_OPTION){
             fileUtils.saveGraph(areaGrafica.getAreaGrafico(), jfc.getSelectedFile().getPath());
        }
        
//        BufferedImage image = mxCellRenderer.createBufferedImage(areaGrafica.getGrafico(), null, 1, Color.WHITE, true, null);
//        try {
//            ImageIO.write(image, "PNG", new File("C:\\Users\\AllanMagnum\\Pictures\\graph.png"));
//        } catch (IOException ex) {
//            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        JFileChooser jfc = new JFileChooser();
        FileUtils fileUtils = new FileUtils();
        
        if(jfc.showOpenDialog(jMenu1) == JFileChooser.APPROVE_OPTION){    
            fileUtils.loadGraph(areaGrafica.getAreaGrafico(), jfc.getSelectedFile().getPath());
        }
        
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jButtonEntidadeFraca1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEntidadeFraca1ActionPerformed
        botao = 7;
    }//GEN-LAST:event_jButtonEntidadeFraca1ActionPerformed

    private void jButtonEntidadeFraca2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEntidadeFraca2ActionPerformed
        botao = 8;
    }//GEN-LAST:event_jButtonEntidadeFraca2ActionPerformed

    private void jButtonEntidadeFraca3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEntidadeFraca3ActionPerformed
        botao = 9;
    }//GEN-LAST:event_jButtonEntidadeFraca3ActionPerformed

 
    
	
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            /* Set the Nimbus look and feel */
            //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
            /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
            * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
            */
            UIManager.setLookAndFeel(new WindowsLookAndFeel());
            //</editor-fold>
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.com.concepter.view.AreaGrafica areaGrafica;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAtributoChave;
    private javax.swing.JButton jButtonAtributoComposto;
    private javax.swing.JButton jButtonAtributoDerivado;
    private javax.swing.JButton jButtonAtributoMultivalorado;
    private javax.swing.JButton jButtonAtributoSimples;
    private javax.swing.JButton jButtonEntidade;
    private javax.swing.JButton jButtonEntidadeFraca;
    private javax.swing.JButton jButtonEntidadeFraca1;
    private javax.swing.JButton jButtonEntidadeFraca2;
    private javax.swing.JButton jButtonEntidadeFraca3;
    private javax.swing.JButton jButtonEspecializacaoDisjuncao;
    private javax.swing.JButton jButtonEspecializacaoSobrePosicao;
    private javax.swing.JButton jButtonRelacionamento;
    private javax.swing.JButton jButtonRelacionamentoQuaternario;
    private javax.swing.JButton jButtonRelacionamentoTernario;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBarTelaPrincipal;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator10;
    private javax.swing.JToolBar.Separator jSeparator11;
    private javax.swing.JToolBar.Separator jSeparator12;
    private javax.swing.JToolBar.Separator jSeparator13;
    private javax.swing.JToolBar.Separator jSeparator14;
    private javax.swing.JToolBar.Separator jSeparator15;
    private javax.swing.JToolBar.Separator jSeparator16;
    private javax.swing.JToolBar.Separator jSeparator17;
    private javax.swing.JToolBar.Separator jSeparator18;
    private javax.swing.JToolBar.Separator jSeparator19;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator20;
    private javax.swing.JToolBar.Separator jSeparator21;
    private javax.swing.JToolBar.Separator jSeparator22;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JToolBar.Separator jSeparator8;
    private javax.swing.JToolBar.Separator jSeparator9;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
