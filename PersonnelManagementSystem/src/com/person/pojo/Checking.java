package com.person.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author itcherish
 * @date 2022/6/21 20:55
 */
public class Checking implements Serializable{
    private Integer checkId;
    private Integer empId;
    private String empName;
    private String depName;
    private Date startDate;
    private Integer state;
    private String note;

    public Checking() {
    }

    public Checking(Integer empId, String empName, String depName, Date startDate, Integer state, String note) {
        this.empId = empId;
        this.empName = empName;
        this.depName = depName;
        this.startDate = startDate;
        this.state = state;
        this.note = note;
    }


    @Override
    public String toString() {
        return "Checking{" +
                "checkId=" + checkId +
                ", empId=" + empId +
                ", empName='" + empName + '\'' +
                ", depName='" + depName + '\'' +
                ", startDate=" + startDate +
                ", state=" + state +
                ", note='" + note + '\'' +
                '}';
    }

    public Integer getCheckId() {
        return checkId;
    }

    public void setCheckId(Integer checkId) {
        this.checkId = checkId;
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

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Checking(Integer checkId, Integer empId, String empName, String depName, Date startDate, Integer state, String note) {
        this.checkId = checkId;
        this.empId = empId;
        this.empName = empName;
        this.depName = depName;
        this.startDate = startDate;
        this.state = state;
        this.note = note;
    }
}
