package Agendamento;

public class Categoria {
    private String urgencia;  // Ex: "Alta", "Média", "Baixa"
    private String localizacao; // Ex: "Residencial", "Comercial"

    public Categoria(String urgencia, String localizacao) {
        this.urgencia = urgencia;
        this.localizacao = localizacao;
    }

    public String getUrgencia() {
        return urgencia;
    }

    public void setUrgencia(String urgencia) {
        this.urgencia = urgencia;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    @Override
    public String toString() {
        return "Urgência: " + urgencia + " | Localização: " + localizacao;
    }
}

