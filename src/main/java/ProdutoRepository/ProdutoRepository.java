package ProdutoRepository;

import Diretório.Produto;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository  extends CrudRepository<Produto, String> {
    Produto finfByCodigo(long codigo);
}
