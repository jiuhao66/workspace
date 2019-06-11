package menutest.service.impl;

import menutest.mapper.FilmInfoMapper;
import menutest.pojo.FilmInfo;
import menutest.service.SearchService;

import java.util.List;

/**
 * @author LX
 * @date 2019/3/3 - 15:38
 */
public class SearchServiceImpl implements SearchService {

    private FilmInfoMapper filmInfoMapper;

    public FilmInfoMapper getFilmInfoMapper() {
        return filmInfoMapper;
    }

    public void setFilmInfoMapper(FilmInfoMapper filmInfoMapper) {
        this.filmInfoMapper = filmInfoMapper;
    }

    @Override
    public List<FilmInfo> selectAllFilmInfo() {
        return filmInfoMapper.selAll();
    }

    /**
     * 根据条件 查询
     * @param filmInfo
     * @return
     */
    @Override
    public List<FilmInfo> selectByFilmInfo(FilmInfo filmInfo) {

        return filmInfoMapper.selByFilmInfo(filmInfo);
    }
}
