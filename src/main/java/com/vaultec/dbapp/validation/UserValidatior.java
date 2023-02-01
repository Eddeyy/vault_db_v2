package com.vaultec.dbapp.validation;
import com.vaultec.dbapp.model.enums.UserType;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Method;
import java.util.Arrays;

@Getter
@Setter
public class UserValidatior {

    public static boolean isAllowed(String job) {
        StackWalker walker = StackWalker
                .getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);
        try {
            Method method = walker.getCallerClass().getDeclaredMethod(walker.walk(frames -> frames
                    .map(StackWalker.StackFrame::getMethodName)
                    .skip(1)
                    .findFirst()).toString());

            return Arrays.stream(method.getAnnotation(UsableBy.class).value()).anyMatch(val -> val == UserType.valueOf(job));
        }catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return false;
    }
}
