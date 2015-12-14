//package analizador;

/**
 * OnlyDevelopers.
 * @author Created by Elihu Cruz Albores on 09/12/15.
 * @version 1.1
 */

import java.util.Stack;

public class KeysCheck {
    
    private Stack<String> Validation;
    private int count;
    
    public KeysCheck(){
        this.Validation = new Stack<>();
    }
    
    /**
     *@param A : String la cadena a validar, con un solo tipo de llave
     *         u operando, la validacion solo considera la cadena enviada con base
     *         en los datos de apertura y cierre
     *@param open : Char que indica el caracter de apertura a validar solo puede
     *            ser validado en caso de considir con la cadena recivida.
     *@param close: Char que contirne el caracter de cierre en la validacion. el cierre de
     *            la validacion se basa en el caracter recivido
     *@return boolean : con los resultados de la validacion de caracteres.
     */
    public boolean validationString(String A, char open, char close){
        //Analizamos la cadena recibida para detectar si el numero de
        //Parentesis o llaves esta equilibrado.
        //De lo contrario devolvemos un error.
        
        for (int i = 0; i < A.length() ; i++){
            
            //Almacenamos el caracter para evitar doble carga
            char Current = A.charAt(i);
            
            //Validamos la posicion de la llave de apertura.
            if(Current == open){
                
                Validation.add("" + Current);
                count++;
                
            }else if(Current == close){
                //De lo contrario verificamos si se trata de un cierre
                //Consideramos el caso en el que el stack esta vacio
                
                if(Validation.isEmpty()){//Devolvemos falso
                    return false;
                }else{
                    Validation.pop();
                }
            }
        }
        
        return (Validation.isEmpty());
    }
    
    /**
     *@param A : String la cadena a validar, con un solo tipo de llave
     *         u operando, la validacion solo considera la cadena enviada con base
     *         en los datos de apertura y cierre
     *@param rules : recive un string que contiene los datos de los parametros
     *             a validar\n<strong>En la primer posición o caracter cuenta
     *             con el caracter de apertura a validar y en el segundo el caracter
     *             de cierre</>
     *@return boolean : con los resultados de la validacion de caracteres.
     */
    public boolean validationString_Format(String A, String rules){
        //Analizamos la cadena recibida este equilibrada en parentesis
        char open = rules.charAt(0), close = rules.charAt(1);
        
        for (int i = 0; i < A.length() ; i++){
            
            //Almacenamos el caracter para evitar doble carga
            char Current = A.charAt(i);
            
            //Validamos la posicion de la llave de apertura.
            if(Current == open){
                
                Validation.add("" + Current);
                count++;
                
            }else if(Current == close){
                //De lo contrario verificamos si se trata de un cierre
                //Consideramos el caso en el que el stack esta vacio
                
                if(Validation.isEmpty()){//Devolvemos falso
                    return false;
                }else{
                    Validation.pop();
                }
            }
        }
        
        return (Validation.isEmpty());
    }
    
    /**
     * Validacion de llaves y perentesis con parametros multiples.
     * @param A : String que contiene la cadena a validar.
     * @param params : Argumentos o conjunto de llaves y/o parentesis que se desean analizar dentro del stack.
     * @return Resultado de la validacion de llaves o perentesis.
     */
    public boolean multipleValidation(String A,String params){
        
        //Verificamos los parametros de validacion separados por comas
        //Validacion de parametros de entrada
        
        //Una ves validado
        
        
        if(!(validationParams(params))){
            System.out.println("Los parametros a evaluar deben contener dos elmentos.");
            return false;
        }
        
        String [] paramsVector = params.split(",");
        
        //Validacion de cadena
        
        
        for(int i = 0; i < A.length(); i++){
            
            char current = A.charAt(i);//Buffer caracter
            for(int j = 0; j < paramsVector.length; j++){
                
                char open  = paramsVector[j].charAt(0);
                char close = paramsVector[j].charAt(1);
                
                if(current == open){
                    Validation.add("" + current);
                    count++;
                }else if(current == close){
                    
                    if(Validation.isEmpty()){
                        return false;
                    }else{
                        
                        if(Validation.peek().equals("" + open)){
                            Validation.pop();
                        }
                    }
                }
            }
        }
        
        return (Validation.isEmpty());
    }
    
    /**
     * Validacion de los parametros de entrada a validar
     * @param A : Cadena que contriene al conjunto de argumentos para validar un cadena.
     * @return Resultado de la validacion, para argumentos.
     */
    protected boolean validationParams(String A){
        
        String [] paramsVector = A.split(",");
        for(int i = 0; i < A.length() ; i++){
            //Verificamos que cada parametro tenga dos elementos.
            if(!(paramsVector.length != 2)){
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * Contador de parentesis de apertura de la ultima validacion realizada
     * @return count un valor entero del numero de parentesis de apertura
     * encontrados al analizar ultima cadena.
     */
    public int getCount() {
        return count;
    }
    
    public boolean restart(){
        this.Validation = new Stack<>();
        return true;
    }
}
