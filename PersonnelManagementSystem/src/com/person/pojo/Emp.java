package com.person.pojo;

/**
 * @author itcherish
 * @date 2022/6/21 20:44
 */
public class Emp {

    private Integer empId;
    private String empName;
    private String empsex;
    private Integer empage;
    private Integer work_year;
    private String telephone;
    private String address;

    public Emp() {
    }

    public Emp(int empid, String empname) {
        this.empId = empid;
        this.empName = empname;
    }

    public Emp(Integer empId, String empName, String empsex, Integer empage, Integer work_year, String telephone, String address) {
        this.empId = empId;
        this.empName = empName;
        this.empsex = empsex;
        this.empage = empage;
        this.work_year = work_year;
        this.telephone = telephone;
        this.address = address;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpsex() {
        return empsex;
    }

    public void setEmpsex(String empsex) {
        this.empsex = empsex;
    }

    public Integer getEmpage() {
        return empage;
    }

    public void setEmpage(Integer empage) {
        this.empage = empage;
    }

    public Integer getWork_year() {
        return work_year;
    }

    public void setWork_year(Integer work_year) {
        this.work_year = work_year;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empsex='" + empsex + '\'' +
                ", empage=" + empage +
                ", work_year=" + work_year +
                ", telephone='" + telephone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
