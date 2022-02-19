//Henrique Andrew da Silva

package Teste_Pessoa;

public class Pessoa {
    private int cod; 
	private String nome;

	public Pessoa(){ //default
		cod = 0;
		nome="";
	}

	public int getCod(){
		return cod;
	}

	public String getNome(){
		return nome;
	}

	public void setCod(int cod){
		this.cod = cod;
	}

	public void setNome(String nome){
		this.nome = nome;
	}
}
