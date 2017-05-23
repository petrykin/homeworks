package lesson11.task3;

import java.lang.reflect.Method;

public class CheckingClassMethod extends CheckingMethod {
    public CheckingClassMethod(String name, int parameterCount) {
        super(name, parameterCount);
    }

    @Override
    public boolean isContainedIn(Class<?> c) {
        String methodName;
        if (!c.getSimpleName().equals("Integer")) {
            methodName = getName() + c.getSimpleName();
        } else {
            methodName = getName() + "Int";
        }
        for (Method method : c.getMethods()) {
            if (method.getName().equals(methodName) &&
                    method.getParameterCount() == getParameterCount()) {
                setStatic(method.getModifiers() == super.PUBLIC_STATIC_MODIFIER_NUMBER);
                return true;
            }
        }
        return false;
    }
}
