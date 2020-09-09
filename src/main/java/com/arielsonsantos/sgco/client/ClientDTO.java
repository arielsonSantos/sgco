package com.arielsonsantos.sgco.client;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;

public class ClientDTO implements Serializable {

    @NotEmpty(message = "Campo 'nome' é de preenchimento obrigatório!")
    private String nome;

    @NotEmpty(message = "Campo 'sobrenome' é de preenchimento obrigatório!")
    private String sobrenome;

    @NotNull(message = "Campo 'nascimento' é de preenchimento obrigatório!")
    @Past(message = "Data de nascimento inválida! A data deve ser menor que a data atual.")
    private Date nascimento;

    @NotEmpty(message = "Campo 'CPF/CNPJ' é de preenchimento obrigatório!")
    @Size(min = 11, max = 14, message = "CPF/CPNJ com formato inválido!")
    private String cpfCnpj;

    @NotEmpty(message = "Campo 'RG/IE' é de preenchimento obrigatório!")
    private String rgIe;

    @NotEmpty(message = "Campo 'email' é de preenchimento obrigatório!")
    @Email(message = "Email inválido!")
    private String email;

    @NotNull(message = "Campo 'status' é de preenchimento obrigatório!")
    private ClientStatus status;

    private String observacoes;

    public ClientDTO() {
    }

    public ClientDTO(Client client) {
        this.nome = client.getNome();
        this.sobrenome = client.getSobrenome();
        this.nascimento = client.getNascimento();
        this.cpfCnpj = client.getCpfCnpj();
        this.rgIe = client.getRgIe();
        this.email = client.getEmail();
        this.status = client.getStatus();
        this.observacoes = client.getObservacoes();
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public String getRgIe() {
        return rgIe;
    }

    public String getEmail() {
        return email;
    }

    public ClientStatus getStatus() {
        return status;
    }

    public String getObservacoes() {
        return observacoes;
    }
}
