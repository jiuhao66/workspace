package menutest.service.impl;

import menutest.mapper.TeacherMapper;
import menutest.pojo.Teacher;
import menutest.service.TeacherService;

import java.util.List;

/**
 * @author LX
 * @date 2019/1/30 - 19:19
 */
public class TeacherServiceImpl implements TeacherService {

    private TeacherMapper teacherMapper ;

    public TeacherMapper getTeacherMapper() {
        return teacherMapper;
    }

    public void setTeacherMapper(TeacherMapper teacherMapper) {
        this.teacherMapper = teacherMapper;
    }

    @Override
    public List<Teacher> show() {

        return teacherMapper.selAll();
    }
}
