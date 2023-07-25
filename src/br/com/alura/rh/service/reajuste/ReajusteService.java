package br.com.alura.rh.service.reajuste;

import br.com.alura.rh.model.Funcionario;
import br.com.alura.rh.service.ValidacaoReajustes;

import java.math.BigDecimal;
import java.util.List;

public class ReajusteService {

    private List<ValidacaoReajustes> validacoes;

    public ReajusteService(List<ValidacaoReajustes> validacoes) {
        this.validacoes = validacoes;
    }

    public void reajustarSalarioDoFuncionario(Funcionario funcionario, BigDecimal aumento){
        this.validacoes.forEach(v -> v.validar(funcionario, aumento));

        BigDecimal salarioReajustado = funcionario.getSalario().add(aumento);
        funcionario.atualizarSalario(salarioReajustado);
    }


}
