package dao;

import entity.Employee;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class EmployeeDAOImpl extends HibernateDaoSupport implements EmployeeDAO {


    public void save(Employee emp) {

        getHibernateTemplate().save(emp);
    }

    public void update(Employee emp) {

        getHibernateTemplate().update(emp);
    }

    public void delete(Employee emp) {

        getHibernateTemplate().delete(emp);
    }

    public Employee getById(long id) {

        List employees = getHibernateTemplate().find("from Employee where id = ?", id);

        if (!CollectionUtils.isEmpty(employees)) {
            return (Employee) employees.get(0);
        }

        return null;

    }
}
