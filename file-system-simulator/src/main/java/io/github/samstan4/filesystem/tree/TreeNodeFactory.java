package io.github.samstan4.filesystem.tree;

import org.reflections.Reflections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.time.ZonedDateTime;

public class TreeNodeFactory {
  
  private static final Map<String, Class<? extends TreeNodeBase>> registeredNodeTypes = new HashMap<>();

  static {
    TreeNodeFactory.discoverAndRegisterNodeSubTypes();
  }

  private static void discoverAndRegisterNodeSubTypes() {
    final String packageName = TreeNodeBase.class.getPackageName();
    Reflections reflections = new Reflections(packageName);
    Set<Class<? extends TreeNodeBase>> subTypes = reflections.getSubTypesOf(TreeNodeBase.class);
    for (Class<? extends TreeNodeBase> subClass : subTypes) {
      try {
        TreeNodeBase instance = subClass.getDeclaredConstructor(String.class).newInstance("");
        final String typeKey = instance.getType().name().toLowerCase();
        TreeNodeFactory.registeredNodeTypes.put(typeKey, subClass);
      } catch (Exception e) {
        System.err.println("[FATAL ERROR] unable to register class: " + subClass.getName() + ", " + e);
      }
    }
  }

  public static TreeNodeBase createNode(final FileType newType, final String newName) {
    final String newTypeKey = newType.name().toLowerCase();
    Class<? extends TreeNodeBase> targetClass = TreeNodeFactory.registeredNodeTypes.get(newTypeKey);
    if (targetClass == null) {
      return null;
    }
    try {
      return targetClass.getDeclaredConstructor(String.class).newInstance(newName);
    } catch (Exception e) {
      System.err.println("[CRITICAL ERROR] unable to create node of type: " + newTypeKey + ", " + e);
      return null;
    }
  }

  public static TreeNodeBase createNode(final FileType newType, final String newName, final ZonedDateTime newTime) {
    final String newTypeKey = newType.name().toLowerCase();
    Class<? extends TreeNodeBase> targetClass = TreeNodeFactory.registeredNodeTypes.get(newTypeKey);
    if (targetClass == null) {
      return null;
    }
    try {
      return targetClass.getDeclaredConstructor(String.class, ZonedDateTime.class).newInstance(newName, newTime);
    } catch (Exception e) {
      System.err.println("[CRITICAL ERROR] unable to create node of type: " + newTypeKey + ", " + e);
      return null;
    }
  }
}