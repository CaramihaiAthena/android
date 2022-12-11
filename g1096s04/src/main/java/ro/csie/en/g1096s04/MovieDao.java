package ro.csie.en.g1096s04;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

//Room - library
//DAO - data acess object  (this DAO includes methods that offer abstract access to my app's database)
@Dao
public interface MovieDao {

    @Query("select * from movie")
    List<Movie> getAllMovies();

    @Query("select * from movie where id=:movieId")
    Movie getMovieById(long movieId);

    @Insert
    long insert(Movie movie); //return the new movieId

    @Update
    int update(Movie movie); //indicates the number of rows that were updated successfully

    @Update
    int update(List<Movie> movies);

    @Delete
    int delete(Movie movie);

    @Query("DELETE FROM movie WHERE id = :movieId")
    void deleteMovieById(int movieId);
}
