package br.pv.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class ContaRepositorio {

	private String[] scriptCreate={
		"CREATE TABLE itens (id integer PRIMARY KEY AUTOINCREMENT NOT NULL, descricao varchar(70) NOT NULL, figura varchar(30) NOT NULL);",
		"INSERT INTO itens(descricao,figura) VALUES('Guarana','guarana');",
		"INSERT INTO itens(descricao,figura) VALUES('Cerveja', 'cerveja');",
		"INSERT INTO itens(descricao,figura) VALUES('Batata frita','batata_frita');"
	};
	private String[] scriptDrop={
			"DROP TABLE IF EXISTS itens;"
	};
	private SQLiteDatabase db;
	
	public ContaRepositorio(Context contexto, String nome, int versao){
		Repositorio rep = new Repositorio(contexto, nome, versao, scriptCreate, scriptDrop);
		db = rep.getWritableDatabase();
	}
	
	public SQLiteDatabase getDatabase(){
		return this.db;
	}
}
