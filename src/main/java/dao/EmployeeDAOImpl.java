package dao;

import entity.Employee;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    private final boolean READ_FROM_POSTGRE = false;
    private final boolean DUAL_WRITE = true;

    private OracleEmployeeDAOImpl oracleEmployeeDAO;
    private PostgreEmployeeDAOImpl postgreEmployeeDAO;

    public EmployeeDAOImpl(OracleEmployeeDAOImpl oracleEmployeeDAO, PostgreEmployeeDAOImpl postgreEmployeeDAO) {
        this.oracleEmployeeDAO = oracleEmployeeDAO;
        this.postgreEmployeeDAO = postgreEmployeeDAO;
    }


    public void save(Employee emp) {

        this.oracleEmployeeDAO.save(emp);

        if (DUAL_WRITE) {
            this.postgreEmployeeDAO.save(emp);
        }

    }

    public void update(Employee emp) {

        this.oracleEmployeeDAO.update(emp);

        if (DUAL_WRITE) {
            this.postgreEmployeeDAO.update(emp);
        }

    }

    public void delete(Employee emp) {

        this.oracleEmployeeDAO.delete(emp);

        if (DUAL_WRITE) {
            this.postgreEmployeeDAO.delete(emp);
        }

    }

    public Employee getById(long id) {

        if (READ_FROM_POSTGRE) {
            return this.postgreEmployeeDAO.getById(id);
        } else {
            return this.oracleEmployeeDAO.getById(id);
        }

    }
}
