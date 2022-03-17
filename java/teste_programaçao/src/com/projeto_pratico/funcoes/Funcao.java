package com.projeto_pratico.funcoes;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.text.*;

import javax.annotation.processing.RoundEnvironment;

import com.projeto_pratico.models.Funcionario;

public class Funcao {

    List<Funcionario> list;
    int maisVelho = 2050;
    private BigDecimal totalSalario = new BigDecimal("0");

    public Funcao(List<Funcionario> list) {
        this.list = list;
    }

    public String getFuncionarioMaisVelho(List<Funcionario> list) {
        for (Funcionario x : list) {
            if (x.getDataNascimento().getYear() < maisVelho) {
                maisVelho = x.getDataNascimento().getYear();
            }

        }
        for (Funcionario x : list) {
            if (x.getDataNascimento().getYear() == maisVelho) {
                return x.toString();
            }

        }
        return null;
    }

    public String getSalarioTotal(List<Funcionario> list) {
        NumberFormat n = NumberFormat.getCurrencyInstance();
        for (Funcionario f : list) {
            totalSalario = totalSalario.add(f.getSalario());
        }
        return n.format(totalSalario);
    }

    public void getSalariosMinimos(List<Funcionario> list) {
        for (Funcionario f : list) {
            BigDecimal s = f.getSalario().divide(new BigDecimal(1212), new MathContext(2, RoundingMode.HALF_EVEN));

            System.out.println("O funcionario " + f.getNome() + " Possue " + s + " Salarios minimos em seu salario ");
        }

    }

    public void getTodosFuncionarios(List<Funcionario> list) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        NumberFormat n = NumberFormat.getCurrencyInstance();
        for (Funcionario f : list) {
            System.out.println("Nome: " + f.getNome() +
             " Função: " + f.getFuncao() +
             " Data de Nascimento: " + f.getDataNascimento().format(formatter) +
             " Salário: " + n.format(f.getSalario()));
        }
    }

}
