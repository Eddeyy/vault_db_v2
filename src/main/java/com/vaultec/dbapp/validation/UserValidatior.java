package com.vaultec.dbapp.validation;

import com.vaultec.dbapp.config.routing.WithDatabase;
import com.vaultec.dbapp.model.enums.UserType;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Method;
import java.util.Arrays;

@Getter
@Setter
public class UserValidatior {

    public static boolean isAllowed(String job, Method method) {
        return Arrays.stream(method.getAnnotation(UsableBy.class).value()).anyMatch(val -> val == UserType.valueOf(job));
    }
}
