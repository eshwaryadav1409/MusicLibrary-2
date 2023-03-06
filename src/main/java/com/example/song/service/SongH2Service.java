package com.example.song.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

//import org.springframework.http.HttpStatus;
//import org.springframework.web.server.ResponseStatusException;
import com.example.song.model.Song;
import com.example.song.model.SongRowMapper;
import com.example.song.repository.SongRepository;

import java.util.*;

@Service
public class SongH2Service implements SongRepository{
    @Autowired
    private JdbcTemplate db;


    @Override
    public ArrayList<Song> getSongs(){
        List<Song> songList = db.query("select * from playlist", new SongRowMapper());
        ArrayList<Song> songs = new ArrayList<>(songList);
        return songs;
    }
}