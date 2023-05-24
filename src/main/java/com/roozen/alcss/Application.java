package com.roozen.alcss;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;

/**
 * <p>
 * 应用程序启动类
 * </p>
 *
 * @author <a href="https://roozen.top">Roozen</a>
 * @since 2023-05-20
 * @version 1.0
 */
@Slf4j
@SpringBootApplication
@MapperScan("com.roozen.alcss.mapper")
public class Application {
//    private static final Logger log = LoggerFactory.getLogger(AustLabCourseSchedulingSystemApplication.class); 用@Slf4j代替

    @SneakyThrows
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        ConfigurableApplicationContext application = app.run(args);
        //ConfigurableApplicationContext application=SpringApplication.run(Knife4jSpringBootDemoApplication.class, args);
        Environment env = application.getEnvironment();
        String hostAddress = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port");
        String applicationName = env.getProperty("spring.application.name");
        log.info("""
                    
                    ----------------------------------------------------------
                    Application '{}' is running! Access URLs:
                    Local: \t\thttp://localhost:{}
                    External: \thttp://{}:{}
                    Doc: \t\thttp://{}:{}/doc.html
                    ----------------------------------------------------------
                    
                    """,
                applicationName,
                port,
                hostAddress,
                port,
                hostAddress,
                port);
    }

}
