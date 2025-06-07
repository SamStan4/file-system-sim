package io.github.samstan4.filesystem.tree;

// import java.io.File;

public class FileSystemTree {
  private TreeNodeBase rootNode;

  /**
   * Default constructor for a cold start, no reload of a file system
   */
  public FileSystemTree() {
    this.rootNode = TreeNodeFactory.createNode(FileType.DIRECTORY, "~");
    rootNode.setParentLink(rootNode);
  }

  /**
   * Simple getter for the root node
   * @return returns the root of the file system. This can be used for the cd command
   *         when there is no path given.
   */
  public TreeNodeBase getRootNode() {
    return this.rootNode;
  }

  /**
   * This function is for reloading file systems from a save.
   * @param path This is the path in which our file system save is located at. This needs to be an XML file.
   * @return Returns true if the file system was loaded. False otherwise.
   */
  public boolean loadFileSystemFromXML(final String path) {
    throw new Error("not implemented");
  }

  /**
   * This function saves a file system to an XML document.
   * @param path
   * @return
   */
  public boolean saveFileSystemToXML(final String saveName) {
    throw new Error("not implemented");
  }
}