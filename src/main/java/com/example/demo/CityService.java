package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService implements ICityService {
    @Autowired
    private JdbcTemplate jtm;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public List<FeedMessage> findAll() {

        String sql = "SELECT * FROM rss";

        return jtm.query(sql, new BeanPropertyRowMapper<>(FeedMessage.class));
    }

    @Override
    public FeedMessage create(FeedMessage feedMessage) {
        String INSERT_SQL = "MERGE INTO rss(guid, link, title) values(:guid, :link, :title)";
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("guid", feedMessage.getGuid())
                .addValue("link", feedMessage.getLink())
                .addValue("title", feedMessage.getTitle());
        namedParameterJdbcTemplate.update(INSERT_SQL, parameters);
        return feedMessage;
    }


}
