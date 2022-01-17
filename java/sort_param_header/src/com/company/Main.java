package com.company;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<EmployeeDTO> list = new ArrayList<>();

        EmployeeDTO e1 = new EmployeeDTO();
        e1.setId(3L);
        e1.setName(null);
        e1.setSalary(new BigDecimal("1000"));
        e1.setRegister(LocalDateTime.now());
        list.add(e1);

        EmployeeDTO e2 = new EmployeeDTO();
        e2.setId(2L);
        e2.setName(null);
        e2.setSalary(null);
        e2.setRegister(LocalDateTime.now().plusDays(120));
        list.add(e2);

        EmployeeDTO e3 = new EmployeeDTO();
        e3.setId(1L);
        e3.setName(null);
        e3.setSalary(new BigDecimal("1000.001"));
        e3.setRegister(LocalDateTime.now().plusDays(12));
        list.add(e3);

        EmployeeDTO e4 = new EmployeeDTO();
        e4.setId(5L);
        e4.setName(null);
        e4.setSalary(null);
        e4.setRegister(LocalDateTime.now().plusDays(30));
        list.add(e4);

        EmployeeDTO e5 = new EmployeeDTO();
        e5.setId(4L);
        e5.setName(null);
        e5.setSalary(new BigDecimal("1000.1102"));
        e5.setRegister(null);
        list.add(e5);

        DynamicComparator.sort(list, "register", true);

        final Iterator<EmployeeDTO> li = list.iterator();
        EmployeeDTO e = null;
        while (li.hasNext()) {
            e = (EmployeeDTO) li.next();
            System.out.println(e.toString());
        }

    }

}
