package br.edu.ifpe.apoo.negocio;

public class FachadaNegocioFactory {
	private static FachadaAluno instancia;

	public static IFachadaNegocio getInstancia() {
		if (instancia == null) instancia = new FachadaAluno();

		return instancia;
	}
}
