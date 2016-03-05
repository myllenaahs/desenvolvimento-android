package br.edu.ifpb.edittextlistenerapp.entidade;


import java.io.Serializable;

import br.edu.ifpb.edittextlistenerapp.exclusion.ExcluirJSON;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Rhavy on 27/02/2016.
 */
public class Pessoa implements Serializable {
	
	public Pessoa(){
		
	}


    public Pessoa (String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    @ExcluirJSON
	@SerializedName("id")
    private int id;

    @SerializedName("fullName")
    private String nome;
    
    @ExcluirJSON
    @SerializedName("email")
    private String email;

    @ExcluirJSON
    @SerializedName("typeInscription")
    private String descricao;

    @ExcluirJSON
    @SerializedName("isDelivered")
    private boolean entregue;
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isEntregue() {
		return entregue;
	}

	public void setEntregue(boolean entregue) {
		this.entregue = entregue;
	}

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "[fullName: " + nome + "; email: " + email + "]";
    }
}