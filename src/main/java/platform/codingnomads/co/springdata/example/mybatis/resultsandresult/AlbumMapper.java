package platform.codingnomads.co.springdata.example.mybatis.resultsandresult;

import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

@Mapper
public interface AlbumMapper {

    @Insert("INSERT INTO mybatis.albums " +
            "(name, artist_name, year_released) " +
            "VALUES (#{name}, #{artistName}, #{yearReleased});")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insertNewAlbum(Album album);

    @Select("SELECT * " +
            "FROM mybatis.albums " +
            "WHERE id = #{param1};")
    @Results(
            id = "albumResultMap",
            value = {
                    @Result(property = "artistName", column = "artist_name"),
                    @Result(property = "yearReleased", column = "year_released")
            }
    )
    Album getAlbumById(Long id);

    @Select("SELECT * " +
            "FROM mybatis.albums " +
            "WHERE name = #{param1};")
    @ResultMap("albumResultMap")
    ArrayList<Album> getAlbumsByName(String name);

    @Select("SELECT * " +
            "FROM mybatis.albums " +
            "WHERE artist_name = #{param1};")
    @ResultMap("albumResultMap")
    ArrayList<Album> getAlbumsByArtist(String artistName);

    @Update("UPDATE mybatis.albums " +
            "SET name = #{name}, artist_name = #{artistName}, year_released = #{yearReleased} " +
            "WHERE id = #{id};")
    ArrayList<Album> updateAlbum(Album album);

    @Delete("DELETE FROM mybatis.albums WHERE id = #{param1};")
    ArrayList<Album> deleteAlbumById(Long albumId);

    @Delete("DELETE FROM mybatis.albums " +
            "WHERE artist_name = #{artistName};")
    void deleteAlbumsByArtist(String artistName);
}