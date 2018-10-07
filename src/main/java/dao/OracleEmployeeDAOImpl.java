package dao;

import entity.Employee;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

public class OracleEmployeeDAOImpl extends HibernateDaoSupport {

    @Transactional(value = "transactionManager")
    public void save(Employee emp) {

        getSessionFactory().getCurrentSession().save(emp);
    }

    @Transactional(value = "transactionManager")
    public void update(Employee emp) {

        getSessionFactory().getCurrentSession().update(emp);
    }

    @Transactional(value = "transactionManager")
    public void delete(Employee emp) {

        getSessionFactory().getCurrentSession().delete(emp);
    }

    @Transactional(value = "transactionManager")
    public Employee getById(long id) {

        Employee emp = getSessionFactory().getCurrentSession().get(Employee.class, id);

        return emp;

    }
}
