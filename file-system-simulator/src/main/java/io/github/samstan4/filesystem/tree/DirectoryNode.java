package io.github.samstan4.filesystem.tree;

import java.time.ZonedDateTime;

public class DirectoryNode extends TreeNodeBase {

  // Only a directory can have children
  TreeNodeBase firstChildLink;

  // MARK: constructors

  public DirectoryNode(final String newName) {
    super(newName);
    this.firstChildLink = null;
  }

  public DirectoryNode(final String newName, final ZonedDateTime newTime) {
    super(newName, newTime);
    this.firstChildLink = null;
  }

  // MARK: setters

  public boolean addChild(final String newChildName, final FileType newType) {
    if (this.hasChild(newChildName)) {
      return false;
    }
    
    return true;
  }

  // MARK: getters

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

  // MARK: overrides
  
  @Override
  public FileType getType() {
    return FileType.DIRECTORY;
  }
}