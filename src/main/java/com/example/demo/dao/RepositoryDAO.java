package com.example.demo.dao;

import java.util.List;

public interface RepositoryDAO <S> {

     List<S> all();
     void create(S s);
     void update(S s);
     void delete(S s);
     S findOne(Integer id);

}
