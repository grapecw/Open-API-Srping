package dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import vo.NewsVO;

@Repository
public class NewsDAO implements NewsDAOinterface {
	
	@Autowired
	SqlSession session = null;
	
	public boolean insert(NewsVO vo) {
		// TODO Auto-generated method stub

		System.out.println("Mybatis 를 사용 DB 연동-insert ");
		boolean result = false;

		// sql session 객체를 만들때 true를 준다.
		// true를 준다는 것은 자동 commit 모드가 활성화 된다.

		String statement = "resource.NewsMapper.insertNews";
		if (session.insert(statement, vo) == 1)
			result = true;

//		 
		return result;
	}
	
	
	public boolean update(NewsVO vo) {
		System.out.println("Mybatis 를 사용 DB 연동-update ");
		boolean result = false;

		// sql session 객체를 만들때 true를 준다.
		// true를 준다는 것은 자동 commit 모드가 활성화 된다.

		System.out.println(vo.getId());
		String statement = "resource.NewsMapper.updateNews";
		if (session.update(statement, vo) == 1)
			result = true;

		return result;
	}


	public boolean delete(int eNo) {
		// TODO Auto-generated method stub

		System.out.println("Mybatis 를 사용 DB 연동-delete ");
		boolean result = false;

		// sql session 객체를 만들때 true를 준다.
		// true를 준다는 것은 자동 commit 모드가 활성화 된다.

		String statement = "resource.NewsMapper.deleteNews";
		if (session.insert(statement, eNo) == 1)
			result = true;
 
		return result;
	}
	

	
	public List<NewsVO> listAll(PagingControl paging) {
		// TODO Auto-generated method stub
		System.out.println("Mybatis 를 사용 DB 연동-listAll ");
		
		paging.postCnt = session.selectOne("resource.NewsMapper.selectTotalNewsNum");
		
		
		List<NewsVO> list = new ArrayList<NewsVO>();
		String statement = "resource.NewsMapper.selectNews";
		list = session.selectList(statement,paging.getPgNum());

		System.out.println(session.getClass().getName());
		return list;
	}


	public NewsVO listOne(int id) {
		// TODO Auto-generated method stub

		System.out.println("Mybatis 를 사용 DB 연동-listOne ");

		// sql session 객체를 만들때 true를 준다.
		// true를 준다는 것은 자동 commit 모드가 활성화 된다.

		String statement = "resource.NewsMapper.selectOneNews";
		NewsVO searchOne = session.selectOne(statement, id);
		
		searchOne.setCnt(searchOne.getCnt()+1);
		statement = "resource.NewsMapper.updateViews";
		session.update(statement,searchOne);
			
		return searchOne;
	}


	
	public List<NewsVO> search(String key, String searchType)  {
		// TODO Auto-generated method stub
		List<NewsVO> list = null;
		
		System.out.println("Mybatis 를 사용 DB 연동-search");


		String statement = null;
		if(searchType.equals("listwriter")) 
			statement = "resource.NewsMapper.searchWriterNews";
		else 
			statement = "resource.NewsMapper.searchTitleNews";

		list = session.selectList(statement,key);
		return list;
	}

	@Override
	public List<NewsVO> listWriter(String writer) {
		// TODO Auto-generated method stub
		return search(writer,"listwriter");
	}


	@Override
	public List<NewsVO> listAll(int num) {
		// TODO Auto-generated method stub
		return null;
	}


}
