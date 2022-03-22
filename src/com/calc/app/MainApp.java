package com.calc.app;

import static com.calc.utils.CollectionUtils.deleteNulls;
import static com.calc.utils.CollectionUtils.printCol;

import com.calc.model.Decimal;
import com.calc.model.Entero;
import com.calc.model.Numero;

public class MainApp {

	public static void main(String[] args) {

		Aritmetica ari = new Aritmetica();
		
		try {
			Numero ne1 = new Entero(3);
			Numero ne2 = new Entero(2);
			System.out.println(ari.suma(ne1, ne2));
			System.out.println(ari.resta(ne1, ne2));
			
			
			Numero nd1 = new Decimal(15, 3);
			Numero nd2 = new Decimal(25, 3);
			System.out.println(ari.suma(nd1, nd2));
			System.out.println(ari.resta(nd1, nd2));
			
			Numero[] lista = new Numero[10];
			lista[1]=ne1;
			lista[2]=ne2;
			lista[3]=nd1;
			lista[6]=nd2;
			
			System.out.println(ari.calcularMedia(deleteNulls(lista)));
			System.out.println(printCol(deleteNulls(lista)));
			Numero nd3 = new Decimal(250000000, 3);

			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

		
		
	}

}
