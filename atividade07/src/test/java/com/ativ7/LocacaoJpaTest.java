package com.ativ7;

import com.ativ7.api.App;

import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = App.class)
@AutoConfigureMockMvc
@TestMethodOrder(OrderAnnotation.class)
public class LocacaoJpaTest {
}
