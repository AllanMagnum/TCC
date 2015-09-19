package br.com.concepter.model.beans;

import com.mxgraph.model.mxCell;
import com.mxgraph.view.mxGraph;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Agregacao {
    private String nome;
    private mxGraph grafico;
    private HashMap mapaGraficoAgregacao;
    private HashMap mapaGraficoRelacionamentos;
    private List<Atributo> atributos = new ArrayList<>();
    private float pY;
    private float pX;
    private int tamanhoLargura;
    private int tamanhoAltura;

    public Agregacao(mxGraph grafico, HashMap mapaGraficoAgregacao, HashMap mapaGraficoRelacionamentos, String nome, float pX, float pY){
            this.nome = nome;
            this.grafico = grafico;
            this.mapaGraficoAgregacao= mapaGraficoAgregacao;
            this.mapaGraficoRelacionamentos= mapaGraficoRelacionamentos;
            this.tamanhoLargura = 140;
            this.tamanhoAltura = 90;
            this.pX = pX;
            this.pY = pY;
    }

    public List<Atributo> getAtributos() {
        return atributos;
    }

    public void setAtributos(List<Atributo> atributos) {
        this.atributos = atributos;
    }
        	
    public void add(Object relacionamento, Object entidade_1){
            this.grafico.getModel().beginUpdate();
            Object agregacao = null;
            Object parent = this.grafico.getDefaultParent();

            try{	
                double posx = ((mxCell) relacionamento).getGeometry().getX() -20;
                double posy = ((mxCell) relacionamento).getGeometry().getY() -20;

               agregacao = this.grafico.insertVertex(parent, null, null, posx, posy, this.tamanhoLargura, tamanhoAltura, "verticalAlign=top;fillColor=none;shape=rectangle;");


               ((mxCell) relacionamento).getGeometry().setRect(20, 20, 100, 50);

               this.grafico.addCell(relacionamento, agregacao);

               relacionamento =  this.grafico.insertVertex(parent, null, "Relacionamento", posx + 220, posy + 20, 100, 50, "shape=rhombus;");

               this.grafico.insertEdge(parent, null, "N-M", agregacao, relacionamento,"startArrow=none;endArrow=none;strokeColor=red;");
               this.grafico.insertEdge(parent, null, "N-M", entidade_1, relacionamento,"startArrow=none;endArrow=none;strokeColor=red;"); 
            }
            finally{
                this.mapaGraficoAgregacao.put( Integer.valueOf( ((mxCell) agregacao).getId() ), this ) ;
                this.mapaGraficoRelacionamentos.put( Integer.valueOf( ((mxCell) relacionamento).getId() ), this ) ;
                this.grafico.getModel().endUpdate();
            }
    }

    public void add(Object relacionamento, Object entidade_1, Object entidade_2){
            this.grafico.getModel().beginUpdate();
            Object agregacao = null;
            Object parent = this.grafico.getDefaultParent();

            try{	
                double posx = ((mxCell) relacionamento).getGeometry().getX() -20;
                double posy = ((mxCell) relacionamento).getGeometry().getY() -20;

                agregacao = this.grafico.insertVertex(parent, null, null, posx, posy, this.tamanhoLargura, tamanhoAltura, "verticalAlign=top;fillColor=none;shape=rectangle;rounded=true;");

                ((mxCell) relacionamento).getGeometry().setRect(20, 30, 100, 50);

                this.grafico.addCell(relacionamento, agregacao);

                relacionamento =  this.grafico.insertVertex(parent, null, "Relacionamento", posx + 220, posy + 20, 100, 50, "shape=rhombus;");

                this.grafico.insertEdge(parent, null, "N-M", agregacao, relacionamento,"startArrow=none;endArrow=none;strokeColor=red;");
                this.grafico.insertEdge(parent, null, "N-M", entidade_1, relacionamento,"startArrow=none;endArrow=none;strokeColor=red;");
                this.grafico.insertEdge(parent, null, "N-M", entidade_2, relacionamento,"startArrow=none;endArrow=none;strokeColor=red;");

            }
            finally{
                this.mapaGraficoAgregacao.put( Integer.valueOf( ((mxCell) agregacao).getId() ), this ) ;
                this.mapaGraficoRelacionamentos.put( Integer.valueOf( ((mxCell) relacionamento).getId() ), this ) ;
                this.grafico.getModel().endUpdate();
            }
    }

    public void add(Object relacionamento, Object entidade_1, Object entidade_2, Object entidade_3){
            this.grafico.getModel().beginUpdate();
            Object agregacao = null;
            Object parent = this.grafico.getDefaultParent();

            try{	
                double posx = ((mxCell) relacionamento).getGeometry().getX() -20;
                double posy = ((mxCell) relacionamento).getGeometry().getY() -20;

                agregacao = this.grafico.insertVertex(parent, null, null, posx, posy, this.tamanhoLargura, tamanhoAltura, "verticalAlign=top;fillColor=none;shape=rectangle;");

                ((mxCell) relacionamento).getGeometry().setRect(20, 30, 100, 50);

                this.grafico.addCell(relacionamento, agregacao);

                relacionamento =  this.grafico.insertVertex(parent, null, "Relacionamento", posx + 220, posy + 20, 100, 50, "shape=rhombus;");

                this.grafico.insertEdge(parent, null, "N-M", agregacao, relacionamento,"startArrow=none;endArrow=none;strokeColor=red;");
                this.grafico.insertEdge(parent, null, "N-M", entidade_1, relacionamento,"startArrow=none;endArrow=none;strokeColor=red;");
                this.grafico.insertEdge(parent, null, "N-M", entidade_2, relacionamento,"startArrow=none;endArrow=none;strokeColor=red;");
                this.grafico.insertEdge(parent, null, "N-M", entidade_3, relacionamento,"startArrow=none;endArrow=none;strokeColor=red;");
            }
            finally{
                this.mapaGraficoAgregacao.put( Integer.valueOf( ((mxCell) agregacao).getId() ), this ) ;
                this.mapaGraficoRelacionamentos.put( Integer.valueOf( ((mxCell) relacionamento).getId() ), this ) ;
                this.grafico.getModel().endUpdate();
            }
    }
}