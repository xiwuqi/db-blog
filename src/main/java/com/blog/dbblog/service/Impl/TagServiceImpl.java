package com.blog.dbblog.service.Impl;

import com.blog.dbblog.config.page.PageRequest;
import com.blog.dbblog.entity.Tag;
import com.blog.dbblog.mapper.TagMapper;
import com.blog.dbblog.service.TagService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 博客标签实现类
 *
 * @author wuxi
 * @create 2023-08-17
 */
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    TagMapper tagMapper;

    @Override
    public List<Tag> getTagPage(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum,pageSize);
        List<Tag> tagList = tagMapper.getTagPage();
        return tagList;
    }

    @Override
    public int saveTag(Tag tag) throws Exception {
        if (findByTagName(tag.getTagName()) != null) {
            throw new Exception ("标签已存在");
        }
        return tagMapper.createTag(tag);
    }

    @Override
    public int updateTag(Tag tag) {
        return tagMapper.updateTag(tag);
    }

    @Override
    public void deleteTag(Integer tagId) {
        tagMapper.deleteTag(tagId);
    }

    @Override
    public boolean batchAddTag(String tags) throws Exception {
        //将字符串转成数组
        String[] split = tags.split(",");
        List<Tag> tagList = new ArrayList<>();
        //循环数据,放入List集合中
        for (String str : split) {
            //过滤：判断数据库中是否有存在的标签,没有就添加，有就不添加
            if (findByTagName(str) == null) {
                Tag tag = new Tag();
                tag.setTagName(str);
                tagList.add(tag);
            }
        }
        //我们限制下添加的数量，一次最多添加10个标签
        if (tagList == null || tagList.size() == 0 || tagList.size() > 10){
            throw new Exception ("标签已存在或超过添加标签的限制！");
        }
        boolean isStatus = tagMapper.batchAddTag(tagList);
        return isStatus;
    }

    @Override
    public boolean batchDelTag(String ids){
        //将id字符串转成数组
        String[] split = ids.split(",");
        List<Integer> idList = new ArrayList<>();
        for (String id : split) {
            idList.add(Integer.valueOf(id));
        }
        boolean isStatus = tagMapper.deleteBatch(idList);
        return isStatus;
    }

    @Override
    public Tag findByTagName(String tagName) {
        Tag tag = new Tag();
        tag.setTagName(tagName);
        Tag byTagName = tagMapper.getByTagName(tag);
        return byTagName;
    }

}
