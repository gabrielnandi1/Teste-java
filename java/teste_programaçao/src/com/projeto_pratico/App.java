package com.projeto_pratico;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



import javax.net.ssl.SSLException;

import com.projeto_pratico.funcoes.Funcao;
import com.projeto_pratico.models.Funcionario;

public class App {
    public static void main(String[] args) throws Exception {

        List<Funcionario> list = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
    // Criaçao das datas de nascimento.
        LocalDate dt1 = LocalDate.parse("18/10/2000", formatter);
        LocalDate dt2 = LocalDate.parse("12/05/1990", formatter);
        LocalDate dt3 = LocalDate.parse("02/05/1961", formatter);
        LocalDate dt4 = LocalDate.parse("14/10/1988", formatter);
        LocalDate dt5 = LocalDate.parse("05/01/1995", formatter);
        LocalDate dt6 = LocalDate.parse("19/11/1999", formatter);
        LocalDate dt7 = LocalDate.parse("31/03/1993", formatter);
        LocalDate dt8 = LocalDate.parse("08/07/1994", formatter);
        LocalDate dt9 = LocalDate.parse("24/05/2003", formatter);
        LocalDate dt10 = LocalDate.parse("02/09/1996", formatter);

        // Criaçao do salario dos funcionarios, definindo as casas decimais.

        BigDecimal salario1 = new BigDecimal(2009.44).setScale(2,RoundingMode.HALF_UP);
        BigDecimal salario2 = new BigDecimal(2284.38).setScale(2,RoundingMode.HALF_UP);
        BigDecimal salario3 = new BigDecimal(9836.14).setScale(2,RoundingMode.HALF_UP);
        BigDecimal salario4 = new BigDecimal(19119.88).setScale(2,RoundingMode.HALF_UP);
        BigDecimal salario5 = new BigDecimal(2234.68).setScale(2,RoundingMode.HALF_UP);
        BigDecimal salario6 = new BigDecimal(1582.72).setScale(2,RoundingMode.HALF_UP);
        BigDecimal salario7 = new BigDecimal(4071.84).setScale(2,RoundingMode.HALF_UP);
        BigDecimal salario8 = new BigDecimal(3017.45).setScale(2,RoundingMode.HALF_UP);
        BigDecimal salario9 = new BigDecimal(1606.85).setScale(2,RoundingMode.HALF_UP);
        BigDecimal salario10 = new BigDecimal(2799.93).setScale(2,RoundingMode.HALF_UP);

        // Criando os funcionarios e seus atributos.

        Funcionario funcionario1 = new Funcionario("Maria", dt1, salario1, "operador");
        Funcionario funcionario2 = new Funcionario("Joao", dt2, salario2, "Operador");
        Funcionario funcionario3 = new Funcionario("Caio", dt3, salario3, "Coodernador");
        Funcionario funcionario4 = new Funcionario("Miguel", dt4, salario4, "Diretor");
        Funcionario funcionario5 = new Funcionario("Alice", dt5, salario5, "Recepcionista");
        Funcionario funcionario6 = new Funcionario("Heitor", dt6, salario6, "Operador");
        Funcionario funcionario7 = new Funcionario("Arthur", dt7, salario7, "Contador");
        Funcionario funcionario8 = new Funcionario("Laura", dt8, salario8, "Gerente");
        Funcionario funcionario9 = new Funcionario("Heloisa", dt9, salario9, "Eletricista");
        Funcionario funcionario10 = new Funcionario("Helena", dt10, salario10, "Gerente");

        // Adicionando os funcionarios à lista.

        list.add(funcionario1);
        list.add(funcionario2);
        list.add(funcionario3);
        list.add(funcionario4);
        list.add(funcionario5);
        list.add(funcionario6);
        list.add(funcionario7);
        list.add(funcionario8);
        list.add(funcionario9);
        list.add(funcionario10);
         
        // Removendo o funcionario da lista "joao"

        list.remove(funcionario2);

        Funcao funcao = new Funcao(list);

      
        // Adicionando o 10% no salario dos funcionarios.

        BigDecimal acrescimo1 = funcionario1.getSalario().multiply(new BigDecimal("1.1"));
        BigDecimal acrescimo2 = funcionario2.getSalario().multiply(new BigDecimal("1.1"));
        BigDecimal acrescimo3 = funcionario3.getSalario().multiply(new BigDecimal("1.1"));
        BigDecimal acrescimo4 = funcionario4.getSalario().multiply(new BigDecimal("1.1"));
        BigDecimal acrescimo5 = funcionario5.getSalario().multiply(new BigDecimal("1.1"));
        BigDecimal acrescimo6 = funcionario6.getSalario().multiply(new BigDecimal("1.1"));
        BigDecimal acrescimo7 = funcionario7.getSalario().multiply(new BigDecimal("1.1"));
        BigDecimal acrescimo8 = funcionario8.getSalario().multiply(new BigDecimal("1.1"));
        BigDecimal acrescimo9 = funcionario9.getSalario().multiply(new BigDecimal("1.1"));
        BigDecimal acrescimo10 = funcionario10.getSalario().multiply(new BigDecimal("1.1"));

        //Definiçao dos novos salarios
    
        funcionario1.setSalario(acrescimo1);
        funcionario2.setSalario(acrescimo2);
        funcionario3.setSalario(acrescimo3);
        funcionario4.setSalario(acrescimo4);
        funcionario5.setSalario(acrescimo5);
        funcionario6.setSalario(acrescimo6);
        funcionario7.setSalario(acrescimo7);
        funcionario8.setSalario(acrescimo8);
        funcionario9.setSalario(acrescimo9);
        funcionario10.setSalario(acrescimo10);

        //Print dos aniversariantes do mes 10 e 12

        for (Funcionario x : list) {
            if (x.getDataNascimento().getMonthValue() == 10
                    || x.getDataNascimento().getMonthValue() == 12) {
                System.out.println("O funcionario " + x.getNome() + " faz aniversario no mes " + x.getDataNascimento().getMonthValue() );
                
            }
        }
        
        // Print das informaçoes do funcionario mais velho
        System.out.println("O funcionario mais velho é " + funcao.getFuncionarioMaisVelho(list));
        Collections.sort(list); 

        // Print da lista de todos os funcionarios.

       funcao.getTodosFuncionarios(list);

       System.out.println("O salario total dos funcionarios é " + funcao.getSalarioTotal(list));
       
        
       // Print de quantos salarios minimos cada funcionario recebe
        funcao.getSalariosMinimos(list);

    }

}
