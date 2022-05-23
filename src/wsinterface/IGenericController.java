package wsinterface;

import java.util.ArrayList;

import javax.ws.rs.core.Response;

public interface IGenericController<T> {

	/**
	 * @description Busca por todos os dados.
	 * @return Response
	 * 
	 * @author Matheus Eduardo França - matheusefranca1727@gmail.com
	 */
	public Response initialize();

	/**
	 * @description Busca por dado com base no id.
	 * @param id
	 *            Id do dado a ser buscado.
	 * @return Response
	 * 
	 * @author Matheus Eduardo França - matheusefranca1727@gmail.com
	 */
	public Response findById(int id);

	/**
	 * @description Busca por todos os dados retornando somente as colunas
	 *              especificadas. Também é possível passar uma validação.
	 * @param columns
	 *            Array de strings com as colunas desejadas.
	 * @param validate
	 *            Array bidimensional de strings opcional que fará validação dos
	 *            dados.
	 * @return Response
	 * 
	 * @author Matheus Eduardo França - matheusefranca1727@gmail.com
	 */
	public Response findByColumns(ArrayList<T> columns, ArrayList<T> validate);

	/**
	 * @description Cria um novo dado.
	 * @return Response
	 * 
	 * @author Matheus Eduardo França - matheusefranca1727@gmail.com
	 */
	public Response store(T request);

	/**
	 * @description Atualiza um dado existente.
	 * @return Response
	 * 
	 * @author Matheus Eduardo França - matheusefranca1727@gmail.com
	 */
	public Response update(T request);

	/**
	 * @description Deleta um dado utilizando o id.
	 * @param id
	 *            utilizado para deletar o dado.
	 * @return Response
	 * 
	 * @author Matheus Eduardo França - matheusefranca1727@gmail.com
	 */
	public Response delete(int id);

}
