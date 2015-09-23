package br.com.concepter.model.beans;

import br.com.concepter.model.enuns.TipoEntidadeEnum;
import com.mxgraph.model.mxCell;
import com.mxgraph.view.mxGraph;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Entidade{

    private String nome;
    private TipoEntidadeEnum tipo;
    private List<Object> relacionamentos;
    private List<Atributo> atributos = new ArrayList<>();
    private mxGraph grafico;
    private Integer cont_entidade;
    private HashMap<Integer, Entidade> mapaGrafico;
    private float pX;
    private float pY;
    private int tamanhoLargura;
    private int tamanhoAltura;
    private mxCell cell;

    public Entidade(mxGraph grafico, HashMap<Integer, Entidade> mapaGrafico, Integer cont_entidade, String nome,float pX, float pY, TipoEntidadeEnum tipo){
            this.nome = nome;
            this.tipo = tipo;
            this.relacionamentos = new ArrayList<Object>();
            this.grafico = grafico;
            this.cont_entidade = cont_entidade;
            this.mapaGrafico = mapaGrafico;
            this.tamanhoLargura = 100;
            this.tamanhoAltura = 50;
            this.pX = pX;
            this.pY = pY;
    }
	
    public void add(){

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
                    this.mapaGrafico.put( Integer.valueOf( ((mxCell) entidade).getId() ), this);
                    this.grafico.getModel().endUpdate();
            }
    }
    
    
    public float getPX(){
        return this.pX;
    }

    public float getPY(){
        return this.pY;
    }

    public List<Object> getRelacionamentos() {
        return relacionamentos;
    }

    public void setRelacionamentos(List<Object> relacionamentos) {
        this.relacionamentos = relacionamentos;
    }   

    public List<Atributo> getAtributos() {
        return atributos;
    }

    public void setAtributos(List<Atributo> atributos) {
        this.atributos = atributos;
    }

    public mxCell getCell() {
        return cell;
    }

    public void setCell(mxCell cell) {
        this.cell = cell;
    }
    
}
