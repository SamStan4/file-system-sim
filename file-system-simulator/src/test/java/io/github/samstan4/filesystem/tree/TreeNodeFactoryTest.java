package io.github.samstan4.filesystem.tree;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.ZonedDateTime;
import org.junit.jupiter.api.DisplayName;

@DisplayName("tree node factory tests")
public class TreeNodeFactoryTest {

  @Test
  @DisplayName("name only dir node creation")
  public void test01() {
    final FileType testType = FileType.DIRECTORY;
    final String testName = "Desktop";
    TreeNodeBase testNode = TreeNodeFactory.createNode(testType, testName);
    assertNotNull(testNode);
    assertEquals(testType, testNode.getType());
    assertEquals(testName, testNode.getName());
  }

  @Test
  @DisplayName("name and time dir node creation")
  public void test02() {
    final FileType testType = FileType.DIRECTORY;
    final String testName = "Desktop";
    final ZonedDateTime testTime = ZonedDateTime.now();
    TreeNodeBase testNode = TreeNodeFactory.createNode(testType, testName, testTime);
    assertNotNull(testNode);
    assertEquals(testType, testNode.getType());
    assertEquals(testName, testNode.getName());
    assertEquals(testTime, testNode.getTimeCreated());
  }

  @Test
  @DisplayName("name only file node creation")
  public void test03() {
    final FileType testType = FileType.FILE;
    final String testName = "cool_image.txt";
    TreeNodeBase testNode = TreeNodeFactory.createNode(testType, testName);
    assertNotNull(testNode);
    assertEquals(testType, testNode.getType());
    assertEquals(testName, testNode.getName());
  }

  @Test
  @DisplayName("name and time file node creation")
  public void test04() {
    final FileType testType = FileType.FILE;
    final String testName = "virus_download.exe";
    final ZonedDateTime testTime = ZonedDateTime.now();
    TreeNodeBase testNode = TreeNodeFactory.createNode(testType, testName, testTime);
    assertNotNull(testNode);
    assertEquals(testType, testNode.getType());
    assertEquals(testName, testNode.getName());
    assertEquals(testTime, testNode.getTimeCreated());
  }
}