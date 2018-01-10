import com.bpzj.web.domain.Student;
import com.github.pagehelper.PageInfo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:spring-mvc.xml"})
public class MvcTest {

    @Autowired
    WebApplicationContext context;

    // 虚拟MVC请求，获取处理结果
    MockMvc mockMvc;

    @Before
    public void initMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testPage() throws Exception{

        // 使用 MockMvc 模拟请求拿到返回值
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/students").
                param("pn", "1")).andReturn();
        // 请求成功后，请求域中会有pageInfo
        MockHttpServletRequest request = result.getRequest();
        PageInfo pi = (PageInfo) request.getAttribute("pageInfo");
        System.out.println("当前页码" + pi.getPageNum());
        System.out.println("总页码" + pi.getPages());
        System.out.println("总记录数" + pi.getTotal());
        int[] nums = pi.getNavigatepageNums();
        for (int i :nums) {
            System.out.println(" " + i);
        }
        List<Student> students = pi.getList();
        for (Student student : students) {
            System.out.println(student);
        }
    }
}