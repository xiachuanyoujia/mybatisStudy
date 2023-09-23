import com.kuang.dao.BlogMapper;
import com.kuang.pojo.Blog;
import com.kuang.utils.IDutils;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MyTest {
    @Test
    public void addInitBlog() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = new Blog();
        blog.setId(IDutils.getId());
        blog.setTitle("Mybatis如此简单");
        blog.setAuthor("狂神说");
        blog.setCreateTime(new Date());
        blog.setViews(9999);

        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("Java如此简单");
        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("Spring如此简单");
        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("微服务如此简单");
        mapper.addBlog(blog);

        sqlSession.commit(); // 手动提交事务

        sqlSession.close();
    }

    @Test
    public void queryBlogIF() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
//        map.put("title", "Java如此简单");
        map.put("author", "狂神说");

        List<Blog> blogs = mapper.queryBlogIF(map);
        for (Blog blog : blogs ) {
            System.out.println(blog);
        }

        sqlSession.commit(); // 手动提交事务

        sqlSession.close();
    }
}
