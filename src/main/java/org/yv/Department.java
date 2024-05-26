package org.yv;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class Department {
    private String departmentId;
    private String departmentName;
    private static int nextId;

    /**
     * Checks if departmentName only contains space or letters
     * @param departmentName String input
     * @return boolean value true or false
     */
    public static boolean validateDepartmentName(String departmentName) {
        for (int i = 0; i < departmentName.length(); i++) {
            if (departmentName.charAt(i) != ' ' || !Character.isLetter(i)) {
                return false;
            }
        } return true;
    }

    /**
     * Constructor if departmentName is not valid by using the method validateDepartmentName
     * set everything as null
     * @param departmentName String input
     */
    public Department(String departmentName) {
        if (!validateDepartmentName(departmentName)) {
            this.departmentId = null;
            this.departmentName = null;
            this.nextId = Integer.parseInt(null);
        }
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Department.nextId = nextId;
    }
}
