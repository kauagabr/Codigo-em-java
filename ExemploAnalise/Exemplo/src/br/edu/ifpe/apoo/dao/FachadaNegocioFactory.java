package br.edu.ifpe.apoo.dao;

public class FachadaNegocioFactory {
	private static FachadaListControlador instancia;

	public static IfachadaListControlador getInstancia() {
		if (instancia == null) instancia = new FachadaListControlador();
		return instancia;
		
		
	}
}
