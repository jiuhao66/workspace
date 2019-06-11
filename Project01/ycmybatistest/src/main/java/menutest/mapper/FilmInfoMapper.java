package menutest.mapper;

import menutest.pojo.FilmInfo;

import java.util.List;

/**
 * @author LX
 * @date 2019/3/3 - 15:06
 */
public interface FilmInfoMapper {

    List<FilmInfo> selAll();

    int insFilmInfo( FilmInfo  fileInfo);

    List<FilmInfo> selByFilmInfo(FilmInfo filmInfo);

}
