package com.dev.payments.category;

import com.dev.payments.common.DtoMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends DtoMapper <Category, CategoryDTO> {

}
