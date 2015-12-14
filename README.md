Conjunto de métodos para el analisis de llaves y/o paréntesis en una cadena, validando si esta o no balanceada.

La clase no cuenta con dos mètodos para la validacion de una sola clase de llaveque son : 
	validationString(String A,char open, char close)
	validationString_Format(String A, String rules)

Ambos métodos validan el balance de llaves o parétesis.
validationString_Format, permite el envio de una cadena que contenga los elementos a analizar, en la primer caracter se encuentra la apertura y en el segundo el cierre.
	Ejemplo:
	
	String Cadena = "()" o String Cadena_2 = "{}"

Para validación de multiples llaves o perentesis cuenta con el método:

	public boolean multipleValidation(String A,String params)

Permite enviar parametros múltiples en el campo "params" al igual que el metodo validationString_Format

Para el envio de multiples parámetros, requiere separar en grupos de dos por comas
	Ejemplo:
	
	String Cadena = "(),{},[]"


