package fpt.java.finalproject.services;

public interface ShopEmployeeService {

    public  ShopEmployee save(ShopEmployee entity);

    public List<ShopEmployee>  saveAll(List<ShopEmployee> entities);

    public Optional<ShopEmployee> findById(Integer id) ;

    public boolean existsById(Integer id) ;

    public Iterable<ShopEmployee> findAll() ;

    public List<ShopEmployee> findAllById(List<Integer> ids);

    public long count() ;

    public void deleteById(Integer id);

    public void delete(ShopEmployee entity);

    public void deleteAll(List<ShopEmployee> entities);

    public void deleteAll() ;

}
