package com.amazonaws.appflow.custom.connector.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link ErrorDetails}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableErrorDetails.builder()}.
 */
@SuppressWarnings("all")
@ParametersAreNonnullByDefault
@Immutable
public final class ImmutableErrorDetails implements ErrorDetails {
  private final ErrorCode errorCode;
  private final @Nullable Integer retryAfterSeconds;
  private final String errorMessage;

  private ImmutableErrorDetails(
      ErrorCode errorCode,
      @Nullable Integer retryAfterSeconds,
      String errorMessage) {
    this.errorCode = errorCode;
    this.retryAfterSeconds = retryAfterSeconds;
    this.errorMessage = errorMessage;
  }

  /**
   * Error Code.
   */
  @JsonProperty("errorCode")
  @Override
  public ErrorCode errorCode() {
    return errorCode;
  }

  /**
   * Specifies the time delay in seconds after which operation can be retried.
   */
  @JsonProperty("retryAfterSeconds")
  @Override
  public @Nullable Integer retryAfterSeconds() {
    return retryAfterSeconds;
  }

  /**
   * Detailed error message corresponding to the error code.
   */
  @JsonProperty("errorMessage")
  @Override
  public String errorMessage() {
    return errorMessage;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ErrorDetails#errorCode() errorCode} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param errorCode A new value for errorCode
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableErrorDetails withErrorCode(ErrorCode errorCode) {
    if (this.errorCode == errorCode) return this;
    ErrorCode newValue = Preconditions.checkNotNull(errorCode, "errorCode");
    return new ImmutableErrorDetails(newValue, this.retryAfterSeconds, this.errorMessage);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ErrorDetails#retryAfterSeconds() retryAfterSeconds} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param retryAfterSeconds A new value for retryAfterSeconds (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableErrorDetails withRetryAfterSeconds(@Nullable Integer retryAfterSeconds) {
    if (Objects.equal(this.retryAfterSeconds, retryAfterSeconds)) return this;
    return new ImmutableErrorDetails(this.errorCode, retryAfterSeconds, this.errorMessage);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ErrorDetails#errorMessage() errorMessage} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param errorMessage A new value for errorMessage
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableErrorDetails withErrorMessage(String errorMessage) {
    if (this.errorMessage.equals(errorMessage)) return this;
    String newValue = Preconditions.checkNotNull(errorMessage, "errorMessage");
    return new ImmutableErrorDetails(this.errorCode, this.retryAfterSeconds, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableErrorDetails} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableErrorDetails
        && equalTo((ImmutableErrorDetails) another);
  }

  private boolean equalTo(ImmutableErrorDetails another) {
    return errorCode.equals(another.errorCode)
        && Objects.equal(retryAfterSeconds, another.retryAfterSeconds)
        && errorMessage.equals(another.errorMessage);
  }

  /**
   * Computes a hash code from attributes: {@code errorCode}, {@code retryAfterSeconds}, {@code errorMessage}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 31;
    h = h * 17 + errorCode.hashCode();
    h = h * 17 + Objects.hashCode(retryAfterSeconds);
    h = h * 17 + errorMessage.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code ErrorDetails} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("ErrorDetails")
        .omitNullValues()
        .add("errorCode", errorCode)
        .add("retryAfterSeconds", retryAfterSeconds)
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
  static final class Json implements ErrorDetails {
    @Nullable ErrorCode errorCode;
    @Nullable Integer retryAfterSeconds;
    @Nullable String errorMessage;
    @JsonProperty("errorCode")
    public void setErrorCode(ErrorCode errorCode) {
      this.errorCode = errorCode;
    }
    @JsonProperty("retryAfterSeconds")
    public void setRetryAfterSeconds(@Nullable Integer retryAfterSeconds) {
      this.retryAfterSeconds = retryAfterSeconds;
    }
    @JsonProperty("errorMessage")
    public void setErrorMessage(String errorMessage) {
      this.errorMessage = errorMessage;
    }
    @Override
    public ErrorCode errorCode() { throw new UnsupportedOperationException(); }
    @Override
    public Integer retryAfterSeconds() { throw new UnsupportedOperationException(); }
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
  static ImmutableErrorDetails fromJson(Json json) {
    ImmutableErrorDetails.Builder builder = ImmutableErrorDetails.builder();
    if (json.errorCode != null) {
      builder.errorCode(json.errorCode);
    }
    if (json.retryAfterSeconds != null) {
      builder.retryAfterSeconds(json.retryAfterSeconds);
    }
    if (json.errorMessage != null) {
      builder.errorMessage(json.errorMessage);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link ErrorDetails} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable ErrorDetails instance
   */
  public static ImmutableErrorDetails copyOf(ErrorDetails instance) {
    if (instance instanceof ImmutableErrorDetails) {
      return (ImmutableErrorDetails) instance;
    }
    return ImmutableErrorDetails.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableErrorDetails ImmutableErrorDetails}.
   * @return A new ImmutableErrorDetails builder
   */
  public static ImmutableErrorDetails.Builder builder() {
    return new ImmutableErrorDetails.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableErrorDetails ImmutableErrorDetails}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_ERROR_CODE = 0x1L;
    private static final long INIT_BIT_ERROR_MESSAGE = 0x2L;
    private long initBits = 0x3L;

    private @Nullable ErrorCode errorCode;
    private @Nullable Integer retryAfterSeconds;
    private @Nullable String errorMessage;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code ErrorDetails} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(ErrorDetails instance) {
      Preconditions.checkNotNull(instance, "instance");
      errorCode(instance.errorCode());
      @Nullable Integer retryAfterSecondsValue = instance.retryAfterSeconds();
      if (retryAfterSecondsValue != null) {
        retryAfterSeconds(retryAfterSecondsValue);
      }
      errorMessage(instance.errorMessage());
      return this;
    }

    /**
     * Initializes the value for the {@link ErrorDetails#errorCode() errorCode} attribute.
     * @param errorCode The value for errorCode 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder errorCode(ErrorCode errorCode) {
      this.errorCode = Preconditions.checkNotNull(errorCode, "errorCode");
      initBits &= ~INIT_BIT_ERROR_CODE;
      return this;
    }

    /**
     * Initializes the value for the {@link ErrorDetails#retryAfterSeconds() retryAfterSeconds} attribute.
     * @param retryAfterSeconds The value for retryAfterSeconds (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder retryAfterSeconds(@Nullable Integer retryAfterSeconds) {
      this.retryAfterSeconds = retryAfterSeconds;
      return this;
    }

    /**
     * Initializes the value for the {@link ErrorDetails#errorMessage() errorMessage} attribute.
     * @param errorMessage The value for errorMessage 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder errorMessage(String errorMessage) {
      this.errorMessage = Preconditions.checkNotNull(errorMessage, "errorMessage");
      initBits &= ~INIT_BIT_ERROR_MESSAGE;
      return this;
    }

    /**
     * Builds a new {@link ImmutableErrorDetails ImmutableErrorDetails}.
     * @return An immutable instance of ErrorDetails
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableErrorDetails build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableErrorDetails(errorCode, retryAfterSeconds, errorMessage);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_ERROR_CODE) != 0) attributes.add("errorCode");
      if ((initBits & INIT_BIT_ERROR_MESSAGE) != 0) attributes.add("errorMessage");
      return "Cannot build ErrorDetails, some of required attributes are not set " + attributes;
    }
  }
}
