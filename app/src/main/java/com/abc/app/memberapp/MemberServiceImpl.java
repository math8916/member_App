package com.abc.app.memberapp;

import com.abc.app.memberapp.MemberBean;
import com.abc.app.memberapp.MemberDAO;
import com.abc.app.memberapp.MemberService;

import java.util.List;
import java.util.Map;

/**
 * Created by hb2017 on 2016-07-27.
 */
public class MemberServiceImpl implements MemberService {


    MemberBean session;
    private static MemberServiceImpl instance = new MemberServiceImpl();

    private MemberServiceImpl() {
        // TODO Auto-generated constructor stub
    }

    public static MemberServiceImpl getInstance() {
        return instance;
    }

    // MemberBean mem = Class.forName("member.MemberBean").newInstance();
    @Override
    // 1.등록
    public String regist(MemberBean mem) {
        // TODO Auto-generated method stub
        String msg = "";
        int result = dao.insert(mem);
        if (result == 1) {
            msg = "가입 성공";
        } else {
            msg = "가입 실패";
        }
        return msg;
    }

    @Override
    // 2.보기
    public String show() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    // 3. 수정
    public void update(MemberBean mem) {

        int result = dao.update(mem);

        if (result == 1) {
            session = this.findByID(mem.getId());
        }

    }

    @Override
    // 4. 삭제
    public void delete(MemberBean mem) {
        // TODO Auto-generated method stub
        String msg = "";

        if (dao.delete(mem) == 1) {
            msg = "변경 성공";
            session = null;
        } else {
            msg = "변경 실패";
        }

    }

    @Override
    public int count() {
        // TODO Auto-generated method stub
        return dao.count();
    }

    @Override
    public MemberBean findByID(String findID) {
        // TODO Auto-generated method stub

        return dao.findByID(findID);
    }

    @Override
    public List<MemberBean> list() {

        return dao.list();
    }

    @Override
    public List<MemberBean> findByName(String findName) {
        // TODO Auto-generated method stub
        return dao.findByName(findName);
    }

    @Override
    public String login(MemberBean member) {
        // TODO Auto-generated method stub\
        String result = "";

        if (dao.login(member)) {

            session = dao.findByID(member.getId());
            result = session.getName();
            accService.map();
            System.out.println("impl"+session);
        } else {
            result = "";
        }
        return result;
    }



    @Override
    public void logout(MemberBean member) {
        if (member.getId().equals(session.getId()) && member.getPw().equals(session.getPw())) {
            session = null;
        }

    }
}
