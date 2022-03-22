package com.calc.model;

import java.util.Objects;

public class Decimal extends Numero{

	private int valorDecimal;
	
	private static final int VALOR_MINIMO = -100000;
	private static final int VALOR_MAXIMO = 100001;
	
	
	
	public Decimal(int value, Base base) {
		super(value, base);
		setValorDecimal(0);
	}

	
	public Decimal(int value, int valorDecimal, Base base) {
		super(value, base);
		setValorDecimal(valorDecimal);
	}
	
	public Decimal(int value, int valorDecimal) {
		super(value);
		setValorDecimal(valorDecimal);
	}
	
	@Override
	protected void setValorEntero(int valorEntero) {
		
		String aCadena = String.valueOf(valorEntero);
		for (int i=0; i<aCadena.length(); i++ ) {
			if(Character.isLetter(i)) {
				throw new NumeroException("Un número decimal|binario no contiene letras");
			}
		}
		
		if(Base.BINARIO.equals(this.base)) {
			for (int i=0; i<aCadena.length(); i++ ) {
				if(i!='1' && i!='0') {
					throw new NumeroException("Un número binario solo contiene 0s y 1s");
				}
			}			
		}
		
		if(valorEntero > VALOR_MAXIMO) {
			throw new NumeroException("El valor introducido es mayor de lo permitido");
		}else if(valorEntero < VALOR_MINIMO) {
			throw new NumeroException("El valor introducido es menor de lo permitido");
		}
		
		this.valorEntero=valorEntero;
	}
	
	
	private void setValorDecimal(int valorDecimal) {
		
		String aCadena = String.valueOf(valorDecimal);
		
		for (int i=0; i<aCadena.length(); i++ ) {
			if(Character.isLetter(i)) {
				throw new NumeroException("Un número decimal|binario no contiene letras");
			}
		}
		
		if(Base.BINARIO.equals(this.base)) {
			for (int i=0; i<aCadena.length(); i++ ) {
				if(i!='1' && i!='0') {
					throw new NumeroException("Un número binario solo contiene 0s y 1s");
				}
			}			
		}
		this.valorDecimal=valorDecimal;
	}


	public int getValorDecimal() {
		return valorDecimal;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(valorDecimal);
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		return super.equals(obj) && ((Decimal) obj).getValorDecimal()==this.valorDecimal;

	}
	
	public String toString() {
		return super.toString()+" y valor decimal "+this.valorDecimal;
	}
	
}
