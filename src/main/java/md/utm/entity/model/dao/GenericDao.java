package md.utm.entity.model.dao;
import java.io.Serializable;

//iaca aici nu is sigur treb in packege de pus sau in folder
// stai
//da sa fac ceva, sa vad daca se poate de pus varianta ta pe git
public interface GenericDao {

	//asta co o interfata
	
	//public <T> T get(Class<T> entity, Serializable id);

	//public <T> List<T> get(Class<T> entity);

	public <T> Serializable save(T entity);

	//public <T> void saveOrUpdate(T entity);

	//public <T> void saveOrUpdate(Collection<T> entities);

	//public <T> void refresh(T entity);

	public <T> void delete(T entity);

	//public <T> void delete(Collection<T> entities);
}
