package com.ityu.models;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TestConverter {
    TestConverter INSTANCE = Mappers.getMapper(TestConverter.class);
    @Mapping(source = "nameA", target = "nameB")
    TestB fromSource(TestA source);
    //继承反方向的配置
    @InheritInverseConfiguration
    TestA toSource(TestB target);
}
