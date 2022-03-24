package com.example.demoproject;

import com.example.demoproject.domain.Video;
import com.example.demoproject.service.VideoService;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;
import java.nio.charset.Charset;
import java.util.List;

@RunWith(SpringRunner.class) //底层⽤junit SpringJUnit4ClassRunner
@SpringBootTest(classes={DemoProjectApplication.class})//启动整个springboot⼯程
@AutoConfigureMockMvc
public class VideoTest {
    @Autowired
    private VideoService videoService;
//    @Test
//    public void testVideoList(){
//        List<Video> videoList = videoService.listVideo();
//        TestCase.assertTrue(videoList.size()>0);
//    }
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void testVideoListApi()throws Exception{
        MvcResult mvcResult =
                mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/pub/video/list"))

                        .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        int status = mvcResult.getResponse().getStatus();
        System.out.println(status);
        //会乱码
        //String result = mvcResult.getResponse().getContentAsString();
        // 使⽤下⾯这个，增加 编码 说明，就不会乱码打印
        String result =
                mvcResult.getResponse().getContentAsString(Charset.forName("utf-8"));
        System.out.println(result);
    }
}
