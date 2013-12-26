package br.pv.model;

public class Item {
	public static final String[] COLUNAS= {
		"id",
		"descricao",
		"figura"
	}; 
	
	private long id;
	private String descricao;
	private String figura;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getFigura() {
		return figura;
	}
	public void setFigura(String figura) {
		this.figura = figura;
	}
}
