package pessoa;

public class Cliente {

    private String rua;
    private String cidade;
    private String estado;

    public Cliente(String rua, String cidade, String estado){
        this.rua = rua;
        this.cidade = cidade;
        this.estado = estado;
    }

    public String getRua() {return rua;}

    public void setRua(String rua) {this.rua = rua;}

    public String getCidade() {return cidade;}

    public void setCidade(String cidade) {this.cidade = cidade;}

    public String getEstado() {return estado;}

    public void setEstado(String estado) {this.estado = estado;}

    @Override
    public String toString() {
        return "-------------------------" +
                "Qual seu endereço? " +
                "\n rua = " + rua +
                "\n cidade = " + cidade +
                "\n estado = " + estado +
                "-------------------------------";
    }
}


