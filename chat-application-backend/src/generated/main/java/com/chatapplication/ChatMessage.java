// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: chat.proto

package com.chatapplication;

/**
 * Protobuf type {@code ChatMessage}
 */
public final class ChatMessage extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:ChatMessage)
    ChatMessageOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ChatMessage.newBuilder() to construct.
  private ChatMessage(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ChatMessage() {
    message_ = "";
    from_ = "";
    to_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new ChatMessage();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.chatapplication.ChatProto.internal_static_ChatMessage_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.chatapplication.ChatProto.internal_static_ChatMessage_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.chatapplication.ChatMessage.class, com.chatapplication.ChatMessage.Builder.class);
  }

  public static final int MESSAGE_FIELD_NUMBER = 1;
  private volatile java.lang.Object message_;
  /**
   * <code>string message = 1;</code>
   * @return The message.
   */
  @java.lang.Override
  public java.lang.String getMessage() {
    java.lang.Object ref = message_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      message_ = s;
      return s;
    }
  }
  /**
   * <code>string message = 1;</code>
   * @return The bytes for message.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getMessageBytes() {
    java.lang.Object ref = message_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      message_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int FROM_FIELD_NUMBER = 2;
  private volatile java.lang.Object from_;
  /**
   * <code>string from = 2;</code>
   * @return The from.
   */
  @java.lang.Override
  public java.lang.String getFrom() {
    java.lang.Object ref = from_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      from_ = s;
      return s;
    }
  }
  /**
   * <code>string from = 2;</code>
   * @return The bytes for from.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getFromBytes() {
    java.lang.Object ref = from_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      from_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int TO_FIELD_NUMBER = 3;
  private volatile java.lang.Object to_;
  /**
   * <code>string to = 3;</code>
   * @return The to.
   */
  @java.lang.Override
  public java.lang.String getTo() {
    java.lang.Object ref = to_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      to_ = s;
      return s;
    }
  }
  /**
   * <code>string to = 3;</code>
   * @return The bytes for to.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getToBytes() {
    java.lang.Object ref = to_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      to_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int BELONGSTOGROUP_FIELD_NUMBER = 4;
  private boolean belongsToGroup_;
  /**
   * <code>bool belongsToGroup = 4;</code>
   * @return The belongsToGroup.
   */
  @java.lang.Override
  public boolean getBelongsToGroup() {
    return belongsToGroup_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(message_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, message_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(from_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, from_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(to_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, to_);
    }
    if (belongsToGroup_ != false) {
      output.writeBool(4, belongsToGroup_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(message_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, message_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(from_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, from_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(to_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, to_);
    }
    if (belongsToGroup_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(4, belongsToGroup_);
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.chatapplication.ChatMessage)) {
      return super.equals(obj);
    }
    com.chatapplication.ChatMessage other = (com.chatapplication.ChatMessage) obj;

    if (!getMessage()
        .equals(other.getMessage())) return false;
    if (!getFrom()
        .equals(other.getFrom())) return false;
    if (!getTo()
        .equals(other.getTo())) return false;
    if (getBelongsToGroup()
        != other.getBelongsToGroup()) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + MESSAGE_FIELD_NUMBER;
    hash = (53 * hash) + getMessage().hashCode();
    hash = (37 * hash) + FROM_FIELD_NUMBER;
    hash = (53 * hash) + getFrom().hashCode();
    hash = (37 * hash) + TO_FIELD_NUMBER;
    hash = (53 * hash) + getTo().hashCode();
    hash = (37 * hash) + BELONGSTOGROUP_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getBelongsToGroup());
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.chatapplication.ChatMessage parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.chatapplication.ChatMessage parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.chatapplication.ChatMessage parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.chatapplication.ChatMessage parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.chatapplication.ChatMessage parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.chatapplication.ChatMessage parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.chatapplication.ChatMessage parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.chatapplication.ChatMessage parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.chatapplication.ChatMessage parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.chatapplication.ChatMessage parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.chatapplication.ChatMessage parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.chatapplication.ChatMessage parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.chatapplication.ChatMessage prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code ChatMessage}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:ChatMessage)
      com.chatapplication.ChatMessageOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.chatapplication.ChatProto.internal_static_ChatMessage_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.chatapplication.ChatProto.internal_static_ChatMessage_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.chatapplication.ChatMessage.class, com.chatapplication.ChatMessage.Builder.class);
    }

    // Construct using com.chatapplication.ChatMessage.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      message_ = "";

      from_ = "";

      to_ = "";

      belongsToGroup_ = false;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.chatapplication.ChatProto.internal_static_ChatMessage_descriptor;
    }

    @java.lang.Override
    public com.chatapplication.ChatMessage getDefaultInstanceForType() {
      return com.chatapplication.ChatMessage.getDefaultInstance();
    }

    @java.lang.Override
    public com.chatapplication.ChatMessage build() {
      com.chatapplication.ChatMessage result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.chatapplication.ChatMessage buildPartial() {
      com.chatapplication.ChatMessage result = new com.chatapplication.ChatMessage(this);
      result.message_ = message_;
      result.from_ = from_;
      result.to_ = to_;
      result.belongsToGroup_ = belongsToGroup_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.chatapplication.ChatMessage) {
        return mergeFrom((com.chatapplication.ChatMessage)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.chatapplication.ChatMessage other) {
      if (other == com.chatapplication.ChatMessage.getDefaultInstance()) return this;
      if (!other.getMessage().isEmpty()) {
        message_ = other.message_;
        onChanged();
      }
      if (!other.getFrom().isEmpty()) {
        from_ = other.from_;
        onChanged();
      }
      if (!other.getTo().isEmpty()) {
        to_ = other.to_;
        onChanged();
      }
      if (other.getBelongsToGroup() != false) {
        setBelongsToGroup(other.getBelongsToGroup());
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              message_ = input.readStringRequireUtf8();

              break;
            } // case 10
            case 18: {
              from_ = input.readStringRequireUtf8();

              break;
            } // case 18
            case 26: {
              to_ = input.readStringRequireUtf8();

              break;
            } // case 26
            case 32: {
              belongsToGroup_ = input.readBool();

              break;
            } // case 32
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }

    private java.lang.Object message_ = "";
    /**
     * <code>string message = 1;</code>
     * @return The message.
     */
    public java.lang.String getMessage() {
      java.lang.Object ref = message_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        message_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string message = 1;</code>
     * @return The bytes for message.
     */
    public com.google.protobuf.ByteString
        getMessageBytes() {
      java.lang.Object ref = message_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        message_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string message = 1;</code>
     * @param value The message to set.
     * @return This builder for chaining.
     */
    public Builder setMessage(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      message_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string message = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearMessage() {
      
      message_ = getDefaultInstance().getMessage();
      onChanged();
      return this;
    }
    /**
     * <code>string message = 1;</code>
     * @param value The bytes for message to set.
     * @return This builder for chaining.
     */
    public Builder setMessageBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      message_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object from_ = "";
    /**
     * <code>string from = 2;</code>
     * @return The from.
     */
    public java.lang.String getFrom() {
      java.lang.Object ref = from_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        from_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string from = 2;</code>
     * @return The bytes for from.
     */
    public com.google.protobuf.ByteString
        getFromBytes() {
      java.lang.Object ref = from_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        from_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string from = 2;</code>
     * @param value The from to set.
     * @return This builder for chaining.
     */
    public Builder setFrom(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      from_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string from = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearFrom() {
      
      from_ = getDefaultInstance().getFrom();
      onChanged();
      return this;
    }
    /**
     * <code>string from = 2;</code>
     * @param value The bytes for from to set.
     * @return This builder for chaining.
     */
    public Builder setFromBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      from_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object to_ = "";
    /**
     * <code>string to = 3;</code>
     * @return The to.
     */
    public java.lang.String getTo() {
      java.lang.Object ref = to_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        to_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string to = 3;</code>
     * @return The bytes for to.
     */
    public com.google.protobuf.ByteString
        getToBytes() {
      java.lang.Object ref = to_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        to_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string to = 3;</code>
     * @param value The to to set.
     * @return This builder for chaining.
     */
    public Builder setTo(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      to_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string to = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearTo() {
      
      to_ = getDefaultInstance().getTo();
      onChanged();
      return this;
    }
    /**
     * <code>string to = 3;</code>
     * @param value The bytes for to to set.
     * @return This builder for chaining.
     */
    public Builder setToBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      to_ = value;
      onChanged();
      return this;
    }

    private boolean belongsToGroup_ ;
    /**
     * <code>bool belongsToGroup = 4;</code>
     * @return The belongsToGroup.
     */
    @java.lang.Override
    public boolean getBelongsToGroup() {
      return belongsToGroup_;
    }
    /**
     * <code>bool belongsToGroup = 4;</code>
     * @param value The belongsToGroup to set.
     * @return This builder for chaining.
     */
    public Builder setBelongsToGroup(boolean value) {
      
      belongsToGroup_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool belongsToGroup = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearBelongsToGroup() {
      
      belongsToGroup_ = false;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:ChatMessage)
  }

  // @@protoc_insertion_point(class_scope:ChatMessage)
  private static final com.chatapplication.ChatMessage DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.chatapplication.ChatMessage();
  }

  public static com.chatapplication.ChatMessage getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ChatMessage>
      PARSER = new com.google.protobuf.AbstractParser<ChatMessage>() {
    @java.lang.Override
    public ChatMessage parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<ChatMessage> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ChatMessage> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.chatapplication.ChatMessage getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

