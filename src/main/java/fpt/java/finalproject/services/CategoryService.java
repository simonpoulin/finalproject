package fpt.java.finalproject.services;

public interface CategoryService {
    public List <Category> saveAll(List<Category> entities) ;

    public Optional<Category> findById(Integer id);

    public boolean existsById(Integer id) ;

    public Iterable<Category> findAll();

    public List<Category> findAllById(List<Integer> ids);

    public long count() ;

    public void deleteById(Integer id);

    public void delete(Category entity) ;

    public void deleteAll(List<Category> entities) ;
    
    public void deleteAll() 
}
