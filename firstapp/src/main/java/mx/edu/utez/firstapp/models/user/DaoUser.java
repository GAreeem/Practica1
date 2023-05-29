package mx.edu.utez.firstapp.models.user;
import mx.edu.utez.firstapp.models.crud.DaoRepository;
public class DaoUser implements DaoRepository<user>{
    @Override
    public user findOne(Long id) {
        return null;
    }

    @Override
    public boolean update(user object) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
