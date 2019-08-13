package com.jn.langx.util.collect.function;

/**
 * A factory that is similar to Java 8 Supplier.
 * @param <I> the argument
 * @param <O> the result
 */
public interface Supplier<I,O>{
    O get(I input);
}
