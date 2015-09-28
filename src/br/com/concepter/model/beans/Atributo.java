package br.com.concepter.model.beans;

import br.com.concepter.model.enuns.TipoAtributoEnum;
import com.mxgraph.model.mxCell;
import java.util.HashMap;
import com.mxgraph.view.mxGraph;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Atributo {

    private String nome;
    private TipoAtributoEnum tipoAtributo;
    private Entidade entidade;
    private Atributo atributo;
    private Relacionamento relacionamento;
    private Agregacao agregacao;
    private List<Atributo> atributos = new ArrayList<>();
    
    private mxGraph grafico; 
    private mxCell forma;
    private double pX;
    private double pY;
    private int tamanhoLargura;
    private int tamanhoAltura;
    
    private HashMap<Integer, Atributo> mapaGraficoAtributos;
    private Integer cont_Atributo;
    private boolean isRelacionamento;

    public Atributo() {
    }

    public Atributo(mxGraph grafico, HashMap<Integer, Atributo> mapaGraficoAtributos, TipoAtributoEnum tipoAtributo, String nome, double pX, double pY, Integer cont_Atributo){
            this.nome = nome;
            this.grafico = grafico;
            this.mapaGraficoAtributos = mapaGraficoAtributos;
            this.pX = pX - 40;
            this.pY = pY - 80;
            this.tamanhoLargura = 100;
            this.tamanhoAltura = 25;
            this.tipoAtributo = tipoAtributo;
            this.cont_Atributo = cont_Atributo;
    } 
    
    public void add(Object objeto){
        String caracteristicas = "";
       
        if(tipoAtributo == TipoAtributoEnum.SIMPLES){
            caracteristicas = "fillColor=white;shape=ellipse;";
        }
        if(tipoAtributo == TipoAtributoEnum.CHAVE){
            caracteristicas = "fillColor=white;shape=ellipse;fontStyle=1;";
        }
        if(tipoAtributo == TipoAtributoEnum.COMPOSTO){
            caracteristicas = "fillColor=white;shape=ellipse;";
        }
        if(tipoAtributo == TipoAtributoEnum.MULTIVALORADO){
            caracteristicas = "fillColor=white;shape=doubleEllipse;";
        }
        if(tipoAtributo == TipoAtributoEnum.DERIVADO){
            caracteristicas = "fillColor=white;shape=ellipse;dashed=true;";
        }

        this.grafico.getModel().beginUpdate();
        Object atributo = null;
        Object atributo_1 = null;
        Object atributo_2 = null;
        Object parent = this.grafico.getDefaultParent();
        try{
            
            double posx = ((mxCell) objeto).getGeometry().getX();
            double posy = ((mxCell) objeto).getGeometry().getY();

            if(this.isRelacionamento){
                posx = posx + 40;
                posy = posy + 120;
            }
            
            atributo = this.grafico.insertVertex(parent, null, this.nome +  this.cont_Atributo, posx, posy - 50, this.tamanhoLargura, this.tamanhoAltura, caracteristicas);
            
            this.grafico.insertEdge(parent, null, null, atributo, objeto,"startArrow=none;endArrow=none;");

            if(tipoAtributo == TipoAtributoEnum.COMPOSTO){
                this.cont_Atributo++;
                atributo_1 = this.grafico.insertVertex(parent, null, "Atributo" + this.cont_Atributo, this.pX - 55, this.pY - 50, this.tamanhoLargura, this.tamanhoAltura, "fillColor=white;shape=ellipse;rounded=true;");
                Atributo atr_1 = new Atributo(this.grafico, this.mapaGraficoAtributos, TipoAtributoEnum.SIMPLES, "Atributo" + this.cont_Atributo, this.pX, this.pY, cont_Atributo);
                atr_1.setForma((mxCell) atributo_1);
                this.mapaGraficoAtributos.put( Integer.valueOf( ((mxCell) atributo_1).getId() ), atr_1 );
                
                this.cont_Atributo++;
                atributo_2 = this.grafico.insertVertex(parent, null, "Atributo" + this.cont_Atributo, this.pX + 55, this.pY - 50, this.tamanhoLargura, this.tamanhoAltura, "fillColor=white;shape=ellipse;rounded=true;");
                Atributo atr_2 = new Atributo(this.grafico, this.mapaGraficoAtributos, TipoAtributoEnum.SIMPLES, "Atributo" + this.cont_Atributo, this.pX, this.pY, cont_Atributo);
                atr_2.setForma((mxCell) atributo_2);
                this.mapaGraficoAtributos.put( Integer.valueOf( ((mxCell) atributo_2).getId() ), atr_2 );
                
                this.grafico.insertEdge(parent, null, null, atributo_1, atributo,"startArrow=none;endArrow=none;");
                this.grafico.insertEdge(parent, null, null, atributo_2, atributo,"startArrow=none;endArrow=none;");
            }
        }
        finally{
            if(this.entidade != null){
                this.entidade.getAtributos().add(this);
            }
            
            if(this.relacionamento != null){
                this.relacionamento.getAtributos().add(this);
            }
            
            if(this.atributo != null){
                this.atributo.getAtributos().add(this);
            } 
            
            this.forma = (mxCell) atributo;
            this.mapaGraficoAtributos.put( Integer.valueOf( ((mxCell) atributo).getId() ), this );
            this.grafico.getModel().endUpdate();
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
  
    public TipoAtributoEnum getTipoAtributo() {
        return tipoAtributo;
    }

    public void setTipoAtributo(TipoAtributoEnum tipoAtributo) {
        this.tipoAtributo = tipoAtributo;
    }
    @XmlTransient
    public Entidade getEntidade() {
        return entidade;
    }

    public void setEntidade(Entidade entidade) {
        this.entidade = entidade;
    }
    @XmlTransient
    public Atributo getAtributo() {
        return atributo;
    }

    public void setAtributo(Atributo atributo) {
        this.atributo = atributo;
    }
    @XmlTransient
    public Relacionamento getRelacionamento() {
        return relacionamento;
    }

    public void setRelacionamento(Relacionamento relacionamento) {
        this.relacionamento = relacionamento;
    }
    @XmlTransient
    public Agregacao getAgregacao() {
        return agregacao;
    }
   
    public void setAgregacao(Agregacao agregacao) {
        this.agregacao = agregacao;
    }
    @XmlTransient
    public List<Atributo> getAtributos() {
        return atributos;
    }

    public void setAtributos(List<Atributo> atributos) {
        this.atributos = atributos;
    }
    @XmlTransient
    public mxGraph getGrafico() {
        return grafico;
    }
    
    public void setGrafico(mxGraph grafico) {
        this.grafico = grafico;
    }
    @XmlTransient
    public mxCell getForma() {
        return forma;
    }

    public void setForma(mxCell forma) {
        this.forma = forma;
    }
    @XmlTransient
    public double getpX() {
        return pX;
    }

    public void setpX(double pX) {
        this.pX = pX;
    }
    @XmlTransient
    public double getpY() {
        return pY;
    }

    public void setpY(double pY) {
        this.pY = pY;
    }
    @XmlTransient
    public int getTamanhoLargura() {
        return tamanhoLargura;
    }

    public void setTamanhoLargura(int tamanhoLargura) {
        this.tamanhoLargura = tamanhoLargura;
    }
    @XmlTransient
    public int getTamanhoAltura() {
        return tamanhoAltura;
    }

    public void setTamanhoAltura(int tamanhoAltura) {
        this.tamanhoAltura = tamanhoAltura;
    }
    @XmlTransient
    public HashMap<Integer, Atributo> getMapaGraficoAtributos() {
        return mapaGraficoAtributos;
    }

    public void setMapaGraficoAtributos(HashMap<Integer, Atributo> mapaGraficoAtributos) {
        this.mapaGraficoAtributos = mapaGraficoAtributos;
    }
    @XmlTransient
    public Integer getCont_Atributo() {
        return cont_Atributo;
    }

    public void setCont_Atributo(Integer cont_Atributo) {
        this.cont_Atributo = cont_Atributo;
    }
    @XmlTransient
    public boolean isIsRelacionamento() {
        return isRelacionamento;
    }

    public void setIsRelacionamento(boolean isRelacionamento) {
        this.isRelacionamento = isRelacionamento;
    }
    
    
    
}
