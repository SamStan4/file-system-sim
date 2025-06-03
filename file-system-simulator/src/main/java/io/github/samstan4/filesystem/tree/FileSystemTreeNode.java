package io.github.samstan4.filesystem.tree;
import java.time.ZonedDateTime;

public class FileSystemTreeNode {

  private String name;
  private FileType type;
  private ZonedDateTime timeCreated;
  private FileSystemTreeNode parent;
  private FileSystemTreeNode sibling;
  private FileSystemTreeNode child;

  // MARK: static methods

  public static boolean validateName(
    final String _name
  ) {
    if (_name == null || _name.isEmpty()) {
      return false;
    }
    return !(_name.contains("/") || _name.contains(" "));
  }

  // MARK: constructors
  
  public FileSystemTreeNode(
    final String _name,
    final FileType _type
  ) {
    this.parent = null;
    this.sibling = null;
    this.child = null;
    this.timeCreated = ZonedDateTime.now();
    this.name = _name;
    this.type = _type;
  }

  public FileSystemTreeNode(
    final String _name,
    final FileType _type,
    final ZonedDateTime _timeCreated
  ) {
    this.parent = null;
    this.sibling = null;
    this.child = null;
    this.timeCreated = _timeCreated;
    this.name = _name;
    this.type = _type;
  }

  // MARK: setters

  public void setName(
    final String _name
  ) {
    this.name = _name;
  }

  public void setType(
    final FileType _type
  ) {
    this.type = _type;
  }

  public void setParent(
    final FileSystemTreeNode _parent
  ) {
    this.parent = _parent;
  }

  public void setSibling(
    final FileSystemTreeNode _sibling
  ) {
    this.sibling = _sibling;
  }

  public void setChild(
    final FileSystemTreeNode _child
  ) {
    this.child = _child;
  }

  // MARK: getters

  public String getName() {
    return this.name;
  }

  public FileType getType() {
    return this.type;
  }

  public ZonedDateTime getTimeCreated() {
    return this.timeCreated;
  }

  public String getTimeCreatedString() {
    return this.timeCreated.toString();
  }

  public FileSystemTreeNode getParent() {
    return this.parent;
  }

  public FileSystemTreeNode getSibling() {
    return this.sibling;
  }

  public FileSystemTreeNode getChild() {
    return this.child;
  }

  public String[] getPath() {
    java.util.List<String> pathNames = new java.util.ArrayList<String>();
    FileSystemTreeNode curNode = this;
    while (curNode != null) {
      pathNames.add(curNode.getName());
      curNode = curNode.getParent();
    }
    java.util.Collections.reverse(pathNames);
    return pathNames.toArray(new String[0]);
  }

  public String getPathString() {
    return String.join("/", this.getPath());
  }

  // MARK: Overrides

  @Override
  public String toString() {
    return String.format(
      "%s-%s-%s",
      this.type == FileType.dir ? "D" : "F",
      this.timeCreated.toString(),
      this.getPathString()
    );
  }
}