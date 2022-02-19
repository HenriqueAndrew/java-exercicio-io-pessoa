//Henrique Andrew da Silva

package Teste_Pessoa;

import java.util.ArrayList;
import java.util.List;

public class TstCol {
    
    private static List<Pessoa> BDPes = new ArrayList<Pessoa>();

    private static Pessoa pessoa = new Pessoa();

    private static Leitura l = new Leitura();

    public static void main(String arg[]){
		

    //VARS
    boolean continua = true;
    int opcao = 0;

    //MENU INICIAL
	
    while(continua){
        System.out.println("\n\t\t\tMENU INICIAL");
        System.out.println("\t(1) Cadastrar uma Pessoa");
        System.out.println("\t(2) Imprimir todas Pessoas ");
        System.out.println("\t(3) Imprimir Pessoa pelo CODIGO");
        System.out.println("\t(4) Alterar Pessoa pelo CODIGO");
        System.out.println("\t(5) Excluir Pessoa pelo CODIGO");
        System.out.println("\t(6) Sair do Sistema");

        try{
            opcao = Integer.parseInt(l.entDados("\n\tEscolha uma opcao"));
        }
        catch(NumberFormatException nfe){
            System.out.println("Opção deve ser um valor inteiro");
            l.entDados("");
            continue;
        }

        switch(opcao){
            case 1:
                pessoa = cadPessoa(new Pessoa());
                if(consPesCod(pessoa) == null){		
                    BDPes.add(pessoa);
                }
                else{
                    System.out.println("\n\t\t===== Já existe uma pessoa com este codigo!=====\n");
                }
                break;

            case 2:
                System.out.println("\nImprimir todas as Pessoas");
                System.out.println("=============================================== ");					
                for(int i = 0; i < BDPes.size(); i++){
                    if(BDPes.get(i)!= null){
                        impPessoa(BDPes.get(i));
                    }
                    else{
                    l.entDados("\nSem mais pessoas para imprimir - press <ENTER>");
                    }
                }
                System.out.println("===============================================");
                break;

            case 3:
                System.out.println("\nConsulta pelo CODIGO da pessoa");
                System.out.println("===============================================");
                pessoa = new Pessoa();
                pessoa.setCod(Integer.parseInt(l.entDados("\nInforme o codigo a ser pesquisado: ")));
                pessoa = consPesCod(pessoa);
                if( pessoa != null){
                    impPessoa(pessoa);
                }
                else{
                    System.out.println("\nNAO existe PESSOA com este CODIGO");					
                }		
                break;			
				
            case 4:
                System.out.println("\nAlterar cadastro de Pessoa");
                System.out.println("===============================================");                                    
                int local = 0;
                pessoa = new Pessoa();
                pessoa.setCod(Integer.parseInt(l.entDados("\nInforme o codigo da Pessoa que deseja ALTERAR: ")));
                local = consCod(pessoa, local);					
                if(local >= 0){
                    pessoa.setCod(Integer.parseInt(l.entDados("\n Digite o NOVO Codigo...: ")));
                    pessoa.setNome(l.entDados("\n Digite o NOVO Nome...: "));
                    alteraPessoa(local, pessoa);
                }
                else{
                    System.out.println("\nNAO existe PESSOA com este CODIGO");								
                }
                break;								
				
            case 5:
                System.out.println("\nExclui cadastro de Pessoa");
                System.out.println("===============================================");
                pessoa = new Pessoa();
                pessoa.setCod(Integer.parseInt(l.entDados("\nInforme o codigo da Pessoa que deseja EXCLUIR: ")));
                pessoa = consPesCod(pessoa);					
                if( pessoa != null){
                    excluiPessoa(pessoa);
                    System.out.println("=====================\nExclusão do cadastro realizada!");
                }
                else{
                    System.out.println("\nNAO existe PESSOA com este CODIGO");										
                }
                break;

            case 6:
                continua = false;
                System.out.println("======SISTEMA ENCERRADO=======");
                break;
                default:
                l.entDados("\nO valor deve ser >= 1 e <= 6 <press ENTER...>");
                break;
        }//fim do switch-case
    }//fim do while			
}//fim do main
	
    public static Pessoa consPesCod(Pessoa pessoa){
        for(int i = 0; i < BDPes.size(); i++){
            if(BDPes.get(i).getCod() == pessoa.getCod()){
                return BDPes.get(i);
            }
        }
        return null;
    }
        
    public static int consCod(Pessoa pessoa, int local){
        local = -1;
        for(int i= 0; i<BDPes.size(); i++){
            if (BDPes.get(i).getCod() == pessoa.getCod()){
            return i;
            }
        }
        return local;
    }
        
    public static Pessoa alteraPessoa(int local, Pessoa pessoa){
		
        //local = 0;
        //pessoa = new Pessoa();
        //pessoa.setCod(Integer.parseInt(l.entDados("\n Digite o NOVO Codigo: ")));
        //pessoa.setNome(l.entDados("\n NOVO Nome"));
        BDPes.set(local, pessoa);                                 
        return pessoa;           
    } 

    public static Pessoa excluiPessoa(Pessoa pessoa){
		    
        BDPes.remove(pessoa);
        return pessoa;
    } 

    public static Pessoa cadPessoa(Pessoa pessoa){

        System.out.println("\n\n===============================================");
        System.out.println("Cadastro de PESSOAS");
        System.out.println("===============================================");

        pessoa.setCod(Integer.parseInt(l.entDados("\nCodigo.: ")));
        pessoa.setNome(l.entDados("\nNome.....: "));

        return pessoa;

    }//fim cadPessoa


    public static void impPessoa(Pessoa pessoa){

        System.out.println("\nCodigo: "+ pessoa.getCod()+" - Nome: "+ pessoa.getNome());

    }//fim impPessoa
} 
