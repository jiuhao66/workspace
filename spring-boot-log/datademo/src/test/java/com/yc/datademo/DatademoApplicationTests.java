package com.yc.datademo;

import com.yc.datademo.mapper.NovelMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DatademoApplicationTests {

	@Autowired
	NovelMapper novelMapper;
	@Test
	public void contextLoads(){

		System.out.println(novelMapper.getNovelById(1l));
	}

}
