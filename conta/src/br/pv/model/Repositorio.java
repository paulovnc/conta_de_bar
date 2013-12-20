package br.pv.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Repositorio extends SQLiteOpenHelper {
	private String[] scriptCreate;
	private String[] scriptDrop;
	
	public Repositorio(Context contexto, String nomeBanco, int versao, String[] scriptCreate, String[] scriptDrop ){
		super(contexto, nomeBanco, null, versao);
		this.scriptCreate = scriptCreate;
		this.scriptDrop = scriptDrop;
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		for(int x = 0, total = scriptCreate.length; x<total;x++){
			db.execSQL(scriptCreate[x]);
		}
		
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		for(int x = 0, total = scriptDrop.length; x<total;x++){
			db.execSQL(scriptDrop[x]);
		}
	}

}
