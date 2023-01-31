package com.vaultec.dbapp.config.routing;

import com.vaultec.dbapp.config.db.DataSourceType;
import jakarta.transaction.Transactional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
    Use this @annotation to set a datasource type for the app to use
    when performing transactions on specific views or tables. In this
    project's context it will mean VAULT for general repositories and
    services, DWELLER for common views and services, and the specified
    user type for others.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Transactional
public @interface WithDatabase {

    DataSourceType value() default DataSourceType.HAMACHI_VAULT;
}
