package com.calc.app;

import com.calc.model.Decimal;
import com.calc.model.Entero;
import com.calc.model.Numero;

public class Aritmetica {

	public Aritmetica() {}

	
	public Numero suma(Numero n1, Numero n2) {
		Numero resultado = null;
		
		if(n1.getBase().equals(n2.getBase())) {
			
			if (n1 instanceof Entero && n2 instanceof Entero) {
				resultado = new Entero(n1.getValorEntero()+n2.getValorEntero());
				
			}else if(n1 instanceof Decimal && n2 instanceof Decimal) {
				resultado = new Decimal(n1.getValorEntero()+n2.getValorEntero(),
						((Decimal)n1).getValorDecimal()+((Decimal)n2).getValorDecimal(),
						n1.getBase()
				);
			}else if(n1 instanceof Decimal) {
				resultado = new Decimal(n1.getValorEntero()+n2.getValorEntero(),
						((Decimal)n1).getValorDecimal(),
						n1.getBase());
			}else {
				resultado = new Decimal(n1.getValorEntero()+n2.getValorEntero(),
						((Decimal)n2).getValorDecimal(),
						n1.getBase());
			}
			
		}
		
		return resultado;
	}
	
	public Numero resta(Numero n1, Numero n2) {
		Numero sustraer = null;
		if (n2 instanceof Decimal) {
			Decimal tmp = (Decimal)n2;
			sustraer = new Decimal(-tmp.getValorEntero(), -tmp.getValorDecimal(), tmp.getBase()); 
		}else {
			sustraer = new Entero(-n2.getValorEntero());
		}
		return suma(n1, sustraer);
	}
	
	
	public Numero calcularMedia(Object[] objs) {
		Numero acumulador = new Entero(0);
		
		for(int i=0; i<objs.length; i++) {
			acumulador = suma(acumulador, (Numero)objs[i]);
		}
		return new Decimal(acumulador.getValorEntero()/objs.length, 
						((Decimal)acumulador).getValorDecimal()*objs.length);
	}
}
