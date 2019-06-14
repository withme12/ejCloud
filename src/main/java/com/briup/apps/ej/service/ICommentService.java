package com.briup.apps.ej.service;

import com.briup.apps.ej.bean.Comment;

import java.util.List;

public interface ICommentService {
    List<Comment> findAll();

    // List<CustomerExample> query(CustomerExample customerExample);

    Comment selectById(Long id);

    int saveOrUpdate(Comment comment) throws Exception;

    int deleteById(Long id) throws  Exception;

    void batchDelete(long[] ids) throws Exception;


}
