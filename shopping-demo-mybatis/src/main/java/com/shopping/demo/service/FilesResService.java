package com.shopping.demo.service;

import com.shopping.demo.entity.FilesRes;

import java.util.List;

/**
 * @Author ldc
 * @Date 2020/12/17 14:36
 * @Version 1.0
 */
public interface FilesResService {

    List<FilesRes> saveFileRes(List<FilesRes> filesRes);

    void deleteFilesRes(List<FilesRes> filesResList);

    void deleteFileResByFileId(Long FileId);
}
