package com.company;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class DynamicComparator implements Comparator<Object> {

    private static final String STRING_INSTANCE = "java.lang.String";

    private static final String BIG_DECIMAL_INSTANCE = "java.math.BigDecimal";

    private static final String LOCALDATETIME_INSTANCE = "java.time.LocalDateTime";

    private String field;

    private boolean sortAsc;

    private String fieldReturnType;

    private Method method;

    private int result;

    private List<EmployeeDTO> collection;

    public static void sort(Collection<EmployeeDTO> collection, String field, boolean sortAsc) {
        Collections.sort((List<EmployeeDTO>) collection, new DynamicComparator(field, sortAsc));
    }

    @Override
    public int compare(Object o1, Object o2) {

        try {

            if (STRING_INSTANCE.equalsIgnoreCase(this.fieldReturnType)) {
                String f1 = (String) invoke(this.method, o1);
                String f2 = (String) invoke(this.method, o2);

                System.out.println(String.format("[%s, %s]", f1, f2));

                if (f1 == null && f2 == null) {
                    if (this.sortAsc) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
                if (f1 == null) {
                    if (this.sortAsc) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
                if (f2 == null) {
                    if (this.sortAsc) {
                        return -1;
                    } else {
                        return 1;
                    }
                }

                result = f1.compareTo(f2);
                result *= getSortOrder();

            }

            if (LOCALDATETIME_INSTANCE.equalsIgnoreCase(this.fieldReturnType)) {
                LocalDateTime f1 = (LocalDateTime) invoke(this.method, o1);
                LocalDateTime f2 = (LocalDateTime) invoke(this.method, o2);

                System.out.println(String.format("[%s, %s]", f1, f2));

                if (f1 == null && f2 == null) {
                    if (this.sortAsc) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
                if (f1 == null) {
                    if (this.sortAsc) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
                if (f2 == null) {
                    if (this.sortAsc) {
                        return -1;
                    } else {
                        return 1;
                    }
                }

                result = f1.compareTo(f2);
                result *= getSortOrder();

            }

            if (BIG_DECIMAL_INSTANCE.equalsIgnoreCase(this.fieldReturnType)) {
                BigDecimal f1 = (BigDecimal) invoke(this.method, o1);
                BigDecimal f2 = (BigDecimal) invoke(this.method, o2);

                System.out.println(String.format("[%s, %s]", f1, f2));

                if (f1 == null && f2 == null) {
                    if (this.sortAsc) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
                if (f1 == null) {
                    if (this.sortAsc) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
                if (f2 == null) {
                    if (this.sortAsc) {
                        return -1;
                    } else {
                        return 1;
                    }
                }

                result = f1.compareTo(f2);
                result *= getSortOrder();

            }

            return result;
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private DynamicComparator(String field, boolean sortAsc) {
        super();

        // get field need sort
        this.field = constructMethodName(field);
        this.sortAsc = sortAsc;

        System.out.println("Field Sort: " + this.field);
        System.out.println("Sort ASC: " + this.sortAsc);

        try {

            EmployeeDTO dto = new EmployeeDTO();

            // getter of field sort
            this.method = getMethod(dto, this.field);

            // get type of field sort
            this.fieldReturnType = this.method.getReturnType().getName();

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

    /**
     * Not used for sorting. Only here to meet the requirements of the Comparator
     interface.
     *
     * @param o The object for comparison
     * @return boolean
     */
    public boolean equals(Object o) {
        return true;
    }

    private static String constructMethodName(String field) {
        StringBuilder sb = new StringBuilder("get");
        sb.append(field.substring(0, 1).toUpperCase());
        sb.append(field.substring(1));
        return sb.toString();
    }

    private static Method getMethod(Object o, String field) throws NoSuchMethodException {
        return o.getClass().getMethod(field);
    }

    private static Object invoke(Method method, Object o) throws InvocationTargetException, IllegalAccessException {
        return method.invoke(o);
    }

    private int getSortOrder() {
        return this.sortAsc ? 1 : -1;
    }

}
