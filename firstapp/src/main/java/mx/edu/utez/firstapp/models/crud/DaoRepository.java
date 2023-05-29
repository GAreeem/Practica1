package mx.edu.utez.firstapp.models.crud;

public interface DaoRepository<T>{
List<T> findAll();
T findOne(Long id);
boolean update(T object);
boolean delete(Long id);
}
