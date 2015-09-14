package br.com.concepter.model;

import br.com.concepter.model.enuns.TipoEntidadeEnum;
import com.mxgraph.model.mxCell;
import com.mxgraph.view.mxGraph;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Entidade{

    private String nome;
    private TipoEntidadeEnum tipoEntidade;
    private List<Object> relacionamentos;
    private List<Atributo> atributos = new ArrayList<>();
    private mxGraph grafico;
    private Integer cont_entidade;
    private HashMap<Integer, Object> mapaGrafico;
    private float pX;
    private float pY;
    private int tamanhoLargura;
    private int tamanhoAltura;
    private Object cell;

    public Entidade(mxGraph grafico, HashMap<Integer, Object> mapaGrafico, Integer cont_entidade, String nome,float pX, float pY){
            this.nome = nome;
            this.tipoEntidade = tipoEntidade;
            this.grafico = grafico;
            this.cont_entidade = cont_entidade;
            this.mapaGrafico = mapaGrafico;
            this.tamanhoLargura = 100;
            this.tamanhoAltura = 50;
            this.pX = pX;
            this.pY = pY;
            this.relacionamentos = new ArrayList<Object>();
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
	
    public void add(TipoEntidadeEnum tipoEntidade){

            this.grafico.getModel().beginUpdate();
            Object entidade = null;
            Object parent = this.grafico.getDefaultParent();
            String caracteristicas = "";
            if(tipoEntidade.toString() == "forte"){
                caracteristicas = "fillColor=yellow;shape=rectangle;";
            }
            if(tipoEntidade.toString() == "fraco"){
                caracteristicas = "fillColor=yellow;shape=doubleRectangle;";
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
                    // Updates the display
                    this.cell = entidade;
                    this.mapaGrafico.put( Integer.valueOf( ((mxCell) entidade).getId() ), this);
                    this.grafico.getModel().endUpdate();
            }
    }
}
