// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: noval.proto

package com.yc.proto;

/**
 * Protobuf type {@code com.yc.proto.NovalReponse}
 */
public  final class NovalReponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.yc.proto.NovalReponse)
    NovalReponseOrBuilder {
  // Use NovalReponse.newBuilder() to construct.
  private NovalReponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private NovalReponse() {
    id_ = 0;
    novalName_ = "";
    chapterName_ = "";
    chapterContent_ = "";
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private NovalReponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    int mutable_bitField0_ = 0;
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!input.skipField(tag)) {
              done = true;
            }
            break;
          }
          case 8: {

            id_ = input.readInt32();
            break;
          }
          case 18: {
            String s = input.readStringRequireUtf8();

            novalName_ = s;
            break;
          }
          case 26: {
            String s = input.readStringRequireUtf8();

            chapterName_ = s;
            break;
          }
          case 34: {
            String s = input.readStringRequireUtf8();

            chapterContent_ = s;
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return noval.internal_static_com_yc_proto_NovalReponse_descriptor;
  }

  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return noval.internal_static_com_yc_proto_NovalReponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            NovalReponse.class, Builder.class);
  }

  public static final int ID_FIELD_NUMBER = 1;
  private int id_;
  /**
   * <code>int32 id = 1;</code>
   */
  public int getId() {
    return id_;
  }

  public static final int NOVALNAME_FIELD_NUMBER = 2;
  private volatile Object novalName_;
  /**
   * <code>string novalName = 2;</code>
   */
  public String getNovalName() {
    Object ref = novalName_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      novalName_ = s;
      return s;
    }
  }
  /**
   * <code>string novalName = 2;</code>
   */
  public com.google.protobuf.ByteString
      getNovalNameBytes() {
    Object ref = novalName_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      novalName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int CHAPTERNAME_FIELD_NUMBER = 3;
  private volatile Object chapterName_;
  /**
   * <code>string chapterName = 3;</code>
   */
  public String getChapterName() {
    Object ref = chapterName_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      chapterName_ = s;
      return s;
    }
  }
  /**
   * <code>string chapterName = 3;</code>
   */
  public com.google.protobuf.ByteString
      getChapterNameBytes() {
    Object ref = chapterName_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      chapterName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int CHAPTERCONTENT_FIELD_NUMBER = 4;
  private volatile Object chapterContent_;
  /**
   * <code>string chapterContent = 4;</code>
   */
  public String getChapterContent() {
    Object ref = chapterContent_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      chapterContent_ = s;
      return s;
    }
  }
  /**
   * <code>string chapterContent = 4;</code>
   */
  public com.google.protobuf.ByteString
      getChapterContentBytes() {
    Object ref = chapterContent_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      chapterContent_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (id_ != 0) {
      output.writeInt32(1, id_);
    }
    if (!getNovalNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, novalName_);
    }
    if (!getChapterNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, chapterName_);
    }
    if (!getChapterContentBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, chapterContent_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (id_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, id_);
    }
    if (!getNovalNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, novalName_);
    }
    if (!getChapterNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, chapterName_);
    }
    if (!getChapterContentBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, chapterContent_);
    }
    memoizedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  @Override
  public boolean equals(final Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof NovalReponse)) {
      return super.equals(obj);
    }
    NovalReponse other = (NovalReponse) obj;

    boolean result = true;
    result = result && (getId()
        == other.getId());
    result = result && getNovalName()
        .equals(other.getNovalName());
    result = result && getChapterName()
        .equals(other.getChapterName());
    result = result && getChapterContent()
        .equals(other.getChapterContent());
    return result;
  }

  @Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + ID_FIELD_NUMBER;
    hash = (53 * hash) + getId();
    hash = (37 * hash) + NOVALNAME_FIELD_NUMBER;
    hash = (53 * hash) + getNovalName().hashCode();
    hash = (37 * hash) + CHAPTERNAME_FIELD_NUMBER;
    hash = (53 * hash) + getChapterName().hashCode();
    hash = (37 * hash) + CHAPTERCONTENT_FIELD_NUMBER;
    hash = (53 * hash) + getChapterContent().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static NovalReponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static NovalReponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static NovalReponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static NovalReponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static NovalReponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static NovalReponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static NovalReponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static NovalReponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static NovalReponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static NovalReponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(NovalReponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @Override
  protected Builder newBuilderForType(
      BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code com.yc.proto.NovalReponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.yc.proto.NovalReponse)
      com.yc.proto.NovalReponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return noval.internal_static_com_yc_proto_NovalReponse_descriptor;
    }

    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return noval.internal_static_com_yc_proto_NovalReponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              NovalReponse.class, Builder.class);
    }

    // Construct using com.yc.proto.NovalReponse.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      id_ = 0;

      novalName_ = "";

      chapterName_ = "";

      chapterContent_ = "";

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return noval.internal_static_com_yc_proto_NovalReponse_descriptor;
    }

    public NovalReponse getDefaultInstanceForType() {
      return NovalReponse.getDefaultInstance();
    }

    public NovalReponse build() {
      NovalReponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public NovalReponse buildPartial() {
      NovalReponse result = new NovalReponse(this);
      result.id_ = id_;
      result.novalName_ = novalName_;
      result.chapterName_ = chapterName_;
      result.chapterContent_ = chapterContent_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof NovalReponse) {
        return mergeFrom((NovalReponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(NovalReponse other) {
      if (other == NovalReponse.getDefaultInstance()) return this;
      if (other.getId() != 0) {
        setId(other.getId());
      }
      if (!other.getNovalName().isEmpty()) {
        novalName_ = other.novalName_;
        onChanged();
      }
      if (!other.getChapterName().isEmpty()) {
        chapterName_ = other.chapterName_;
        onChanged();
      }
      if (!other.getChapterContent().isEmpty()) {
        chapterContent_ = other.chapterContent_;
        onChanged();
      }
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      NovalReponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (NovalReponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int id_ ;
    /**
     * <code>int32 id = 1;</code>
     */
    public int getId() {
      return id_;
    }
    /**
     * <code>int32 id = 1;</code>
     */
    public Builder setId(int value) {
      
      id_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 id = 1;</code>
     */
    public Builder clearId() {
      
      id_ = 0;
      onChanged();
      return this;
    }

    private Object novalName_ = "";
    /**
     * <code>string novalName = 2;</code>
     */
    public String getNovalName() {
      Object ref = novalName_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        novalName_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string novalName = 2;</code>
     */
    public com.google.protobuf.ByteString
        getNovalNameBytes() {
      Object ref = novalName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        novalName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string novalName = 2;</code>
     */
    public Builder setNovalName(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      novalName_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string novalName = 2;</code>
     */
    public Builder clearNovalName() {
      
      novalName_ = getDefaultInstance().getNovalName();
      onChanged();
      return this;
    }
    /**
     * <code>string novalName = 2;</code>
     */
    public Builder setNovalNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      novalName_ = value;
      onChanged();
      return this;
    }

    private Object chapterName_ = "";
    /**
     * <code>string chapterName = 3;</code>
     */
    public String getChapterName() {
      Object ref = chapterName_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        chapterName_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string chapterName = 3;</code>
     */
    public com.google.protobuf.ByteString
        getChapterNameBytes() {
      Object ref = chapterName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        chapterName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string chapterName = 3;</code>
     */
    public Builder setChapterName(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      chapterName_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string chapterName = 3;</code>
     */
    public Builder clearChapterName() {
      
      chapterName_ = getDefaultInstance().getChapterName();
      onChanged();
      return this;
    }
    /**
     * <code>string chapterName = 3;</code>
     */
    public Builder setChapterNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      chapterName_ = value;
      onChanged();
      return this;
    }

    private Object chapterContent_ = "";
    /**
     * <code>string chapterContent = 4;</code>
     */
    public String getChapterContent() {
      Object ref = chapterContent_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        chapterContent_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string chapterContent = 4;</code>
     */
    public com.google.protobuf.ByteString
        getChapterContentBytes() {
      Object ref = chapterContent_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        chapterContent_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string chapterContent = 4;</code>
     */
    public Builder setChapterContent(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      chapterContent_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string chapterContent = 4;</code>
     */
    public Builder clearChapterContent() {
      
      chapterContent_ = getDefaultInstance().getChapterContent();
      onChanged();
      return this;
    }
    /**
     * <code>string chapterContent = 4;</code>
     */
    public Builder setChapterContentBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      chapterContent_ = value;
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:com.yc.proto.NovalReponse)
  }

  // @@protoc_insertion_point(class_scope:com.yc.proto.NovalReponse)
  private static final NovalReponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new NovalReponse();
  }

  public static NovalReponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<NovalReponse>
      PARSER = new com.google.protobuf.AbstractParser<NovalReponse>() {
    public NovalReponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new NovalReponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<NovalReponse> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<NovalReponse> getParserForType() {
    return PARSER;
  }

  public NovalReponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

