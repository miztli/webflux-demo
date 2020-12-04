package com.webflux.models;

public class Employee
{
    private String name;
    private int age;

    public Employee(final String name, final int age)
    {
        this.name = name;
        this.age = age;
    }

    public String getName()
    {
        return name;
    }

    public void setName(final String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(final int age)
    {
        this.age = age;
    }

    @Override
    public String toString()
    {
        return "Employee{" +
            "name='" + name + '\'' +
            ", age=" + age +
            '}';
    }
}
