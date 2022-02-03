package com.amazonaws.appflow.custom.connector.model.write;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.primitives.Booleans;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link WriteRecordResult}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableWriteRecordResult.builder()}.
 */
@SuppressWarnings("all")
@ParametersAreNonnullByDefault
@Immutable
public final class ImmutableWriteRecordResult
    implements WriteRecordResult {
  private final boolean isSuccess;
  private final String recordId;
  private final @Nullable String errorMessage;

  private ImmutableWriteRecordResult(
      boolean isSuccess,
      String recordId,
      @Nullable String errorMessage) {
    this.isSuccess = isSuccess;
    this.recordId = recordId;
    this.errorMessage = errorMessage;
  }

  /**
   * Specifies if the record is written successfully or not.
   */
  @JsonProperty("isSuccess")
  @Override
  public boolean isSuccess() {
    return isSuccess;
  }

  /**
   * Unique identifier for the record.
   */
  @JsonProperty("recordId")
  @Override
  public String recordId() {
    return recordId;
  }

  /**
   * Error message if the record is not written to the destination successfully.
   */
  @JsonProperty("errorMessage")
  @Override
  public @Nullable String errorMessage() {
    return errorMessage;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link WriteRecordResult#isSuccess() isSuccess} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param isSuccess A new value for isSuccess
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableWriteRecordResult withIsSuccess(boolean isSuccess) {
    if (this.isSuccess == isSuccess) return this;
    return new ImmutableWriteRecordResult(isSuccess, this.recordId, this.errorMessage);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link WriteRecordResult#recordId() recordId} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param recordId A new value for recordId
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableWriteRecordResult withRecordId(String recordId) {
    if (this.recordId.equals(recordId)) return this;
    String newValue = Preconditions.checkNotNull(recordId, "recordId");
    return new ImmutableWriteRecordResult(this.isSuccess, newValue, this.errorMessage);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link WriteRecordResult#errorMessage() errorMessage} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param errorMessage A new value for errorMessage (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableWriteRecordResult withErrorMessage(@Nullable String errorMessage) {
    if (Objects.equal(this.errorMessage, errorMessage)) return this;
    return new ImmutableWriteRecordResult(this.isSuccess, this.recordId, errorMessage);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableWriteRecordResult} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableWriteRecordResult
        && equalTo((ImmutableWriteRecordResult) another);
  }

  private boolean equalTo(ImmutableWriteRecordResult another) {
    return isSuccess == another.isSuccess
        && recordId.equals(another.recordId)
        && Objects.equal(errorMessage, another.errorMessage);
  }

  /**
   * Computes a hash code from attributes: {@code isSuccess}, {@code recordId}, {@code errorMessage}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 31;
    h = h * 17 + Booleans.hashCode(isSuccess);
    h = h * 17 + recordId.hashCode();
    h = h * 17 + Objects.hashCode(errorMessage);
    return h;
  }

  /**
   * Prints the immutable value {@code WriteRecordResult} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("WriteRecordResult")
        .omitNullValues()
        .add("isSuccess", isSuccess)
        .add("recordId", recordId)
        .add("errorMessage", errorMessage)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements WriteRecordResult {
    boolean isSuccess;
    boolean isSuccessIsSet;
    @Nullable String recordId;
    @Nullable String errorMessage;
    @JsonProperty("isSuccess")
    public void setIsSuccess(boolean isSuccess) {
      this.isSuccess = isSuccess;
      this.isSuccessIsSet = true;
    }
    @JsonProperty("recordId")
    public void setRecordId(String recordId) {
      this.recordId = recordId;
    }
    @JsonProperty("errorMessage")
    public void setErrorMessage(@Nullable String errorMessage) {
      this.errorMessage = errorMessage;
    }
    @Override
    public boolean isSuccess() { throw new UnsupportedOperationException(); }
    @Override
    public String recordId() { throw new UnsupportedOperationException(); }
    @Override
    public String errorMessage() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator
  static ImmutableWriteRecordResult fromJson(Json json) {
    ImmutableWriteRecordResult.Builder builder = ImmutableWriteRecordResult.builder();
    if (json.isSuccessIsSet) {
      builder.isSuccess(json.isSuccess);
    }
    if (json.recordId != null) {
      builder.recordId(json.recordId);
    }
    if (json.errorMessage != null) {
      builder.errorMessage(json.errorMessage);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link WriteRecordResult} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable WriteRecordResult instance
   */
  public static ImmutableWriteRecordResult copyOf(WriteRecordResult instance) {
    if (instance instanceof ImmutableWriteRecordResult) {
      return (ImmutableWriteRecordResult) instance;
    }
    return ImmutableWriteRecordResult.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableWriteRecordResult ImmutableWriteRecordResult}.
   * @return A new ImmutableWriteRecordResult builder
   */
  public static ImmutableWriteRecordResult.Builder builder() {
    return new ImmutableWriteRecordResult.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableWriteRecordResult ImmutableWriteRecordResult}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_IS_SUCCESS = 0x1L;
    private static final long INIT_BIT_RECORD_ID = 0x2L;
    private long initBits = 0x3L;

    private boolean isSuccess;
    private @Nullable String recordId;
    private @Nullable String errorMessage;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code WriteRecordResult} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(WriteRecordResult instance) {
      Preconditions.checkNotNull(instance, "instance");
      isSuccess(instance.isSuccess());
      recordId(instance.recordId());
      @Nullable String errorMessageValue = instance.errorMessage();
      if (errorMessageValue != null) {
        errorMessage(errorMessageValue);
      }
      return this;
    }

    /**
     * Initializes the value for the {@link WriteRecordResult#isSuccess() isSuccess} attribute.
     * @param isSuccess The value for isSuccess 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder isSuccess(boolean isSuccess) {
      this.isSuccess = isSuccess;
      initBits &= ~INIT_BIT_IS_SUCCESS;
      return this;
    }

    /**
     * Initializes the value for the {@link WriteRecordResult#recordId() recordId} attribute.
     * @param recordId The value for recordId 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder recordId(String recordId) {
      this.recordId = Preconditions.checkNotNull(recordId, "recordId");
      initBits &= ~INIT_BIT_RECORD_ID;
      return this;
    }

    /**
     * Initializes the value for the {@link WriteRecordResult#errorMessage() errorMessage} attribute.
     * @param errorMessage The value for errorMessage (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder errorMessage(@Nullable String errorMessage) {
      this.errorMessage = errorMessage;
      return this;
    }

    /**
     * Builds a new {@link ImmutableWriteRecordResult ImmutableWriteRecordResult}.
     * @return An immutable instance of WriteRecordResult
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableWriteRecordResult build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableWriteRecordResult(isSuccess, recordId, errorMessage);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_IS_SUCCESS) != 0) attributes.add("isSuccess");
      if ((initBits & INIT_BIT_RECORD_ID) != 0) attributes.add("recordId");
      return "Cannot build WriteRecordResult, some of required attributes are not set " + attributes;
    }
  }
}
