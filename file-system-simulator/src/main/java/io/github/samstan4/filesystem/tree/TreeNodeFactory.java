package io.github.samstan4.filesystem.tree;

import org.reflections.Reflections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.lang.reflect.Constructor;
import java.time.ZonedDateTime;

public class TreeNodeFactory {

  private static final Map<FileType, Constructor<? extends TreeNodeBase>> nameConstructorMap = new HashMap<>();
  private static final Map<FileType, Constructor<? extends TreeNodeBase>> nameTimeConstructorMap = new HashMap<>();

  static {
    TreeNodeFactory.discoverAndRegisterNodeSubTypes();
  }

  private static void discoverAndRegisterNodeSubTypes() {
    final String packageName = TreeNodeBase.class.getPackageName();
    Reflections reflections = new Reflections(packageName);
    Set<Class<? extends TreeNodeBase>> subTypes = reflections.getSubTypesOf(TreeNodeBase.class);
    for (Class<? extends TreeNodeBase> subType : subTypes) {
      try {
        TreeNodeBase subTypeInstance = subType.getDeclaredConstructor(String.class).newInstance("");
        final FileType typeKey = subTypeInstance.getType();
        final Constructor<? extends TreeNodeBase> subTypeNameConstructor = subType.getDeclaredConstructor(String.class);
        final Constructor<? extends TreeNodeBase> subTypeNameTimeConstructor = subType.getDeclaredConstructor(String.class, ZonedDateTime.class);
        if (TreeNodeFactory.nameConstructorMap.containsKey(typeKey) || TreeNodeFactory.nameTimeConstructorMap.containsKey(typeKey)) {
          System.err.println("[FATAL ERROR] duplicate file key node key found: " + typeKey.name());
        }
        TreeNodeFactory.nameConstructorMap.put(typeKey, subTypeNameConstructor);
        TreeNodeFactory.nameTimeConstructorMap.put(typeKey, subTypeNameTimeConstructor);
      } catch (Exception e) {
        System.err.println("[FATAL ERROR] unable to register class: " + subType.getName() + ", " + e);
      }
    }
  }

  public static TreeNodeBase createNode(final FileType newType, final String newName) {
    Constructor<? extends TreeNodeBase> targetTypeConstructor = TreeNodeFactory.nameConstructorMap.get(newType);
    if (targetTypeConstructor == null) {
      System.err.println("[CRITICAL ERROR] unregistered type: " + newType.name().toLowerCase());
      return null;
    }
    try {
      return targetTypeConstructor.newInstance(newName);
    } catch (Exception e) {
      System.err.println("[CRITICAL ERROR] unable to create node of type: " + newType.name().toLowerCase() + ", " + e);
      return null;
    }
  }

  public static TreeNodeBase createNode(final FileType newType, final String newName, final ZonedDateTime newTime) {
    Constructor<? extends TreeNodeBase> targetTypeConstructor = TreeNodeFactory.nameTimeConstructorMap.get(newType);
    if (targetTypeConstructor == null) {
      System.err.println("[CRITICAL ERROR] unregistered type: " + newType.name().toLowerCase());
      return null;
    }
    try {
      return targetTypeConstructor.newInstance(newName, newTime);
    } catch (Exception e) {
      System.err.println("[CRITICAL ERROR] unable to create node of type: " + newType.name().toLowerCase() + ", " + e);
      return null;
    }
  }
}