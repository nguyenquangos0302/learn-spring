package com.securityauditing.demo.convert;

import java.util.function.Function;

public interface IConvertData<E, T> extends Function<E, T> {

    E convertToDtoOrModel(T tObject);

    T convertToEntity(E eObject);

}
