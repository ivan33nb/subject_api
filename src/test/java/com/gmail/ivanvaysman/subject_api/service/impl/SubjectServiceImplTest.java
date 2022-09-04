package com.gmail.ivanvaysman.subject_api.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import com.tej.JooQDemo.jooq.sample.model.tables.Subject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
class SubjectServiceImplTest {
  
  private DSLContext dslContext;

  @Container
  private static final MySQLContainer<?> mySqlDB =
      new MySQLContainer<>("mysql:5.7.37").withInitScript("db/create-and-fill-test-table.sql");

  @DynamicPropertySource
  public static void properties(DynamicPropertyRegistry registry) {
    registry.add("spring.datasource.url", mySqlDB::getJdbcUrl);
    registry.add("spring.datasource.username", mySqlDB::getUsername);
    registry.add("spring.datasource.password", mySqlDB::getPassword);
  }

  @BeforeEach
  public void init() throws SQLException {
    dslContext = DSL.using(mySqlDB.createConnection(""), SQLDialect.MYSQL);
  }

  @Test
  public void checkContainerIsRunning() {
    assertTrue(mySqlDB.isRunning());
  }

  @Test
  public void checkElementCount(){
    Result<Record> selectAll = dslContext.fetch("select * from test.subject_test");
    assertEquals(selectAll.size(), 10);
  }

  @Test
  public void checkFindById(){
    Result<Record> selectById = dslContext.fetch("select * from test.subject_test st where st.id = 1");

    assertEquals(selectById.size(), 1);
    assertFalse(selectById.isEmpty());

    Record record = selectById.get(0);

    String name = (String) record.getValue("name");
    String comment = (String) record.getValue("comment");

    assertEquals(name, "1");
    assertEquals(comment, "one");
  }

  @Test
  public void checkUpdateEntity(){
    final String updateName = "update_name";
    final String updateComment = "update_comment";
    final String selectByIdQuery = "select * from test.subject_test st where st.id = 2";

    Result<Record> selectByIdBeforeUpdate = dslContext.fetch(selectByIdQuery);

    assertEquals(selectByIdBeforeUpdate.size(), 1);
    assertFalse(selectByIdBeforeUpdate.isEmpty());

    Record recordBeforeUpdate = selectByIdBeforeUpdate.get(0);

    String nameBeforeUpdate = (String) recordBeforeUpdate.getValue("name");
    String commentBeforeUpdate = (String) recordBeforeUpdate.getValue("comment");

    assertEquals(nameBeforeUpdate, "2");
    assertEquals(commentBeforeUpdate, "two");

    dslContext.query(String.format("update test.subject_test st set st.name = '%s', st.comment = '%s' where st.id = %d", updateName, updateComment, 2)).execute();

    Result<Record> selectAllAfterUpdate = dslContext.fetch(selectByIdQuery);

    assertEquals(selectAllAfterUpdate.size(), 1);
    assertFalse(selectAllAfterUpdate.isEmpty());

    Record recordAfterUpdate = selectAllAfterUpdate.get(0);

    String nameAfterUpdate = (String) recordAfterUpdate.getValue("name");
    String commentAfterUpdate = (String) recordAfterUpdate.get("comment");

    assertNotEquals(nameBeforeUpdate, nameAfterUpdate);
    assertNotEquals(commentBeforeUpdate, commentAfterUpdate);
    assertEquals(nameAfterUpdate, updateName);
    assertEquals(commentAfterUpdate, updateComment);

  }
}