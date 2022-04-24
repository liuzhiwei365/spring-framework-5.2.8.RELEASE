package org.lzw.base.conf;

import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

public class MyFilterType implements TypeFilter {

    /** metadataReader 可以获取当前正在扫描的类的信息
     *  metadataReaderFactory  可以获取其他任何类的信息
     */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        //获取注解元数据
        AnnotationMetadata am = metadataReader.getAnnotationMetadata();
        //获取类元数据
        ClassMetadata cm = metadataReader.getClassMetadata();
        //获取类资源
        Resource re = metadataReader.getResource();

        return  false;
        //return am.getClassName()!="org.lzw.base.BookDao"?false:true;
    }
}

