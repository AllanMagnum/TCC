/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.concepter.view;

import br.com.concepter.model.beans.Agregacao;
import br.com.concepter.model.beans.Atributo;
import br.com.concepter.model.beans.Especializacao;
import br.com.concepter.model.beans.Entidade;
import br.com.concepter.model.beans.Relacionamento;
import br.com.concepter.model.enuns.TipoAtributoEnum;
import com.mxgraph.model.mxCell;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JMenu;
import javax.swing.JOptionPane;

/**
 *
 * @author AllanMagnum
 */
public class AreaGrafica extends JInternalFrame {
    
    private static mxGraph grafico;
    private static mxGraphComponent areaGrafico;
    private Integer cont_entidade = 0;
    private Integer cont_relacionamento = 0;
    private Integer cont_atributo = new Integer(0);
    private HashMap<Integer, Entidade> mapaGraficoEntidades = new HashMap<Integer, Entidade>();
    private HashMap<Integer, Atributo> mapaGraficoAtributos = new HashMap<Integer, Atributo>();
    private HashMap<Integer, Relacionamento> mapaGraficoRelacionamentos = new HashMap<Integer, Relacionamento>();
    private HashMap<Integer, Especializacao> mapaGraficoEspecializacao = new HashMap<Integer, Especializacao>();
    private HashMap<Integer, Object> mapaGraficoAgregacao = new HashMap<Integer, Object>();
    private Object cell;
    private Entidade entidade_1 = null;
    private Entidade entidade_2 = null;
    private Entidade entidade_3 = null;
    private Entidade entidade_4 = null;
    private Object relacionamento = null;
    private JPopupMenu menuPopup;
    private JMenu menuComplitude;
    private JMenu menuCardinalidade;
    private JMenuItem menuItemDelete;
    private JMenuItem menuItemBinario;
    private JMenuItem menuItemTernario;
    private JMenuItem menuItemQuaternario;
    private JMenu menuAgregacao;
    private JMenu menuTotalidade;
    private JMenu menuParcialidade;
    private JMenu menuNn;
    private JMenu menu1n;
    private static float px, py;
    
    public AreaGrafica(){
        this.grafico = new mxGraph();
        this.areaGrafico = new mxGraphComponent(grafico);
        this.areaGrafico.setPreferredSize(new Dimension(500,200));
        this.areaGrafico.setLocation(83,0);
	this.areaGrafico.getGraphControl().addMouseListener(new ObjetoMer_Selecionado());
	this.areaGrafico.getGraphControl().addMouseListener(new ObjetoMer_RigthClick());
        this.areaGrafico.getGraphControl().addMouseListener(new BotaoEsquerdoCliqueGrafico());
		
	
        this.grafico.setEdgeLabelsMovable(false);   //Nao permite que a descricao da seta seja movida
        this.grafico.setCellsDisconnectable(false); //Nao Permite que as setas sejam desconectadas

        //this.grafico.setAllowDanglingEdges(false);
        this.grafico.setAllowLoops(false);
	this.grafico.setCellsResizable(false);
	this.grafico.setCellsBendable(false);
	this.grafico.setSplitEnabled(true);
	this.grafico.setKeepEdgesInForeground(false);
	this.grafico.setKeepEdgesInBackground(true);
         
        areaGrafico.setConnectable(false);
      
        this.add(areaGrafico);
        
        //Menu popup para Objetos Mer
	menuPopup = new JPopupMenu();
	
        menuComplitude = new JMenu("Complitude");
        menuCardinalidade = new JMenu("Cardinalidade");
        
	//Item para o Menu popup de Objetos Mer
        menuItemDelete = new JMenuItem("Delete");
        
        menuAgregacao = new JMenu("Agregação");
        menuItemBinario = new JMenuItem("Binário");
        menuItemTernario = new JMenuItem("Ternário");
        menuItemQuaternario = new JMenuItem("Quaternário");
        
        menuParcialidade = new JMenu("Parcialidade");
        menuTotalidade = new JMenu("Totalidade");
         
        menuNn = new JMenu("N - N");
        menu1n = new JMenu("1 - N");
        
        menuPopup.add(menuItemDelete);

	menuItemDelete.addActionListener(new BotaoDeletarPopupMenu());
    }
    
    public mxGraph getGrafico(){
        return this.grafico;
    }
    
    public mxGraphComponent getAreaGrafico(){
        return this.areaGrafico;
    }
    
    public float getPx(){
        return px;
    }
    
    public float getPy(){
        return py;
    }

    public void setCont_atributo(Integer cont_atributo) {
        this.cont_atributo = cont_atributo;
    }
    
    
    
    private void limparMenuPopup(){
        menuComplitude.removeAll();
        menuCardinalidade.removeAll();
        
        menuParcialidade.removeAll();
        menuTotalidade.removeAll();
        
        menu1n.removeAll();
        menuNn.removeAll();
        
        menuPopup.remove(menuComplitude);
        menuPopup.remove(menuCardinalidade);
        menuPopup.remove(menuAgregacao);
        
    }
    
    private void preencherPopupMenu(){
        Entidade entidade = (Entidade) mapaGraficoEntidades.get( Integer.parseInt(((mxCell) cell).getId()));

        List<Object> entidades = entidade.getRelacionamentos();
        
        if(!entidades.isEmpty()){
            menuPopup.add(menuComplitude);
            menuPopup.add(menuCardinalidade);
            
            menuComplitude.add(menuParcialidade);
            menuComplitude.add(menuTotalidade);
        
            menuCardinalidade.add(menuNn);
            menuCardinalidade.add(menu1n);
            for (Object entidade1 : entidades) {
                JMenuItem jmi = new JMenuItem(((mxCell)entidade1).getValue().toString());
                jmi.addActionListener(new BotaoTotalidadePopupMenu());
                menu1n.add(jmi);
//                menuParcialidade.addActionListener(new BotaoDeletarPopupMenu());
//                menuTotalidade.add( ((mxCell)entidade1).getValue().toString() );
//                menuTotalidade.addActionListener(new BotaoDeletarPopupMenu());
//                menu1n.add( ((mxCell)entidade1).getValue().toString() );
//                menu1n.addActionListener(new BotaoDeletarPopupMenu());
//                menuNn.add( ((mxCell)entidade1).getValue().toString() );
//                menu1n.addActionListener(new BotaoDeletarPopupMenu());
            }
        }
    }
    
    public class BotaoDeletarPopupMenu implements ActionListener {
        @Override
	public void actionPerformed(ActionEvent e) {
            grafico.getModel().remove(cell);
	}
    }
    
    public class BotaoTotalidadePopupMenu implements ActionListener {
        @Override
	public void actionPerformed(ActionEvent e) {
            mxCell source = (mxCell)cell;
            
            if(source.getEdgeCount() > 0)
            {
                for(int i=0; i < source.getEdgeCount(); i++)
                {
                    mxCell target = (mxCell)((mxCell)source.getEdgeAt(i)).getTarget();
                    if(target != source)
                    {
                        JOptionPane.showMessageDialog(null, source.getValue().toString() );
                    }
                }
            }
            
	}
    }
    
    public class BotaoBinarioPopupMenu implements ActionListener {
        @Override
	public void actionPerformed(ActionEvent e) {
            TelaPrincipal.setBotao(7);
        }    
    }
    
    public class ObjetoMer_RigthClick extends MouseAdapter {	
        @Override
	public void mouseReleased(MouseEvent e){
            boolean isRelacionamento = false;
            boolean isEntidade = false;
            boolean isAtributo = false;
            boolean isAgregacao = false;
            Entidade entidadeSelecionado = null;
            Relacionamento relacionamentoSelecionado = null;
            Atributo atributoSelecionado = null;
            Agregacao agregacaoSelecionado = null;
            
            limparMenuPopup();
            
            cell = areaGrafico.getCellAt(e.getX(), e.getY());
            
            if(e.isPopupTrigger() && cell != null ){
                relacionamentoSelecionado = (Relacionamento) mapaGraficoRelacionamentos.get( Integer.parseInt( ( (mxCell) areaGrafico.getCellAt(e.getX(), e.getY()) ).getId() ));
                entidadeSelecionado = (Entidade) mapaGraficoEntidades.get( Integer.parseInt( ( (mxCell) areaGrafico.getCellAt(e.getX(), e.getY()) ).getId() ) );
                atributoSelecionado =  (Atributo) mapaGraficoAtributos.get( Integer.parseInt( ( (mxCell) areaGrafico.getCellAt(e.getX(), e.getY()) ).getId() ) );
                agregacaoSelecionado =  (Agregacao) mapaGraficoAgregacao.get( Integer.parseInt( ( (mxCell) areaGrafico.getCellAt(e.getX(), e.getY()) ).getId() ) );

                if(relacionamentoSelecionado != null){
                    isRelacionamento = true;
                }

                if(entidadeSelecionado != null){
                    isEntidade = true;
                }

                if(agregacaoSelecionado != null){
                    isAgregacao = true;
                }

                if(atributoSelecionado != null){
                    if(atributoSelecionado.getTipoAtributo().equals(TipoAtributoEnum.COMPOSTO) || atributoSelecionado.getTipoAtributo().equals(TipoAtributoEnum.MULTIVALORADO)){
                        isAtributo = true;
                    }
                }
                
                if(isRelacionamento){
                    menuPopup.add(menuComplitude);
                    menuPopup.add(menuCardinalidade);
                    
                    for (Entidade entidade : relacionamentoSelecionado.getEntidades()) {
                        JMenu jm = new JMenu(entidade.getCell().getValue().toString());
                        JMenuItem jmi1 = new JMenuItem("1");
                        JMenuItem jmiN = new JMenuItem("N");
                        jm.add(jmi1);
                        jm.add(jmiN);
                        jmi1.addActionListener(new BotaoTotalidadePopupMenu());    
                        jmiN.addActionListener(new BotaoTotalidadePopupMenu());
              
                        menuCardinalidade.add(jm);
                    }
                   
                }
                         
		menuPopup.show(e.getComponent(), e.getX(), e.getY());
            }
	}
    }
	
    public class ObjetoMer_Selecionado extends MouseAdapter {
        @Override
	public void mouseReleased(MouseEvent e){
            cell = areaGrafico.getCellAt(e.getX(), e.getY());
	}
    }
    
    public class BotaoEsquerdoCliqueGrafico extends MouseAdapter{
        @Override
        public void mouseReleased(MouseEvent e){
            boolean isRelacionamento = false;
            boolean isEntidade = false;
            boolean isAtributo = false;
            boolean isAgregacao = false;
            Entidade entidadeSelecionado = null;
            Relacionamento relacionamentoSelecionado = null;
            Atributo atributoSelecionado = null;
            Agregacao agregacaoSelecionado = null;
            
            if(e.getButton() == MouseEvent.BUTTON1){
                
                if(px == 0 && py == 0){
                    px = e.getX();
                    py = e.getY();
                }
                
                if(areaGrafico.getCellAt(e.getX(), e.getY()) != null){
                    relacionamentoSelecionado = (Relacionamento) mapaGraficoRelacionamentos.get( Integer.parseInt( ( (mxCell) areaGrafico.getCellAt(e.getX(), e.getY()) ).getId() ));
                    entidadeSelecionado = (Entidade) mapaGraficoEntidades.get( Integer.parseInt( ( (mxCell) areaGrafico.getCellAt(e.getX(), e.getY()) ).getId() ) );
                    atributoSelecionado =  (Atributo) mapaGraficoAtributos.get( Integer.parseInt( ( (mxCell) areaGrafico.getCellAt(e.getX(), e.getY()) ).getId() ) );
                    agregacaoSelecionado =  (Agregacao) mapaGraficoAgregacao.get( Integer.parseInt( ( (mxCell) areaGrafico.getCellAt(e.getX(), e.getY()) ).getId() ) );
                    
                    if(relacionamentoSelecionado != null){
                        isRelacionamento = true;
                    }
                    
                    if(entidadeSelecionado != null){
                        isEntidade = true;
                    }
                    
                    if(agregacaoSelecionado != null){
                        isAgregacao = true;
                    }
                    
                    if(atributoSelecionado != null){
                        if(atributoSelecionado.getTipoAtributo().equals(TipoAtributoEnum.COMPOSTO) || atributoSelecionado.getTipoAtributo().equals(TipoAtributoEnum.MULTIVALORADO)){
                            isAtributo = true;
                        }
                    }
                }
                
                //botao entidade
                if(TelaPrincipal.getBotao() == 1){
                    cont_entidade++;
                    Entidade entidade = new Entidade( grafico, 
                                                      mapaGraficoEntidades,
                                                      cont_entidade ,
                                                      "Entidade" + cont_entidade,
                                                      px,
                                                      py,
                                                      TelaPrincipal.getTipoEntidade());
                    entidade.add();
                    TelaPrincipal.setTipoEntidade();
                    TelaPrincipal.setBotao(0);
                    px = 0;
                    py = 0;
                }
                
                //botao atributo
                if(TelaPrincipal.getBotao() == 2){
                    if (cell != null && (isRelacionamento || isEntidade || isAtributo || isAgregacao)){
                        cont_atributo++;
                        Atributo atributo = new Atributo( grafico,
                                                          mapaGraficoAtributos,
                                                          TelaPrincipal.getTipoAtributo(),
                                                          "Atributo",
                                                          px,
                                                          py,
                                                          cont_atributo);
                        atributo.setIsRelacionamento(isRelacionamento);
                        
                        if(isEntidade){
                            int cont = 0;
                            if(TelaPrincipal.getTipoAtributo() == TipoAtributoEnum.CHAVE){
                                for (Atributo atrib : entidadeSelecionado.getAtributos() ) {
                                    if(atrib.getTipoAtributo() == TipoAtributoEnum.CHAVE){
                                        cont++;
                                    }
                                    if(cont == 3){
                                        JOptionPane.showMessageDialog(null, "Número de atributos chave excedido!");
                                        return;
                                    }
                                }
                            }

                            if(entidadeSelecionado.getAtributos().size() < 20){
                                atributo.setEntidade( entidadeSelecionado );
                            }else{
                                JOptionPane.showMessageDialog(null, "Número de atributos excedido!");
                                return;
                            }
                        }
                        
                        if(isRelacionamento){
                            int cont = 0;
                            if(TelaPrincipal.getTipoAtributo() == TipoAtributoEnum.CHAVE){
                                for (Atributo atrib : relacionamentoSelecionado.getAtributos() ) {
                                    if(atrib.getTipoAtributo() == TipoAtributoEnum.CHAVE){
                                        cont++;
                                    }
                                    if(cont == 3){
                                        JOptionPane.showMessageDialog(null, "Número de atributos chave excedido!");
                                        return;
                                    }
                                }
                            }

                            if(relacionamentoSelecionado.getAtributos().size() < 20){
                                atributo.setRelacionamento(relacionamentoSelecionado );
                            }else{
                                JOptionPane.showMessageDialog(null, "Número de atributos excedido!");
                                return;
                            }
                        }
                        
                        if(isAgregacao){
                            int cont = 0;
                            if(TelaPrincipal.getTipoAtributo() == TipoAtributoEnum.CHAVE){
                                for (Atributo atrib : agregacaoSelecionado.getAtributos() ) {
                                    if(atrib.getTipoAtributo() == TipoAtributoEnum.CHAVE){
                                        cont++;
                                    }
                                    if(cont == 3){
                                        JOptionPane.showMessageDialog(null, "Número de atributos chave excedido!");
                                        return;
                                    }
                                }
                            }
                            
                            if(agregacaoSelecionado.getAtributos().size() < 20){
                                atributo.setAgregacao(agregacaoSelecionado);
                            }else{
                                JOptionPane.showMessageDialog(null, "Número de atributos excedido!");
                                return;
                            }
                            
                        }
                        
                        if(isAtributo){
                            if(atributoSelecionado.getAtributos().size() < 20){
                                atributo.setAtributo(atributoSelecionado);
                            }else{
                                JOptionPane.showMessageDialog(null, "Número de atributos excedido!");
                                return;
                            }
                        }
                        
                        atributo.add(cell);
                        
                        TelaPrincipal.setBotao(0);
                        TelaPrincipal.setTipoAtributo();
                        cell = null;
                        px = 0;
                        py = 0;
                    }
                }
                
                //botao relacionamento
                if(TelaPrincipal.getBotao() == 3){
                    if(entidade_1 != null && isEntidade){
                        entidade_2 = entidadeSelecionado;
                    }
                    if(entidade_1 == null && isEntidade){
                        entidade_1 = entidadeSelecionado;
                    }
                    
                    if (entidade_1 != null && entidade_2 != null){
                        cont_relacionamento++;
                         
                        Relacionamento relacionamento = new Relacionamento( grafico, 
                                                                            mapaGraficoEntidades, 
                                                                            mapaGraficoRelacionamentos,
                                                                            "Relacionamento" + cont_relacionamento, 
                                                                            px,
                                                                            py);
                        relacionamento.add(entidade_1, entidade_2);
                        TelaPrincipal.setBotao(0);
                        entidade_1 = null;
                        entidade_2 = null;
                        px = 0;
                        py = 0;
                        
                    }
                }
                
                if(TelaPrincipal.getBotao() == 4){
                    
                    if(entidade_2 != null && entidade_1 != null && isEntidade){
                        entidade_3 = entidadeSelecionado;
                    }
                    if(entidade_1 != null && entidade_3 == null && isEntidade){
                        entidade_2 = entidadeSelecionado;
                    }
                    if(entidade_1 == null && isEntidade){
                        entidade_1 = entidadeSelecionado;
                    }
                    
                    if (entidade_1 != null && entidade_2 != null && entidade_3 != null){
                        cont_relacionamento++;
                        Relacionamento relacionamento = new Relacionamento( grafico, 
                                                                            mapaGraficoEntidades, 
                                                                            mapaGraficoRelacionamentos,
                                                                            "Relacionamento" + cont_relacionamento,
                                                                            px,
                                                                            py);
                        relacionamento.add(entidade_1, entidade_2, entidade_3);
                        TelaPrincipal.setBotao(0);
                        entidade_1 = null;
                        entidade_2 = null;
                        entidade_3 = null;
                        px = 0;
                        py = 0;
                    }
                }
                
                if(TelaPrincipal.getBotao() == 5){
                    
                    if(entidade_1 != null && entidade_2 != null && entidade_3 != null && isEntidade){
                        entidade_4 = entidadeSelecionado;
                    }
                    if(entidade_2 != null && entidade_1 != null && entidade_4 == null && isEntidade){
                        entidade_3 = entidadeSelecionado;
                    }
                    if(entidade_1 != null && entidade_3 == null && entidade_4 == null && isEntidade){
                        entidade_2 = entidadeSelecionado;
                    }
                    if(entidade_1 == null && isEntidade){
                        entidade_1 = entidadeSelecionado;
                    }
                    
                    if (entidade_1 != null && entidade_2 != null && entidade_3 != null && entidade_4 != null){
                        cont_relacionamento++;
                        Relacionamento relacionamento = new Relacionamento( grafico, 
                                                                            mapaGraficoEntidades, 
                                                                            mapaGraficoRelacionamentos,
                                                                            "Relacionamento" + cont_relacionamento,  
                                                                            px,
                                                                            py);
                        relacionamento.add(entidade_1, entidade_2, entidade_3, entidade_4);
                        TelaPrincipal.setBotao(0);
                        entidade_1 = null;
                        entidade_2 = null;
                        entidade_3 = null;
                        entidade_4 = null;
                        px = 0;
                        py = 0;
                    }
                }
                
                 if(TelaPrincipal.getBotao() == 6){
                    
                     
                    if (cell != null){
                        Especializacao disjuncao = new Especializacao( grafico, 
                                                          mapaGraficoEspecializacao, 
                                                          px,
                                                          py,
                                                          TelaPrincipal.getTipoEspecializacao());
                        disjuncao.add(cell);
                        TelaPrincipal.setBotao(0);
                        cell = null;
                    }
                }
                
                //botao relacionamento
                if(TelaPrincipal.getBotao() == 7){
                    
                    if(relacionamento != null  && isEntidade){
                        entidade_1 = entidadeSelecionado;
                    }
                    if(relacionamento == null && isRelacionamento){
                        relacionamento = areaGrafico.getCellAt(e.getX(), e.getY());
                    }
                    
                    if (relacionamento != null && entidade_1 != null){
                  
                        Agregacao agregacao = new Agregacao( grafico, 
                                                             mapaGraficoAgregacao,
                                                             mapaGraficoRelacionamentos,
                                                             "Agregação", 
                                                             px,
                                                             py);
                        agregacao.add(relacionamento, entidade_1);
                        TelaPrincipal.setBotao(0);
                        entidade_1 = null;
                        entidade_2 = null;
                        px = 0;
                        py = 0;
                        
                    }
                } 
                
                if(TelaPrincipal.getBotao() == 8){
                    if(entidade_1 != null && relacionamento != null  && isEntidade){
                        entidade_2 = entidadeSelecionado;
                    }
                    if(relacionamento != null && entidade_2 == null  && isEntidade){
                        entidade_1 = entidadeSelecionado;
                    }
                    if(relacionamento == null && isRelacionamento){
                        relacionamento = areaGrafico.getCellAt(e.getX(), e.getY());
                    }
                    
                    if (relacionamento != null && entidade_1 != null && entidade_2 != null){
                  
                        Agregacao agregacao = new Agregacao( grafico, 
                                                             mapaGraficoAgregacao, 
                                                             mapaGraficoRelacionamentos,
                                                             "Agregação", 
                                                             px,
                                                             py);
                        agregacao.add(relacionamento, entidade_1, entidade_2);
                        TelaPrincipal.setBotao(0);
                        relacionamento = null;
                        entidade_1 = null;
                        entidade_2 = null;
                        px = 0;
                        py = 0;
                        
                    }
                }
                
                //botao relacionamento
                if(TelaPrincipal.getBotao() == 9){
                    if(relacionamento != null && entidade_1 != null && entidade_2 != null  && isEntidade){
                        entidade_3 = entidadeSelecionado;
                    }
                    if(entidade_1 != null && relacionamento != null && entidade_3 == null  && isEntidade){
                        entidade_2 = entidadeSelecionado;
                    }
                    if(relacionamento != null && entidade_2 == null && entidade_3 == null  && isEntidade){
                        entidade_1 = entidadeSelecionado;
                    }
                    if(relacionamento == null && isRelacionamento){
                        relacionamento = areaGrafico.getCellAt(e.getX(), e.getY());
                    }
                    
                    if (relacionamento != null && entidade_1 != null && entidade_2 != null && entidade_3 != null){
                  
                        Agregacao agregacao = new Agregacao( grafico, 
                                                             mapaGraficoAgregacao, 
                                                             mapaGraficoRelacionamentos,
                                                             "Agregação", 
                                                             px,
                                                             py);
                        agregacao.add(relacionamento, entidade_1, entidade_2, entidade_3);
                        TelaPrincipal.setBotao(0);
                        relacionamento = null;
                        entidade_1 = null;
                        entidade_2 = null;
                        entidade_3 = null;
                        px = 0;
                        py = 0;
                        
                    }
                }
            
            }
        }
    }
    
}
