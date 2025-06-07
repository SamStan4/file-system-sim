package io.github.samstan4.filesystem.tree;

import java.time.ZonedDateTime;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

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
  public String getTypeNiceString() {
    return FileType.FILE.toString().toLowerCase();
  }

  @Override
  public FileType getType() {
    return FileType.FILE;
  }

  @Override
  public Element toXml(final Document document) {
    throw new Error("not implemented");
  }
}