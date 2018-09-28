package dao;

import entity.Employee;

public interface EmployeeDAO {

    void save(Employee emp);
    void update(Employee emp);
    void delete(Employee emp);
    Employee getById(long id);
}
