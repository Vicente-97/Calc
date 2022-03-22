package com.calc.model;

public class Entero extends Numero {

	private static final int VALOR_MINIMO = -100000;
	private static final int VALOR_MAXIMO = 100001;

	
	
	
	public Entero(int value, Base base) {
		super(value, base);
	}
	
	public Entero(int value) {
		super(value);
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

}
