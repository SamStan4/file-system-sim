package io.github.samstan4.filesystem.tree;

import java.time.ZonedDateTime;

public class DirectoryNode extends TreeNodeBase {

  // Only a directory can have children
  TreeNodeBase firstChildLink;

  public DirectoryNode(final String newName) {
    super(newName);
    this.firstChildLink = null;
  }

  public DirectoryNode(final String newName, final ZonedDateTime newTime) {
    super(newName, newTime);
    this.firstChildLink = null;
  }

  public TreeNodeBase getChild(final String childName) {
    TreeNodeBase curChild = this.firstChildLink;
    while (curChild != null) {
      if (childName == curChild.name) {
        return curChild;
      }
    }
    return curChild;
  }

  public boolean hasChild(final String childName) {
    return this.getChild(childName) != null;
  }
  
  @Override
  public String getType() {
    return "dir";
  }
}