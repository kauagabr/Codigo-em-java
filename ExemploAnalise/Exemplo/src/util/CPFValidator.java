package util;

public class CPFValidator {
	public static boolean validarCPF(String cpf) {

        cpf = cpf.replaceAll("[^0-9]", "");

        if (cpf.length() != 11) {
            return false;
        }

        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        int digito1 = calcularDigitoVerificador(cpf.substring(0, 9));

        int digito2 = calcularDigitoVerificador(cpf.substring(0, 10));

        return (Character.getNumericValue(cpf.charAt(9)) == digito1 && Character.getNumericValue(cpf.charAt(10)) == digito2);
    }

    private static int calcularDigitoVerificador(String base) {
        int total = 0;
        int peso = base.length() + 1;
        for (char c : base.toCharArray()) {
            total += Character.getNumericValue(c) * peso;
            peso--;
        }
        int resto = total % 11;
        return (resto < 2) ? 0 : (11 - resto);
    }

}
