package com.person.pojo;

/**
 * @author itcherish
 * @date 2022/6/21 20:47
 */
public class Salary {

    private Integer salId;
    private Integer empId;
    private String empName;
    private Double overtime;
    private Double baseSal;
    private Double commission;
    private Double allSal;

    public Integer getSalId() {
        return salId;
    }

    public void setSalId(int salId) {
        this.salId = salId;
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

    public Double getOvertime() {
        return overtime;
    }

    public void setOvertime(Double overtime) {
        this.overtime = overtime;
    }

    public Double getBaseSal() {
        return baseSal;
    }

    public void setBaseSal(Double baseSal) {
        this.baseSal = baseSal;
    }

    public Double getCommission() {
        return commission;
    }

    public void setCommission(Double commission) {
        this.commission = commission;
    }

    public Double getAllSal() {
        return allSal;
    }

    public void setAllSal(Double allSal) {
        this.allSal = allSal;
    }

    public Salary(Integer salId, Integer empId, String empName, Double overtime, Double baseSal, Double commission, Double allSal) {
        this.salId = salId;
        this.empId = empId;
        this.empName = empName;
        this.overtime = overtime;
        this.baseSal = baseSal;
        this.commission = commission;
        this.allSal = allSal;
    }

    public Salary() {
    }

    @Override
    public String toString() {
        return "Salary{" +
                "salId=" + salId +
                ", empId=" + empId +
                ", empName='" + empName + '\'' +
                ", overtime=" + overtime +
                ", baseSal=" + baseSal +
                ", commission=" + commission +
                ", allSal=" + allSal +
                '}';
    }
}
