package com.amazonaws.appflow.custom.connector.model.credentials;

import com.amazonaws.appflow.custom.connector.model.ErrorDetails;
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
 * Immutable implementation of {@link ValidateCredentialsResponse}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableValidateCredentialsResponse.builder()}.
 */
@SuppressWarnings("all")
@ParametersAreNonnullByDefault
@Immutable
public final class ImmutableValidateCredentialsResponse
    implements ValidateCredentialsResponse {
  private final boolean isSuccess;
  private final @Nullable ErrorDetails errorDetails;

  private ImmutableValidateCredentialsResponse(
      boolean isSuccess,
      @Nullable ErrorDetails errorDetails) {
    this.isSuccess = isSuccess;
    this.errorDetails = errorDetails;
  }

  /**
   * Specifies if the operation is successful or not.
   */
  @JsonProperty("isSuccess")
  @Override
  public boolean isSuccess() {
    return isSuccess;
  }

  /**
   * Error details if the Operation is unsuccessful.
   */
  @JsonProperty("errorDetails")
  @Override
  public @Nullable ErrorDetails errorDetails() {
    return errorDetails;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ValidateCredentialsResponse#isSuccess() isSuccess} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param isSuccess A new value for isSuccess
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableValidateCredentialsResponse withIsSuccess(boolean isSuccess) {
    if (this.isSuccess == isSuccess) return this;
    return new ImmutableValidateCredentialsResponse(isSuccess, this.errorDetails);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ValidateCredentialsResponse#errorDetails() errorDetails} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param errorDetails A new value for errorDetails (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableValidateCredentialsResponse withErrorDetails(@Nullable ErrorDetails errorDetails) {
    if (this.errorDetails == errorDetails) return this;
    return new ImmutableValidateCredentialsResponse(this.isSuccess, errorDetails);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableValidateCredentialsResponse} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableValidateCredentialsResponse
        && equalTo((ImmutableValidateCredentialsResponse) another);
  }

  private boolean equalTo(ImmutableValidateCredentialsResponse another) {
    return isSuccess == another.isSuccess
        && Objects.equal(errorDetails, another.errorDetails);
  }

  /**
   * Computes a hash code from attributes: {@code isSuccess}, {@code errorDetails}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 31;
    h = h * 17 + Booleans.hashCode(isSuccess);
    h = h * 17 + Objects.hashCode(errorDetails);
    return h;
  }

  /**
   * Prints the immutable value {@code ValidateCredentialsResponse} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("ValidateCredentialsResponse")
        .omitNullValues()
        .add("isSuccess", isSuccess)
        .add("errorDetails", errorDetails)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json
      implements ValidateCredentialsResponse {
    boolean isSuccess;
    boolean isSuccessIsSet;
    @Nullable ErrorDetails errorDetails;
    @JsonProperty("isSuccess")
    public void setIsSuccess(boolean isSuccess) {
      this.isSuccess = isSuccess;
      this.isSuccessIsSet = true;
    }
    @JsonProperty("errorDetails")
    public void setErrorDetails(@Nullable ErrorDetails errorDetails) {
      this.errorDetails = errorDetails;
    }
    @Override
    public boolean isSuccess() { throw new UnsupportedOperationException(); }
    @Override
    public ErrorDetails errorDetails() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator
  static ImmutableValidateCredentialsResponse fromJson(Json json) {
    ImmutableValidateCredentialsResponse.Builder builder = ImmutableValidateCredentialsResponse.builder();
    if (json.isSuccessIsSet) {
      builder.isSuccess(json.isSuccess);
    }
    if (json.errorDetails != null) {
      builder.errorDetails(json.errorDetails);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link ValidateCredentialsResponse} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable ValidateCredentialsResponse instance
   */
  public static ImmutableValidateCredentialsResponse copyOf(ValidateCredentialsResponse instance) {
    if (instance instanceof ImmutableValidateCredentialsResponse) {
      return (ImmutableValidateCredentialsResponse) instance;
    }
    return ImmutableValidateCredentialsResponse.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableValidateCredentialsResponse ImmutableValidateCredentialsResponse}.
   * @return A new ImmutableValidateCredentialsResponse builder
   */
  public static ImmutableValidateCredentialsResponse.Builder builder() {
    return new ImmutableValidateCredentialsResponse.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableValidateCredentialsResponse ImmutableValidateCredentialsResponse}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_IS_SUCCESS = 0x1L;
    private long initBits = 0x1L;

    private boolean isSuccess;
    private @Nullable ErrorDetails errorDetails;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code ValidateCredentialsResponse} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(ValidateCredentialsResponse instance) {
      Preconditions.checkNotNull(instance, "instance");
      isSuccess(instance.isSuccess());
      @Nullable ErrorDetails errorDetailsValue = instance.errorDetails();
      if (errorDetailsValue != null) {
        errorDetails(errorDetailsValue);
      }
      return this;
    }

    /**
     * Initializes the value for the {@link ValidateCredentialsResponse#isSuccess() isSuccess} attribute.
     * @param isSuccess The value for isSuccess 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder isSuccess(boolean isSuccess) {
      this.isSuccess = isSuccess;
      initBits &= ~INIT_BIT_IS_SUCCESS;
      return this;
    }

    /**
     * Initializes the value for the {@link ValidateCredentialsResponse#errorDetails() errorDetails} attribute.
     * @param errorDetails The value for errorDetails (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder errorDetails(@Nullable ErrorDetails errorDetails) {
      this.errorDetails = errorDetails;
      return this;
    }

    /**
     * Builds a new {@link ImmutableValidateCredentialsResponse ImmutableValidateCredentialsResponse}.
     * @return An immutable instance of ValidateCredentialsResponse
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableValidateCredentialsResponse build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableValidateCredentialsResponse(isSuccess, errorDetails);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_IS_SUCCESS) != 0) attributes.add("isSuccess");
      return "Cannot build ValidateCredentialsResponse, some of required attributes are not set " + attributes;
    }
  }
}
