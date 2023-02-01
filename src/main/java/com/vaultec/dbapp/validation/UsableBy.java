package com.vaultec.dbapp.validation;

import com.vaultec.dbapp.model.enums.UserType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface UsableBy {

    UserType[] value() default UserType.OVERSEER;
}
