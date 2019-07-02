package com.dev.payments.common;

import java.util.List;

public interface DtoMapper<T, DTO> {
    DTO toOut(T t);

    List<DTO> toOut(List<? extends T> tList);

}
