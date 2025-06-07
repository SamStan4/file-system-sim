package io.github.samstan4.filesystem.tree;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.Collections;
import java.time.ZonedDateTime;

public abstract class TreeNodeBase {

  protected String name;

  protected ZonedDateTime timeCreated;

  protected TreeNodeBase parentLink;
  protected TreeNodeBase rightSiblingLink;
  
  // MARK: constructors

  public TreeNodeBase(final String newName) {
    this.name = newName;
    this.timeCreated = ZonedDateTime.now();
    this.parentLink = null;
    this.rightSiblingLink = null;
  }

  public TreeNodeBase(final String newName, final ZonedDateTime newTime) {
    this.name = newName;
    this.timeCreated = newTime;
    this.parentLink = null;
    this.rightSiblingLink = null;
  }

  // MARK: setters

  public void setName(final String newName) {
    this.name = newName;
  }

  public void setParentLink(final TreeNodeBase newParentLink) {
    this.parentLink = newParentLink;
  }

  public void setRightSiblingLink(final TreeNodeBase newRightSibling) {
    this.rightSiblingLink = newRightSibling;
  }

  // MARK: getters

  public String getName() {
    return this.name;
  }

  public TreeNodeBase getParentLink() {
    return this.parentLink;
  }

  public TreeNodeBase getRightSiblingLink() {
    return this.rightSiblingLink;
  }

  public ZonedDateTime getTimeCreated() {
    return this.timeCreated;
  }

  public String getTimeCreatedString() {
    return this.timeCreated.toString();
  }

  public String[] getPath() {
    List<String> pathList = new ArrayList<String>();
    for (TreeNodeBase curNode = this; curNode != null; curNode = curNode.parentLink) {
      pathList.add(curNode.name);
    }
    Collections.reverse(pathList);
    return pathList.toArray(new String[0]);
  }

  public String getPathString() {
    return String.join("/", this.getPath());
  }

  // MARK: abstracts

  public abstract String getTypeNiceString();

  public abstract FileType getType();

  public abstract Element toXml(final Document document);

  // MARK: overrides

  @Override
  public String toString() {
    return String.format("%s-%s", this.getType().toString(), this.name);
  }
}