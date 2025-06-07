package io.github.samstan4.filesystem.tree;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

@DisplayName("test cases for the directory node")
public class DirectoryNodeTest {

  @Test
  @DisplayName("this test the add child, get child functionality")
  public void test01() {
    final String testFileName = "init.py";
    final DirectoryNode testNode = new DirectoryNode("Desktop");
    testNode.addChild(FileType.FILE, testFileName);
    assertNotNull(testNode.getChild(testFileName));
    assertTrue(testNode.hasChild(testFileName));
  }

  @Test
  @DisplayName("This tests the insertion and removal of child nodes")
  public void test02() {
    final String testDirName = "Downloads";
    final String testChildNameOne = "coolImg.png";
    final String testChildNameTwo = "otherCoolImg.png";
    final FileType testChildType = FileType.FILE;
    final DirectoryNode testDirNode = new DirectoryNode(testDirName);

    // add two children
    assertTrue(testDirNode.addChild(testChildType, testChildNameOne));    
    assertTrue(testDirNode.addChild(testChildType, testChildNameTwo));

    // attempt to add duplicate
    assertFalse(testDirNode.addChild(testChildType, testChildNameOne));
    assertFalse(testDirNode.addChild(testChildType, testChildNameTwo));

    testDirNode.removeChild(testChildNameOne);

    assertFalse(testDirNode.hasChild(testChildNameOne));

    testDirNode.removeChild(testChildNameTwo);

    assertFalse(testDirNode.hasChild(testChildNameTwo));

    assertTrue(testDirNode.addChild(testChildType, testChildNameOne));
  }
}