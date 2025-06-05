package io.github.samstan4.filesystem.tree;

import java.time.ZonedDateTime;

public class FileNode extends TreeNodeBase {

  private String fileContents;
  
  public FileNode(final String newName) {
    super(newName);
  }

  public FileNode(final String newName, final ZonedDateTime newTime) {
    super(newName, newTime);
  }

  public void setFileContents(final String newFileContents) {
    this.fileContents = newFileContents;
  }

  public String getFileContents() {
    return this.fileContents;
  }

  @Override
  public FileType getType() {
    return FileType.FILE;
  }
}