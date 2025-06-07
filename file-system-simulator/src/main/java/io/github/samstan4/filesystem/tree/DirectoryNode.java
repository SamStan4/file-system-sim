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

  /**
   * @param newChild the node that we are inserting into the tree
   * @apiNote this should only ever be called if it has already been verified that this results in no duplicates.
   */
  private boolean addChild(final TreeNodeBase newChild) {
    if (newChild == null) {
      return false;
    }
    newChild.setRightSiblingLink(this.firstChildLink);
    newChild.setParentLink(this);
    this.firstChildLink = newChild;
    return true;
  }

  /**
   * @apiNote adds child to the current node. Does an insert at front
   * @param newType file/dir
   * @param newChildName name of the file/dir
   * @return true or false depending on wether or not the node was inserted
   */
  public boolean addChild(final FileType newType, final String newChildName) {
    if (this.hasChild(newChildName)) {
      return false;
    }
    return this.addChild(TreeNodeFactory.createNode(newType, newChildName));
  }

  /**
   * @apiNote adds child to the current node. Does an insert at front
   * @param newType file/dir
   * @param newChildName name of the file/dir
   * @param newChildTime the time that the child was created
   * @return true or false depending on wether or not the node was inserted
   */
  public boolean addChild(final FileType newType, final String newChildName, final ZonedDateTime newChildTime) {
    if (this.hasChild(newChildName)) {
      return false;
    }
    return this.addChild(TreeNodeFactory.createNode(newType, newChildName, newChildTime));
  }

  // MARK: getters

  public TreeNodeBase getChild(final String childName) {
    TreeNodeBase curChild = this.firstChildLink;
    while (curChild != null) {
      if (childName == curChild.name) {
        return curChild;
      }
      curChild = curChild.getRightSiblingLink();
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