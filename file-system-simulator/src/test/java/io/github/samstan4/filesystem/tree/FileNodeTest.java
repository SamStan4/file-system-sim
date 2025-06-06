package io.github.samstan4.filesystem.tree;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

@DisplayName("File node tests")
public class FileNodeTest {

  @Test
  @DisplayName("tests the file node getters, setters")
  public void test01() {
    final String testName = "index.html";
    final FileType testType = FileType.FILE;
    TreeNodeBase testNode = new FileNode(testName);
    assertEquals(testNode.getType(), testType);
    assertEquals(testNode.getName(), testName);
    assertNull(testNode.getParentLink());
    assertNull(testNode.getRightSiblingLink());
  }
}