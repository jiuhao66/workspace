package ioc_annotation.config;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * @author LX
 * @date 2019/3/17 - 10:49
 */
public class MyTypeFilter implements TypeFilter {

    /**
     *
     * @param metadataReader
     * @param metadataReaderFactory
     * @return
     * @throws IOException
     */

    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {


        //获得 当前 注解的信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();


        //获得 当前 正在扫描的类的信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();

        //根据 名字 来  筛取  要 注入的 类
        // return true  表示 包含  否则 不包含
        // 每扫描一个类 就 执行一次  本次方法
        String className = classMetadata.getClassName();

        System.out.println(className);

        //获得 当前类资源 (类路径)
        Resource resource = metadataReader.getResource();

        return false;
    }
}
