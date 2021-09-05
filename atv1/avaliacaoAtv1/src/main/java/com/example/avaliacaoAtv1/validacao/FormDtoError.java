package com.example.avaliacaoAtv1.validacao;

public class FormDtoError {

    private String camp;
    private String error;

    public FormDtoError(String camp, String error) {
        this.camp = camp;
        this.error = error;
    }

    public String getCamp() {
        return camp;
    }

    public void setCamp(String camp) {
        this.camp = camp;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
