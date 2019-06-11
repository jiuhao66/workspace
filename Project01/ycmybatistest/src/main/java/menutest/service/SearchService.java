package menutest.service;

import menutest.pojo.FilmInfo;

import java.util.List;

/**
 * @author LX
 * @date 2019/3/3 - 15:37
 */
public interface SearchService {

    public List<FilmInfo> selectAllFilmInfo();

    public List<FilmInfo> selectByFilmInfo(FilmInfo filmInfo);

}
