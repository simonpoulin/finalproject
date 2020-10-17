package fpt.java.finalproject.services;

public interface EmployeeRoleService {

    public  EmployeeRole save(EmployeeRole entity);
   
    public List <EmployeeRole>  saveAll(List<EmployeeRole> entities);

    public Optional<EmployeeRole> findById(Integer id) ;

    public boolean existsById(Integer id);

    public Iterable<EmployeeRole> findAll() ;

    public List<EmployeeRole> findAllById(List<Integer> ids);

    public long count();

    public void deleteById(Integer id);

    public void delete(EmployeeRole entity);

    public void deleteAll(List<EmployeeRole> entities);

    public void deleteAll() ;
}
