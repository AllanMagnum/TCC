package br.com.concepter.model.beans;

import com.mxgraph.model.mxCell;
import com.mxgraph.view.mxGraph;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Relacionamento {
    private String nome;
    private mxGraph grafico;
    private List<Atributo> atributos = new ArrayList<>();
    private List<Entidade> entidades = new ArrayList<>();
    private HashMap mapaGraficoEntidades;
    private HashMap mapaGraficoRelacionamentos;
    private float pY;
    private float pX;
    private int tamanhoLargura;
    private int tamanhoAltura;
    private mxCell cell;

    public Relacionamento(mxGraph grafico, HashMap mapaGraficoEntidades, HashMap mapaGraficoRelacionamentos, String nome, float pX, float pY){
            this.nome = nome;
            this.grafico = grafico;
            this.mapaGraficoEntidades= mapaGraficoEntidades;
            this.mapaGraficoRelacionamentos= mapaGraficoRelacionamentos;
            this.tamanhoLargura = 100;
            this.tamanhoAltura = 50;
            this.pX = pX;
            this.pY = pY;
    }
	
    public void add(Entidade entidade_1, Entidade entidade_2){
            this.grafico.getModel().beginUpdate();
            Object relacionamento = null;
            Object parent = this.grafico.getDefaultParent();

            try{	
                double posx = entidade_1.getCell().getGeometry().getX();
                double posy = entidade_1.getCell().getGeometry().getY();

                relacionamento =  this.grafico.insertVertex(parent, null, this.nome, posx + 160, posy, this.tamanhoLargura, this.tamanhoAltura, "fillColor=white;shape=rhombus;");

                this.grafico.insertEdge(parent, null, "N-M", entidade_1.getCell(), relacionamento,"startArrow=none;endArrow=none;strokeColor=red;edgeStyle=elbowEdgeStyle;elbow=horizontal;orthogonal=0;");
                this.grafico.insertEdge(parent, null, "N-M", entidade_2.getCell(), relacionamento,"startArrow=none;endArrow=none;strokeColor=red;");


            }
            finally{
                this.entidades.add(entidade_1);
                this.entidades.add(entidade_2);
                
                this.cell = (mxCell)relacionamento;
                
                this.mapaGraficoRelacionamentos.put( Integer.valueOf( ((mxCell) relacionamento).getId() ), this);

                this.grafico.getModel().endUpdate();
            }
    }

    public void add(Entidade entidade_1, Entidade entidade_2, Entidade entidade_3){
            this.grafico.getModel().beginUpdate();
            Object relacionamento = null;
            Object parent = this.grafico.getDefaultParent();

            try{	
                double posx = entidade_1.getCell().getGeometry().getX();
                double posy = entidade_1.getCell().getGeometry().getY();

                relacionamento =  this.grafico.insertVertex(parent, null, this.nome, posx + 160, posy, this.tamanhoLargura, this.tamanhoAltura, "shape=rhombus;");

                this.grafico.insertEdge(parent, null, "N-M", entidade_1.getCell(), relacionamento,"startArrow=none;endArrow=none;strokeColor=red;");
                this.grafico.insertEdge(parent, null, "N-M", entidade_2.getCell(), relacionamento,"startArrow=none;endArrow=none;strokeColor=red;");
                this.grafico.insertEdge(parent, null, "N-M", entidade_3.getCell(), relacionamento,"startArrow=none;endArrow=none;strokeColor=red;");

            }
            finally{
                this.entidades.add(entidade_1);
                this.entidades.add(entidade_2);
                this.entidades.add(entidade_3);
                
                this.cell = (mxCell)relacionamento;

                this.mapaGraficoRelacionamentos.put( Integer.valueOf( ((mxCell) relacionamento).getId() ), this);

                this.grafico.getModel().endUpdate();
            }
    }

    public void add(Entidade entidade_1, Entidade entidade_2, Entidade entidade_3, Entidade entidade_4){
            this.grafico.getModel().beginUpdate();
            Object relacionamento = null;
            Object parent = this.grafico.getDefaultParent();

            try{	
                double posx = entidade_1.getCell().getGeometry().getX();
                double posy = entidade_1.getCell().getGeometry().getY();

                relacionamento =  this.grafico.insertVertex(parent, null, this.nome, posx + 160, posy, this.tamanhoLargura, this.tamanhoAltura, "shape=rhombus;");

                this.grafico.insertEdge(parent, null, "N-M", entidade_1.getCell(), relacionamento,"startArrow=none;endArrow=none;strokeColor=red;");
                this.grafico.insertEdge(parent, null, "N-M", entidade_2.getCell(), relacionamento,"startArrow=none;endArrow=none;strokeColor=red;");
                this.grafico.insertEdge(parent, null, "N-M", entidade_3.getCell(), relacionamento,"startArrow=none;endArrow=none;strokeColor=red;");
                this.grafico.insertEdge(parent, null, "N-M", entidade_4.getCell(), relacionamento,"startArrow=none;endArrow=none;strokeColor=red;");
            }
            finally{
                this.entidades.add(entidade_1);
                this.entidades.add(entidade_2);
                this.entidades.add(entidade_3);
                this.entidades.add(entidade_4);
                
                this.cell = (mxCell)relacionamento;
               
                this.mapaGraficoRelacionamentos.put( Integer.valueOf( ((mxCell) relacionamento).getId() ), this);

                this.grafico.getModel().endUpdate();
            }
    }

    public List<Entidade> getEntidades() {
        return entidades;
    }

    public void setEntidades(List<Entidade> entidades) {
        this.entidades = entidades;
    }

    public mxCell getCell() {
        return cell;
    }

    public void setCell(mxCell cell) {
        this.cell = cell;
    }
    
    public List<Atributo> getAtributos() {
        return atributos;
    }

    public void setAtributos(List<Atributo> atributos) {
        this.atributos = atributos;
    }
    
}