package execeptions;

public class NegotiationExecution extends RuntimeException {

    private static final long serialVersionUID = 1L; // versão 1

    public NegotiationExecution(String msg) {
        super(msg);
    }


}
