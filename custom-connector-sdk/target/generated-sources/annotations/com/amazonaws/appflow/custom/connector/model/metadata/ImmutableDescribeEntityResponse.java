package com.amazonaws.appflow.custom.connector.model.metadata;

import com.amazonaws.appflow.custom.connector.model.CacheControl;
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
 * Immutable implementation of {@link DescribeEntityResponse}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableDescribeEntityResponse.builder()}.
 */
@SuppressWarnings("all")
@ParametersAreNonnullByDefault
@Immutable
public final class ImmutableDescribeEntityResponse
    implements DescribeEntityResponse {
  private final boolean isSuccess;
  private final @Nullable ErrorDetails errorDetails;
  private final @Nullable EntityDefinition entityDefinition;
  private final @Nullable CacheControl cacheControl;

  private ImmutableDescribeEntityResponse(
      boolean isSuccess,
      @Nullable ErrorDetails errorDetails,
      @Nullable EntityDefinition entityDefinition,
      @Nullable CacheControl cacheControl) {
    this.isSuccess = isSuccess;
    this.errorDetails = errorDetails;
    this.entityDefinition = entityDefinition;
    this.cacheControl = cacheControl;
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
   * Data model of the entity.
   */
  @JsonProperty("entityDefinition")
  @Override
  public @Nullable EntityDefinition entityDefinition() {
    return entityDefinition;
  }

  /**
   * Caching policy for the entity.
   */
  @JsonProperty("cacheControl")
  @Override
  public @Nullable CacheControl cacheControl() {
    return cacheControl;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link DescribeEntityResponse#isSuccess() isSuccess} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param isSuccess A new value for isSuccess
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableDescribeEntityResponse withIsSuccess(boolean isSuccess) {
    if (this.isSuccess == isSuccess) return this;
    return new ImmutableDescribeEntityResponse(isSuccess, this.errorDetails, this.entityDefinition, this.cacheControl);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link DescribeEntityResponse#errorDetails() errorDetails} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param errorDetails A new value for errorDetails (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableDescribeEntityResponse withErrorDetails(@Nullable ErrorDetails errorDetails) {
    if (this.errorDetails == errorDetails) return this;
    return new ImmutableDescribeEntityResponse(this.isSuccess, errorDetails, this.entityDefinition, this.cacheControl);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link DescribeEntityResponse#entityDefinition() entityDefinition} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param entityDefinition A new value for entityDefinition (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableDescribeEntityResponse withEntityDefinition(@Nullable EntityDefinition entityDefinition) {
    if (this.entityDefinition == entityDefinition) return this;
    return new ImmutableDescribeEntityResponse(this.isSuccess, this.errorDetails, entityDefinition, this.cacheControl);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link DescribeEntityResponse#cacheControl() cacheControl} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param cacheControl A new value for cacheControl (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableDescribeEntityResponse withCacheControl(@Nullable CacheControl cacheControl) {
    if (this.cacheControl == cacheControl) return this;
    return new ImmutableDescribeEntityResponse(this.isSuccess, this.errorDetails, this.entityDefinition, cacheControl);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableDescribeEntityResponse} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableDescribeEntityResponse
        && equalTo((ImmutableDescribeEntityResponse) another);
  }

  private boolean equalTo(ImmutableDescribeEntityResponse another) {
    return isSuccess == another.isSuccess
        && Objects.equal(errorDetails, another.errorDetails)
        && Objects.equal(entityDefinition, another.entityDefinition)
        && Objects.equal(cacheControl, another.cacheControl);
  }

  /**
   * Computes a hash code from attributes: {@code isSuccess}, {@code errorDetails}, {@code entityDefinition}, {@code cacheControl}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 31;
    h = h * 17 + Booleans.hashCode(isSuccess);
    h = h * 17 + Objects.hashCode(errorDetails);
    h = h * 17 + Objects.hashCode(entityDefinition);
    h = h * 17 + Objects.hashCode(cacheControl);
    return h;
  }

  /**
   * Prints the immutable value {@code DescribeEntityResponse} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("DescribeEntityResponse")
        .omitNullValues()
        .add("isSuccess", isSuccess)
        .add("errorDetails", errorDetails)
        .add("entityDefinition", entityDefinition)
        .add("cacheControl", cacheControl)
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
      implements DescribeEntityResponse {
    boolean isSuccess;
    boolean isSuccessIsSet;
    @Nullable ErrorDetails errorDetails;
    @Nullable EntityDefinition entityDefinition;
    @Nullable CacheControl cacheControl;
    @JsonProperty("isSuccess")
    public void setIsSuccess(boolean isSuccess) {
      this.isSuccess = isSuccess;
      this.isSuccessIsSet = true;
    }
    @JsonProperty("errorDetails")
    public void setErrorDetails(@Nullable ErrorDetails errorDetails) {
      this.errorDetails = errorDetails;
    }
    @JsonProperty("entityDefinition")
    public void setEntityDefinition(@Nullable EntityDefinition entityDefinition) {
      this.entityDefinition = entityDefinition;
    }
    @JsonProperty("cacheControl")
    public void setCacheControl(@Nullable CacheControl cacheControl) {
      this.cacheControl = cacheControl;
    }
    @Override
    public boolean isSuccess() { throw new UnsupportedOperationException(); }
    @Override
    public ErrorDetails errorDetails() { throw new UnsupportedOperationException(); }
    @Override
    public EntityDefinition entityDefinition() { throw new UnsupportedOperationException(); }
    @Override
    public CacheControl cacheControl() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator
  static ImmutableDescribeEntityResponse fromJson(Json json) {
    ImmutableDescribeEntityResponse.Builder builder = ImmutableDescribeEntityResponse.builder();
    if (json.isSuccessIsSet) {
      builder.isSuccess(json.isSuccess);
    }
    if (json.errorDetails != null) {
      builder.errorDetails(json.errorDetails);
    }
    if (json.entityDefinition != null) {
      builder.entityDefinition(json.entityDefinition);
    }
    if (json.cacheControl != null) {
      builder.cacheControl(json.cacheControl);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link DescribeEntityResponse} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable DescribeEntityResponse instance
   */
  public static ImmutableDescribeEntityResponse copyOf(DescribeEntityResponse instance) {
    if (instance instanceof ImmutableDescribeEntityResponse) {
      return (ImmutableDescribeEntityResponse) instance;
    }
    return ImmutableDescribeEntityResponse.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableDescribeEntityResponse ImmutableDescribeEntityResponse}.
   * @return A new ImmutableDescribeEntityResponse builder
   */
  public static ImmutableDescribeEntityResponse.Builder builder() {
    return new ImmutableDescribeEntityResponse.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableDescribeEntityResponse ImmutableDescribeEntityResponse}.
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
    private @Nullable EntityDefinition entityDefinition;
    private @Nullable CacheControl cacheControl;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code DescribeEntityResponse} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(DescribeEntityResponse instance) {
      Preconditions.checkNotNull(instance, "instance");
      isSuccess(instance.isSuccess());
      @Nullable ErrorDetails errorDetailsValue = instance.errorDetails();
      if (errorDetailsValue != null) {
        errorDetails(errorDetailsValue);
      }
      @Nullable EntityDefinition entityDefinitionValue = instance.entityDefinition();
      if (entityDefinitionValue != null) {
        entityDefinition(entityDefinitionValue);
      }
      @Nullable CacheControl cacheControlValue = instance.cacheControl();
      if (cacheControlValue != null) {
        cacheControl(cacheControlValue);
      }
      return this;
    }

    /**
     * Initializes the value for the {@link DescribeEntityResponse#isSuccess() isSuccess} attribute.
     * @param isSuccess The value for isSuccess 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder isSuccess(boolean isSuccess) {
      this.isSuccess = isSuccess;
      initBits &= ~INIT_BIT_IS_SUCCESS;
      return this;
    }

    /**
     * Initializes the value for the {@link DescribeEntityResponse#errorDetails() errorDetails} attribute.
     * @param errorDetails The value for errorDetails (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder errorDetails(@Nullable ErrorDetails errorDetails) {
      this.errorDetails = errorDetails;
      return this;
    }

    /**
     * Initializes the value for the {@link DescribeEntityResponse#entityDefinition() entityDefinition} attribute.
     * @param entityDefinition The value for entityDefinition (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder entityDefinition(@Nullable EntityDefinition entityDefinition) {
      this.entityDefinition = entityDefinition;
      return this;
    }

    /**
     * Initializes the value for the {@link DescribeEntityResponse#cacheControl() cacheControl} attribute.
     * @param cacheControl The value for cacheControl (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder cacheControl(@Nullable CacheControl cacheControl) {
      this.cacheControl = cacheControl;
      return this;
    }

    /**
     * Builds a new {@link ImmutableDescribeEntityResponse ImmutableDescribeEntityResponse}.
     * @return An immutable instance of DescribeEntityResponse
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableDescribeEntityResponse build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableDescribeEntityResponse(isSuccess, errorDetails, entityDefinition, cacheControl);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_IS_SUCCESS) != 0) attributes.add("isSuccess");
      return "Cannot build DescribeEntityResponse, some of required attributes are not set " + attributes;
    }
  }
}
