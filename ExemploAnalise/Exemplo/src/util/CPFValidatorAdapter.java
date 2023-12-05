package util;

import br.edu.ifpe.apoo.excecoes.ExcecaoCpfInvalido;

public class CPFValidatorAdapter {
	
	public boolean validarCPF(String cpf) throws ExcecaoCpfInvalido {
        try {
            return CPFValidator.validarCPF(cpf);
        } catch (Exception e) {
            throw new ExcecaoCpfInvalido("Erro na validação do CPF: " + e.getMessage());
        }
    }
}
