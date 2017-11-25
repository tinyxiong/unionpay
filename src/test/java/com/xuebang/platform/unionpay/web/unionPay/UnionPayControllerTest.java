package com.xuebang.platform.unionpay.web.unionPay;

import com.xuebang.platform.common.AbstractControllerTest;
import org.junit.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.MultiValueMap;
import org.springframework.web.servlet.FlashMap;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UnionPayControllerTest extends AbstractControllerTest {

    @Test
    public void add() throws Exception {
        mockMvc.perform(post("/UnionPayController/add.do")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("{\n" +
                        "\t\"paidAmount\": \"250\",\n" +
                        "\t\"remark\": \"add test\",\n" +
                        "\t\"blCampusId\": \"1020\",\n" +
                        "\t\"blCampusName\": \"ojiwoefjwife\",\n" +
                        "\t\"institutionId\": \"1\",\n" +
                        "\t\"codeNumber\": \"123\",\n" +
                        "\t\"terminalNumber\": \"456\"\n" +
                        "}")).andExpect(status().isOk()).andReturn();
    }

    @Test
    public void page() throws Exception {

        MvcResult result = mockMvc.perform(get("/UnionPayController/page.do")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("blCampusId", "1")
                .param("institutionId", "11")
                .param("terminalNumber", "1234567")
        ).andExpect(status().isOk()).andReturn();
    }

    @Test
    @Rollback
    public void confirm() throws Exception {
        MvcResult result = mockMvc.perform(get("/UnionPayController/confirm/14.do")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
        ).andExpect(status().isOk()).andReturn();
    }

    @Test
    @Rollback
    public void success() throws Exception {
        MvcResult result = mockMvc.perform(get("/UnionPayController/success/15.do")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
        ).andExpect(status().isOk()).andReturn();
    }

    @Test
    @Rollback
    public void failed() throws Exception {
        MvcResult result = mockMvc.perform(get("/UnionPayController/failed/15.do")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
        ).andExpect(status().isOk()).andReturn();
    }

}