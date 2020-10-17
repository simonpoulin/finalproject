package fpt.java.finalproject.services;

public interface OrderDetailService {
   
    public  OrderDetail save(OrderDetail entity);

    public List<OrderDetail>  saveAll(List<OrderDetail> entities);

    public Optional<OrderDetail> findById(Integer id) ;

    public boolean existsById(Integer id);

    public Iterable<OrderDetail> findAll() ;

    public List<OrderDetail> findAllById(List<Integer> ids);

    public long count() ;

    public void deleteById(Integer id) ;

    public void delete(OrderDetail entity) ;

    public void deleteAll(List<OrderDetail> entities) ;


    public void deleteAll() ;
}
