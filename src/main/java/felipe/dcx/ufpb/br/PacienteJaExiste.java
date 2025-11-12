package felipe.dcx.ufpb.br;

public class PacienteJaExiste extends RuntimeException{
    public PacienteJaExiste(String message){
        super(message);
    }
}
