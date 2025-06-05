package io.github.samstan4.filesystem.tree;

public enum FileType {
  FILE,
  DIRECTORY;

  @Override
  public String toString() {
    return this.name().toLowerCase();
  }
}