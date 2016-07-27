package com.abc.app.memberapp;

import java.util.List;

/**
 * Created by hb2017 on 2016-07-27.
 */
public interface MemberService {
    public String regist(MemberBean mem);
    public void update(MemberBean mem);
    public void delete(MemberBean mem);
    public MemberBean findById(String id);
    public List<?> findBy(String keyword);


}
