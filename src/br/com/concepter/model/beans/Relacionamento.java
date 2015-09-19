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
    private HashMap mapaGraficoEntidades;
    private HashMap mapaGraficoRelacionamentos;
    private float pY;
    private float pX;
    private int tamanhoLargura;
    private int tamanhoAltura;

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

    public List<Atributo> getAtributos() {
        return atributos;
    }

    public void setAtributos(List<Atributo> atributos) {
        this.atributos = atributos;
    }
	
    public void add(Object entidade_1, Object entidade_2){
            this.grafico.getModel().beginUpdate();
            Object relacionamento = null;
            Object parent = this.grafico.getDefaultParent();

            try{	
                double posx = ((mxCell) entidade_1).getGeometry().getX();
                double posy = ((mxCell) entidade_1).getGeometry().getY();

                relacionamento =  this.grafico.insertVertex(parent, null, this.nome, posx + 160, posy, this.tamanhoLargura, this.tamanhoAltura, "shape=rhombus;");

                this.grafico.insertEdge(parent, null, "N-M", entidade_1, relacionamento,"startArrow=none;endArrow=none;strokeColor=red;edgeStyle=elbowEdgeStyle;elbow=horizontal;orthogonal=0;");
                this.grafico.insertEdge(parent, null, "N-M", entidade_2, relacionamento,"startArrow=none;endArrow=none;strokeColor=red;");


            }
            finally{
                Entidade entidade1 = (Entidade) this.mapaGraficoEntidades.get( Integer.parseInt( ((mxCell) entidade_1).getId() ));
                entidade1.getRelacionamentos().add(entidade_2);

                Entidade entidade2 = (Entidade) this.mapaGraficoEntidades.get( Integer.parseInt( ((mxCell) entidade_2).getId() ));
                entidade2.getRelacionamentos().add(entidade_1);

                this.mapaGraficoRelacionamentos.put( Integer.valueOf( ((mxCell) relacionamento).getId() ), this);

                this.grafico.getModel().endUpdate();
            }
    }

    public void add(Object entidade_1, Object entidade_2, Object entidade_3){
            this.grafico.getModel().beginUpdate();
            Object relacionamento = null;
            Object parent = this.grafico.getDefaultParent();

            try{	
                double posx = ((mxCell) entidade_1).getGeometry().getX();
                double posy = ((mxCell) entidade_1).getGeometry().getY();

                relacionamento =  this.grafico.insertVertex(parent, null, this.nome, posx + 160, posy, this.tamanhoLargura, this.tamanhoAltura, "shape=rhombus;");

                this.grafico.insertEdge(parent, null, "N-M", entidade_1, relacionamento,"startArrow=none;endArrow=none;strokeColor=red;");
                this.grafico.insertEdge(parent, null, "N-M", entidade_2, relacionamento,"startArrow=none;endArrow=none;strokeColor=red;");
                this.grafico.insertEdge(parent, null, "N-M", entidade_3, relacionamento,"startArrow=none;endArrow=none;strokeColor=red;");

            }
            finally{
                Entidade entidade1 = (Entidade) this.mapaGraficoEntidades.get(Integer.parseInt( ((mxCell) entidade_1).getId() ));
                entidade1.getRelacionamentos().add(entidade_2);
                entidade1.getRelacionamentos().add(entidade_3);

                Entidade entidade2 = (Entidade) this.mapaGraficoEntidades.get(Integer.parseInt( ((mxCell) entidade_2).getId() ));
                entidade2.getRelacionamentos().add(entidade_1);
                entidade2.getRelacionamentos().add(entidade_3);

                Entidade entidade3 = (Entidade) this.mapaGraficoEntidades.get(Integer.parseInt( ((mxCell) entidade_3).getId() ));
                entidade3.getRelacionamentos().add(entidade_1);
                entidade3.getRelacionamentos().add(entidade_2);

                this.mapaGraficoRelacionamentos.put( Integer.valueOf( ((mxCell) relacionamento).getId() ), this);

                this.grafico.getModel().endUpdate();
            }
    }

    public void add(Object entidade_1, Object entidade_2, Object entidade_3, Object entidade_4){
            this.grafico.getModel().beginUpdate();
            Object relacionamento = null;
            Object parent = this.grafico.getDefaultParent();

            try{	
                double posx = ((mxCell) entidade_1).getGeometry().getX();
                double posy = ((mxCell) entidade_1).getGeometry().getY();

                relacionamento =  this.grafico.insertVertex(parent, null, this.nome, posx + 160, posy, this.tamanhoLargura, this.tamanhoAltura, "shape=rhombus;");

                this.grafico.insertEdge(parent, null, "N-M", entidade_1, relacionamento,"startArrow=none;endArrow=none;strokeColor=red;");
                this.grafico.insertEdge(parent, null, "N-M", entidade_2, relacionamento,"startArrow=none;endArrow=none;strokeColor=red;");
                this.grafico.insertEdge(parent, null, "N-M", entidade_3, relacionamento,"startArrow=none;endArrow=none;strokeColor=red;");
                this.grafico.insertEdge(parent, null, "N-M", entidade_4, relacionamento,"startArrow=none;endArrow=none;strokeColor=red;");
            }
            finally{
                Entidade entidade1 = (Entidade) this.mapaGraficoEntidades.get(Integer.parseInt( ((mxCell) entidade_1).getId() ));
                entidade1.getRelacionamentos().add(entidade_2);
                entidade1.getRelacionamentos().add(entidade_3);
                entidade1.getRelacionamentos().add(entidade_4);

                Entidade entidade2 = (Entidade) this.mapaGraficoEntidades.get(Integer.parseInt( ((mxCell) entidade_2).getId() ));
                entidade2.getRelacionamentos().add(entidade_1);
                entidade2.getRelacionamentos().add(entidade_3);
                entidade2.getRelacionamentos().add(entidade_4);

                Entidade entidade3 = (Entidade) this.mapaGraficoEntidades.get(Integer.parseInt( ((mxCell) entidade_3).getId() ));
                entidade3.getRelacionamentos().add(entidade_1);
                entidade3.getRelacionamentos().add(entidade_2);
                entidade3.getRelacionamentos().add(entidade_4);

                Entidade entidade4 = (Entidade) this.mapaGraficoEntidades.get(Integer.parseInt( ((mxCell) entidade_4).getId() ));
                entidade4.getRelacionamentos().add(entidade_1);
                entidade4.getRelacionamentos().add(entidade_2);
                entidade4.getRelacionamentos().add(entidade_3);

                this.mapaGraficoRelacionamentos.put( Integer.valueOf( ((mxCell) relacionamento).getId() ), this);

                this.grafico.getModel().endUpdate();
            }
    }
}