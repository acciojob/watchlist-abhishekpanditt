package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import java.util.HashMap;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    MovieService ms;
    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        String ans = ms.addMovie(movie);
        return new ResponseEntity<>(ans,HttpStatus.CREATED);
    }
    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director) {
        String ans = ms.addDirector(director);
        return new ResponseEntity<>(ans,HttpStatus.CREATED);
    }
    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movieName")String movieName,@RequestParam("dirName") String dirName){
        String ans = ms.addPair(movieName,dirName);
        return new ResponseEntity<>(ans,HttpStatus.CREATED);
    }
    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name")String name){
        Movie m = ms.getMovieByName(name);
        return new ResponseEntity<>(m,HttpStatus.CREATED);
    }
    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("name")String name){
        Director d = ms.getDirectorByName(name);
        return new ResponseEntity<>(d,HttpStatus.CREATED);
    }
    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("director")String name){
        List<String> m = ms.getMoviesByDirectorName(name);
        return new ResponseEntity<>(m,HttpStatus.CREATED);
    }
    @GetMapping("/get-all-movies")
    public ResponseEntity<List<Movie>> findAllMovies(){

        return new ResponseEntity<>(ms.findAllMovies(),HttpStatus.CREATED);
    }
    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(String name){
        String ans = ms.deleteDirectorByName(name);
        return new ResponseEntity<>(ans,HttpStatus.OK);
    }
    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        String and  = ms.deleteAll();
        return new ResponseEntity<>(and,HttpStatus.OK);
    }
}
