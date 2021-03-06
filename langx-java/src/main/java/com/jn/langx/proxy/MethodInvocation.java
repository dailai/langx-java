package com.jn.langx.proxy;

import java.lang.reflect.Method;

public class MethodInvocation {
    protected Method method;
    protected Object target;
    protected Object[] arguments;
    protected Object proxy;

    public MethodInvocation(Object proxy, Object target, Method method, Object[] arguments) {
        this.arguments = arguments;
        this.proxy = proxy;
        this.target = target;
        this.method = method;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Object[] getArguments() {
        return arguments;
    }

    public void setArguments(Object[] arguments) {
        this.arguments = arguments;
    }

    public Object getProxy() {
        return proxy;
    }

    public void setProxy(Object proxy) {
        this.proxy = proxy;
    }
}
