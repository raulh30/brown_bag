package dao;

import entity.Employee;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class EmployeeDAOImpl extends HibernateDaoSupport implements EmployeeDAO {


    public void save(Employee emp) {

        getSessionFactory().getCurrentSession().save(emp);
    }

    public void update(Employee emp) {

        getSessionFactory().getCurrentSession().update(emp);
    }

    public void delete(Employee emp) {

        getSessionFactory().getCurrentSession().delete(emp);
    }

    public Employee getById(long id) {

        Employee emp= getSessionFactory().getCurrentSession().get(Employee.class, id);

        return emp;

    }
}
