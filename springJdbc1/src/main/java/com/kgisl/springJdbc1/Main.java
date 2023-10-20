package com.kgisl.springJdbc1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

public class Main {
    static JdbcTemplate jdbcTemp;
    static SimpleDriverDataSource dataSrc;

    public static SimpleDriverDataSource getDbConnection() {
        dataSrc = new SimpleDriverDataSource();
        try {
            dataSrc.setDriverClass(com.mysql.cj.jdbc.Driver.class); 
            dataSrc.setUrl("jdbc:mysql://localhost:3306/employeeDB");
            dataSrc.setUsername("root");
            dataSrc.setPassword(""); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataSrc;
    }

    public static void main(String[] args) {
        jdbcTemp = new JdbcTemplate(getDbConnection());
        if (null != jdbcTemp) {
            // INSERT
            String insert = "INSERT INTO employeeList(name, dept, email, phone) VALUES (?, ?, ?, ?)";
            jdbcTemp.update(insert, "MS Dhoni", "Dolphin", "dhoni@gmail.com", "9876543210");
            jdbcTemp.update(insert, "Virat Kohli", "nSure", "kohli@gmail.com", "9006043210");
            jdbcTemp.update(insert, "Rohit Sharma", "Marvel AI", "rohit@yahoo.com", "8967452301");
            jdbcTemp.update(insert, "Hardik Pandya", "", "hardik@gmail.com", "9753108462");

            // UPDATE
            String update = "UPDATE employeeList SET email = ? WHERE name = ?";
            jdbcTemp.update(update, "virat@gmail.com", "Virat Kohli");

            // READ
            String read = "SELECT * FROM employeeList";
            List<Employee> empList = jdbcTemp.query(read, new RowMapper<Employee>() {
                @Override
                public Employee mapRow(ResultSet result, int row) throws SQLException {
                    System.out.println(row);
                    Employee emp = new Employee();
                    emp.setEmpId(result.getInt("id"));
                    emp.setEmpName(result.getString("name"));
                    emp.setEmpEmail(result.getString("email"));
                    emp.setEmpDept(result.getString("dept"));
                    emp.setEmpPhone(result.getString("phone"));
                    return emp;
                }
            });

            // DISPLAY
            for (Employee employee : empList) {
                System.out.println(employee.toString());
            }

            // DELETE
            String delete = "DELETE FROM employeeList WHERE name=?";
            jdbcTemp.update(delete, "Hardik Pandya");
System.out.println("\n");
System.out.println("DELETE**********");
empList.forEach(System.out::println);

        } else {
            System.out.println("App is not able to bind with DB");
        }
        
    }
}
