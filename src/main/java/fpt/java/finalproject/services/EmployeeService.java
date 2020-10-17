package fpt.java.finalproject.services;

public interface EmployeeService {

    public  Employee  save(Employee entity);

    public List<Employee> saveAll(List<Employee> entities) ;

    public Optional<Employee> findById(Integer id) ;

    public boolean existsById(Integer id) ;

    public Iterable<Employee> findAll();

    public List<Employee> findAllById(List<Integer> ids) ;

    public long count() ;

    public void deleteById(Integer id);

    public void delete(Employee entity);

    public void deleteAll(List<Employee> entities) ;
    
    public void deleteAll();
}
