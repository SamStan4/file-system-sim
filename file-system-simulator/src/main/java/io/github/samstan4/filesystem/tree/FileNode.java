package io.github.samstan4.filesystem.tree;

import java.time.ZonedDateTime;

public class FileNode extends TreeNodeBase {
  
  public FileNode(final String newName) {
    super(newName);
  }

  public FileNode(final String newName, final ZonedDateTime newTime) {
    super(newName, newTime);
  }

  @Override
  public String getType() {
    return "file";
  }
}