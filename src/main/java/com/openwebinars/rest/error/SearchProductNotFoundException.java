package com.openwebinars.rest.error;

public class SearchProductNotFoundException extends RuntimeException{

    public SearchProductNotFoundException(){
        super("La búsqueda de productos no produjo resultados");
    }

    public SearchProductNotFoundException(String mensaje){
        super(String.format("EL termino de busqueda %s no produjo resultados", mensaje));
    }



}
