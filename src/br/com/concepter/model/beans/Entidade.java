package br.com.concepter.model.beans;

import br.com.concepter.model.enuns.TipoEntidadeEnum;
import com.mxgraph.model.mxCell;
import com.mxgraph.view.mxGraph;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Entidade implements Serializable{

    private String nome;
    private TipoEntidadeEnum tipo;
    private Especializacao especiaizacao;
    private List<Relacionamento> relacionamentos = new ArrayList<Relacionamento>();
    private List<Atributo> atributos = new ArrayList<>();
    
    private mxGraph grafico;
    private mxCell cell;
    private double pX;
    private double pY;
    private int tamanhoLargura;
    private int tamanhoAltura;
    
    private HashMap<Integer, Entidade> mapaGraficoEntidade;

    public Entidade() {
    }
    
    public Entidade(mxGraph grafico, HashMap<Integer, Entidade> mapaGraficoEntidade, String nome, double pX, double pY, TipoEntidadeEnum tipo){
            this.nome = nome;
            this.tipo = tipo;
            this.grafico = grafico;
            this.mapaGraficoEntidade = mapaGraficoEntidade;
            this.tamanhoLargura = 100;
            this.tamanhoAltura = 50;
            this.pX = pX;
            this.pY = pY;
    }
	
    public mxCell add(){

            this.grafico.getModel().beginUpdate();
            Object entidade = null;
            Object parent = this.grafico.getDefaultParent();
            String caracteristicas = "";
            if(tipo == TipoEntidadeEnum.FORTE){
                caracteristicas = "fillColor=white;shape=rectangle;";
            }
            if(tipo == TipoEntidadeEnum.FRACA){
                caracteristicas = "fillColor=white;shape=doubleRectangle;";
            }
            try{		
                entidade = this.grafico.insertVertex(parent, 
                                                     null, 
                                                     this.nome, 
                                                     this.pX, 
                                                     this.pY, 
                                                     this.tamanhoLargura, 
                                                     this.tamanhoAltura, 
                                                     caracteristicas);
            }
            finally{
                this.cell = (mxCell) entidade;
                this.mapaGraficoEntidade.put( Integer.valueOf( ((mxCell) entidade).getId() ), this);
                this.grafico.getModel().endUpdate();
            }
            return this.cell;
    }
    
    public void add(Especializacao especializacao){
            this.grafico.getModel().beginUpdate();
            Object parent = this.grafico.getDefaultParent();
            
            String caracteristicas = "";
            if(tipo == TipoEntidadeEnum.FORTE){
                caracteristicas = "fillColor=white;shape=rectangle;";
            }
            if(tipo == TipoEntidadeEnum.FRACA){
                caracteristicas = "fillColor=white;shape=doubleRectangle;";
            }
            try{	
                double posx = especializacao.getCell().getGeometry().getX();
                double posy = especializacao.getCell().getGeometry().getY();
                
                this.cell = (mxCell) this.grafico.insertVertex(parent, 
                                                               null, 
                                                               this.nome, 
                                                               posx - 40, 
                                                               posy + 70, 
                                                               this.tamanhoLargura, 
                                                               this.tamanhoAltura, 
                                                               caracteristicas);
                
                this.grafico.insertEdge(parent, null, "U", especializacao.getCell(), this.cell,"startArrow=none;endArrow=none;strokeColor=red;");
            }
            finally{
                    this.especiaizacao = especializacao;
                    especializacao.getEntidades().add(this);
                    this.mapaGraficoEntidade.put( Integer.valueOf( this.cell.getId() ), this);
                    this.grafico.getModel().endUpdate();
            }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
   
    public TipoEntidadeEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoEntidadeEnum tipo) {
        this.tipo = tipo;
    }
    @XmlTransient
    public Especializacao getEspeciaizacao() {
        return especiaizacao;
    }

    public void setEspeciaizacao(Especializacao especiaizacao) {
        this.especiaizacao = especiaizacao;
    }
    @XmlElementWrapper
    public List<Relacionamento> getRelacionamentos() {
        return relacionamentos;
    }

    public void setRelacionamentos(List<Relacionamento> relacionamentos) {
        this.relacionamentos = relacionamentos;
    }
    @XmlElementWrapper
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
    public mxCell getCell() {
        return cell;
    }

    public void setCell(mxCell cell) {
        this.cell = cell;
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
    public HashMap<Integer, Entidade> getMapaGraficoEntidade() {
        return mapaGraficoEntidade;
    }

    public void setMapaGraficoEntidade(HashMap<Integer, Entidade> mapaGraficoEntidade) {
        this.mapaGraficoEntidade = mapaGraficoEntidade;
    }

      
}
