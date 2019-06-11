package menutest.service.impl;

import menutest.mapper.FavoriteMapper;
import menutest.pojo.Favorite;
import menutest.service.FavoriteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class FavoriteServiceImpl implements FavoriteService {

    @Resource
    FavoriteMapper favoriteMapper;
    @Override
    public void addFavorite(Favorite favorite) {

//        String tags = favori

    }
}
