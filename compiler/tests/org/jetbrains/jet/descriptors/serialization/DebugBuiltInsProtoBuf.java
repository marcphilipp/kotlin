// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: core/serialization/src/builtins.debug.proto

package org.jetbrains.jet.descriptors.serialization;

public final class DebugBuiltInsProtoBuf {
  private DebugBuiltInsProtoBuf() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registry.add(org.jetbrains.jet.descriptors.serialization.DebugBuiltInsProtoBuf.className);
  }
  public static final int CLASS_NAME_FIELD_NUMBER = 150;
  /**
   * <code>extend .org.jetbrains.jet.descriptors.serialization.Package { ... }</code>
   */
  public static final
    com.google.protobuf.GeneratedMessage.GeneratedExtension<
      org.jetbrains.jet.descriptors.serialization.DebugProtoBuf.Package,
      java.util.List<java.lang.Integer>> className = com.google.protobuf.GeneratedMessage
          .newFileScopedGeneratedExtension(
        java.lang.Integer.class,
        null);

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n+core/serialization/src/builtins.debug." +
      "proto\022+org.jetbrains.jet.descriptors.ser" +
      "ialization\032.core/serialization/src/descr" +
      "iptors.debug.proto:M\n\nclass_name\0224.org.j" +
      "etbrains.jet.descriptors.serialization.P" +
      "ackage\030\226\001 \003(\005B\002\020\001B\027B\025DebugBuiltInsProtoB" +
      "uf"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
      new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public com.google.protobuf.ExtensionRegistry assignDescriptors(
            com.google.protobuf.Descriptors.FileDescriptor root) {
          descriptor = root;
          className.internalInit(descriptor.getExtensions().get(0));
          return null;
        }
      };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          org.jetbrains.jet.descriptors.serialization.DebugProtoBuf.getDescriptor(),
        }, assigner);
  }

  // @@protoc_insertion_point(outer_class_scope)
}
