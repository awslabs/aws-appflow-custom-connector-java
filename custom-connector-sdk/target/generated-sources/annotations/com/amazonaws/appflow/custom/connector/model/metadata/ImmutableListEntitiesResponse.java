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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.primitives.Booleans;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link ListEntitiesResponse}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableListEntitiesResponse.builder()}.
 */
@SuppressWarnings("all")
@ParametersAreNonnullByDefault
@Immutable
public final class ImmutableListEntitiesResponse
    implements ListEntitiesResponse {
  private final boolean isSuccess;
  private final @Nullable ErrorDetails errorDetails;
  private final @Nullable ImmutableList<Entity> entities;
  private final @Nullable String nextToken;
  private final @Nullable CacheControl cacheControl;

  private ImmutableListEntitiesResponse(
      boolean isSuccess,
      @Nullable ErrorDetails errorDetails,
      @Nullable ImmutableList<Entity> entities,
      @Nullable String nextToken,
      @Nullable CacheControl cacheControl) {
    this.isSuccess = isSuccess;
    this.errorDetails = errorDetails;
    this.entities = entities;
    this.nextToken = nextToken;
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
   * List of entities.
   */
  @JsonProperty("entities")
  @Override
  public @Nullable ImmutableList<Entity> entities() {
    return entities;
  }

  /**
   * The pagination token for the next page of data.
   */
  @JsonProperty("nextToken")
  @Override
  public @Nullable String nextToken() {
    return nextToken;
  }

  /**
   * Caching policy for the list of entities.
   */
  @JsonProperty("cacheControl")
  @Override
  public @Nullable CacheControl cacheControl() {
    return cacheControl;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ListEntitiesResponse#isSuccess() isSuccess} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param isSuccess A new value for isSuccess
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableListEntitiesResponse withIsSuccess(boolean isSuccess) {
    if (this.isSuccess == isSuccess) return this;
    return new ImmutableListEntitiesResponse(isSuccess, this.errorDetails, this.entities, this.nextToken, this.cacheControl);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ListEntitiesResponse#errorDetails() errorDetails} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param errorDetails A new value for errorDetails (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableListEntitiesResponse withErrorDetails(@Nullable ErrorDetails errorDetails) {
    if (this.errorDetails == errorDetails) return this;
    return new ImmutableListEntitiesResponse(this.isSuccess, errorDetails, this.entities, this.nextToken, this.cacheControl);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link ListEntitiesResponse#entities() entities}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableListEntitiesResponse withEntities(@Nullable Entity... elements) {
    if (elements == null) {
      return new ImmutableListEntitiesResponse(this.isSuccess, this.errorDetails, null, this.nextToken, this.cacheControl);
    }
    @Nullable ImmutableList<Entity> newValue = elements == null ? null : ImmutableList.copyOf(elements);
    return new ImmutableListEntitiesResponse(this.isSuccess, this.errorDetails, newValue, this.nextToken, this.cacheControl);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link ListEntitiesResponse#entities() entities}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of entities elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableListEntitiesResponse withEntities(@Nullable Iterable<? extends Entity> elements) {
    if (this.entities == elements) return this;
    @Nullable ImmutableList<Entity> newValue = elements == null ? null : ImmutableList.copyOf(elements);
    return new ImmutableListEntitiesResponse(this.isSuccess, this.errorDetails, newValue, this.nextToken, this.cacheControl);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ListEntitiesResponse#nextToken() nextToken} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param nextToken A new value for nextToken (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableListEntitiesResponse withNextToken(@Nullable String nextToken) {
    if (Objects.equal(this.nextToken, nextToken)) return this;
    return new ImmutableListEntitiesResponse(this.isSuccess, this.errorDetails, this.entities, nextToken, this.cacheControl);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ListEntitiesResponse#cacheControl() cacheControl} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param cacheControl A new value for cacheControl (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableListEntitiesResponse withCacheControl(@Nullable CacheControl cacheControl) {
    if (this.cacheControl == cacheControl) return this;
    return new ImmutableListEntitiesResponse(this.isSuccess, this.errorDetails, this.entities, this.nextToken, cacheControl);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableListEntitiesResponse} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableListEntitiesResponse
        && equalTo((ImmutableListEntitiesResponse) another);
  }

  private boolean equalTo(ImmutableListEntitiesResponse another) {
    return isSuccess == another.isSuccess
        && Objects.equal(errorDetails, another.errorDetails)
        && Objects.equal(entities, another.entities)
        && Objects.equal(nextToken, another.nextToken)
        && Objects.equal(cacheControl, another.cacheControl);
  }

  /**
   * Computes a hash code from attributes: {@code isSuccess}, {@code errorDetails}, {@code entities}, {@code nextToken}, {@code cacheControl}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 31;
    h = h * 17 + Booleans.hashCode(isSuccess);
    h = h * 17 + Objects.hashCode(errorDetails);
    h = h * 17 + Objects.hashCode(entities);
    h = h * 17 + Objects.hashCode(nextToken);
    h = h * 17 + Objects.hashCode(cacheControl);
    return h;
  }

  /**
   * Prints the immutable value {@code ListEntitiesResponse} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("ListEntitiesResponse")
        .omitNullValues()
        .add("isSuccess", isSuccess)
        .add("errorDetails", errorDetails)
        .add("entities", entities)
        .add("nextToken", nextToken)
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
      implements ListEntitiesResponse {
    boolean isSuccess;
    boolean isSuccessIsSet;
    @Nullable ErrorDetails errorDetails;
    List<Entity> entities = null;
    @Nullable String nextToken;
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
    @JsonProperty("entities")
    public void setEntities(@Nullable List<Entity> entities) {
      this.entities = entities;
    }
    @JsonProperty("nextToken")
    public void setNextToken(@Nullable String nextToken) {
      this.nextToken = nextToken;
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
    public List<Entity> entities() { throw new UnsupportedOperationException(); }
    @Override
    public String nextToken() { throw new UnsupportedOperationException(); }
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
  static ImmutableListEntitiesResponse fromJson(Json json) {
    ImmutableListEntitiesResponse.Builder builder = ImmutableListEntitiesResponse.builder();
    if (json.isSuccessIsSet) {
      builder.isSuccess(json.isSuccess);
    }
    if (json.errorDetails != null) {
      builder.errorDetails(json.errorDetails);
    }
    if (json.entities != null) {
      builder.addAllEntities(json.entities);
    }
    if (json.nextToken != null) {
      builder.nextToken(json.nextToken);
    }
    if (json.cacheControl != null) {
      builder.cacheControl(json.cacheControl);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link ListEntitiesResponse} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable ListEntitiesResponse instance
   */
  public static ImmutableListEntitiesResponse copyOf(ListEntitiesResponse instance) {
    if (instance instanceof ImmutableListEntitiesResponse) {
      return (ImmutableListEntitiesResponse) instance;
    }
    return ImmutableListEntitiesResponse.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableListEntitiesResponse ImmutableListEntitiesResponse}.
   * @return A new ImmutableListEntitiesResponse builder
   */
  public static ImmutableListEntitiesResponse.Builder builder() {
    return new ImmutableListEntitiesResponse.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableListEntitiesResponse ImmutableListEntitiesResponse}.
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
    private ImmutableList.Builder<Entity> entities = null;
    private @Nullable String nextToken;
    private @Nullable CacheControl cacheControl;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code ListEntitiesResponse} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(ListEntitiesResponse instance) {
      Preconditions.checkNotNull(instance, "instance");
      isSuccess(instance.isSuccess());
      @Nullable ErrorDetails errorDetailsValue = instance.errorDetails();
      if (errorDetailsValue != null) {
        errorDetails(errorDetailsValue);
      }
      @Nullable List<Entity> entitiesValue = instance.entities();
      if (entitiesValue != null) {
        addAllEntities(entitiesValue);
      }
      @Nullable String nextTokenValue = instance.nextToken();
      if (nextTokenValue != null) {
        nextToken(nextTokenValue);
      }
      @Nullable CacheControl cacheControlValue = instance.cacheControl();
      if (cacheControlValue != null) {
        cacheControl(cacheControlValue);
      }
      return this;
    }

    /**
     * Initializes the value for the {@link ListEntitiesResponse#isSuccess() isSuccess} attribute.
     * @param isSuccess The value for isSuccess 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder isSuccess(boolean isSuccess) {
      this.isSuccess = isSuccess;
      initBits &= ~INIT_BIT_IS_SUCCESS;
      return this;
    }

    /**
     * Initializes the value for the {@link ListEntitiesResponse#errorDetails() errorDetails} attribute.
     * @param errorDetails The value for errorDetails (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder errorDetails(@Nullable ErrorDetails errorDetails) {
      this.errorDetails = errorDetails;
      return this;
    }

    /**
     * Adds one element to {@link ListEntitiesResponse#entities() entities} list.
     * @param element A entities element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addEntities(Entity element) {
      if (this.entities == null) {
        this.entities = ImmutableList.builder();
      }
      this.entities.add(element);
      return this;
    }

    /**
     * Adds elements to {@link ListEntitiesResponse#entities() entities} list.
     * @param elements An array of entities elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addEntities(Entity... elements) {
      if (this.entities == null) {
        this.entities = ImmutableList.builder();
      }
      this.entities.add(elements);
      return this;
    }

    /**
     * Sets or replaces all elements for {@link ListEntitiesResponse#entities() entities} list.
     * @param elements An iterable of entities elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder entities(@Nullable Iterable<? extends Entity> elements) {
      if (elements == null) {
        this.entities = null;
        return this;
      }
      this.entities = ImmutableList.builder();
      return addAllEntities(elements);
    }

    /**
     * Adds elements to {@link ListEntitiesResponse#entities() entities} list.
     * @param elements An iterable of entities elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllEntities(Iterable<? extends Entity> elements) {
      Preconditions.checkNotNull(elements, "entities element");
      if (this.entities == null) {
        this.entities = ImmutableList.builder();
      }
      this.entities.addAll(elements);
      return this;
    }

    /**
     * Initializes the value for the {@link ListEntitiesResponse#nextToken() nextToken} attribute.
     * @param nextToken The value for nextToken (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder nextToken(@Nullable String nextToken) {
      this.nextToken = nextToken;
      return this;
    }

    /**
     * Initializes the value for the {@link ListEntitiesResponse#cacheControl() cacheControl} attribute.
     * @param cacheControl The value for cacheControl (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder cacheControl(@Nullable CacheControl cacheControl) {
      this.cacheControl = cacheControl;
      return this;
    }

    /**
     * Builds a new {@link ImmutableListEntitiesResponse ImmutableListEntitiesResponse}.
     * @return An immutable instance of ListEntitiesResponse
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableListEntitiesResponse build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableListEntitiesResponse(isSuccess, errorDetails, entities == null ? null : entities.build(), nextToken, cacheControl);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_IS_SUCCESS) != 0) attributes.add("isSuccess");
      return "Cannot build ListEntitiesResponse, some of required attributes are not set " + attributes;
    }
  }
}
