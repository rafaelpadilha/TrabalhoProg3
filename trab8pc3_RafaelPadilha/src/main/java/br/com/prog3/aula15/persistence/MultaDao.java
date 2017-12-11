package br.com.prog3.aula15.persistence;

import java.util.List;

import br.com.prog3.aula15.model.Multa;
import br.com.prog3.aula15.model.Veiculo;

public interface MultaDao {
	public void incluir(Multa multa);

	public void alterar(Multa multa);

	public void excluir(Multa multa);

	public List<Multa> listarTodos();

	public Multa buscarPeloCodigo(int codigo);

	public List<Multa> buscarPeloVeiculo(Veiculo veiculo);
}