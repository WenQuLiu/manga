package com.baizhi.cmfz.cmfzadmin.util;

import org.apache.shiro.crypto.hash.Md5Hash;

import java.io.UnsupportedEncodingException;

/**
 * Created by Administrator on 2018/7/11.
 */
public class Md5Test {

    public static void main(String[] args) throws UnsupportedEncodingException {
        Md5Hash md5Hash = new Md5Hash("123", "123", 512);
        System.out.println(md5Hash);
//        byte[] bytes = Base64.decode("5V/h4ZnozbBIiKAAV5+jyhBdRtMffGhYDYzrR8m/EOL17r5hPkatnlBK1vl7S2N3TDBmRpkRxWPRvkr3oTXTb8QjiT+DWfdQuHekguRf3YVmYH3AGNua3dj+XJKcFi5BcJybqhS7smMTpuFU2/YOx0cSauUYTCblareK51jzUYZ3IqmtrUi7gIJc7GYpViGR5nYvQMciXJ8QlrkT/TcyNMQ7Kwg7BK0GemvceULxGFpwQB0MDZ+I3GHFFuzP+pKerZtTRQC7POjJDA1lJwG4nP8apvsSE8fHj40IBEdjD5RTmAkr3yUVDIKE5AF/tYL4LpRsdEY55Fx7nqfozMfBs5dda0/V0QsI3d4gJ7ZOedGWKm1pKUqNadGfsZmPHvhas1DQWe3cdLaWkk7JXJutZnGEZ6l6QpDHUoY7pJaxGQwwOjCTUYGxb+EVNDfkA/kdRiFLpZLk87uF8fNmlf1+PFNWsnSkVeuZuzySGlNasDRsKED25ttz8uyiuakdVYeQoSV9Y4R5LWrN9ZVsPqKy8w==");
//        System.out.println(new String(bytes,"iso-8859-1"));
    }
}
