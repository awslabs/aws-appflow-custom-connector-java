package com.amazonaws.appflow.custom.connector.model.metadata;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link ReadOperationProperty}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableReadOperationProperty.builder()}.
 */
@SuppressWarnings("all")
@ParametersAreNonnullByDefault
@Immutable
public final class ImmutableReadOperationProperty
    implements ReadOperationProperty {
  private final @Nullable Boolean isRetrievable;
  private final @Nullable Boolean isNullable;
  private final @Nullable Boolean isQueryable;
  private final @Nullable Boolean isTimestampFieldForIncrementalQueries;

  private ImmutableReadOperationProperty(
      @Nullable Boolean isRetrievable,
      @Nullable Boolean isNullable,
      @Nullable Boolean isQueryable,
      @Nullable Boolean isTimestampFieldForIncrementalQueries) {
    this.isRetrievable = isRetrievable;
    this.isNullable = isNullable;
    this.isQueryable = isQueryable;
    this.isTimestampFieldForIncrementalQueries = isTimestampFieldForIncrementalQueries;
  }

  /**
   * Specifies if the source field can be returned in a search result.
   */
  @JsonProperty("isRetrievable")
  @Override
  public @Nullable Boolean isRetrievable() {
    return isRetrievable;
  }

  /**
   * Specifies if the source field can have a null value.
   */
  @JsonProperty("isNullable")
  @Override
  public @Nullable Boolean isNullable() {
    return isNullable;
  }

  /**
   * Specifies if the source field can be queried.
   */
  @JsonProperty("isQueryable")
  @Override
  public @Nullable Boolean isQueryable() {
    return isQueryable;
  }

  /**
   * Specifies if the source field can be used for incremental queries.
   */
  @JsonProperty("isTimestampFieldForIncrementalQueries")
  @Override
  public @Nullable Boolean isTimestampFieldForIncrementalQueries() {
    return isTimestampFieldForIncrementalQueries;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ReadOperationProperty#isRetrievable() isRetrievable} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param isRetrievable A new value for isRetrievable (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableReadOperationProperty withIsRetrievable(@Nullable Boolean isRetrievable) {
    if (Objects.equal(this.isRetrievable, isRetrievable)) return this;
    return new ImmutableReadOperationProperty(isRetrievable, this.isNullable, this.isQueryable, this.isTimestampFieldForIncrementalQueries);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ReadOperationProperty#isNullable() isNullable} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param isNullable A new value for isNullable (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableReadOperationProperty withIsNullable(@Nullable Boolean isNullable) {
    if (Objects.equal(this.isNullable, isNullable)) return this;
    return new ImmutableReadOperationProperty(this.isRetrievable, isNullable, this.isQueryable, this.isTimestampFieldForIncrementalQueries);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ReadOperationProperty#isQueryable() isQueryable} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param isQueryable A new value for isQueryable (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableReadOperationProperty withIsQueryable(@Nullable Boolean isQueryable) {
    if (Objects.equal(this.isQueryable, isQueryable)) return this;
    return new ImmutableReadOperationProperty(this.isRetrievable, this.isNullable, isQueryable, this.isTimestampFieldForIncrementalQueries);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ReadOperationProperty#isTimestampFieldForIncrementalQueries() isTimestampFieldForIncrementalQueries} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param isTimestampFieldForIncrementalQueries A new value for isTimestampFieldForIncrementalQueries (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableReadOperationProperty withIsTimestampFieldForIncrementalQueries(@Nullable Boolean isTimestampFieldForIncrementalQueries) {
    if (Objects.equal(this.isTimestampFieldForIncrementalQueries, isTimestampFieldForIncrementalQueries)) return this;
    return new ImmutableReadOperationProperty(this.isRetrievable, this.isNullable, this.isQueryable, isTimestampFieldForIncrementalQueries);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableReadOperationProperty} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableReadOperationProperty
        && equalTo((ImmutableReadOperationProperty) another);
  }

  private boolean equalTo(ImmutableReadOperationProperty another) {
    return Objects.equal(isRetrievable, another.isRetrievable)
        && Objects.equal(isNullable, another.isNullable)
        && Objects.equal(isQueryable, another.isQueryable)
        && Objects.equal(isTimestampFieldForIncrementalQueries, another.isTimestampFieldForIncrementalQueries);
  }

  /**
   * Computes a hash code from attributes: {@code isRetrievable}, {@code isNullable}, {@code isQueryable}, {@code isTimestampFieldForIncrementalQueries}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 31;
    h = h * 17 + Objects.hashCode(isRetrievable);
    h = h * 17 + Objects.hashCode(isNullable);
    h = h * 17 + Objects.hashCode(isQueryable);
    h = h * 17 + Objects.hashCode(isTimestampFieldForIncrementalQueries);
    return h;
  }

  /**
   * Prints the immutable value {@code ReadOperationProperty} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("ReadOperationProperty")
        .omitNullValues()
        .add("isRetrievable", isRetrievable)
        .add("isNullable", isNullable)
        .add("isQueryable", isQueryable)
        .add("isTimestampFieldForIncrementalQueries", isTimestampFieldForIncrementalQueries)
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
      implements ReadOperationProperty {
    @Nullable Boolean isRetrievable;
    @Nullable Boolean isNullable;
    @Nullable Boolean isQueryable;
    @Nullable Boolean isTimestampFieldForIncrementalQueries;
    @JsonProperty("isRetrievable")
    public void setIsRetrievable(@Nullable Boolean isRetrievable) {
      this.isRetrievable = isRetrievable;
    }
    @JsonProperty("isNullable")
    public void setIsNullable(@Nullable Boolean isNullable) {
      this.isNullable = isNullable;
    }
    @JsonProperty("isQueryable")
    public void setIsQueryable(@Nullable Boolean isQueryable) {
      this.isQueryable = isQueryable;
    }
    @JsonProperty("isTimestampFieldForIncrementalQueries")
    public void setIsTimestampFieldForIncrementalQueries(@Nullable Boolean isTimestampFieldForIncrementalQueries) {
      this.isTimestampFieldForIncrementalQueries = isTimestampFieldForIncrementalQueries;
    }
    @Override
    public Boolean isRetrievable() { throw new UnsupportedOperationException(); }
    @Override
    public Boolean isNullable() { throw new UnsupportedOperationException(); }
    @Override
    public Boolean isQueryable() { throw new UnsupportedOperationException(); }
    @Override
    public Boolean isTimestampFieldForIncrementalQueries() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator
  static ImmutableReadOperationProperty fromJson(Json json) {
    ImmutableReadOperationProperty.Builder builder = ImmutableReadOperationProperty.builder();
    if (json.isRetrievable != null) {
      builder.isRetrievable(json.isRetrievable);
    }
    if (json.isNullable != null) {
      builder.isNullable(json.isNullable);
    }
    if (json.isQueryable != null) {
      builder.isQueryable(json.isQueryable);
    }
    if (json.isTimestampFieldForIncrementalQueries != null) {
      builder.isTimestampFieldForIncrementalQueries(json.isTimestampFieldForIncrementalQueries);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link ReadOperationProperty} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable ReadOperationProperty instance
   */
  public static ImmutableReadOperationProperty copyOf(ReadOperationProperty instance) {
    if (instance instanceof ImmutableReadOperationProperty) {
      return (ImmutableReadOperationProperty) instance;
    }
    return ImmutableReadOperationProperty.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableReadOperationProperty ImmutableReadOperationProperty}.
   * @return A new ImmutableReadOperationProperty builder
   */
  public static ImmutableReadOperationProperty.Builder builder() {
    return new ImmutableReadOperationProperty.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableReadOperationProperty ImmutableReadOperationProperty}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private @Nullable Boolean isRetrievable;
    private @Nullable Boolean isNullable;
    private @Nullable Boolean isQueryable;
    private @Nullable Boolean isTimestampFieldForIncrementalQueries;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code ReadOperationProperty} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(ReadOperationProperty instance) {
      Preconditions.checkNotNull(instance, "instance");
      @Nullable Boolean isRetrievableValue = instance.isRetrievable();
      if (isRetrievableValue != null) {
        isRetrievable(isRetrievableValue);
      }
      @Nullable Boolean isNullableValue = instance.isNullable();
      if (isNullableValue != null) {
        isNullable(isNullableValue);
      }
      @Nullable Boolean isQueryableValue = instance.isQueryable();
      if (isQueryableValue != null) {
        isQueryable(isQueryableValue);
      }
      @Nullable Boolean isTimestampFieldForIncrementalQueriesValue = instance.isTimestampFieldForIncrementalQueries();
      if (isTimestampFieldForIncrementalQueriesValue != null) {
        isTimestampFieldForIncrementalQueries(isTimestampFieldForIncrementalQueriesValue);
      }
      return this;
    }

    /**
     * Initializes the value for the {@link ReadOperationProperty#isRetrievable() isRetrievable} attribute.
     * @param isRetrievable The value for isRetrievable (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder isRetrievable(@Nullable Boolean isRetrievable) {
      this.isRetrievable = isRetrievable;
      return this;
    }

    /**
     * Initializes the value for the {@link ReadOperationProperty#isNullable() isNullable} attribute.
     * @param isNullable The value for isNullable (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder isNullable(@Nullable Boolean isNullable) {
      this.isNullable = isNullable;
      return this;
    }

    /**
     * Initializes the value for the {@link ReadOperationProperty#isQueryable() isQueryable} attribute.
     * @param isQueryable The value for isQueryable (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder isQueryable(@Nullable Boolean isQueryable) {
      this.isQueryable = isQueryable;
      return this;
    }

    /**
     * Initializes the value for the {@link ReadOperationProperty#isTimestampFieldForIncrementalQueries() isTimestampFieldForIncrementalQueries} attribute.
     * @param isTimestampFieldForIncrementalQueries The value for isTimestampFieldForIncrementalQueries (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder isTimestampFieldForIncrementalQueries(@Nullable Boolean isTimestampFieldForIncrementalQueries) {
      this.isTimestampFieldForIncrementalQueries = isTimestampFieldForIncrementalQueries;
      return this;
    }

    /**
     * Builds a new {@link ImmutableReadOperationProperty ImmutableReadOperationProperty}.
     * @return An immutable instance of ReadOperationProperty
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableReadOperationProperty build() {
      return new ImmutableReadOperationProperty(isRetrievable, isNullable, isQueryable, isTimestampFieldForIncrementalQueries);
    }
  }
}
