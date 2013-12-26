package br.pv;

import java.util.ArrayList;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import br.pv.model.ContaRepositorio;
import br.pv.model.Item;

public class CardapioAdapter extends BaseAdapter {
	private ArrayList<Item> figuras;
	public CardapioAdapter(Context contexto, String nome, int versao) {
		figuras = new ArrayList<Item>();
		ContaRepositorio rep = new ContaRepositorio(contexto, nome, versao);
		SQLiteDatabase db = rep.getDatabase();
		Cursor cursor = db.query("itens",Item.COLUNAS , null, null, null, null, null);
		cursor.moveToFirst();
		for(int x=0, total=cursor.getCount();x<total;x++,cursor.moveToNext()){
			Item item = new Item();
			item.setId(cursor.getLong(0));
			item.setDescricao(cursor.getString(1));
			item.setFigura(cursor.getString(2));
			figuras.add(item);
		}
	}
	@Override
	public int getCount() {
		return figuras.size();
	}

	@Override
	public Object getItem(int position) {
		return figuras.get(position);
	}

	@Override
	public long getItemId(int position) {
		return figuras.get(position).getId();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.item,null);
		return view;
	}

}
