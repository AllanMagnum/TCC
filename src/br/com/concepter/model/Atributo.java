package br.com.concepter.model;

import br.com.concepter.model.enuns.TipoAtributoEnum;
import com.mxgraph.model.mxCell;
import java.util.HashMap;
import com.mxgraph.view.mxGraph;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Atributo {

    private String nome;
    protected Properties display;
    private mxGraph grafico; 
    private Entidade entidade;
    private Atributo atributo;
    private Relacionamento relacionamento;
    private Agregacao agregacao;
    private List<Atributo> atributos = new ArrayList<>();
    private HashMap<Integer, Object> mapaGraficoAtributos;
    private float pX;
    private float pY;
    private int tamanhoLargura;
    private int tamanhoAltura;
    private TipoAtributoEnum tipoAtributo;
    private mxCell forma;
    private Integer cont_Atributo;

    public Atributo(mxGraph grafico, HashMap<Integer, Object> mapaGraficoAtributos, TipoAtributoEnum tipoAtributo, String nome, float pX, float pY, Integer cont_Atributo){
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

    public TipoAtributoEnum getTipoAtributo() {
        return tipoAtributo;
    }

    public void setForma(mxCell forma) {
        this.forma = forma;
    }
    public mxCell getForma() {
        return forma;
    }

    public Entidade getEntidade() {
        return entidade;
    }

    public void setEntidade(Entidade entidade) {
        this.entidade = entidade;
    }

    public Atributo getAtributo() {
        return atributo;
    }

    public void setAtributo(Atributo atributo) {
        this.atributo = atributo;
    }

    public Relacionamento getRelacionamento() {
        return relacionamento;
    }

    public void setRelacionamento(Relacionamento relacionamento) {
        this.relacionamento = relacionamento;
    }

    public List<Atributo> getAtributos() {
        return atributos;
    }

    public void setAtributos(List<Atributo> atributos) {
        this.atributos = atributos;
    }

    public Agregacao getAgregacao() {
        return agregacao;
    }

    public void setAgregacao(Agregacao agregacao) {
        this.agregacao = agregacao;
    }
    
    public void add(Object entidade ){
        String caracteristicas = "";
        if(tipoAtributo.toString() == "simples"){
            caracteristicas = "shape=ellipse;";
        }
        if(tipoAtributo.toString() == "multivalorado"){
            caracteristicas = "shape=doubleEllipse;";
        }
        if(tipoAtributo.toString() == "derivado"){
            caracteristicas = "shape=ellipse;dashed=true;";
        }
        if(tipoAtributo.toString() == "chave"){
            caracteristicas = "shape=ellipse;fontStyle=1";
        }
        if(tipoAtributo.toString() == "composto"){
            caracteristicas = "shape=ellipse;";
        }

        this.grafico.getModel().beginUpdate();
        Object atributo = null;
        Object atributo_1 = null;
        Object atributo_2 = null;
        Object parent = this.grafico.getDefaultParent();
        try{
            double posx = ((mxCell) entidade).getGeometry().getX();
            double posy = ((mxCell) entidade).getGeometry().getY();

            atributo = this.grafico.insertVertex(parent, null, this.nome +  this.cont_Atributo, posx, posy - 50, this.tamanhoLargura, this.tamanhoAltura, caracteristicas);

            this.grafico.insertEdge(parent, null, null, atributo, entidade,"startArrow=none;endArrow=none;");

            if("composto".equals(tipoAtributo.toString())){
                this.cont_Atributo++;
                atributo_1 = this.grafico.insertVertex(parent, null, "Atributo" + this.cont_Atributo, this.pX - 55, this.pY - 50, this.tamanhoLargura, this.tamanhoAltura, "shape=ellipse;rounded=true;");
                Atributo atr_1 = new Atributo(this.grafico, this.mapaGraficoAtributos, TipoAtributoEnum.simples, "Atributo" + this.cont_Atributo, this.pX, this.pY, cont_Atributo);
                atr_1.setForma((mxCell) atributo_1);
                this.mapaGraficoAtributos.put( Integer.valueOf( ((mxCell) atributo_1).getId() ), atr_1 );
                
                this.cont_Atributo++;
                atributo_2 = this.grafico.insertVertex(parent, null, "Atributo" + this.cont_Atributo, this.pX + 55, this.pY - 50, this.tamanhoLargura, this.tamanhoAltura, "shape=ellipse;rounded=true;");
                Atributo atr_2 = new Atributo(this.grafico, this.mapaGraficoAtributos, TipoAtributoEnum.simples, "Atributo" + this.cont_Atributo, this.pX, this.pY, cont_Atributo);
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
}
