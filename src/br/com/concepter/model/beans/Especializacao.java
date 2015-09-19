/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.concepter.model.beans;

import br.com.concepter.model.enuns.TipoEspecializacaoEnum;
import com.mxgraph.view.mxGraph;
import java.util.HashMap;

/**
 *
 * @author AllanMagnum
 */
public class Especializacao {
        private String nome;
	private mxGraph grafico; 
	private HashMap mapaGrafico;
	private float pX;
	private float pY;
	private int tamanhoLargura;
	private int tamanhoAltura;
        private TipoEspecializacaoEnum tipoEspecializacao;
	
	public Especializacao(mxGraph grafico, HashMap mapaGrafico, float pX, float pY, TipoEspecializacaoEnum tipoEspecializacao){
		this.grafico = grafico;
		this.mapaGrafico = mapaGrafico;
		this.tamanhoLargura = 20;
		this.tamanhoAltura = 20;
                this.pX = pX;
		this.pY = pY + 50;
                this.tipoEspecializacao = tipoEspecializacao;
	}
        
        public float getPX(){
            return this.pX;
        }
        
        public float getPY(){
            return this.pY;
        }
	
	public void add(Object entidade){
            
            if(tipoEspecializacao == TipoEspecializacaoEnum.DISJUNCAO){
                nome = "d";
            }
            if(tipoEspecializacao == TipoEspecializacaoEnum.SOBREPOSICAO){
                nome = "o";
            }
                
            
            this.grafico.getModel().beginUpdate();
            Object especializacao = null;
            Object subClasse_1 = null;
            Object subClasse_2 = null;
            Object parent = this.grafico.getDefaultParent();
            try{	
                especializacao = this.grafico.insertVertex(parent, null, this.nome, this.pX, this.pY, this.tamanhoLargura, this.tamanhoAltura, "shape=ellipse;");
                subClasse_1 = this.grafico.insertVertex(parent, null, "subClasse1", this.pX - 125, this.pY + 50, 100, 50, "fillColor=yellow;shape=rectangle;");
                subClasse_2 = this.grafico.insertVertex(parent, null, "subClasse2", this.pX + 50, this.pY + 50, 100, 50, "fillColor=yellow;shape=rectangle;");
                this.grafico.insertEdge(parent, null, null, especializacao, entidade,"startArrow=none;endArrow=none;");
                this.grafico.insertEdge(parent, null, "U", subClasse_1, especializacao,"startArrow=none;endArrow=none;");
                this.grafico.insertEdge(parent, null, "U", subClasse_2, especializacao,"startArrow=none;endArrow=none;");
            }
            
            finally{
                this.grafico.getModel().endUpdate();
            }
        }
}
