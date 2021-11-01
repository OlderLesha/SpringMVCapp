package com.kravchenko.springmvcapp.dao;

import com.kravchenko.springmvcapp.models.Person;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Component
public class PersonDao {
    private static int PEOPLE_COUNT=0;

    private static final String URL="jdbc:postgresql://localhost:5432/people_db";
    private static final String USERNAME="postgres";
    private static final String PASSWORD="1234";

    private static Connection CONNECTION;
    static {

        try {
            CONNECTION = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Person> index() throws SQLException {
        List<Person> people= new ArrayList<>();

        Statement statement= CONNECTION.createStatement();
        ResultSet resultSet=statement.executeQuery("SELECT * from Person");

        while (resultSet.next()){
            Person person = new Person();

            person.setId(resultSet.getInt("id"));
            person.setAge(resultSet.getInt("age"));
            person.setName(resultSet.getString("name"));
            person.setEmail(resultSet.getString("email"));

            people.add(person);
        }
        return people;
    }

    public Person show(int inId){
        //return people.stream().filter(x->x.getId()==inId).findAny().orElse(null);
        return null;
    }
}
