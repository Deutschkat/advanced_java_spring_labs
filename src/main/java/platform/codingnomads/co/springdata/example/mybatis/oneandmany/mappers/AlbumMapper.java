package platform.codingnomads.co.springdata.example.mybatis.oneandmany.mappers;

import org.apache.ibatis.annotations.*;
import platform.codingnomads.co.springdata.example.mybatis.oneandmany.models.Album;

import java.util.List;

@Mapper
public interface AlbumMapper {

    @Insert("INSERT INTO mybatis.albums (name, year, artist_id) VALUES (#{name}, #{year}, #{artist.id});")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insertNewAlbum(Album album);

    @Select("SELECT * FROM mybatis.albums WHERE id = #{param1};")
    @Results(id = "albumResultMap", value = {
            @Result(property = "id", column = "id"),
            @Result(property = "songs", column = "id",
                    javaType = List.class,
                    many = @Many(select = "platform.codingnomads.co.springdata.example.mybatis.oneandmany.mappers.SongMapper.getSongsByAlbumId"))
    })
    Album getAlbumById(Long id);

    @Select("SELECT * FROM mybatis.albums WHERE artist_id = #{param1};")
    @ResultMap("albumResultMap")
    List<Album> getAlbumsByArtistId(Long artistId);

    @Update("UPDATE mybatis.albums SET name = #{name}, year = #{year}, artist_id = #{artist.id} WHERE id = #{id};")
    void updateAlbum(Album album);

    @Delete("DELETE FROM mybatis.albums WHERE id = #{param1};")
    void deleteAlbumById(Long albumId);

    @Delete("DELETE FROM mybatis.albums WHERE artist_id = #{artistId};")
    void deleteAlbumsByArtistId(Long artistId);
}
