package br.com.concepter.model.beans;

import br.com.concepter.model.enuns.TipoObrigatoriedadeEnum;
import com.mxgraph.model.mxCell;
import com.mxgraph.view.mxGraph;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;

@XmlRootElement
public class Relacionamento{
    private String nome;
    private List<Atributo> atributos = new ArrayList<>();
    private HashMap<Entidade, Relacao> entidades = new HashMap<Entidade, Relacao>();
    private Agregacao agregacao = null;
    
    private mxGraph grafico;
    private mxCell cell;
    private double pY;
    private double pX;
    private int tamanhoLargura;
    private int tamanhoAltura;
    
    private HashMap mapaGraficoRelacionamentos;

    public Relacionamento() {
    }

    public Relacionamento(mxGraph grafico, HashMap mapaGraficoRelacionamentos, String nome, double pX, double pY){
            this.nome = nome;
            this.grafico = grafico;
            this.mapaGraficoRelacionamentos= mapaGraficoRelacionamentos;
            this.tamanhoLargura = 100;
            this.tamanhoAltura = 50;
            this.pX = pX;
            this.pY = pY;
    }
	
    public void add(Object entidade_agregacao, Entidade entidade_2){
            this.grafico.getModel().beginUpdate();
            Object relacionamento = null;
            Object parent = this.grafico.getDefaultParent();
            double posx = 0;
            double posy = 0;
            try{	
                if("br.com.concepter.model.beans.Entidade".equals(entidade_agregacao.getClass().getName())){
                    posx = ((Entidade)entidade_agregacao).getCell().getGeometry().getX();
                    posy = ((Entidade)entidade_agregacao).getCell().getGeometry().getY();
                    
                    this.entidades.put((Entidade)entidade_agregacao, new Relacao("N", TipoObrigatoriedadeEnum.PARCIAL));
                    
                    ((Entidade)entidade_agregacao).getRelacionamentos().add(this);
                    
                    entidade_agregacao = ((Entidade)entidade_agregacao).getCell();      
                }else{
                    posx = ((Agregacao)entidade_agregacao).getCell().getGeometry().getX();
                    posy = ((Agregacao)entidade_agregacao).getCell().getGeometry().getY();
                   
                    this.agregacao = (Agregacao)entidade_agregacao;
                    
                    entidade_agregacao = ((Agregacao)entidade_agregacao).getCell();
                }

                relacionamento =  this.grafico.insertVertex(parent, null, this.nome, posx + 160, posy, this.tamanhoLargura, this.tamanhoAltura, "fillColor=white;shape=rhombus;");
                
                this.grafico.insertEdge(parent, null, "N", entidade_agregacao, relacionamento,"startArrow=none;endArrow=none;strokeColor=red;fontSize=15;fontStyle=1;");
                this.grafico.insertEdge(parent, null, "M", entidade_2.getCell(), relacionamento,"startArrow=none;endArrow=none;strokeColor=red;fontSize=15;fontStyle=1;");


            }
            finally{
               
                this.entidades.put(entidade_2, new Relacao("N", TipoObrigatoriedadeEnum.PARCIAL));
                
                this.cell = (mxCell)relacionamento;
                
                entidade_2.getRelacionamentos().add(this);
                
                this.mapaGraficoRelacionamentos.put( Integer.valueOf( ((mxCell) relacionamento).getId() ), this);

                this.grafico.getModel().endUpdate();
            }
    }

    public void add(Object entidade_agregacao, Entidade entidade_2, Entidade entidade_3){
            this.grafico.getModel().beginUpdate();
            Object relacionamento = null;
            Object parent = this.grafico.getDefaultParent();
            double posx = 0;
            double posy = 0;
            
            try{	
                if("br.com.concepter.model.beans.Entidade".equals(entidade_agregacao.getClass().getName())){
                    posx = ((Entidade)entidade_agregacao).getCell().getGeometry().getX();
                    posy = ((Entidade)entidade_agregacao).getCell().getGeometry().getY();
                    
                    this.entidades.put(((Entidade)entidade_agregacao), new Relacao("N", TipoObrigatoriedadeEnum.PARCIAL));
                    
                    entidade_agregacao = ((Entidade)entidade_agregacao).getCell();      
                }else{
                    posx = ((Agregacao)entidade_agregacao).getCell().getGeometry().getX();
                    posy = ((Agregacao)entidade_agregacao).getCell().getGeometry().getY();
                   
                    this.agregacao = (Agregacao)entidade_agregacao;
                    
                    entidade_agregacao = ((Agregacao)entidade_agregacao).getCell();
                }

                relacionamento =  this.grafico.insertVertex(parent, null, this.nome, posx + 160, posy, this.tamanhoLargura, this.tamanhoAltura, "shape=rhombus;");

                this.grafico.insertEdge(parent, null, "N", entidade_agregacao, relacionamento,"startArrow=none;endArrow=none;strokeColor=red;fontSize=15;fontStyle=1;");
                this.grafico.insertEdge(parent, null, "M", entidade_2.getCell(), relacionamento,"startArrow=none;endArrow=none;strokeColor=red;fontSize=15;fontStyle=1;");
                this.grafico.insertEdge(parent, null, "O", entidade_3.getCell(), relacionamento,"startArrow=none;endArrow=none;strokeColor=red;fontSize=15;fontStyle=1;");

            }
            finally{
                this.entidades.put(entidade_2, new Relacao("N", TipoObrigatoriedadeEnum.PARCIAL));
                this.entidades.put(entidade_3, new Relacao("M", TipoObrigatoriedadeEnum.PARCIAL));
                
                this.cell = (mxCell)relacionamento;

                this.mapaGraficoRelacionamentos.put( Integer.valueOf( ((mxCell) relacionamento).getId() ), this);

                this.grafico.getModel().endUpdate();
            }
    }

    public void add(Object entidade_agregacao, Entidade entidade_2, Entidade entidade_3, Entidade entidade_4){
            this.grafico.getModel().beginUpdate();
            Object relacionamento = null;
            Object parent = this.grafico.getDefaultParent();

            double posx = 0;
            double posy = 0;
            try{	
                if("br.com.concepter.model.beans.Entidade".equals(entidade_agregacao.getClass().getName())){
                    posx = ((Entidade)entidade_agregacao).getCell().getGeometry().getX();
                    posy = ((Entidade)entidade_agregacao).getCell().getGeometry().getY();
                    
                    this.entidades.put(((Entidade)entidade_agregacao), new Relacao("N", TipoObrigatoriedadeEnum.PARCIAL));
                    
                    entidade_agregacao = ((Entidade)entidade_agregacao).getCell();      
                }else{
                    posx = ((Agregacao)entidade_agregacao).getCell().getGeometry().getX();
                    posy = ((Agregacao)entidade_agregacao).getCell().getGeometry().getY();
                   
                    this.agregacao = (Agregacao)entidade_agregacao;
                    
                    entidade_agregacao = ((Agregacao)entidade_agregacao).getCell();
                }

                relacionamento =  this.grafico.insertVertex(parent, null, this.nome, posx + 160, posy, this.tamanhoLargura, this.tamanhoAltura, "shape=rhombus;");

                this.grafico.insertEdge(parent, null, "N", entidade_agregacao, relacionamento,"startArrow=none;endArrow=none;strokeColor=red;fontSize=15;fontStyle=1;");
                this.grafico.insertEdge(parent, null, "M", entidade_2.getCell(), relacionamento,"startArrow=none;endArrow=none;strokeColor=red;fontSize=15;fontStyle=1;");
                this.grafico.insertEdge(parent, null, "O", entidade_3.getCell(), relacionamento,"startArrow=none;endArrow=none;strokeColor=red;fontSize=15;fontStyle=1;");
                this.grafico.insertEdge(parent, null, "P", entidade_4.getCell(), relacionamento,"startArrow=none;endArrow=none;strokeColor=red;fontSize=15;fontStyle=1;");
            }
            finally{
                this.entidades.put(entidade_2, new Relacao("N", TipoObrigatoriedadeEnum.PARCIAL));
                this.entidades.put(entidade_3, new Relacao("N", TipoObrigatoriedadeEnum.PARCIAL));
                this.entidades.put(entidade_4, new Relacao("N", TipoObrigatoriedadeEnum.PARCIAL));
                
                this.cell = (mxCell)relacionamento;
               
                this.mapaGraficoRelacionamentos.put( Integer.valueOf( ((mxCell) relacionamento).getId() ), this);

                this.grafico.getModel().endUpdate();
            }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Atributo> getAtributos() {
        return atributos;
    }

    public void setAtributos(List<Atributo> atributos) {
        this.atributos = atributos;
    }
    @XmlTransient
    public HashMap<Entidade, Relacao> getEntidades() {
        return entidades;
    }
    
    public void setEntidades(HashMap<Entidade, Relacao> entidades) {
        this.entidades = entidades;
    }

    public Agregacao getAgregacao() {
        return agregacao;
    }

    public void setAgregacao(Agregacao agregacao) {
        this.agregacao = agregacao;
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
    public double getpY() {
        return pY;
    }

    public void setpY(double pY) {
        this.pY = pY;
    }
    @XmlTransient
    public double getpX() {
        return pX;
    }

    public void setpX(double pX) {
        this.pX = pX;
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
 
    public HashMap getMapaGraficoRelacionamentos() {
        return mapaGraficoRelacionamentos;
    }

    public void setMapaGraficoRelacionamentos(HashMap mapaGraficoRelacionamentos) {
        this.mapaGraficoRelacionamentos = mapaGraficoRelacionamentos;
    }

    
    
}