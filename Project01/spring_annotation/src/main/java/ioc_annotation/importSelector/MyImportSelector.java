package ioc_annotation.importSelector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 自定义逻辑返回需要导入的组件
 * @author LX
 * @date 2019/3/17 - 19:13
 */
public class MyImportSelector implements ImportSelector {


    /**
     * 直接 取 bean的路径   后台通过  反射 来  注入 bean
     *
     * 返回值 就是导入到容器中的组件全类名
     *
     * @param annotationMetadata
     * @return
     */
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {

        return new String[]{"ioc_annotation.pojo.Teacher"};
    }
}
