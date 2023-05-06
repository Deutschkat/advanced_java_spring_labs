package platform.codingnomads.co.springdata.example.springdatajdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringDataJDBCDemo implements CommandLineRunner {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJDBCDemo.class);
    }

    @Override
    public void run(String... strings) {

        try {
            //create employee table using the JdbcTemplate method "execute"
            jdbcTemplate.execute("CREATE TABLE employees (id BIGINT AUTO_INCREMENT PRIMARY KEY," +
                    "first_name VARCHAR(255) NOT NULL,last_name  VARCHAR(255) NOT NULL);");
        } catch (Exception e) {
            //nothing
        }

        try {
            jdbcTemplate.execute("CREATE TABLE job_position (id BIGINT AUTO_INCREMENT PRIMARY KEY," +
                    "position_title VARCHAR(255) NOT NULL,position_department VARCHAR(255) NOT NULL);");
        } catch (Exception e) {

        }


        //create a list of first and last names
        List<Object[]> splitUpNames = Stream.of("Java Ninja", "Spring Guru", "Java Guru", "Spring Ninja")
                .map(name -> name.split(" "))
                .collect(Collectors.toList());

        //for each first & last name pair insert an Employee into the database
        for (Object[] name : splitUpNames) {
            jdbcTemplate.execute(String.format("INSERT INTO employees(first_name, last_name) VALUES ('%s','%s')", name[0], name[1]));
        }

        //query the database for Employees with first name Java
        jdbcTemplate.query(
                        "SELECT id, first_name, last_name FROM employees WHERE first_name = 'Java'",
                        (rs, rowNum) -> new Employee(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"))
                )
                //print each found employee to the console
                .forEach(employee -> System.out.println(employee.toString()));


        //truncate the table
        jdbcTemplate.execute("TRUNCATE TABLE employees;");
        //delete the table
        jdbcTemplate.execute("DROP TABLE employees");


        //create job positions

        List<JobPosition> jobPositions = Stream.of(
                new JobPosition(1,"Software Dev", "Engineering"),
                new JobPosition(2,"HR Director", "Human Resources"),
                new JobPosition(3, "Graphic Design Lead", "Marketing")
        ).collect(Collectors.toList());

        for (JobPosition jobPosition : jobPositions) {
            jdbcTemplate.update(
                    "INSERT INTO job_position(id, position_title, position_department) VALUES (?,?,?)",
                    jobPosition.getId(),
                    jobPosition.getPositionTitle(),
                    jobPosition.getPositionDepartment()
            );
        }


        //query for job positions where engineering is department.

        jdbcTemplate.query(
                        "SELECT id, position_title, position_department FROM job_position WHERE position_department = 'Engineering'",
                        (rs, rowNum) -> new JobPosition(rs.getLong("id"), rs.getString("position_title"), rs.getString("position_department"))
                )
                //print each found job position to the console
                .forEach(jobPosition -> System.out.println(jobPosition.toString()));


        //truncate the table
        jdbcTemplate.execute("TRUNCATE TABLE job_position;");
        //delete the table
        jdbcTemplate.execute("DROP TABLE job_position");
    }
}
