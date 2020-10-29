package Logica;

public class MiExcepcion extends Exception{
     
    private String codigoError;
     
    public MiExcepcion(String codigoError){
        super();
        this.codigoError=codigoError;
    }  
}
