package com.automobile.company.manager.model.enums;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public enum EmployeeDepartment {
    HR,
    SALES,
    FINANCE,
    IT,
    SERVICES,
    ADMINISTRATION;

    public static final Map<EmployeeDepartment, Set<EmployeeDesignation>> departmentDesignationMap = new HashMap<>();
    static {
        departmentDesignationMap.put(EmployeeDepartment.HR, Set.of(EmployeeDesignation.HR_LEAD, EmployeeDesignation.HR_MANAGER));
        departmentDesignationMap.put(EmployeeDepartment.SALES, Set.of(EmployeeDesignation.SALES_EXECUTIVE,
                EmployeeDesignation.SALES_MANAGER));
        departmentDesignationMap.put(EmployeeDepartment.FINANCE, Set.of(EmployeeDesignation.ACCOUNT_ASSISTANT,
                EmployeeDesignation.ACCOUNT_MANAGER));
        departmentDesignationMap.put(EmployeeDepartment.IT, Set.of(EmployeeDesignation.IT_MANAGER,
                EmployeeDesignation.IT_TEAM_LEAD, EmployeeDesignation.SOFTWARE_ENGINEER));
        departmentDesignationMap.put(EmployeeDepartment.SERVICES, Set.of(EmployeeDesignation.SERVICE_MANAGER,
                EmployeeDesignation.TECHNICAL_ENGINEER));
        departmentDesignationMap.put(EmployeeDepartment.ADMINISTRATION, Set.of(EmployeeDesignation.OFFICE_ASSISTANT,
                EmployeeDesignation.RECEPTIONIST, EmployeeDesignation.ADMIN_MANAGER, EmployeeDesignation.FACILITY_MANAGER));
    }
}
