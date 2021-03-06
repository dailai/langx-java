package com.jn.langx.util.reflect.parameter;

import com.jn.langx.annotation.Name;

import java.lang.reflect.Method;

@Name("langx_java6")
public class Java6MethodParameterSupplier extends AbstractMethodParameterSupplier {
    @Override
    public MethodParameter get(ParameterMeta meta) {
        init();
        return new Java6MethodParameter(meta.getName(), meta.getModifiers(), (Method) meta.getExecutable(), meta.getIndex());
    }

    @Override
    public boolean usingJdkApi() {
        return false;
    }
}
