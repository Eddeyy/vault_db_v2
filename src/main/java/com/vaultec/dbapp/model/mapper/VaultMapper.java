package com.vaultec.dbapp.model.mapper;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class VaultMapper {

    public static <T> T map(T from, T to) {

        Class<?> objClass = to.getClass();
        
        for(Field field : objClass.getDeclaredFields()) {
            try{
                Object objField = new PropertyDescriptor(field.getName(),
                        from.getClass()).getReadMethod().invoke(from);

                new PropertyDescriptor(field.getName(), to.getClass())
                        .getWriteMethod().invoke(to, objField);
            } catch (IntrospectionException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        return to;
    }

    public static <T> T mapNullSafe(T from, T to) {

        Class<?> objClass = to.getClass();

        for(Field field : objClass.getDeclaredFields()) {
            try{
                Object objField = new PropertyDescriptor(field.getName(),
                        from.getClass()).getReadMethod().invoke(from);

                if (objField == null)
                    continue;

                new PropertyDescriptor(field.getName(), to.getClass())
                        .getWriteMethod().invoke(to, objField);
            } catch (IntrospectionException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        return to;
    }

}
