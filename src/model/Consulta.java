package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Consulta {

    private String nome;
    private String sobrenome;
    private String cpf;
    private Date data;
    private String hora;
    private String planos;
    private String servicos;
    private String observacao;

    public Consulta(String nome, String sobrenome, String cpf, Date data, String hora, String planos, String servicos, String observacao) throws ParseException {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.data = data;
        this.hora = hora;
        this.planos = planos;
        this.servicos = servicos;
        this.observacao = observacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getPlanos() {
        return planos;
    }

    public void setPlanos(String planos) {
        this.planos = planos;
    }

    public String getServicos() {
        return servicos;
    }

    public void setServicos(String servicos) {
        this.servicos = servicos;
    }

    public String getObservacao() {
        
        return observacao;
    }
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
